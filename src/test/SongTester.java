import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;


public class SongTester {



    @Test
    @DisplayName("Test for Song Class With No Parameters")
    public void serializeTest() throws IOException, ClassNotFoundException
    {
        final Song TestSong= new Song();
        TestSong.setAlbumName("My Beautiful Dark Twisted Fantasy");
        TestSong.setAlbumArtLocation("/Nelson/Desktop/Documents/");
        TestSong.setArtistName("Kanye West");
        TestSong.setLocal(true);
        TestSong.setTrackTitle("Power");
        TestSong.setReleaseDate("2012");



        assertTrue("My Beautiful Dark Twisted Fantasy".equals(TestSong.getAlbumName()));
        assertTrue("Power".equals(TestSong.getTrackTitle()));
        assertTrue("Kanye West".equals(TestSong.getArtistName()));
        assertTrue("2012".equals(TestSong.getReleaseDate()));
        assertTrue("/Nelson/Desktop/Documents/".equals(TestSong.getAlbumArtLocation()));
        assertTrue(true== TestSong.isLocal());

    }
        @Test
        @DisplayName("Test for Song Class With first constructor type with Parameters")
        public void songTest2() throws IOException, ClassNotFoundException
        {
            final Song TestSong= new Song("Power","Kanye West","My Beautiful Dark Twisted Fanatasy","2012","/Nelson/Desktop/Documents");
            assertTrue("My Beautiful Dark Twisted Fantasy".equals(TestSong.getAlbumName()));
            assertTrue("Power".equals(TestSong.getTrackTitle()));
            assertTrue("Kanye West".equals(TestSong.getArtistName()));
            assertTrue("2012".equals(TestSong.getReleaseDate()));
            assertTrue("/Nelson/Desktop/Documents/".equals(TestSong.getAlbumArtLocation()));
            assertTrue(false== TestSong.isLocal());
            assertTrue((TestSong.getLocalPath().isEmpty()));
    }
    @Test
    @DisplayName("Test for Song Class With second constructor type with Parameters")
    public void songTest3() throws IOException, ClassNotFoundException
    {
        final Song TestSong= new Song("Power","Kanye West","My Beautiful Dark Twisted Fanatasy","2012","/Nelson/Desktop/Documents", true);
        assertTrue("My Beautiful Dark Twisted Fantasy".equals(TestSong.getAlbumName()));
        assertTrue("Power".equals(TestSong.getTrackTitle()));
        assertTrue("Kanye West".equals(TestSong.getArtistName()));
        assertTrue("2012".equals(TestSong.getReleaseDate()));
        assertTrue("/Nelson/Desktop/Documents/".equals(TestSong.getAlbumArtLocation()));
        assertTrue(true== TestSong.isLocal());
        assertTrue((TestSong.getLocalPath().isEmpty()));
    }
}


