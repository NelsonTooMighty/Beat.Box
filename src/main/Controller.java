import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final DatabaseQuery model = new DatabaseQuery();
    private final Player songPlayer = new Player();


    public Controller() throws Exception {
    }

    /**
     * Displays all playlists within the local directory of the computer the user
     * is running the program on.
     * <p>
     * Does this by getting each playlist in index order and shows it
     * by text area in the GUI.
     *
     * @param screen the screen to display AllPlaylist to
     */
    public void displayAllPlaylists(JPanel screen) {
        ArrayList<Playlist> playlists = model.getAllPlaylists();
        int i = 1;
        for (Playlist playlist : playlists) {    // gets each playlist in index order and shows it in a gui's
            JButton newButton = new JButton(i++ + ". " + playlist.getPlaylistName() + "\n");
            int index = i - 1;
            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayPlaylistContent(screen, index);
                }
            });
            screen.add(newButton);// text area


        }
        Playlist pl = new Playlist();
        try {
            pl.add(new Song("", "", "", "", "demo local files/Beethoven.wav", true));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        songPlayer.setClip(pl);
        try {
            songPlayer.play(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //BB-89
    public void displayAllSongs(JPanel screen) {
        ArrayList<String> songs = model.getAllSongs();
        int i = 1;
        for (String name : songs) {
            JButton newButton = new JButton(i++ + ". " + name);
            screen.add(newButton);
        }
    }

    //BB-89
    public void displayAllAlbumList(JPanel screen) {
        ArrayList<String> albums = model.getAllAlbums();
        int i = 1;
        for (String name : albums) {
            JButton newButton = new JButton(i++ + ". " + name);
            int index = i - 1;
            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayAlbumContent(screen, name);
                }
            });


            screen.add(newButton);
        }


    }

    /**
     * Appends the a list of songs that have been flaged as "liked" by the user
     * resulting in a similar structure to the displayPlaylistContent above.
     *
     * @param screen the scrren to display Liked Lists to
     */
    public void displayLikedList(JPanel screen) {
        screen.removeAll();
        screen.repaint();
        screen.revalidate();
        Playlist songs = model.getLikedList();
        int i = 1;
        for (Song song : songs) {
            JButton output = new JButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() + "\n \t" +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");
            screen.add(output);
        }
    }

    /**
     * Appends the content of the playlists once they are located on the local machine <br>
     * 
     * The function utilizes string and append methods to pull the song name, artist name,
     * album name and album release date
     * 
     * @param screen the screen to display the Playlist content on
     * @param playlistIndex the index of the desired Playlist
     */
    public void displayPlaylistContent(JPanel screen, int playlistIndex) {
        displayPlaylistContent(screen, model.getPlaylist_index(playlistIndex));
    }

    /**
     * Appends the content of the playlists once they are located on the local machine <br>
     *
     * The function utilizes string and append methods to pull the song name, artist name,
     * album name and album release date
     * @param screen the screen to display the Playlist content on
     * @param playlist the desired Playlist
     */
    public void displayPlaylistContent(JPanel screen, Playlist playlist) {
        screen.removeAll();
        screen.revalidate();
        screen.repaint();

        int i = 1;
        for (Song song : playlist) {
            String text = i++ + ". " + song.getSongName();
            if(song.getArtistName() != null) text += " " + song.getArtistName();
            if(song.getAlbumName() != null) text += " " + song.getAlbumName();
            if(song.getReleaseDate() != null) text += " " + song.getReleaseDate();
            JButton newButton = new JButton(text);
            //song - will have a clip to the player
            //
            screen.add(newButton);
        }
    }

    //#BB-89
    public void displayAlbumContent(JPanel screen, String album_name) {
        screen.removeAll();
        screen.revalidate();
        screen.repaint();
        Playlist desiredPlaylist = model.getAlbumSongList(album_name);
        int i = 1;

        for (Song song : desiredPlaylist) {
            JButton newButton = new JButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");
            screen.add(newButton);
        }

    }
