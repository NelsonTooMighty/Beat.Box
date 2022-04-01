import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * SpotifyImporter reads developer credentials from credentials.config
 * and allows Spotify playlist URLs to be imported with {@link #importPlaylist(String url)}.
 */
public class SpotifyImporter implements CloudPlaylistImporter { //with reference to https://github.com/spotify-web-api-java/spotify-web-api-java/blob/develop/examples/authorization/client_credentials/ClientCredentialsExample.java
    private static SpotifyImporter singleton;
    private static String clientId = "";
    private static String clientSecret = "";
    private static SpotifyApi spotifyApi;
    private static ClientCredentialsRequest clientCredentialsRequest;
    private static ClientCredentials clientCredentials;
    private static long expireTime = 0;

    private SpotifyImporter() { //reads client token from gitignored file
        Path path = FileSystems.getDefault().getPath("credentials.config");
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(path);
        } catch (IOException e) {
            System.out.println("\nCould not find credentials.config file in base directory!:\n" + e.getMessage());
        }
        try {
            clientId = reader.readLine();
            clientSecret = reader.readLine();
        } catch (IOException e) {
            System.out.println("\ncredentials.config file was empty or too short!:\n" + e.getMessage());
        }
        spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build();
        clientCredentialsRequest = spotifyApi.clientCredentials()
                .build();
    }

    /**
     * Gets the instance of the SpotifyImporter class. Shares credentials loaded from credentials.config in a singleton pattern.
     * @return the singleton instance of {@link SpotifyImporter}
     */
    public static SpotifyImporter getInstance() {
        if(singleton == null) singleton = new SpotifyImporter();
        return singleton;
    }

    /**
     * Takes the URL of a Spotify playlist, retrieves it, parses it into songs, and returns a Playlist.
     * @param url the url of a public Spotify playlist to be imported
     * @return a Playlist object constructed from the Spotify playlist
     */
    @Override
    public Playlist importPlaylist(String url) {
        Playlist newPlaylist = new Playlist();
        if(System.currentTimeMillis() > expireTime) //if credentials have expired
            refreshClientCredentials();

        String playlistID = url.split("[/?]")[4]; //grabs the ID part and ignores any tracker at the end (?si=)
        final GetPlaylistRequest getPlaylistRequest = spotifyApi.getPlaylist(playlistID).build(); //sets up playlist request
        se.michaelthelin.spotify.model_objects.specification.Playlist importedPlaylist = null;    //readies receiving variable

        try {
            importedPlaylist = getPlaylistRequest.execute();                //executes playlist request
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("\nError retrieving playlist!:\n" + e.getMessage());
        }
        if (importedPlaylist == null) return null; //if nothing was imported, leave
        newPlaylist.setPlaylistName(importedPlaylist.getName());

        Paging<PlaylistTrack> tracks = importedPlaylist.getTracks();        //converts to list of PlaylistTracks
        if (tracks == null) return null; //if no tracks, leave
        PlaylistTrack[] trackList = tracks.getItems();                      //converts to array for for-loop parsing
        if (trackList == null) return null;
        for (PlaylistTrack playlistTrack : trackList) {                     //for every PlaylistTrack
            newPlaylist.add(playlistTrackParser(playlistTrack));            //parse components, add Song
        }
        return newPlaylist;
    }

    /**
     * Gets/refreshes client credentials from Spotify's API
     */
    private static void refreshClientCredentials() {
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

    /**
     * Takes a PlaylistTrack object, converts it to a Track object, and converts it into a {@link Song} object.
     * @param playlistTrack PlaylistTrack to be converted
     * @return {@link Song} object with PlaylistTrack's properties
     */
    private Song playlistTrackParser(PlaylistTrack playlistTrack) {
        if (playlistTrack == null) return null;
        Track track = ((Track)playlistTrack.getTrack());
        return new Song(
                track.getName(),
                track.getArtists()[0].getName(),
                track.getAlbum().toString(),
                track.getAlbum().getReleaseDate(),
                track.getAlbum().getImages()[0].getUrl()
                );
    }
}
