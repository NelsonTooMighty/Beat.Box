import java.util.ArrayList;
import java.util.Iterator;
public class DatabaseQuery {
    private Database model = Database.getInstance();

    public DatabaseQuery() {}

    public Song getSong(Playlist playlistName,String songName){

    }
    public Playlist getPlaylist(int index) {
        //use db[index] to get the requested playlist
        return null; //replace with a return with found playlist
    }

    //Input: name of a playlist
    //Search database for file with name (ArrayList methods can do this)
    //Output: playlist with matching name from Database/db
    public Playlist getPlaylist(String playlistName) {
        for (Playlist currentPlaylist : model) {                                    //check for playlist in database
            if (playlistName.equals(currentPlaylist.getPlaylistName())) {
                return currentPlaylist;
            }
        }
        return null;
    }

    //Input: index of a playlist, new name to set the playlist to
    //Output: renamed playlist object
    public Playlist renamePlaylist(int index, String newName) {return null;}

    //input: index of a playlist
    //remove playlist from Database/db
    //output: if the object was found and removed
    public boolean removePlaylist(int index) {return false;}
    public void removeSong(String playlistName, String songName){
        Playlist desiredPlaylist =  getPlaylist(playlistName);
        Song removeSong = getSong(desiredPlaylist,songName);
        desiredPlaylist.remove(removeSong);                                        //Got code from: https://www.javatpoint.com/remove-an-element-from-arraylist-in-java
    }
    //output: list of all Playlist objects from database
    public ArrayList<Playlist> getAllPlaylists() {return null;}

    public Iterator<Playlist> iterator() {
        return model.iterator();
    }
}
