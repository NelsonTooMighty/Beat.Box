import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final DatabaseQuery model = new DatabaseQuery();

    /** 
     * Displays all playlists within the local directory of the computer the user 
     * is running the program on.
     * 
     * Does this by getting each playlist in index order and shows it 
     * by text area in the GUI.
     * 
     * @param screen the screen to display AllPlaylist to
     */
    public void displayAllPlaylists (JTextArea screen) {
        ArrayList<Playlist> playlists = model.getAllPlaylists();
        int i = 1;
        for (Playlist playlist : playlists) {                                // gets each playlist in index order and shows it in a gui's
            screen.append(i++ + ". " + playlist.getPlaylistName() + "\n");   // text area
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
     * Appends the content of the playlist's once they are located on the local machine
     * 
     * The function utilizes string and append methods to pull the song name, artist name,
     * album name and album release date
     * 
     * @param screen the screen to display the PlaylistContent to
     * @param playlistIndex the index that iterates through local files and fills itself
     */
    public void displayPlaylistContent(JTextArea screen, int playlistIndex) {
        Playlist desiredPlaylist = model.getPlaylist_index(playlistIndex);
        int i = 1;
        if (desiredPlaylist == null)
            screen.append("Error: Playlist not found!\n");
        else {
            screen.append(desiredPlaylist.getPlaylistName() + ": \n");
            for (Song song : desiredPlaylist) {
                String songMessage = i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() + "\n\t" +
                        song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
                screen.append(songMessage);
            }
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
    public void displayAllArtistList(JTextArea screen) {
        ArrayList<String> artists = model.getAllArtists();
        int i = 1;
        for (String name : artists) {
            String output = i++ + ". " + name + "\tSongs: " + model.getArtistSongCount(name) + "\n";
            screen.append(output);
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
    public void displayArtistContent (JTextArea screen, String artist_name) {
        Playlist desiredPlaylist = model.getArtistSongList(artist_name);
        int i = 1;
        if (desiredPlaylist == null)
            screen.append("Error: Artist Playlist not found!\n");
        else
            for(Song song : desiredPlaylist) {
                String songMessage = i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() +
                        song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
                screen.append(songMessage);
            }
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
