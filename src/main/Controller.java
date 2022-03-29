public class Controller {
    private static final Controller singleton = new Controller();
    private static final Database db = Database.getInstance();

    private Controller() {}
    public static Controller getInstance() {return singleton;} //Use this to get the Controller object

    public Playlist getPlaylist(int index) {
        //use db[index] to get the requested playlist
        return null; //replace with a return with found playlist
    }

    //Input: name of a playlist
    //Search database for file with name (ArrayList methods can do this)
    //Output: playlist with matching name from Database/db
    public Playlist getPlaylist(String playlistName) {return null;}

    //Input: index of a playlist, new name to set the playlist to
    //Output: renamed playlist object
    public Playlist renamePlaylist(int index, String newName) {return null;}

    //input: index of a playlist
    //remove playlist from Database/db
    //output: if the object was found and removed
    public boolean removePlaylist(int index) {return false;}
}
