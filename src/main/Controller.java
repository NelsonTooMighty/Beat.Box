import javax.swing.*;
import java.util.ArrayList;

public class Controller {
    private PlaylistFrame view;
    private final DatabaseQuery model = new DatabaseQuery();

    public Controller(PlaylistFrame view) {
        this.view = view;
    }

    public void displayAllPlaylists (JTextArea screen) {
        ArrayList<Playlist> playlists = model.getAllPlaylists();
        int i = 1;
        for (Playlist playlist : playlists) {                                // gets each playlist in index order and shows it in a gui's
            screen.append(i++ + ". " + playlist.getPlaylistName() + "\n");   // text area
        }
    }

    public void displayPlaylistContent(JTextArea screen, int playlistIndex) {
        Playlist desiredPlaylist = model.getPlaylist(playlistIndex);
        int i = 1;
        if (desiredPlaylist == null)
            screen.append("Error: Playlist not found!\n");
        else
            for(Song song : desiredPlaylist) {
                String songMessage = i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() +
                        song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
                screen.append(songMessage);
            }
    }

    /**
     * @param screen the screen to display artist lists to
     * @output A list of all artists with songs in the Database, no duplicates, with their Song count
     *         1. ArtistName    Songs: #
     *         2. ArtistName    Songs: #    etc
     */
    public void displayArtistList(JTextArea screen) {
        ArrayList<String> artists = model.getAllArtists();
        int i = 1;
        for (String name : artists) {
            String output = i++ + ". " + name + "\tSongs: " + model.getArtistSongCount(name) + "\n";
            screen.append(output);
        }
    }
}
