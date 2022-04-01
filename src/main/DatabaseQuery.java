import java.util.ArrayList;

public class DatabaseQuery {
    private final Database db = Database.getInstance();

    public DatabaseQuery() {}

    public Playlist getPlaylist(int index) { // Create DatabaseQuery method to return a requested Playlist
        //use db[index] to get the requested playlist
        if (index < db.size())
            return db.get(index);
        else
        return null; //replace with a return with found playlist
    }

    //Input: name of a playlist
    //Search database for file with name (ArrayList methods can do this)
    //Output: playlist with matching name from Database/db
    public Playlist getPlaylist(String playlistName) {
        for (Playlist currentPlaylist : db) {                                    //check for playlist in database
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

    //output: list of all Playlist objects from database
    public ArrayList<Playlist> getAllPlaylists() {
        return new ArrayList<>(db);
    }

    public Playlist getArtistList(String artistName){
        for(Playlist currentPlaylist : db) {                              //check is existing artist playlist in database
            String currentPlaylistName = currentPlaylist.getPlaylistName();
            if (currentPlaylistName.equals(artistName)){
                return currentPlaylist;
            }
        } //if it gets here, it was not found
        //if there is no playlist it creates one and adds songs with
        Playlist artistPlaylist = new Playlist();                        // artists name stored in its class
        artistPlaylist.setPlaylistName(artistName);
        ArrayList<Playlist> playlists = getAllPlaylists(); //gets list of all playlists
        for (Playlist playlist : playlists){               //loops through them
            for (Song song : playlist){                    //adds all songs by that Artist to the new playlist
                if (artistName.equals(song.getArtistName()))
                    artistPlaylist.add(song);
            }
        }
        return artistPlaylist;

    }
}