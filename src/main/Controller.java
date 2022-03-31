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
    public Song getSong(Playlist currentPlaylist,String songName){
        boolean foundSong = false;
        Iterator<Song> it = currentPlaylist.iterator();
        while(!foundSong && it.hasNext()){
            Song currentSong = it.next();
            if (songName.equals(currentSong.getTrackTitle())){
                foundSong = true;
                return currentSong;
            }
            else{it.next();}
        }
    }

    public Playlist getPlaylist(int index) {
        //use db[index] to get the requested playlist
        return null; //replace with a return with found playlist
    }

    //Input: name of a playlist
    //Search database for file with name (ArrayList methods can do this)
    //Output: playlist with matching name from Database/db
    public Playlist getPlaylist(String playlistName) {
        boolean hasPlaylist = false;
        Iterator<Playlist> it = model.iterator();                                // used so I don't have to create for loop and force an exit
        while(!hasPlaylist && it.hasNext()){                                     //check is existing artist playlist in database
            Playlist currentPlaylist = it.next();
            String currentPlaylistName = currentPlaylist.getPlaylistName();
            if (currentPlaylistName.equals(playlistName)){
                hasPlaylist = true;
                return currentPlaylist;
            }
            else{ it.next();}
            
        }
        return null;}

    //Input: index of a playlist, new name to set the playlist to
    //Output: renamed playlist object
    public Playlist renamePlaylist(int index, String newName) {return null;}

    //input: index of a playlist
    //remove playlist from Database/db
    //output: if the object was found and removed
    public boolean removePlaylist(int index) {
        boolean hasRemoved = false;
        if (index <= model.size()){
            model.remove(index);
            hasRemoved = true;
        }
        return hasRemoved;
    }
    public void removePlaylist (String playlistName){
        Playlist desiredPlaylist =  getPlaylist(playlistName);
        model.remove(desiredPlaylist);                                //found code from 
    }                                                                        //https://www.javatpoint.com/remove-an-element-from-arraylist-in-java
    public void removeSongfromPlaylist(String songName, String playlistName){
        boolean hasRemoved = false;
        Playlist desiredPlaylist = getPlaylist(playlistName);
        Song removeSong = getSong(desiredPlaylist,songName);
        desiredPlaylist.remove(removeSong);
    }
    public Playlist getArtistList(String artistName){
       boolean hasPlaylist = false;
       Iterator<Playlist> it = model.iterator();                             // used so I don't have to create for loop and force an exit
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
    public void displayPlaylistcontent(JTextArea screen,String playlistName){
        Playlist desiredPlaylist = getPlaylist(playlistName);
        for(Song song:desiredPlaylist){
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
