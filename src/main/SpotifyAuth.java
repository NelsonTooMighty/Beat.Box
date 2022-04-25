import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

// relies heavily on spotify-web-api-java dependency: https://github.com/spotify-web-api-java/spotify-web-api-java/tree/8fa8ae77e23e68507872cfadc4fe38321f5b86cc

/**
 * Singleton that stores the authorization details, access codes, etc. To use, simply run the following:
 * {@code SpotifyAuth.getInstance().fullyAuthorize();}
 */
public class SpotifyAuth {
    public static SpotifyApi spotifyApi; //Importers and Exporters can use this authorized object
    private static final SpotifyAuth singleton = new SpotifyAuth();
    private final String clientId = "0eeae725ca604326b3939e91ecc18c71"; //Avery's Beat Box Spotify App ID, not secret
    private long expireTime = 0; //time of token expiry in milliseconds; updated with System.currentTimeMillis()
    final int PORT = 8888; //port the CallbackListener will listen to
    final boolean verbose = true; //console output
    private ClientCredentialsRequest clientCredentialsRequest;
    private final URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:8888/callback"); //the URI spotify will redirect the user to after authorization
    private String codeChallenge = null; //challenge to be exchanged with Spotify for the URI
    private String codeVerifier = null; //verifier to be exchanged alongside the code with Spotify for the access tokens; generateCodes()
    private volatile String code; //to be filled by the CallbackListener webserver with the code from the Spotify URI redirect

