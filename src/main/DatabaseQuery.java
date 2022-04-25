import java.util.ArrayList;

public class DatabaseQuery {
    private final Database db = Database.getInstance();
    
    public DatabaseQuery() {}

    /**
     * Gets the playlist at the specified index from the Database.
     * 
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
     * 
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

    //Input: index of a playlist, new name to set the playlist to
    //Output: renamed playlist object
    public Playlist renamePlaylist(int index, String newName) { // Create a DatabaseQuery method for renaming a specified Playlist
        Playlist temp = getPlaylist(index);
        temp.setPlaylistName(newName);
        return temp;
    }
    //This one can use getPlaylist(index) and then use the Playlist's own methods to rename (Playlist.java)
    /**
     * Renames the Playlist at the specified index.
     * This one can use getPlaylist(index) and then use the 
     * Playlist's own methods to rename (Playlist.java)
     * 
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

    /**
     * The two funtions below are used to remove a specified playlist 
     * from the GUI.
     * The first function removes the playlist and cross checks it with a boolean
     * value and the second function double checks that the playlist was acutally 
     * removed from the list. 
     * 
     * @param playlistName to pull from the playlist name from the database
     * @return returns the "wasRemoved" variable indicating successful fuction execution
     */
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

    /**
     * This function returns all the playlist that are locally stored on the machine,
     * appointing them to a new ArrayList<> with the database (db)
     * 
     * @return returns the new ArrayList<> to the database (db)
     */
    public ArrayList<Playlist> getAllPlaylists() {
        return new ArrayList<>(db);
    }




    /**
     * Returns a list of all unique Artists that have songs in the Database.
     * 
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
//BB-89
    public ArrayList<String> getAllAlbums(){
        ArrayList<String> albums = new ArrayList<>();
        for(Playlist playlist : db) //for every playlist
            for(Song song : playlist) //for every song in every playlist
                if(!albums.contains(song.getAlbumName())) //if the playlist doesn't have an artist name
                    albums.add(song.getAlbumName()); //add it to the list
        return albums;
    }

    //BB-89
    public ArrayList<String> getAllSongs() {
        ArrayList<String> songs = new ArrayList<>();
        for(Playlist playlist : db) //for every playlist
            for(Song song : playlist) //for every song in every playlist
                if(!songs.contains(song.getSongName()))
                    songs.add (song.getSongName());//add it to the list
        return songs;
    }

    /**
     * Gets a count of how many Songs by the specified artist are in the Database.
     * 
     * @param artistName name of specified artist whose Songs will be searched for
     * @return int count of Songs by the specified artist
     */
    public int getArtistSongCount(String artistName) {
        return getArtistSongList(artistName).size();
    }

    /**
     * Gets a Playlist with every song by the specified artist from the Database.
     * Artists name stored in its own class then it 
     * gets list of all playlists and then loops through them.
     * Then adds all songs by that Artist to the new playlist
     * if the artist name matches the sond is added.
     * 
     * @param artistName name of specified artist to search for Songs with
     * @return Playlist with every song by the specified artist
     */
    public Playlist getArtistSongList(String artistName){
        Playlist artistPlaylist = new Playlist();               
        artistPlaylist.setPlaylistName(artistName);
        ArrayList<Playlist> playlists = getAllPlaylists();      
        for (Playlist playlist : playlists){                    
            for (Song song : playlist){                         
                if (artistName.equals(song.getArtistName()))    
                    artistPlaylist.add(song);                       
            }
        }
        return artistPlaylist;

    }

    public  Playlist getAlbumSongList(String albumTitle){
        Playlist albumPlaylist = new Playlist();
        albumPlaylist.setPlaylistName(albumTitle);
        ArrayList<Playlist> playlists = getAllPlaylists();
        for (Playlist playlist : playlists){
            for (Song song : playlist){
                if (albumTitle.equals(song.getAlbumName()))
                    albumPlaylist.add(song);
            }
        }
        return albumPlaylist;

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