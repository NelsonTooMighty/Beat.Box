import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class folderScanner {
    public String songTitle(){
        Scanner input = new Scanner(System.in);
        String songName;
        int stringLength;
        Path path = Paths.get(input.nextLine());
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)) {
            for (Path p : ds) {
                Song currentSong = new Song();
                current
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        input = new Scanner(System.in);

        while(input.hasNext()){
            songName = input.next();
            songName.split
            stringLength = songName.length();
            if(songName.contains(".mp3") || songName.contains(".wav")){
                songName = songName.substring(0,stringLength -4);
            }
            else if (songName.contains(".flac")){
                songName = songName.substring(0,stringLength-5);
            }


            System.out.println(songName);
            return songName;
        }

    }

}