    private SpotifyAuth() { //reads client token from gitignored file
        Path path = FileSystems.getDefault().getPath("credentials.config");
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(path);
        } catch (IOException e) {
            System.out.println("\nCould not find credentials.config file in base directory!:\n" + e.getMessage());
        }
        clientAuthorize();
    }

    /**
     * Fully authorizes by opening a Spotify link in the default browser and waiting for the user to authorize the application.
     * @return true if successful, false if the link could not be opened
     */
    public boolean fullyAuthorize() {
        URI uri = getURI(); //generates the authorization URI
        try {
            Desktop.getDesktop().browse(uri); //opens Spotify auth URI in browser
        } catch (IOException e) {
            System.out.println("\nError: failed to open URL (" + uri + ") in the browser!:\n" + e.getMessage());
            return false;
        }
        authorize(); //captures the return code
        return true;
    }

    /**
     * A lower level of authorization that doesn't require user input, but does require the client secret to be in credentials.config in the source directory. Will do nothing if credentials.config is not found.
     */
    public void clientAuthorize() {
        Path path = FileSystems.getDefault().getPath("credentials.config");
        BufferedReader reader;
        String clientSecret;
        try {
            reader = Files.newBufferedReader(path);
            reader.readLine(); //skip client ID line
            clientSecret = reader.readLine(); //get clientSecret
        } catch (IOException e) {
            System.out.println("\nCould not find valid credentials.config file in base directory. All Spotify operations will require PKCE authorization.\n");
            return;
        }
        spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build(); //sets clientID and secret
        clientCredentialsRequest = spotifyApi.clientCredentials()
                .build(); //readies request for refreshing
        try {
            ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            expireTime = System.currentTimeMillis() + (clientCredentials.getExpiresIn() * 1000);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("\nClient Credential Authorization failed. All Spotify operations will require PKCE authorization:\n" + e.getMessage());
        }
    }

    /**
     * Generates the cryptographically random code challenge and verification codes to be used in the PKCE OAuth authorization scheme.
     */
    private void generateCodes() throws UnsupportedEncodingException, NoSuchAlgorithmException { // made using https://www.appsdeveloperblog.com/pkce-code-verifier-and-code-challenge-in-java/
        SecureRandom secureRandom = new SecureRandom();
        byte[] verifier = new byte[32];
        secureRandom.nextBytes(verifier);
        codeVerifier = Base64.getUrlEncoder().withoutPadding().encodeToString(verifier);

        byte[] bytes = codeVerifier.getBytes(StandardCharsets.US_ASCII);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bytes, 0, bytes.length);
        byte[] digest = messageDigest.digest();
        codeChallenge = Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
    }

    /**
     * Sets the redirect URI return code from Spotify to be used for generating access tokens
     * @param newCode Pre-trimmed Spotify redirect code to be used for authorization
     */
    public void setCode(String newCode) {
        code = newCode;
    }

    //TODO automatic link opening: https://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
    /**
     * Gets URI needed to authenticate the Spotify user. Once link has been provided to user, should be followed up with {@link #authorize()}.
     * @return Spotify OAuth URI to be opened by the user
     */
    public URI getURI() {
        System.out.println(clientId);
        spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();
        clientCredentialsRequest = spotifyApi.clientCredentials()
                .build();
    }

    /**
     * Gets/refreshes client credentials from Spotify's API
     */
    private void captureRedirect() {
        try {
            //while (true) {
                CallbackListener myServer = new CallbackListener(PORT, singleton);
                if (verbose)
                    System.out.println("Connection opened. (" + new Date() + ")");

                // create dedicated thread to manage the client connection
                Thread thread = new Thread(myServer); //3
                thread.start();
            //}

        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }

    /**
     * Authorizes the app using PKCE OAuth proof. Busy-waits for URI redirect to complete, then uses the code from the redirect to get access and refresh tokens.
     */
    private void authorize() {
        captureRedirect(); //start socket listener
        while (code == null) Thread.onSpinWait(); //busy-wait for authentication
        //System.out.println(spotifyAuth.code);
        try {
            //get access token using returned code and code verifier
            AuthorizationCodeCredentials authorizationCodeCredentials = spotifyApi.authorizationCodePKCE(code, codeVerifier)
                    .build()
                    .execute();
            //update expireTime
            expireTime = System.currentTimeMillis() + (authorizationCodeCredentials.getExpiresIn() * 1000);
            // Set access and refresh tokens for further "spotifyApi" object usage
            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());
            if (verbose)
                System.out.println("Authorization complete. Expires in: " + authorizationCodeCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("\nError authorizing with redirect code!:\n" + e.getMessage());
        }
    }

    //TODO automatically refresh asynchronously
    /**
     * Gets/refreshes access tokens from Spotify's API if the tokens are at least halfway expired.
     */
    public void refreshAuthorization() {
        if(System.currentTimeMillis() > expireTime / 2.0) //if credentials are expiring
        {
            long expiresIn = 0;
            if(code == null && clientCredentialsRequest != null) {  //aka using Client Credentials
                try {
                    ClientCredentials clientCredentials = clientCredentialsRequest.execute();
                    spotifyApi.setAccessToken(clientCredentials.getAccessToken());
                    expiresIn = clientCredentials.getExpiresIn(); //update expireTime
                } catch (IOException | ParseException | SpotifyWebApiException e) {
                    System.out.println("\nError refreshing Client Credentials authorization!:\n" + e.getMessage());
                }
            }
            else if (code != null) { //aka using PKCE Code and code has already been acquired
                try {
                    //uses refresh token to request fresh credentials from Spotify
                    AuthorizationCodeCredentials credentials = spotifyApi.authorizationCodePKCERefresh()
                            .build()
                            .execute();
                    // Set access and refresh tokens for further "spotifyApi" object usage
                    spotifyApi.setAccessToken(credentials.getAccessToken());
                    spotifyApi.setRefreshToken(credentials.getRefreshToken());
                    expiresIn = credentials.getExpiresIn(); //update expireTime
                } catch (IOException | ParseException | SpotifyWebApiException e) {
                    System.out.println("\nError refreshing Authorization Code authorization!:\n" + e.getMessage());
                }
            }
            //update expireTime
            expireTime = System.currentTimeMillis() + (expiresIn * 1000);
            if (verbose && expiresIn != 0)
                System.out.println("Authorization expires in " + expiresIn + " seconds.");
        }
    }


    public static SpotifyAuth getInstance() {
        return singleton;
    }

    /**
     * Checks if the object is authorized yet.
     * @return true if an access token exists and is not expired yet; otherwise false
     */
    public boolean isAuthorized() {
        return spotifyApi.getAccessToken() != null && System.currentTimeMillis() < expireTime;
    }

    /*  //driver test/example
    public static void main(String[] args) {
        SpotifyAuth.getInstance().fullyAuthorize();
    }

     */
}
