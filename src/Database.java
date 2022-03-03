import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;

public class Database extends ArrayList<Playlist> { //add(Playlist), remove(Playlist), etc
    private static Database singleton = new Database();
    private String localLibrary = "playlists/";

    private Database() {boot();}

    public static Database getInstance() {
        return singleton;
    }

    void boot() { //with help from https://www.logicbig.com/how-to/code-snippets/jcode-java-io-files-newdirectorystream.html
        Path path = Paths.get(localLibrary);
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
            Iterator<Path> iterator = ds.iterator();
            while (iterator.hasNext()) {
                Path p = iterator.next();
                readFromFile(path.relativize(p).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readFromFile(String filepath) throws FileNotFoundException { //with help from https://www.tutorialspoint.com/java/java_serialization.htm
        FileInputStream fileIn = new FileInputStream(filepath);
    }

    void saveToFile(Playlist pl) throws IOException {
        FileOutputStream fileOut =
                new FileOutputStream(localLibrary + pl.getPlaylistName().replace('/',' ') + pl.hashCode());
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(pl);
        out.close();
        fileOut.close();
    }
}
