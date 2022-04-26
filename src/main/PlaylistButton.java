import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaylistButton extends JButton {
    protected Playlist playlist;

    public PlaylistButton() {
        super();
    }

    public PlaylistButton(String s) {
        super(s);
    }

    public String getPlaylistName() {return playlist.getPlaylistName();}

    public void setPlaylist(Playlist songPlaylist){
        this.playlist = songPlaylist;
    }
    public Playlist getPlaylist(){
        return playlist;
    }
}

