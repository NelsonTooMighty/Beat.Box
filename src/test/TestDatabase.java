import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class TestDatabase {

    private final Database d = Database.getInstance();

    @Test
    @DisplayName("Test for Playlist Serialization")
    public void serializeTest() throws IOException, ClassNotFoundException {
        Playlist test = new Playlist();
        test.setPlaylistName("Vulfy");
        test.add(new Song("Dean Town", "Vulfpeck", "The Beautiful Game", "2016", "https://f4.bcbits.com/img/a1702319957_16.jpg"));
        d.saveToFile(test, "src/resources/test_serial");
        Playlist inTest = d.loadFromFile("src/resources/test_serial");
        assertTrue("Vulfy".equals(inTest.getPlaylistName()));
        assertTrue("Dean Town".equals(inTest.getFirst().getTrackTitle()));
        assertTrue("Vulfpeck".equals(inTest.getFirst().getArtistName()));
        assertTrue("The Beautiful Game".equals(inTest.getFirst().getAlbumName()));
        assertTrue("2016".equals(inTest.getFirst().getReleaseDate()));
    }
}
