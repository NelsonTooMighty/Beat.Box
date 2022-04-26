import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.User;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Exports a Playlist object as a private playlist to Spotify, owned by the currently authorized user.
 * Requires full Code Authorization.
 * <br>{@code new SpotifyExporter().exportPlaylist(Playlist)}
 */
public class SpotifyExporter {
    SpotifyAuth spotifyAuth = SpotifyAuth.getInstance();

    /**
     * Exports the supplies playlist as a private playlist. Will open a Spotify authorization URI if needed.
     * @param playlist
     * @return true if exported successfully, false if not
     */
    public boolean exportPlaylist(Playlist playlist) {
        if (!spotifyAuth.isFullyAuthorized()) { //if not fully authorized, fully authorize
            System.out.println("Not fully authorized yet, authorizing now!");
            spotifyAuth.fullyAuthorize();
        }
        User user = null;
        try { //get User
            user = spotifyAuth.spotifyApi.getCurrentUsersProfile().build().execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: Could not retrieve current user's ID!:\n" + e.getMessage());
            return false;
        }

        se.michaelthelin.spotify.model_objects.specification.Playlist spotifyPlaylist; //has to specify SpotifyAPI Playlist type
        try { //Create playlist
            spotifyPlaylist = spotifyAuth.spotifyApi.createPlaylist(user.getId(), playlist.getPlaylistName()).public_(false).description("Exported from Beat Box!").build().execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: Could not create a playlist for user " + user.getDisplayName() + "!:\n" + e.getMessage());
            return false;
        }

        SpotifySearcher searcher = new SpotifySearcher();
        ArrayList<String> uris = new ArrayList<>();
        for(Song s : playlist) { //get all URIs, add to array
            uris.add(searcher.searchSongURI(s.getSongName()));
        }

        try { //Add all new song URIs to new Spotify playlist
            spotifyAuth.spotifyApi.addItemsToPlaylist(spotifyPlaylist.getId(), uris.toArray(new String[0])).build().execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: Could not add songs to playlist " + playlist.getPlaylistName() + " for user " + user.getDisplayName() + "!:\n\t" + e.getMessage());
        }
        return true;
    }
}
