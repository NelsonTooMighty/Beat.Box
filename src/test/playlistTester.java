
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;


public class playlistTester {
    @Test
    @DisplayName("Test For playlist class")
    public void songTest() throws IOException, ClassNotFoundException
    {
        final Playlist playlistTester = new Playlist();
        playlistTester.setPlaylistName("Mine");
        assertEquals(playlistTester.getPlaylistName(),"Mine");

    }
}
