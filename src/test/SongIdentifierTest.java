import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class SongIdentifierTest {
        @Test
        @DisplayName("Test for Song Identifier With No Parameters")
        public void SongIdentifierTest() throws IOException, ClassNotFoundException
        {
            new SongIdentifier().identify("Power");
            assertTrue(true== SongIdentifier.isLocal());
        }
}
