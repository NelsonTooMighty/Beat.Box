import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistRequest;
import java.io.IOException;

/**
 * SpotifyImporter uses developer credentials logged in SpotifyAuth
 * and allows Spotify playlist URLs to be imported with {@link #importPlaylist(String url)}.
 */
public class SpotifyImporter implements CloudPlaylistImporter { //with reference to https://github.com/spotify-web-api-java/spotify-web-api-java/blob/develop/examples/authorization/client_credentials/ClientCredentialsExample.java

    /**
     * Takes the URL of a Spotify playlist, retrieves it, parses it into songs, and returns a Playlist.
     * @param url the url of a public Spotify playlist to be imported
     * @return a Playlist object constructed from the Spotify playlist
     */
    @Override
    public Playlist importPlaylist(String url) {
        Playlist newPlaylist = new Playlist();

        SpotifyAuth.getInstance().refreshAuthorization();

        String playlistID = url.split("[/?]")[4]; //grabs the ID part and ignores any tracker at the end (?si=)
        final GetPlaylistRequest getPlaylistRequest = SpotifyAuth.spotifyApi.getPlaylist(playlistID).build(); //sets up playlist request
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
                track.getAlbum().getName(),
                track.getAlbum().getReleaseDate(),
                track.getAlbum().getImages() == null ? track.getAlbum().getImages()[0].getUrl() : null
                );
    }
}
