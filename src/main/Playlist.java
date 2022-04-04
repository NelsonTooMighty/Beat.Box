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

    /**
     * Gets a Song from the playlist by its name.
     * @param songName the name of the requested Song
     * @return the Song object with the specified name, null if not found
     */
    public Song getSong(String songName) {
        for(Song song : this)
            if(song.getSongName().equals(songName))
                return song;
        return null; //no name match found
    }

    /**
     * Gets a Song from the playlist by its index.
     * @param index the index of the requested Song
     * @return the Song object at the specified index, null if not found
     */
    public Song getSong(int index) {
        if (index < this.size()) //to avoid throwing an error
            return this.get(index);
        return null; //playlist isn't large enough to have a song at the index
    }

    public boolean removeSong(String songName) {
        Song song = this.getSong(songName);
        return this.remove(song);                                        //Got code from: https://www.javatpoint.com/remove-an-element-from-arraylist-in-java
    }

    public boolean removeSong(int index) {
        if (index < this.size())
            return this.remove(index) != null; //true if removed (not null), false if not removed (null)
        return false;
    }
    
}
