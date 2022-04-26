public class SongDistributer {
    SpotifyAuth spotifyAuth = SpotifyAuth.getInstance();

    public Song distributer(String name) {
        Song s = new SongIdentifier().identify(name); // s = identify(name) from song identifier
        return s; // return playlist
    }
}
