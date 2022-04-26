import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Player  {
    private Clip currentClip;
    private Playlist currentPlaylist;
    private Song currentSong;
    private AudioInputStream audioStream;
    private ListIterator<Song> nowPlaying;// = currentPlaylist.listIterator(); // used to allow changes of traversal of LinkedList can
                                                                // can be changed to for loop if easier
    private int songIndex;
    public Player() {

    }

    public void setClip(Clip newClip) throws LineUnavailableException, IOException {
        if(!currentPlaylist.isEmpty()){
            currentPlaylist.clear();   // supposed to make linked list empty
        }
        this.currentClip = newClip;
        currentClip.open(audioStream);
        if (currentPlaylist != null)
            nowPlaying = currentPlaylist.listIterator();
    }
    public void setClip(Song song) throws Exception {

        if(!currentPlaylist.isEmpty()){
            currentPlaylist.clear();   // supposed to make playlist empty
        }
        this.currentClip = makeClip(song.getLocalPath());
        currentClip.open(audioStream);
    }
    public void setClip(Playlist playlist){
        this.currentPlaylist = playlist;
    }
    public void play() throws Exception {
         currentClip.start();                                        // plays immediately stored song
        while (nowPlaying != null && nowPlaying.hasNext()) {         // checks to see if list is not empty
            currentSong = nowPlaying.next();
            currentClip = makeClip(currentSong.getLocalPath());      // uses string to find song and makes it into playable clip
            play();                                                  // recursive play onwards
        }

    }
    public void play(int index) throws Exception {
        for(int i = 0;i != index;i++){nowPlaying.next();}            //makes counter go to indexed position
        currentSong = currentPlaylist.get(index);
        currentClip = makeClip(currentSong.getLocalPath());
        songIndex = index;
        play();



    }
    public void pause(){
            currentClip.stop();
    }
    public void next() throws Exception {
        if (nowPlaying.hasNext()) {                                // checks to see if list is not empty
            currentSong = nowPlaying.next();                       // gets next song
            songIndex = currentPlaylist.indexOf(currentSong);
            currentClip = makeClip(currentSong.getLocalPath());    // uses string to find song and makes it into playable clip
            play();

        }
    }
    public void restart(){
        currentClip.setMicrosecondPosition(0);
        currentClip.start();
    }

    public void back() throws Exception {                 // goes back on playlist if there are previous songs
        if(nowPlaying.hasPrevious()){
            currentSong = nowPlaying.previous();
            songIndex = currentPlaylist.indexOf(currentSong);
           currentClip = makeClip(currentSong.getLocalPath());
           play();
        }
        else{                                             // else just repeats the song
            restart();
        }
    }
    public Song getCurrentSong(){
        return currentSong;
    }
    public boolean loadedClip(){
        if(currentClip.isOpen()){return true;}
        else {return false;}
    }
    public boolean isRunning(){
        return currentClip.isRunning();
    }
    public String getSongTime (){
        long lengthInms = currentClip.getMicrosecondLength();
        long lengthInMin = TimeUnit.MICROSECONDS.toMinutes(lengthInms);
        long remainder =(TimeUnit.MICROSECONDS.toSeconds(lengthInms) % 60);
        return (String) (lengthInMin + ":"+ remainder);
    }
    public long getCurrentTime(){
        return currentClip.getMicrosecondPosition();
    }

    private Clip makeClip(String filePath) throws Exception{
        File file = new File (filePath);
        audioStream = AudioSystem.getAudioInputStream(file);
        Clip songClip = AudioSystem.getClip();
        songClip.open(audioStream);
        return songClip;
    }
    public int getSongIndex(){
        return songIndex;
    }


}