public void inputScanner(String input, JPanel screen){
        Playlist reqplaylist = scanner.scanFolder(input);
        screen.removeAll();
        screen.revalidate();
        screen.repaint();
        displayPlaylistContent(screen, reqplaylist);
}

    /**
     * Appends a list of all unique artists with songs in the Database,
     * with their Song count, in the following format:
     * <p></p>1. ArtistName
     * <t>      </t>
     * Songs: #
     *
     * @param screen the screen to display artist lists to
     */
    public void displayAllArtistList(JPanel screen) {
        screen.removeAll();
        screen.revalidate();
        ArrayList<String> artists = model.getAllArtists();
        int i = 1;
        for (String name : artists) {
            JButton newButton = new JButton(i++ + ". " + name + "\tSongs: " + model.getArtistSongCount(name) + "\n");
            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayArtistContent(screen, name);
                }
            });

            screen.add(newButton);
        }
    }

    /**
     * Appends the content of the Artist within the given playlist
     * providing the song name, artist name, album name and release date
     * for the specified Artist.
     *
     * @param screen      the screen to display the artist details
     * @param artist_name variable used to hold the information about the specific artist
     */
    public void displayArtistContent(JPanel screen, String artist_name) {
        screen.removeAll();
        screen.revalidate();
        screen.repaint();
        Playlist desiredPlaylist = model.getArtistSongList(artist_name);
        int i = 1;

        for (Song song : desiredPlaylist) {
            JButton newButton = new JButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");
            screen.add(newButton);
        }
    }

    public void currentSongImage(JPanel mainScreen, Song song) {           // as the song changes the image and info should change
        mainScreen.removeAll();
        mainScreen.repaint();
        mainScreen.revalidate();

        displayPlaylistContent(screen, reqplaylist);
        /*
        int i =0;
        for(Song song : reqplaylist) {
            JButton newButton = new JButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");

            if (i == index){
                newButton.setForeground(Color.getHSBColor(255, 22, 22));
            }
            //song - will have a clip to the player
            //
            sideScreen.add(newButton);
        }
        */


    }

   /** 
     * Used boolean, action listener and images to give a clean UI of 
     * like and dislike buttons.
     * 
     * As well as takes off or adds songs to specified playlist depending on 
     * user actions
     * 
     * @param likeButton the button that places and takes off songs from the LikedList
     * 
     * public void likeButtonEffects(JButton likeButton){
        Song currentSong;
        ImageIcon dislikeImage = new ImageIcon("src/resources/GreyBox.png"),
                likeImage = new ImageIcon("../resources/Beat.Box.png");
        boolean inLike = model.checkLike(currentSong);
        ActionListener likeNow = new ActionListener() { // supposed to react when user clicks the icon
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    songPlayer.next();
                    currentSongImage(mainScreen, songPlayer.getCurrentSong()); //changes image on main screen
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        next.addActionListener(nextSong);
    }

    public void playButton(JButton play) {
        ActionListener playSong = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (songPlayer.loadedClip() && !songPlayer.isRunning()) { // check to see if available and running
                    try {
                        songPlayer.play();
                        ImageIcon playImage = new ImageIcon("src/resources/buttonDesign/play.png");
                        play.setIcon(playImage);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    songPlayer.pause();
                    ImageIcon pauseImage = new ImageIcon("src/resources/buttonDesign/pause.png");
                    play.setIcon(pauseImage);
                }
            }
        };
        play.addActionListener(playSong);
    }

    public void previousSong(JButton back, JPanel mainScreen) {

        ActionListener goBack = new ActionListener() {
            int click = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                click++;
                if ((click % 2) == 0) {             // clicked back button twice should go back
                    try {
                        songPlayer.back();
                        currentSongImage(mainScreen, songPlayer.getCurrentSong()); //changes song image on main screen
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    songPlayer.restart();
                }
            }
        };
    }

    /**
     * Used boolean, action listener and images to give a clean UI of
     * like and dislike buttons.
     * <p>
     * As well as takes off or adds songs to specified playlist depending on
     * user actions
     *
     * @param likeButton the button that places and takes off songs from the LikedList
     *                   <p>
     *                   public void likeButtonEffects(JButton likeButton){
     *                   Song currentSong;
     *                   ImageIcon dislikeImage = new ImageIcon("src/resources/GreyBox.png"),
     *                   likeImage = new ImageIcon("../resources/Beat.Box.png");
     *                   boolean inLike = model.checkLike(currentSong);
     *                   ActionListener likeNow = new ActionListener() { // supposed to react when user clicks the icon
     * @Override public void actionPerformed(ActionEvent e) {
     * if (inLike) {
     * likeButton.setIcon(dislikeImage);
     * model.removeLikedSong(currentSong);
     * //removeSong();
     * } else {
     * likeButton.setIcon(likeImage);
     * model.addLikedSong(currentSong);
     * //addSong();
     * }
     * }
     * };
     * likeButton.addActionListener(likeNow);
     * }
     */
    public void displayPlaylistContent(JPanel mainScreen, Playlist playlist, JPanel sideScreen) throws Exception {
        mainScreen.removeAll();
        mainScreen.repaint();
        mainScreen.revalidate();
        int i = 1;
        for (Song song : playlist) {
            JButton output = new JButton(song.getAlbumArtImageIcon());
            String songMessage = i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() + "\n\t" +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
            output.setText(songMessage);   // got code from https://www.tutorialspoint.com/swingexamples/create_button_with_icon_text.htm
            output.setVerticalTextPosition(AbstractButton.CENTER);
            output.setHorizontalTextPosition(AbstractButton.RIGHT);
            ActionListener playSong = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        SongButtonAction(output, mainScreen, sideScreen); // adds action listener to each button
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            };
            output.addActionListener(playSong);
        }
    }
}