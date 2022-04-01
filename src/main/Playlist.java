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

    public Song getSong(String songName) {
        for(Song song : this)
            if(song.getTrackTitle().equals(songName))
                return song;
        return null; //no name match found
    }

    public Song getSong(int index) {
        if (index < this.size()) //to avoid throwing an error
            return this.get(index);
        return null; //playlist isn't large enough to have a song at the index
    }
}
