import javax.swing.*;
import java.io.Serializable;
import java.net.URL;
import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class Song implements Serializable { //API documentation: https://developer.spotify.com/documentation/web-api/reference/#/operations/get-track, https://developer.apple.com/documentation/musickit/track/
    private String songName;
    private String artistName;
    private String albumName;
    private String releaseDate;
    private String albumArtLocation;
    private boolean isLocal;
    private String localPath;
    private ImageIcon albumIcon;

    public Song() {
    }

    public Song(String songName, String artistName, String albumName, String releaseDate, String albumArtLocation) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.albumArtLocation = albumArtLocation;
        isLocal = false;
        localPath = null;
    }

    public Song(String songName, String artistName, String albumName, String releaseDate, String localPath, boolean isLocal) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.localPath = localPath;
        this.isLocal = isLocal;
        if (isLocal) {

        }
        this.albumArtLocation = null; //Todo: check isLocal, find albumArtLocation

    }
    public Song(String songName, String artistName, String albumName, String releaseDate, String localPath, boolean isLocal,String albumArtLocation) throws Exception {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.localPath = localPath;
        this.isLocal = isLocal;
        this.albumArtLocation = albumArtLocation; //Todo: check isLocal, find albumArtLocation
        this.albumIcon = getAlbumArtImageIcon();

    }
    
    public ImageIcon getAlbumArtImageIcon() { //returns ImageIcon object for GUI purposes, regardless of online/offline
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

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
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

    public String toString() {
        return "Song(name=" + songName + ", artist=" + artistName
                + ", album=" + albumName + ", date=" + releaseDate
                + ", art=" + albumArtLocation + ", isLocal=" + isLocal
                + ", path=" + localPath + ")";
    }
}
