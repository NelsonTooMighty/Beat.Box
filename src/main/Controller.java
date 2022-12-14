import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final DatabaseQuery model = new DatabaseQuery();
    private final Player songPlayer = new Player();
    private final FolderScanner scanner = new FolderScanner();
    private int click = 0;
    private JPanel mainScreen = new JPanel();
    private JPanel sideScreen = new JPanel();


    public Controller() {
    }
    public Controller(JPanel mainPanel,JPanel sidePanel){
        this.mainScreen = mainPanel;
        this.sideScreen = sidePanel;
    }
    public void setMainPanel(JPanel mainPanel){
        this.mainScreen = mainPanel;
    }
    public void setSidePanel(JPanel sideScreen){
        this.sideScreen = sideScreen;
    }

    public JPanel displayPlaylist(Playlist playlist, String label) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setVisible(true);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        PlaylistButton playlistButton = new PlaylistButton(label);
        JButton saveButton = new JButton(new ImageIcon(new ImageIcon("src/resources/DL.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        JButton exportButton = new JButton(new ImageIcon(new ImageIcon("src/resources/Spotify_Logo.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));

        playlistButton.setPlaylist(playlist);
        playlistButton.addActionListener(e -> displayPlaylistContent(playlist));
        saveButton.addActionListener(e -> Database.getInstance().saveToFile(playlist));
        exportButton.addActionListener(e -> new SpotifyExporter().exportPlaylist(playlist));

        buttonPanel.add(playlistButton);// text area
        buttonPanel.add(saveButton);
        buttonPanel.add(exportButton);
        buttonPanel.revalidate();
        mainScreen.add(buttonPanel);
        return buttonPanel;
    }

    /**
     * Displays all playlists within the local directory of the computer the user
     * is running the program on.
     * <p>
     * Does this by getting each playlist in index order and shows it
     * by text area in the GUI.
     */
    public void displayAllPlaylists() {
        ArrayList<Playlist> playlists = model.getAllPlaylists();
        int i = 1;
        for (Playlist playlist : playlists) {    // gets each playlist in index order and shows it in a gui's
            JPanel buttonPanel = null;
            if (playlist != null) {
                buttonPanel = displayPlaylist(playlist, i++ + ". " + playlist.getPlaylistName() + "\n");
                JButton deleteButton = new JButton(new ImageIcon(new ImageIcon("src/resources/delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
                deleteButton.addActionListener(e -> {
                    Database.getInstance().remove(playlist);
                    mainScreen.removeAll();
                    mainScreen.repaint();
                    displayAllPlaylists();
                    mainScreen.revalidate();
                });
                buttonPanel.add(deleteButton);
            }
        }
    }

    //BB-89
    public void displayAllSongs() {
        ArrayList<Playlist> allPlaylists = model.getAllPlaylists();
        int i = 1;
        for (Playlist playlist : allPlaylists) {
            for(Song song : playlist) {
                SongButton newButton = new SongButton(i++ + ". " + song.getSongName());
                newButton.setSong(song);
                newButton.setPlaylist(playlist);
                mainScreen.add(newButton);
            }
        }
    }

    //BB-89
    public void displayAllAlbumList() {
        ArrayList<String> albums = model.getAllAlbums();
        int i = 1;
        for (String name : albums) {
            displayPlaylist(model.getAlbumSongList(name), i++ + ". " + name);
        }


    }

    /**
     * Appends the list of songs that have been flagged as "liked" by the user
     * resulting in a similar structure to the displayPlaylistContent above.
     */
    public void displayLikedList() {
        mainScreen.removeAll();
        mainScreen.repaint();
        mainScreen.revalidate();
        Playlist songs = model.getLikedList();
        int i = 1;
        for (Song song : songs) {
            SongButton output = new SongButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() + "\n \t" +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");
            output.setSong(song);
            output.setPlaylist(songs);
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
     * @param playlistIndex the index of the desired Playlist
     */
    public void displayPlaylistContent(int playlistIndex) {
        displayPlaylistContent(model.getPlaylist_index(playlistIndex));
    }

    /**
     * Appends the content of the playlists once they are located on the local machine <br>
     *
     * The function utilizes string and append methods to pull the song name, artist name,
     * album name and album release date
     * @param playlist the desired Playlist
     */
    public void displayPlaylistContent(Playlist playlist) {
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();

        int i = 1;
        for (Song song : playlist) {
            SongButton newButton = new SongButton(song.getAlbumArtImageIcon());
            String text = i++ + ". " + song.getSongName();
            if(song.getArtistName() != null) text += "    " + song.getArtistName();
            if(song.getAlbumName() != null) text += "    " + song.getAlbumName();
            if(song.getReleaseDate() != null) text += "    " + song.getReleaseDate();

            newButton.setText(text);   // got code from https://www.tutorialspoint.com/swingexamples/create_button_with_icon_text.htm
            newButton.setPlaylist(playlist);
            newButton.setSong(song);
            newButton.addActionListener(e -> {
                try {
                    songButtonAction(newButton);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });



            //song - will have a clip to the player
            //
            mainScreen.add(newButton);
        }
    }

    //#BB-89
    public void displayAlbumContent(String album_name) {
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();
        Playlist desiredPlaylist = model.getAlbumSongList(album_name);
        int i = 1;

        for (Song song : desiredPlaylist) {
            SongButton songButton = new SongButton(i++ + ". " + song.getSongName() + "  " + song.getArtistName() + "  " +
                    song.getAlbumName() + "  " + song.getReleaseDate());
            songButton.setSong(song);
            songButton.setPlaylist(desiredPlaylist);
            songButton.addActionListener(e -> songButtonAction(songButton));
            mainScreen.add(songButton);
        }
    }

    /**
     * Appends a list of all unique artists with songs in the Database,
     * with their Song count, in the following format:
     * <p></p>1. ArtistName
     * <t>      </t>
     * Songs: #
     *
     */
    public void displayAllArtistList() {
        mainScreen.removeAll();
        mainScreen.revalidate();
        ArrayList<String> artists = model.getAllArtists();
        int i = 1;
        for (String name : artists) {
            displayPlaylist(model.getArtistSongList(name), i++ + ". " + name + "  Songs: " + model.getArtistSongCount(name));
        }
    }

    /**
     * Appends the content of the Artist within the given playlist
     * providing the song name, artist name, album name and release date
     * for the specified Artist.
     *
     * @param artist_name variable used to hold the information about the specific artist
     */
    public void displayArtistContent(String artist_name) {
        mainScreen.removeAll();
        mainScreen.revalidate();
        mainScreen.repaint();
        Playlist desiredPlaylist = model.getArtistSongList(artist_name);
        int i = 1;

        for (Song song : desiredPlaylist) {
            SongButton newButton = new SongButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() + "  " +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");
            newButton.setPlaylist(desiredPlaylist);
            newButton.setSong(song);
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

    public void currentSongText(Song song) {           // as the song changes the image and info should change
        mainScreen.removeAll();
        mainScreen.repaint();
        mainScreen.revalidate();

        PlaylistButton output = new PlaylistButton();
        String songMessage = song.getSongName() + "\n \t" + song.getArtistName() + "\n\t" +
                song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
        output.setText(songMessage);   // got code from https://www.tutorialspoint.com/swingexamples/create_button_with_icon_text.htm
        output.setVerticalTextPosition(AbstractButton.BOTTOM);
        output.setHorizontalTextPosition(AbstractButton.CENTER);

        mainScreen.add(output);
        mainScreen.revalidate();
    }

    /**
     * Used boolean, action listener and images to give a clean UI of 
     * like and dislike buttons.
     * 
     * As well as takes off or adds songs to specified playlist depending on 
     * user actions
     * 
     * //@param likeButton the button that places and takes off songs from the LikedList
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

    public void previousSong() {
        click++;
        if ((click % 2) == 0) {             // clicked back button twice should go back
            try {
                songPlayer.back();
                currentSongText(songPlayer.getCurrentSong()); //changes song image on main screen
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            songPlayer.restart();
        }
    }
    public void nextSong(JButton next) {
        ActionListener nextSong = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    songPlayer.next();
                    currentSongText(songPlayer.getCurrentSong()); //changes image on main screen
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
    //  * @param likeButton the button that places and takes off songs from the LikedList
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
    public void songButtonAction(SongButton currentSong) {
        Playlist currentPlaylist = currentSong.getPlaylist();
        songPlayer.setClip(currentPlaylist);
        int index = currentPlaylist.indexOf(currentSong.getSong());
        songPlayer.play(index);
        highlightMyMusic(currentSong,currentPlaylist,index);
        currentSongText(currentSong.getSong());
    }



    public void highlightMyMusic(JButton Song, Playlist desiredPlaylist, int index){
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
    }

    public void importURI(String input) {
        Playlist reqPlaylist = null;
        if (input.contains("spotify"))
            reqPlaylist = new SpotifyImporter().importPlaylist(input);
        else if (input.contains("youtube"))
            reqPlaylist = new YTMusicImporter().importPlaylist(input);
        else
            reqPlaylist = scanner.scanFolder(input);
        if(reqPlaylist == null) return;
        Database.getInstance().add(reqPlaylist);
        displayPlaylistContent(reqPlaylist);
    }
}