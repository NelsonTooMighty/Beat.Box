import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Controller {
    private final DatabaseQuery model = new DatabaseQuery();
    private final Player songPlayer = new Player();
    private final FolderScanner scanner = new FolderScanner();
    private int click = 0;
    private JPanel mainScreen = new JPanel();
    private JPanel sideScreen = new JPanel();


    public Controller() throws Exception {
    }
    public Controller(JPanel mainPanel,JPanel sidePanel){
        this.mainScreen = mainPanel;
        this.sideScreen = sidePanel;
    }
    public void setMainPanel(JPanel mainPanel){
        this.mainScreen = mainPanel;
    }
    public void setsidePanel(JPanel sideSceen){
        this.sideScreen = sideSceen;
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
    public void displayAllPlaylists(JPanel mainScreen, JPanel sideScreen) {
        ArrayList<Playlist> playlists = model.getAllPlaylists();
        int i = 1;
        for (Playlist playlist : playlists) {    // gets each playlist in index order and shows it in a gui's
            JButton newButton = new JButton(i++ + ". " + playlist.getPlaylistName() + "\n");
            int index = i - 1;
            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayPlaylistContent(index);
                }
            });
            mainScreen.add(newButton);// text area

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
    public void displayAllAlbumList(JPanel mainScreen, JPanel sideScreen) {
        ArrayList<String> albums = model.getAllAlbums();
        int i = 1;
        for (String name : albums) {
            JButton newButton = new JButton(i++ + ". " + name);
            int index = i - 1;
            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayAlbumContent(mainScreen, name, sideScreen);
                }
            });


            mainScreen.add(newButton);
        }


    }

    /**
     * Appends the a list of songs that have been flaged as "liked" by the user
     * resulting in a similar structure to the displayPlaylistContent above.
     *
     * @param screen the scrren to display Liked Lists to
     */
    public void displayLikedList() {
        mainScreen.removeAll();
        mainScreen.repaint();
        mainScreen.revalidate();
        Playlist songs = model.getLikedList();
        int i = 1;
        for (Song song : songs) {
            JButton output = new JButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() + "\n \t" +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");
            output.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        songButtonAction(output);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            mainScreen.add(output);
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
    public void displayPlaylistContent( int playlistIndex) {
        displayPlaylistContent( model.getPlaylist_index(playlistIndex));
    }

    /**
     * Appends the content of the playlists once they are located on the local machine <br>
     *
     * The function utilizes string and append methods to pull the song name, artist name,
     * album name and album release date
     * @param screen the screen to display the Playlist content on
     * @param playlist the desired Playlist
     */
    public void displayPlaylistContent(Playlist playlist) {
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();

        int i = 1;
        for (Song song : playlist) {
            JButton newButton = new JButton(song.getAlbumArtImageIcon());
            String text = i++ + ". " + song.getSongName();
            if(song.getArtistName() != null) text += " " + song.getArtistName();
            if(song.getAlbumName() != null) text += " " + song.getAlbumName();
            if(song.getReleaseDate() != null) text += " " + song.getReleaseDate();

            newButton.setText(text);   // got code from https://www.tutorialspoint.com/swingexamples/create_button_with_icon_text.htm
            newButton.setVerticalTextPosition(AbstractButton.CENTER);
            newButton.setHorizontalTextPosition(AbstractButton.RIGHT);
            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        songButtonAction(newButton);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });



            //song - will have a clip to the player
            //
            mainScreen.add(newButton);
        }
    }

    //#BB-89
    public void displayAlbumContent(JPanel mainScreen, String album_name,JPanel sideScreen) {
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();
        Playlist desiredPlaylist = model.getAlbumSongList(album_name);
        int i = 1;

        for (Song song : desiredPlaylist) {
            JButton newButton = new JButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");
            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        songButtonAction(newButton);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            mainScreen.add(newButton);
        }

    }
public void inputScanner(String input){
        Playlist reqplaylist = scanner.scanFolder(input);
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();
        displayPlaylistContent(reqplaylist);
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
    public void displayAllArtistList(JPanel mainScreen,JPanel sideScreen) {
        mainScreen.removeAll();
        mainScreen.revalidate();
        ArrayList<String> artists = model.getAllArtists();
        int i = 1;
        for (String name : artists) {
            JButton newButton = new JButton(i++ + ". " + name + "\tSongs: " + model.getArtistSongCount(name) + "\n");
            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayArtistContent(mainScreen, name, sideScreen);
                }
            });

            mainScreen.add(newButton);
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
    public void displayArtistContent(JPanel mainScreen, String artist_name, JPanel sideScreen) {
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();
        Playlist desiredPlaylist = model.getArtistSongList(artist_name);
        int i = 1;

        for (Song song : desiredPlaylist) {
            JButton newButton = new JButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");
            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        songButtonAction(newButton);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            mainScreen.add(newButton);
        }
    }

    public void currentSongText(JPanel mainScreen, Song song) {           // as the song changes the image and info should change
        mainScreen.removeAll();
        mainScreen.repaint();
        mainScreen.revalidate();

        JButton output = new JButton();
        String songMessage = song.getSongName() + "\n \t" + song.getArtistName() + "\n\t" +
                song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
        output.setText(songMessage);   // got code from https://www.tutorialspoint.com/swingexamples/create_button_with_icon_text.htm
        output.setVerticalTextPosition(AbstractButton.BOTTOM);
        output.setHorizontalTextPosition(AbstractButton.CENTER);

        mainScreen.add(output);
        mainScreen.revalidate();
            }

    public void inputScanner(String input, JPanel mainScreen){
        Playlist reqplaylist = scanner.scanFolder(input);
        displayPlaylistContent(reqplaylist);
    }

   /** 
     * Used boolean, action listener and images to give a clean UI of 
     * like and dislike buttons.
     * 
     * As well as takes off or adds songs to specified playlist depending on 
     * user actions
     * 
     * @param likeButton the button that places and takes off songs from the LikedList
     */
   /*
      public void likeButtonEffects(JButton likeButton){
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
*/
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

    public void previousSong( JPanel mainScreen) {
        click++;
        if ((click % 2) == 0) {             // clicked back button twice should go back
            try {
                songPlayer.back();
                currentSongText(mainScreen, songPlayer.getCurrentSong()); //changes song image on main screen
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            songPlayer.restart();
        }
    }
    public void nextSong(JButton next, JPanel mainScreen) {
        ActionListener nextSong = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    songPlayer.next();
                    currentSongText(mainScreen, songPlayer.getCurrentSong()); //changes image on main screen
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        next.addActionListener(nextSong);
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
 public void songButtonAction(JButton currentSong) throws Exception {
     /*Playlist currentplaylist = currentSong.getPlaylist();
     songPlayer.setClip(currentplaylist);
     int index = currentplaylist.indexOf(currentSong.getSong());
     songPlayer.play(index);*/
     highlightMyMusic(currentSong,sideScreen,currentplaylist,index);
     currentSongText(mainScreen, currentSong.getSong());
 }



public void highlightMyMusic(JButton Song,JPanel sideScreen, Playlist desiredPlaylist,int index){
        sideScreen.removeAll();
        sideScreen.repaint();
        sideScreen.revalidate();

        int i =1;
        for(Song song : desiredPlaylist) {
            JButton newButton = new JButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");

            if (i == index){
                newButton.setForeground(Color.getHSBColor(255, 22, 22));
            }
            //song - will have a clip to the player
            //
            sideScreen.add(newButton);
        }




        }}