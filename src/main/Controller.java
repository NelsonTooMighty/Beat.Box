import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Controller {
    private PlaylistFrame view;
    private DatabaseQuery model = new DatabaseQuery();

    public Controller(PlaylistFrame view) {
        this.view = view;
    }

    public void displayAllPlaylists (JTextArea screen){
        ArrayList<Playlist> playlists = model.getAllPlaylists();
        for (Playlist playlist : playlists) {                                // gets each playlist in alphabetical order and shows it in a gui's
            screen.append(playlist.getPlaylistName());                  // text area
        }
    }

    public void displayPlaylistcontent(JTextArea screen, String playlistName){
        Playlist desiredPlaylist = model.getPlaylist(playlistName);
        for(Song song:desiredPlaylist){
            String songMessage = song.getTrackTitle() + "\n \t" + song.getArtistName() +
                    song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
            screen.append(songMessage);
        }
    }

    public Playlist getArtistList(String artistName){
        boolean hasPlaylist = false;
        Iterator<Playlist> it = model.iterator();                                // used so I don't have to create for loop and force an exit
        while(!hasPlaylist && it.hasNext()){                                 //check is existing artist playlist in database
            Playlist currentPlaylist = it.next();
            String currentPlaylistName = currentPlaylist.getPlaylistName();
            if (currentPlaylistName.equals(artistName)){
                hasPlaylist = true;
                return currentPlaylist;
            }
            else{ currentPlaylist = it.next();}
        }
        if(!hasPlaylist){                                                    //if there is no playlist it creates one and adds songs with
            Playlist artistPlaylist = new Playlist();                        // artists name stored in its class
            artistPlaylist.setPlaylistName(artistName);
            ArrayList<Playlist> playlists = model.getAllPlaylists();
            for (Playlist playlist : playlists){
                for (Song song : playlist){
                    if (artistName.equals(song.getArtistName()))
                        artistPlaylist.add(song);
                }
            }
            return artistPlaylist;
        }
        return null;
    }

}
