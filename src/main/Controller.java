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
     * Appends a list of all unique artists with songs in the Database,
     * with their Song count, in the following format:
     * <p></p>1. ArtistName
     * <t>      </t>
     * Songs: #
     * @param screen the screen to display artist lists to
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
