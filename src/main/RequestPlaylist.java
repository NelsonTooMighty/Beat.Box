import se.michaelthelin.spotify.model_objects.specification.Playlist;
import java.io.Serializable;
import java.util.LinkedList;




public class RequestPlaylist extends LinkedList<Playlist> implements Serializable
{
    Database db = Database.getInstance();


}
