import javax.swing.*;

public class SongButton extends PlaylistButton {
    private Song song;

    public SongButton(String s) {
        super();
    }

    public SongButton(ImageIcon albumArtImageIcon) {
        super();
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Song getSong() { return song;}
}
