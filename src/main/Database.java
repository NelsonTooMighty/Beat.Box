import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;

public class Database extends ArrayList<Playlist> { //add(Playlist), remove(Playlist), etc
    private static final Database singleton = new Database();
    private final String localLibrary = "playlists/";
    private final Playlist likedPlaylist = new Playlist();

    private Database() {boot();}

    public static Database getInstance() {
        return singleton;
    }
 
    /**
     * This function open the directory utilizing Path and iterates 
     * through the selected path so that the playlist can be found
     * as the info is then used for the DatabaseQuery class to 
     * retrieve playlist location.
     * 
     */
    void boot() { //with help from https://www.logicbig.com/how-to/code-snippets/jcode-java-io-files-newdirectorystream.html
        Path path = Paths.get(localLibrary);
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
            for (Path p : ds) {
                add(loadFromFile(p.toString()));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function follows up on the bool function above and loads the playlist from the 
     * exact file that it is stored at.
     * 
     * @param filepath this filepath shows the path to the desired playlist of playlists
     * @return return the playlist that is being requested
     * 
     * @throws IOException
     * @throws ClassNotFoundException
     */
    Playlist loadFromFile(String filepath) throws IOException, ClassNotFoundException { //with help from https://www.tutorialspoint.com/java/java_serialization.htm
        Playlist pl = null;
        FileInputStream fileIn = new FileInputStream(filepath);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        pl = (Playlist) in.readObject();
        in.close();
        fileIn.close();
        return pl;
    }

    /**
     * This fuctinon saves the pl or playlist to the file where the initial 
     * playlist is being stored
     * 
     * @param pl this is our playlist variable used to load and save playlists
     */
    void saveToFile(Playlist pl) {
        try {
            saveToFile(pl, localLibrary + pl.getPlaylistName().replace('/',' ') + pl.hashCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function is a further implementation to our saveToFile functino above
     * utilizing OututStream for the filepath location
     * 
     * @param pl  this is our playlist variable used to load and save playlists
     * @param filepath shows the filepath to the desired playlist being used
     * @throws IOException
     */
    void saveToFile(Playlist pl, String filepath) throws IOException {
        FileOutputStream fileOut =
                new FileOutputStream(filepath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(pl);
        out.close();
        fileOut.close();
    }

    public void addLikedSong(Song song){
        likedPlaylist.add(song);
    }
    public void removeLikedSong(Song song){
        likedPlaylist.remove(song); 
    }
    public void removeLikedSong(String songName){
        likedPlaylist.remove(likedPlaylist.getSong(songName));
    }
    public boolean isLiked(String songName){
        return likedPlaylist.getSong(songName) != null;
     }
    public boolean isLiked(Song song){
        return likedPlaylist.contains(song);
    }
    public Playlist getLikedList(){  
        Playlist list = new Playlist();
        list.addAll(likedPlaylist);
        return list;
    }
}
