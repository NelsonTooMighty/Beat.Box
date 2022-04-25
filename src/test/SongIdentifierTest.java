import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class SongIdentifierTest {
        @Test
        @DisplayName("Test for Song Class With No Parameters")
        public void SongIdentifierTest() throws IOException, ClassNotFoundException
        {
            final Song TestSong= new Song();
            TestSong.setSongName("Power");
            assertTrue(true== TestSong.isLocal());

        }
}
