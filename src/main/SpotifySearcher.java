import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.enums.ModelObjectType;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.special.SearchResult;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.io.IOException;

/**
 * Searches require either: credentials.config in the top level of the project; or the user has done a PKCE authorization.
 */
public class SpotifySearcher {
    SpotifyAuth spotifyAuth = SpotifyAuth.getInstance();

    public SpotifySearcher(){}

    /**
     * Searches Spotify for a given song name and returns the top result.
     * @param name String name of the song to be searched for
     * @return top result in Song form
     */
    public Song searchSong(String name) {
        SearchResult sr = search(name, "track");
        if (sr != null) {
            Track[] tracks = sr.getTracks().getItems();
            if (tracks.length > 0)
                return trackParser(tracks[0]); //return top result
            else {
                System.out.println("No results found!");
            }
        }
        return null;
    }

    /**
     * Search Spotify.
     * @param query Search query for Spotify
     * @param type Comma-separated list of item types to search. Valid types: album, artist, episode, show, playlist, track.
     * @return SearchResult
     */
    private SearchResult search(String query, String type) {
        if (!spotifyAuth.isAuthorized()) return null;
        try {
            return spotifyAuth.spotifyApi
                    .searchItem(query, type)
                    .build().execute();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("\nError retrieving " + type + " search results for " + query + "!:\n" + e.getMessage());
        }
        return null;
    }

    /**
     * Converts a Spotify {@code Track} to a {@link Song} object.
     * @param track Track (from Spotify) to be parsed
     * @return populated Song object
     */
    private Song trackParser(Track track) {
        return new Song(
                track.getName(),
                track.getArtists()[0].getName(),
                track.getAlbum().getName(),
                track.getAlbum().getReleaseDate(),
                track.getAlbum().getImages()[0].getUrl()
        );
    }

    /*    //driver/tester
    public static void main(String[] args) {
        SpotifySearcher searcher = new SpotifySearcher();
        Song song = searcher.searchSong("Levitating");
        System.out.println(song);
    }
     */
}
