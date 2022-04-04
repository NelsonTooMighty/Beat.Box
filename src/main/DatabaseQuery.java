import java.util.ArrayList;

public class DatabaseQuery {
    private final Database db = Database.getInstance();
    

    public DatabaseQuery() {}

    /**
     * Gets the playlist at the specified index from the Database.
     * @param index the index of the playlist to get from the database
     * @return the playlist at the specified index, or null if out of bounds
     */
    public Playlist getPlaylist(int index) { // Create DatabaseQuery method to return a requested Playlist
        //use db[index] to get the requested playlist
        if (index < db.size())
            return db.get(index);
        else
            return null; //replace with a return with found playlist
    }

    /**
     * Gets the playlist with the specified name from the Database.
     * @param playlistName the name of the playlist to get from the database
     * @return the playlist with the specified name, or null if not found
     */
    public Playlist getPlaylist(String playlistName) {
        for (Playlist currentPlaylist : db) {                                    //check for playlist in database
            if (playlistName.equals(currentPlaylist.getPlaylistName())) {
                return currentPlaylist;
            }
        }
        return null;
    }

    //This one can use getPlaylist(index) and then use the Playlist's own methods to rename (Playlist.java)
    /**
     * Renames the Playlist at the specified index.
     * @param index the index of the Playlist to be renamed
     * @param newName the new name Playlist will have
     * @return the renamed Playlist
     */
    public Playlist renamePlaylist(int index, String newName) {return null;}

    //input: index of a playlist
    //remove playlist from Database/db
    //output: if the object was found and removed
    public boolean removePlaylist(int index) {return false;}

    //output: list of all Playlist objects from database
    public ArrayList<Playlist> getAllPlaylists() {
        return new ArrayList<>(db);
    }

    /**
     * Returns a list of all unique Artists that have songs in the Database.
     * @return ArrayList of artist names
     */
    public ArrayList<String> getAllArtists() {
        ArrayList<String> artists = new ArrayList<>();
        for(Playlist playlist : db) //for every playlist
            for(Song song : playlist) //for every song in every playlist
                if(!artists.contains(song.getArtistName())) //if the playlist doesn't have an artist name
                    artists.add(song.getArtistName()); //add it to the list
        return artists; //when done
    }

    /**
     * Gets a count of how many Songs by the specified artist are in the Database.
     * @param artistName name of specified artist whose Songs will be searched for
     * @return int count of Songs by the specified artist
     */
    public int getArtistSongCount(String artistName) {
        return getArtistList(artistName).size();
    }

    /**
     * Gets a Playlist with every song by the specified artist from the Database.
     * @param artistName name of specified artist to search for Songs with
     * @return Playlist with every song by the specified artist
     */
    public Playlist getArtistList(String artistName){
        /*for(Playlist currentPlaylist : db) {                              //check is existing artist playlist in database
            String currentPlaylistName = currentPlaylist.getPlaylistName();
            if (currentPlaylistName.equals(artistName)){
                return currentPlaylist;
            }
        } //if it gets here, it was not found  */       //This doesn't work if there's new Songs
        Playlist artistPlaylist = new Playlist();               // artists name stored in its class
        artistPlaylist.setPlaylistName(artistName);
        ArrayList<Playlist> playlists = getAllPlaylists();      //gets list of all playlists
        for (Playlist playlist : playlists){                    //loops through them
            for (Song song : playlist){                         //adds all songs by that Artist to the new playlist
                if (artistName.equals(song.getArtistName()))
                    artistPlaylist.add(song);
            }
        }
        return artistPlaylist;

    }
    
   
}