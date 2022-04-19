import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//BB 54
public class ArtistFrame {
    private JTextField userInput = new JTextField(80); //from 50
    private  JButton submitButton = new JButton("Submit");
    private JTextArea displayarea = new JTextArea(40, 40);
    private Controller myController;
    private JFrame jframe;
    private JPanel jPanel;
    public ArtistFrame(Controller Controller){

        myController = Controller;
        jPanel = new JPanel();
        jframe = new JFrame();
        jframe.add(jPanel, BorderLayout.CENTER);

        JLabel small = new JLabel("Enter the name of desired Artist");
        jPanel.add(small);

        jPanel.add(userInput);
        jPanel.add(submitButton);
        jPanel.add(displayarea);
        myController.displayAllArtistList(displayarea);


        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setTitle("Artist Page");

        jframe.pack();


        jframe.setVisible(true);




        ActionListener submitChoice = new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                String input = null;
                try {
                    input = userInput.getText();
                } catch (NumberFormatException numberFormatException) {
                    displayarea.append("Error: Invalid Artist Name! Please enter the name of the artist.\n");
                }


                myController.displayArtistContent(displayarea,input); //-1 because the playlists are listed from 1 but are indexed from 0
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
