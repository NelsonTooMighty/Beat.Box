import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        /*
        SpotifyImporter si = new SpotifyImporter();
        Playlist pl = si.importPlaylist("https://open.spotify.com/playlist/2DxvKWtxPfttWviSORrEqc");
        for (Song song : pl) {
            System.out.println(song.getSongName() + "\n");
        }
        */
        /*
        Database db = Database.getInstance();
        {
            Playlist test = new Playlist();
            test.setPlaylistName("Daft Punk");
            test.add(new Song("Robot Rock", "Daft Punk", "Robot Rock", "2010", "https://f4.bcbits.com/img/a1702319957_16.jpg"));
            db.saveToFile(test, "demo local files/serialized_playlist_demo_2");

            Playlist demo = new Playlist();
            demo.setPlaylistName("The Beautiful Game");
            demo.add(new Song("The Sweet Science", "Vulfpeck", "The Beautiful Game", "2016", "https://f4.bcbits.com/img/a1702319957_16.jpg"));
            demo.add(new Song("Animal Spirits", "Vulfpeck", "The Beautiful Game", "2016", "https://f4.bcbits.com/img/a1702319957_16.jpg"));
            demo.add(new Song("Dean Town", "Vulfpeck", "The Beautiful Game", "2016", "https://f4.bcbits.com/img/a1702319957_16.jpg"));
            demo.add(new Song("Conscious Club", "Vulfpeck", "The Beautiful Game", "2016", "https://f4.bcbits.com/img/a1702319957_16.jpg"));
            demo.add(new Song("Aunt Leslie", "Vulfpeck", "The Beautiful Game", "2016", "https://f4.bcbits.com/img/a1702319957_16.jpg"));
            demo.add(new Song("Cory Wong", "Vulfpeck", "The Beautiful Game", "2016", "https://f4.bcbits.com/img/a1702319957_16.jpg"));
            db.saveToFile(demo, "demo local files/serialized playlist demo");


            int i = 1;
            System.out.println("\n\n-------Contents of serialized playlist:--------");
            Playlist demoIn = db.loadFromFile("demo local files/serialized playlist demo");
            for (Song s : demoIn)
                System.out.println(i++ + ". " + s.getSongName());
            System.out.println("-----------------------------------------------\n");
        }
        */
        //Demo demo = new Demo();

    }
}
