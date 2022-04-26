import javax.swing.*;
import java.awt.*;

/**
 *
 * @author naomipadilla
 */
public class LayoutFrame extends javax.swing.JFrame {
    private final Controller controller = new Controller(MainScreenPanel, SidePanel);

    /**
     * Creates new form LayoutFrame
     */
    public LayoutFrame() throws Exception {
        initComponents();



    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        artistButton = new javax.swing.JButton();
        Songs = new javax.swing.JButton();
        albumButton = new javax.swing.JButton();
        listButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        MainScreenPanel = new javax.swing.JPanel();
        MainScreenScroller = new javax.swing.JScrollPane(MainScreenPanel);
        MusicPlayerPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        SidePanel = new javax.swing.JPanel();
        sidePanelScroller = new javax.swing.JScrollPane(SidePanel);

        MainScreenPanel.setLayout(new BoxLayout(MainScreenPanel, BoxLayout.Y_AXIS)); //https://stackoverflow.com/questions/13510641/add-controls-vertically-instead-of-horizontally-using-flow-layout
        SidePanel.setLayout(new BoxLayout(SidePanel, BoxLayout.Y_AXIS));
        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        artistButton.setBackground(new java.awt.Color(153, 153, 153));
        artistButton.setFont(new java.awt.Font("PT Mono", 0, 15)); // NOI18N
        artistButton.setText("Artists");
        artistButton.setBorder(null);
        artistButton.setBorderPainted(false);
        artistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artistButtonActionPerformed(evt);
            }
        });

        Songs.setBackground(new java.awt.Color(153, 153, 153));
        Songs.setFont(new java.awt.Font("PT Mono", 0, 15)); // NOI18N
        Songs.setText("Songs");
        Songs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SongsActionPerformed(evt);
            }
        });

        albumButton.setBackground(new java.awt.Color(153, 153, 153));
        albumButton.setFont(new java.awt.Font("PT Mono", 0, 15)); // NOI18N
        albumButton.setText("Albums");
        albumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumButtonActionPerformed(evt);
            }
        });
        listButton.setText("Playlists");
        listButton.setBackground(new java.awt.Color(153, 153, 153));
        listButton.setFont(new java.awt.Font("PT Mono", 0, 15)); // NOI18N
        listButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(artistButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(albumButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Songs, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(listButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(17, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(albumButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Songs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(artistButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(17, 17, 17))))
        );

        ImageIcon logoimage = new ImageIcon("src/resources/beatBox.png");
        Image logo = logoimage.getImage();
        jLabel1.setIcon(logoimage); // NOI18N

        jLabel1.setText("jLabel1");

        MusicPlayerPanel.setBackground(new java.awt.Color(0, 0, 0));

        ImageIcon backimage = new ImageIcon("src/resources/buttonDesign/back.png");
        Image back = backimage.getImage();
        jButton1.setIcon(backimage); // NOI18N
        jButton1.setActionCommand("BackButton");
        jButton1.setText("");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        ImageIcon playimage = new ImageIcon("src/resources/buttonDesign/play.png");
        Image play = backimage.getImage();
        jButton2.setIcon(playimage); // NOI18N
        jButton2.setText("");
        jButton2.setMaximumSize(new java.awt.Dimension(80, 90));
        jButton2.setMinimumSize(new java.awt.Dimension(80, 90));

        ImageIcon forwardimage = new ImageIcon("src/resources/buttonDesign/foward.png");
        Image forward = backimage.getImage();
        jButton3.setIcon(forwardimage); // NOI18N
        jButton3.setText("");

        javax.swing.GroupLayout MusicPlayerPanelLayout = new javax.swing.GroupLayout(MusicPlayerPanel);
        MusicPlayerPanel.setLayout(MusicPlayerPanelLayout);
        MusicPlayerPanelLayout.setHorizontalGroup(
                MusicPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MusicPlayerPanelLayout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(jButton1)
                                .addGap(40, 40, 40)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jButton3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MusicPlayerPanelLayout.setVerticalGroup(
                MusicPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MusicPlayerPanelLayout.createSequentialGroup()
                                .addGroup(MusicPlayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 33, Short.MAX_VALUE))
        );

        jButton1.getAccessibleContext().setAccessibleName("BackButton");
        jButton2.getAccessibleContext().setAccessibleName("PlayButton");
        jButton3.getAccessibleContext().setAccessibleName("ForwardButton");

        //gather input from user to recieve the file path to transfer a playlist to the data base
       jTextField1.setText("Enter Path");
        ActionListener input = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SidePanel.removeAll();
                controller.inputScanner(jTextField1.getText(), SidePanel);
                jTextField1.setText("");
                SidePanel.revalidate();
            }
        };
       jTextField1.addActionListener(input);



        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(sidePanelScroller)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sidePanelScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(MusicPlayerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 46, Short.MAX_VALUE))
                                                        .addComponent(MainScreenScroller))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(MainScreenScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MusicPlayerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>
    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {

        // TODO add your handling code here:


    }
    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        MainScreenPanel.removeAll(); //clear off the main panel
        controller.displayAllPlaylists(MainScreenPanel, SidePanel); //add the buttons for each playlist
        MainScreenPanel.revalidate(); //update the panel (needed)
        MainScreenPanel.repaint();
    }

    private void albumButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        MainScreenPanel.removeAll(); //clear off the main panel
        controller.displayAllAlbumList(MainScreenPanel, SidePanel); //add the buttons for each playlist
        MainScreenPanel.revalidate(); //update the panel (needed)
        MainScreenPanel.repaint();
    }

    private void SongsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        MainScreenPanel.removeAll();
        MainScreenPanel.repaint();
        controller.displayAllSongs(MainScreenPanel, SidePanel);
        MainScreenPanel.revalidate();

    }

    private void artistButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        MainScreenPanel.removeAll();
        MainScreenPanel.repaint();
        controller.displayAllArtistList(MainScreenPanel);
        MainScreenPanel.revalidate();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LayoutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LayoutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LayoutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LayoutFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LayoutFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify
    private JPanel MainScreenPanel;
    private javax.swing.JScrollPane MainScreenScroller;
    private javax.swing.JPanel MusicPlayerPanel;
    private JPanel SidePanel;
    private javax.swing.JScrollPane sidePanelScroller;
    private javax.swing.JButton Songs;
    private javax.swing.JButton albumButton;
    private javax.swing.JButton artistButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton listButton;
    // End of variables declaration
}
