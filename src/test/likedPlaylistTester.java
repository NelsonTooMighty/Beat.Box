
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class likedPlaylistTester {
    @Test
    @DisplayName("Test to see if liked Playlist exists")
    public void testLikedPlaylist(){
       // final DatabaseQuery likeTest = new DatabaseQuery(); 
        final Database storeTest = Database.getInstance();
        Song song1 = new Song("Ether","Nas","Stillematic","2001","https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.com%2FStillmatic-Nas%2Fdp%2FB00005U2LB&psig=AOvVaw25yzCOQiDFfelciXunNAIB&ust=1649219453759000&source=images&cd=vfe&ved=0CAoQjRxqFwoTCJj_ya-L_PYCFQAAAAAdAAAAABAD");
        Song song2 = new Song("Unforgettable","Drake, Young Jeezy","Thank Me Later","2010","https://i.ytimg.com/vi/mUZrMNhM7fE/maxresdefault.jpg");
        Song song3 = new Song("F.U.T.W","Jay-Z","Magna Carta Holy Grail","2013","https://i.pinimg.com/originals/c5/39/06/c5390660ed3030c70233e96bd8cb3707.jpg");
        
        storeTest.addLikedSong(song1);
        storeTest.addLikedSong(song2);
        storeTest.addLikedSong(song3);
        Playlist sampleLike = storeTest.getLikedList(); // gets list of secret liked Playlist

        Song currentSong = sampleLike.getSong("Unforgettable");
        assertSame(currentSong,song2); //checks to see if song attributes are stored properly
        storeTest.removeLikedSong(song2);
        storeTest.removeLikedSong("F.U.T.W");
        sampleLike = storeTest.getLikedList();
        assertFalse(storeTest.inLike(song2));
        assertTrue(storeTest.inLike("Ether"));
        assertFalse(storeTest.inLike(song3));

        
    }
    
}
