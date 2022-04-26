import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class FolderScanner {
    public Playlist scanFolder(String folderPath){
        Database currentDatabase = Database.getInstance();
        String []pathArray;
        Playlist currentPlaylist = new Playlist();
        String albumArtPath = null;

        pathArray = folderPath.split("\\\\");
        currentPlaylist.setPlaylistName(pathArray[pathArray.length - 1]); //gets folder name

        Path path = Paths.get(folderPath); // Get folder path from GUI
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) // Edit path
        {
            for (Path p : ds) 
            {
                pathArray = p.getFileName().toString().split("[\\.]+");           //splits the filepath
                String format = pathArray[pathArray.length - 1];                        //gets the format after the dot
                String fileName = pathArray[pathArray.length - 2];                      //gets the fileName before the dot
                
                if(format.equals("png") || format.equals("jpg") || format.equals("jpeg")) { //if album art
                    albumArtPath = p.toString();    //this is the album art
                    for (Song s : currentPlaylist)  //retroactively add the album art to all songs in playlist
                        s.setAlbumArtLocation(albumArtPath);
                    continue; //move to next file
                }

                // if the file is music:
                Song currentSong = new Song();
                currentSong.setSongName(fileName);
                currentSong.setLocal(true);
                currentSong.setLocalPath(p.toString());
                if (albumArtPath != null)
                    currentSong.setAlbumArtLocation(albumArtPath);
                currentPlaylist.add(currentSong);
            }
            
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        //currentDatabase.add(currentPlaylist);

        return currentPlaylist;
       
        // input.close();
    }

}
