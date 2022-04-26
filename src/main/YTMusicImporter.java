import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class YTMusicImporter {
    YTMusicAuth auth = new YTMusicAuth();
    private long maxResults = 100;
    YouTube.PlaylistItems.List playlistRequest = null;

    public YTMusicImporter() {
        try {
            playlistRequest = auth.getYoutubeService().playlistItems().list(Collections.singletonList("snippet"));
        } catch (IOException e) {
            System.out.println("Error generating YT Import request!:\n\t" + e.getMessage());
        }
    }

    /**
     * Imports a public Playlist from YouTube. Does *not* automatically add to the Database.
     * @param url URL of a YouTube playlist
     * @return the constructed Playlist object
     */
    public Playlist importPlaylist(String url) {
        String id = extractID(url);
        PlaylistItemListResponse response = null;
        try {
            response = playlistRequest.setPlaylistId(id)
                    .setMaxResults(maxResults)
                    .execute();
        } catch (IOException e) {
            System.out.println("Error executing YT Import request!:\n\t" + e.getMessage());
        }
        if (response == null) return null;
        Playlist playlist = new Playlist();
        List<PlaylistItem> items = response.getItems();

        try {
            YouTube.Playlists.List plreq = auth.getYoutubeService().playlists().list(List.of("snippet"));
            PlaylistListResponse plresponse = plreq.setId(List.of(id)).execute();
            playlist.setPlaylistName(plresponse.getItems().get(0).getSnippet().getTitle());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (PlaylistItem pi : items)
            playlist.add(snippetParser(pi.getSnippet()));
        return playlist;
    }

    private Song snippetParser(PlaylistItemSnippet snippet) {
        if (snippet == null) return null;
        return new Song(
                snippet.getTitle(),
                snippet.getVideoOwnerChannelTitle(),
                null,
                snippet.getPublishedAt().toStringRfc3339().split("-")[0],
                snippet.getThumbnails().getDefault().getUrl()
        );
    }

    private String extractID(String url) {
        String[] split = url.split("=");
        return split[split.length - 1];
    }

    /* test driver
    public static void main(String[] args) {
        YTMusicImporter importer = new YTMusicImporter();
        Playlist pl = importer.importPlaylist("https://www.youtube.com/playlist?list=PLaDrN74SfdT6FvTs9d2JPLJnVRjnjIlfo");
        for (Song s : pl) System.out.println(s.getSongName() + "\t\t" + s.getArtistName() + "\t\t" + s.getReleaseDate() + "\t\t" + s.getAlbumArtLocation());
    }
     */
}
