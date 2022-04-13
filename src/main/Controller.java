import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final DatabaseQuery model = new DatabaseQuery();

    //JtextArea to Jpanel to help
    public void displayAllPlaylists (JPanel screen) {
        ArrayList<Playlist> playlists = model.getAllPlaylists();
        int i = 1;
        for (Playlist playlist : playlists) {    // gets each playlist in index order and shows it in a gui's
            JButton newButton = new JButton(i++ + ". " + playlist.getPlaylistName() + "\n");
            screen.add(newButton);   // text area
        }
    }

    public void displayPlaylistContent(JTextArea screen, int playlistIndex) {
        Playlist desiredPlaylist = model.getPlaylist_index(playlistIndex);
        int i = 1;
        if (desiredPlaylist == null)
            screen.append("Error: Playlist not found!\n");
        else
            for(Song song : desiredPlaylist) {
                String songMessage = i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() +
                        song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
                screen.append(songMessage);
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

    //displaying all songs of the picked artist        //BB-55 Naomi
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




    /* public void likeButtonEffects(JButton likeButton){
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
    }*/
    public void displayLikedList(JTextArea screen){
        Playlist songs = model.getLikedList();
        int i = 1;
        for (Song song : songs){
            String output = i++ + ". " + song.getSongName() + "\n \t" + song.getArtistName() + "\n \t" +
            song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
            screen.append(output);
        }
    }
}
