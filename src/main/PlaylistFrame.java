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
       

        ActionListener submitChoice = new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                myController.displayPlaylistcontent(displayofPlaylist,userInput.getText());
                userInput.setText("");

            }
        };
        submitButton.addActionListener(submitChoice);
        userInput.addActionListener(submitChoice);
        }


}


