import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTubeRequestInitializer;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

//Uses Youtube API https://github.com/googleapis/google-api-java-client-services/tree/main/clients/google-api-services-youtube
public class YTMusicAuth {
    private final String APIKey = "AIzaSyAJ9BHXvMWX0PM6CMs43qKCTmrtiFwzFW0";
    private static final YTMusicAuth singleton = getInstance();
    private YouTube youtube;

    private YTMusicAuth() {
        try {
            youtube = new YouTube.Builder(
                    GoogleNetHttpTransport.newTrustedTransport(),
                    GsonFactory.getDefaultInstance(),
                    null)
                    .setApplicationName("Beat Box")
                    .setYouTubeRequestInitializer(new YouTubeRequestInitializer(APIKey))
                    .build();
        } catch (GeneralSecurityException | IOException e) {
            System.out.println("Error setting up YouTube request!:\n\t" + e.getMessage());
        }
    }

    public static YTMusicAuth getInstance() {return singleton;}
    public YouTube getYoutubeService() {
        return youtube;
    }
}
