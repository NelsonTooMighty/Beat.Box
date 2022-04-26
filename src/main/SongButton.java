import javax.swing.*;

public class SongButton extends PlaylistButtonExtension  {
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

    public String getPlaylistName() {return pl.getPlaylistName();}

    public void setPlaylist(Playlist songPlaylist){
        this.pl = songPlaylist;
    }
    public Playlist getPlaylist(){
        return pl;
    }

    public Song getSong() { return song;}
}
