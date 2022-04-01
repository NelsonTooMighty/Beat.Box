import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Controller {
    private PlaylistFrame view;
    private DatabaseQuery model = new DatabaseQuery();

    public Controller(PlaylistFrame view) {
        this.view = view;
    }

    public void displayAllPlaylists (JTextArea screen) {
        ArrayList<Playlist> playlists = model.getAllPlaylists();
        for (Playlist playlist : playlists) {                                // gets each playlist in alphabetical order and shows it in a gui's
            screen.append(playlist.getPlaylistName());                       // text area
        }
    }

    public void displayPlaylistContent(JTextArea screen, String playlistName) {
        Playlist desiredPlaylist = model.getPlaylist(playlistName);
        for(Song song : desiredPlaylist){
            String songMessage = song.getTrackTitle() + "\n \t" + song.getArtistName() +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
            screen.append(songMessage);
        }
    }

}
