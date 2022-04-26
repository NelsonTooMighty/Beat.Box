import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class SongDistributorTest{
    @Test
    @DisplayName("Test for Song Identifier With No Parameters")
    public void SongDistributorTest() throws IOException, ClassNotFoundException
    {
        Song saveSong = new SongDistributer().distributer("Power");
        assertTrue(true==  SongName());
    }
}
