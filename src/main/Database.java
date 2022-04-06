import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;

public class Database extends ArrayList<Playlist> { //add(Playlist), remove(Playlist), etc
    private static final Database singleton = new Database();
    private final String localLibrary = "../playlists/";
    private  Playlist likedPlaylist = new Playlist();

    private Database() {boot();}

    public static Database getInstance() {
        return singleton;
    }

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

    Playlist loadFromFile(String filepath) throws IOException, ClassNotFoundException { //with help from https://www.tutorialspoint.com/java/java_serialization.htm
        Playlist pl = null;
        FileInputStream fileIn = new FileInputStream(filepath);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        pl = (Playlist) in.readObject();
        in.close();
        fileIn.close();
        return pl;
    }

    void saveToFile(Playlist pl) throws IOException {
        saveToFile(pl, localLibrary + pl.getPlaylistName().replace('/',' ') + pl.hashCode());
    }

    void saveToFile(Playlist pl, String filepath) throws IOException {
        FileOutputStream fileOut =
                new FileOutputStream(filepath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(pl);
        out.close();
        fileOut.close();
    }
  
    public void removeLikedSong(String songName){
        likedPlaylist.remove(likedPlaylist.getSong(songName)); 
    }
    
    public void addLikedSong(Song song){
        likedPlaylist.add(song); 
    }
    public void removeLikedSong(Song song){
        likedPlaylist.remove(song); 
    }
    public boolean inLike(String songName){
        if(likedPlaylist.getSong(songName) != null){return true;}
        else {return false;}
     }
    public boolean inLike(Song song){
        if(likedPlaylist.contains(song)){
            return true; 
        }
        else {return false;}
    }
    public Playlist getLikedList(){  
        Playlist list = new Playlist();
        for(Song song : likedPlaylist){
            list.add(song);
        }
        return list;
    }
}
