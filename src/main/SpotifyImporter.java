import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class SpotifyImporter implements CloudPlaylistImporter { //with reference to https://github.com/spotify-web-api-java/spotify-web-api-java/blob/develop/examples/authorization/client_credentials/ClientCredentialsExample.java
    private static SpotifyImporter singleton;
    private static String clientId = "";
    private static String clientSecret = "";

    private SpotifyImporter() {
        Path path = FileSystems.getDefault().getPath("credentials.config");
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(path);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\nCould not find credentials.config file in base directory!\n");
        }
        try {
            clientId = reader.readLine();
            clientSecret = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("\ncredentials.config file was empty or too short!\n");
        }
    }

    public static SpotifyImporter getInstance() {
        if(singleton == null) singleton = new SpotifyImporter();
        return singleton;
    }

    @Override
    public Playlist importPlaylist(String url) {
        return null;
    }

    public static void main(String args[]) {
        SpotifyImporter sp = SpotifyImporter.getInstance();
    }
}
