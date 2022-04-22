import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class SpotifyAuth {
    public static SpotifyApi spotifyApi; //Importers and Exporters can use this authorized object
    private static final SpotifyAuth singleton = new SpotifyAuth();
    private static String clientId = "";
    private static String clientSecret = "";
    private static ClientCredentialsRequest clientCredentialsRequest;
    private static ClientCredentials clientCredentials;
    private static long expireTime = 0;

    private SpotifyAuth() { //reads client token from gitignored file
        Path path = FileSystems.getDefault().getPath("credentials.config");
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(path);
        } catch (IOException e) {
            System.out.println("\nCould not find credentials.config file in base directory!:\n" + e.getMessage());
        }
        try {
            if(reader != null) {
                clientId = reader.readLine();
                clientSecret = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("\ncredentials.config file was empty or too short!:\n" + e.getMessage());
        }
        if(clientId == null) System.out.println("\nNo clientId found!\n");
        if(clientSecret == null) System.out.println("\nNo clientSecret found!\n");
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
    public static void refreshClientCredentials() {
        if(System.currentTimeMillis() > expireTime) //if credentials have expired
        {
            try {
                clientCredentials = clientCredentialsRequest.execute();                 //request credentials from Spotify
            } catch (IOException | ParseException | SpotifyWebApiException e) {
                System.out.println("\nError requesting credentials!:\n" + e.getMessage());
            }
            //set expireTime for checks
            expireTime = System.currentTimeMillis() + (clientCredentials.getExpiresIn() * 1000);
            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            System.out.println("Client Credentials expire in: " + clientCredentials.getExpiresIn() + " seconds.");
        }
    }
}
