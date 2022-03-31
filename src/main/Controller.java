import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
public class Controller {
    private PlaylistFrame view;
    private Database model = Database.getInstance();

    public Controller(PlaylistFrame view) {
        this.view = view;

    }

    public Playlist getPlaylist(int index) {
        //use db[index] to get the requested playlist
        return null; //replace with a return with found playlist
    }

    //Input: name of a playlist
    //Search database for file with name (ArrayList methods can do this)
    //Output: playlist with matching name from Database/db
    public Playlist getPlaylist(String playlistName) {return null;}

    //Input: index of a playlist, new name to set the playlist to
    //Output: renamed playlist object
    public Playlist renamePlaylist(int index, String newName) {return null;}

    //input: index of a playlist
    //remove playlist from Database/db
    //output: if the object was found and removed
    public boolean removePlaylist(int index) {return false;}
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
            for (Playlist playlists : model){
                for (Song song : playlists){
                    if (artistName.equals(song.getArtistName()))
                        artistPlaylist.add(song);
                }
            }
                return artistPlaylist;
        }   
        }
    public void displayPlaylistcontent(JTextArea screen,Playlist playlistName){
        for(Song song:playlistName){
            String songMessage = song.getTrackTitle() + "\n \t" + song.getArtistName() +
                                 song.getAlbumName() + "\n \t" + song.getReleaseDate() + "\n\n";
            screen.append(songMessage);
        }

    }

    public void displayAllPlaylists (JTextArea screen){
            for (Playlist playlists : model){                                // gets each playlist in alphabetical order and shows it in a gui's
                screen.append(playlists.getPlaylistName());                  // text area
            }
        }

    //gets all playlistnames
    public String getPlaylistNames(){
        return null;


    }
}
