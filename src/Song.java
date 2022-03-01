import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Song { //API documentation: https://developer.spotify.com/documentation/web-api/reference/#/operations/get-track, https://developer.apple.com/documentation/musickit/track/
    String trackTitle;
    String artistName;
    String albumName;
    String releaseDate;
    String albumArtLocation;
    boolean isLocal;
    String localPath;

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAlbumArtLocation() {
        return albumArtLocation;
    }

    public void setAlbumArtLocation(String albumArtLocation) {
        this.albumArtLocation = albumArtLocation;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public Song() {
    }

    public Song(String trackTitle, String artistName, String albumName, String releaseDate, String albumArtLocation) {
        this.trackTitle = trackTitle;
        this.artistName = artistName;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.albumArtLocation = albumArtLocation;
        isLocal = false;
        localPath = null;
    }

    public Song(String trackTitle, String artistName, String albumName, String releaseDate, String localPath, boolean isLocal) {
        this.trackTitle = trackTitle;
        this.artistName = artistName;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.localPath = localPath;
        this.isLocal = isLocal;
        this.albumArtLocation = null; //Todo: check isLocal, find albumArtLocation
    }

    public ImageIcon getAlbumArtImageIcon() {
        if(albumArtLocation != null) {
            if (isLocal) {
                try {
                    return new ImageIcon(albumArtLocation);
                } catch (Exception e) {
                    System.err.print("Invalid local path: " + albumArtLocation);
                    e.printStackTrace();
                }
            } else {
                try {
                    return new ImageIcon(new URL(albumArtLocation));
                } catch (Exception e) {
                    System.err.print("Invalid URL: " + albumArtLocation);
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
