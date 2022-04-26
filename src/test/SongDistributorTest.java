import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class SongDistributorTest{
    @Test
    @DisplayName("Test for Song Identifier With No Parameters")
    public void SongDistributorTest()
    {
        Song song = new SongDistributer().distributer("Power");
        assertNotNull(song.getArtistName());
    }
}
