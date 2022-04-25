public class SongIdentifier {
    SpotifyAuth spotifyAuth = SpotifyAuth.getInstance();

    public Song identify(String name) {
        return new SpotifySearcher().searchSong(name);
    }
}
