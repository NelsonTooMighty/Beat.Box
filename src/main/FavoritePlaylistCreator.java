/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FavoritePlaylistCreator extends LayoutFrame {

    public void createLikeList(){

    Playlist likedPlaylist = new Playlist();
    Database currentDatabase = Database.getInstance(); // gets access to user's database
    ImageIcon dislikeImage = new ImageIcon("GreyBox.png"),  
               likeImage = new ImageIcon("beatBox.png");
    // got code above from https://www.oreilly.com/library/view/java-swing/156592455X/ch04s02.html
    Boolean isLiked = false;
    JButton likeButton = new JButton(dislikeImage);
    Song currentSong; //supposed to hold current song being Played
    currentDatabase.add(likedPlaylist);

    
    ActionListener likeNow = new ActionListener(){ // supposed to react when user clicks the icon
        @Override
        public void actionPerformed(ActionEvent e){
            if (isLiked){ 
                likeButton.setIcon(dislikeImage);
                removeSong();
            }
            else{
                likeButton.setIcon(likeImage);
                addSong();
            }
        }
    };

    
    }
    private void addSong(){likedPlaylist.add(currentSong);}
    private void removeSong(){likedPlaylist.remove(currentSong);}
    
    
}
*/