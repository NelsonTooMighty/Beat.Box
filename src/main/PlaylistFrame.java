import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaylistFrame {
   JTextField userInput = new JTextField(50);
   JButton submitButton = new JButton("Submit");
   JTextArea displayarea = new JTextArea(20, 40);
   Controller myController;
   JFrame jframe;
   JPanel jPanel;
    public PlaylistFrame(Controller myController){

        jPanel = new JPanel();
        jframe = new JFrame();
        jframe.add(jPanel, BorderLayout.CENTER);

        jPanel.add(displayarea);
        myController.displayAllPlaylists(displayarea);
        jPanel.add(userInput);
        jPanel.add(submitButton);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setTitle("PLayList page");
        this.myController = myController;
        jframe.pack();


        jframe.setVisible(true);


       

        ActionListener submitChoice = new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                String input = userInput.getText();
                int playlistIndex = 0;
                try {
                    playlistIndex = Integer.parseInt(input);
                } catch (NumberFormatException numberFormatException) {
                    displayarea.append("Error: Invalid index! Please enter the integer value of the playlist.\n");
                }
                myController.displayPlaylistContent(displayarea,playlistIndex - 1); //-1 because the playlists are listed from 1 but are indexed from 0
                userInput.setText("");

            }
        };
        submitButton.addActionListener(submitChoice);

        }


            public static void main(String args[]){
                Controller my_controller = new Controller();
                new PlaylistFrame(my_controller);


            }
}


