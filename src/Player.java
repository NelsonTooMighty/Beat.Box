import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Player  {

    public Player() throws LineUnavailableException, UnsupportedAudioFileException, IOException  {
        File file = new File ("befine.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);


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
