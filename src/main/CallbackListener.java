import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//Created following https://ssaurel.medium.com/create-a-simple-http-web-server-in-java-3fc12b29d5fd
public class CallbackListener implements Runnable {
    private final Socket connect;
    private final SpotifyAuth spotifyAuth; //the object waiting for a request

    static final boolean verbose = true;

    public CallbackListener(int PORT, SpotifyAuth auth) throws IOException {
        spotifyAuth = auth;

        ServerSocket serverConnect = new ServerSocket(PORT);
        connect = serverConnect.accept();
        if (verbose) {
            System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");
        }
    }

    @Override
    public void run() {
        try {
            // we read characters from the client via input stream on the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            // get request from client
            String input = in.readLine();
            String code = input.split(" ")[1].substring(15);
            //spotifyAuth.setCode(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}