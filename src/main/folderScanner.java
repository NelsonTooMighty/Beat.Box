import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class folderScanner {
    public void songTitle(){
        // Scanner input = new Scanner(System.in);
        String songName;
        String []songArray;
        int stringLength;
        Playlist currentPlaylist = new Playlist();
        Database currentDatabase = Database.getInstance();

        Path path = Paths.get( String // Get for folder from Naomi);
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) // Edit path
        {
            for (Path p : ds) 
            {
                Song currentSong = new Song();
                songName = p.getFileName().toString();
                songArray = songName.split("[\\.]+");
                stringLength = songArray.length;
                songName = songArray[stringLength - 2];
                currentSong.setSongName(songName);
                currentSong.setLocal(true);
                currentSong.setLocalPath(p.toString());
                currentPlaylist.add(currentSong);
            }
            
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        currentDatabase.add(currentPlaylist);

        return currentPlaylist;
       
        // input.close();
    }

}
