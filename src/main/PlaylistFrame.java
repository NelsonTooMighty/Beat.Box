import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaylistFrame {
   JTextField userInput = new JTextField(50);
   JButton submitButton = new JButton("Submit");
   JTextArea displayofPlaylist = new JTextArea(20, 40);
   Controller myController;
    public PlaylistFrame(Controller myController){
        this.myController = myController;
        myController.displayAllPlaylists(displayofPlaylist);


       

        ActionListener submitChoice = new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                String input = userInput.getText();
                int playlistIndex = 0;
                try {
                    playlistIndex = Integer.parseInt(input);
                } catch (NumberFormatException numberFormatException) {
                    displayofPlaylist.append("Error: Invalid index! Please enter the integer value of the playlist.\n");
                }
                myController.displayPlaylistContent(displayofPlaylist,playlistIndex - 1); //-1 because the playlists are listed from 1 but are indexed from 0
                userInput.setText("");

            }
        };
        submitButton.addActionListener(submitChoice);
        //userInput.addActionListener(submitChoice); should be unnecessary?
        }


}


