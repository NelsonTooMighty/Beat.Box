import java.io.Serializable;
import java.util.LinkedList;

public class Playlist extends LinkedList<Song> implements Serializable {
    String playlistName;

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
}
