import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final DatabaseQuery model = new DatabaseQuery();
    private FolderScanner scanner = new FolderScanner();

    /** 
     * Displays all playlists within the local directory of the computer the user 
     * is running the program on.
     * 
     * Does this by getting each playlist in index order and shows it 
     * by text area in the GUI.
     * 
     * @param screen the screen to display AllPlaylist to
     */
    public void displayAllPlaylists (JPanel screen) {
        ArrayList<Playlist> playlists = model.getAllPlaylists();
        int i = 1;
        for (Playlist playlist : playlists) {    // gets each playlist in index order and shows it in a gui's

            JButton newButton = new JButton(i++ + ". " + playlist.getPlaylistName() + "\n");
            int index = i-1;
            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayPlaylistContent(screen, index);
                }
            });
            screen.add(newButton);// text area




        }
    }
    //BB-89
    public void displayAllSongs(JPanel screen){
        ArrayList<String> songs = model.getAllSongs();
        int i = 1;
        for (String name : songs) {
            JButton newButton = new JButton(i++ + ". " + name);
            screen.add(newButton);
        }
    }
//BB-89
    public void displayAllAlbumList(JPanel screen){
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
    public void displayLikedList(JTextArea screen){
        Playlist songs = model.getLikedList();
        int i = 1;
        for (Song song : songs){
            String output = i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() + "\n \t" +
            song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
            screen.append(output);
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
    public void displayAlbumContent(JPanel screen, String album_name){
        screen.removeAll();
        screen.revalidate();
        screen.repaint();
        Playlist desiredPlaylist = model.getAlbumSongList(album_name);
        int i = 1;

        for(Song song : desiredPlaylist) {
            JButton newButton = new JButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");
            screen.add(newButton);
        }

    }

    /**
     * Appends a list of all unique artists with songs in the Database,
     * with their Song count, in the following format:
     * <p></p>1. ArtistName
     * <t>      </t>
     * Songs: #
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
     * @param screen the screen to display the artist details
     * @param artist_name variable used to hold the information about the specific artist
     */
    public void displayArtistContent (JPanel screen, String artist_name) {
        screen.removeAll();
        screen.revalidate();
        screen.repaint();
        Playlist desiredPlaylist = model.getArtistSongList(artist_name);
        int i = 1;

            for(Song song : desiredPlaylist) {
                JButton newButton = new JButton(i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() +
                        song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n");
                screen.add(newButton);
            }
    }

    public void inputScanner(String input, JPanel screen){
        Playlist reqplaylist = scanner.scanFolder(input);
        displayPlaylistContent(screen, reqplaylist);
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
                if (inLike) {
                    likeButton.setIcon(dislikeImage);
                    model.removeLikedSong(currentSong);
                    //removeSong();
                } else {
                    likeButton.setIcon(likeImage);
                    model.addLikedSong(currentSong);
                    //addSong();
                }
            }
        };
        likeButton.addActionListener(likeNow);
    }
    */


}
