import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTubeRequestInitializer;
import java.io.IOException;
import java.security.GeneralSecurityException;

//Uses Youtube API https://github.com/googleapis/google-api-java-client-services/tree/main/clients/google-api-services-youtube

/**
 * Holds a YouTube service variable including the API Key for use for imports.
 */
public class YTMusicAuth {
    private final String APIKey = "AIzaSyAJ9BHXvMWX0PM6CMs43qKCTmrtiFwzFW0";
    private YouTube youtube;

    /**
     * Sets up YouTube service variable for use by other classes.
     */
    public YTMusicAuth() {
        try {
            youtube = new YouTube.Builder(
                    GoogleNetHttpTransport.newTrustedTransport(),
                    GsonFactory.getDefaultInstance(),
                    null)
                    .setApplicationName("Beat Box")
                    .setYouTubeRequestInitializer(new YouTubeRequestInitializer(APIKey)) //adds API key for subsequent requests
                    .build();
        } catch (GeneralSecurityException | IOException e) {
            System.out.println("Error setting up YouTube request!:\n\t" + e.getMessage());
        }
    }

    /**
     * Gets the Youtube Service with preloaded API key.
     */
    public YouTube getYoutubeService() {
        return youtube;
    }
}
