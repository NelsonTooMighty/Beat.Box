
import javax.swing.*;

public class FavoritePlaylistCreator extends LayoutFrame {

    public void createLikeList() {
        Playlist likedPlaylist = new Playlist();
        Database currentDatabase = Database.getInstance(); // gets access to user's database
        
        // got code above from https://www.oreilly.com/library/view/java-swing/156592455X/ch04s02.html
        Boolean isLiked = false;
        JButton likeButton = new JButton(dislikeImage);
        Song currentSong; //supposed to hold current song being Played
        currentDatabase.add(likedPlaylist);


        
    }
   
}
