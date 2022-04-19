import java.util.ArrayList;

public class DatabaseQuery {
    private final Database db = Database.getInstance();
    

    public DatabaseQuery() {}

    /**
     * Gets the playlist at the specified index from the Database.
     * @param index the index of the playlist to get from the database
     * @return the playlist at the specified index, or null if out of bounds
     */
    public Playlist getPlaylist_index(int index) { //BB-16


        if (index <= db.size())
            return db.get(index-1);
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

<<<<<<< HEAD
    //Input: index of a playlist, new name to set the playlist to
    //Output: renamed playlist object
    public Playlist renamePlaylist(int index, String newName) { // Create a DatabaseQuery method for renaming a specified Playlist
        Playlist temp = getPlaylist(index);
        temp.setPlaylistName(newName);
        return temp;
    }
=======
    //This one can use getPlaylist(index) and then use the Playlist's own methods to rename (Playlist.java)
    /**
     * Renames the Playlist at the specified index.
     * @param index the index of the Playlist to be renamed
     * @param newName the new name Playlist will have
     * @return the renamed Playlist
     */
<<<<<<< HEAD
    public Playlist renamePlaylist(int index, String newName) {return null;}
>>>>>>> master
=======
    public Playlist renamePlaylist(int index, String newName) {  //BB-16

        Playlist temp = getPlaylist_index(index);

        temp.setPlaylistName(newName);
        return temp;
    }
>>>>>>> master

    //input: index of a playlist
    //remove playlist from Database/db
    //output: if the object was found and removed
    public boolean removePlaylist(String playlistName) {  // Part 1 BB-61
        Playlist desiredPlaylist = getPlaylist(playlistName);
        return db.remove(desiredPlaylist);
    }

    public boolean removePlaylist(int index) { // Part 2 BB-16
        boolean wasRemoved = false;
        if(index <= db.size()){
            db.remove(index-1);
            wasRemoved = true;
        }
        return wasRemoved;
    }

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
        return getArtistSongList(artistName).size();
    }

    /**
     * Gets a Playlist with every song by the specified artist from the Database.
     * @param artistName name of specified artist to search for Songs with
     * @return Playlist with every song by the specified artist
     */
    public Playlist getArtistSongList(String artistName){
        Playlist artistPlaylist = new Playlist();               // artists name stored in its class
        artistPlaylist.setPlaylistName(artistName);
        ArrayList<Playlist> playlists = getAllPlaylists();      //gets list of all playlists
        for (Playlist playlist : playlists){                    //loops through them
            for (Song song : playlist){                         //adds all songs by that Artist to the new playlist
                if (artistName.equals(song.getArtistName()))    //if the artist name matches
                    artistPlaylist.add(song);                       //add that song
            }
        }
        return artistPlaylist;

    }
    
    public void addLikedSong(Song song){
        db.addLikedSong(song);
    }
    public void removeLikedSong(Song song){
        db.removeLikedSong(song);
    }
    public void removeLikedSong(String songName){
        db.removeLikedSong(songName);
    }
    public boolean checkLike(String songName){
      return  db.isLiked(songName);
     }
   public boolean checkLike(Song song){
       return db.isLiked(song);
   }
   public Playlist getLikedList(){
       return db.getLikedList();
   }
}