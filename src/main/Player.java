import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;


public class Player  {
    private Clip currentClip;
    private LinkedList<Clip> clipList;

    public void setClip(Clip newClip){
        this.currentClip = newClip;
    }
    public void setCliplist(Playlist playlist){
        for(Song song: playlist){
            clipList.add(song.getClip()); //TODO only add here if it's local
        }
    }
    public void play(){
        currentClip.start();
    }
    public void pause(){
        currentClip.stop();
    }
    public void restart(){
        currentClip.setMicrosecondPosition(0);
        currentClip.start();
    }

    public Player() throws Exception {
        File file = new File ("demo local files/Beethoven.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);


/* Temp way to read local files to play song on gui (Austin's Input for local file reading)
        
        
        public class Player {
            public static void main(String[] args) {
            Player player = new Player();
            List<song> playlist = player.makeMusicList();

            for(int i =0; i < 4; i++){
                player.play(playlist);
        }
    }
        public List<song> makeMusicList() {
            List<song> musicBucket = new ArrayList<song>();
            musicBucket.add(new song("Song Name", "PathToMusicFile"));
            musicBucket.add(new song("Song Name", "PathToMusicFile"));
            musicBucket.add(new song("Song Name", "PathToMusicFile"));
            musicBucket.add(new song("Song Name", "PathToMusicFile"));
            musicBucket.add(new song("Song Name", "PathToMusicFile"));
                return musicBucket;
    }
}
*/

        JFrame frame = new JFrame();
        JLabel SongName = new JLabel();

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clip.start();
                //SongName.setText(" Playing Be Fine by Drake");


            }
        });
        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clip.stop();
              //  SongName.setText("Paused Be Fine by Drake");
            }
        });
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
              //  SongName.setText(" Playing Be Fine by Drake");

            }
        });
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 3));
        panel.add(SongName);
        panel.add(playButton);
        panel.add(pauseButton);
        panel.add(restartButton);

        panel.add(SongName);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Music Player");
        frame.pack();
        frame.setVisible(true);
    }




}
