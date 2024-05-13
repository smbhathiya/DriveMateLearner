package drive.mate.learner;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.Group;
import javafx.scene.Scene;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Component;
import javafx.scene.paint.Color;

/**
 *
 * @author smbha
 */
public class TestScreen extends javax.swing.JFrame {

    private static String selectedLanguage;
    private static String nicNo;
    private MediaPlayer mediaPlayer;

    /**
     * Creates new form TestScreen
     */
    public TestScreen(String selectedLanguage, String nicNo) {
        this.selectedLanguage = selectedLanguage;
        this.nicNo = nicNo;
        initComponents();

        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                AlertMessages.conformExit();
            }
        });
    }

    private void initVideoInternalFrame() {
        try {
            String videoPath = "C:/Users/smbha/OneDrive/Documents/NetBeansProjects/PROJECT/Drive Mate Learner/test/videos/1.mp4";

            JFXPanel fxPanel = new JFXPanel();
            Media media = new Media(new File(videoPath).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            // Creating a MediaView to display the video
            MediaView mediaView = new MediaView(mediaPlayer);
            mediaView.setPreserveRatio(true);

            Group group = new Group();
            group.getChildren().add(mediaView);

            // Creating a Scene with the Group
            Scene scene = new Scene(group, Color.rgb(31, 31, 31));

            // Adding the Scene to the JFXPanel
            fxPanel.setScene(scene);

            // Create a JPanel to hold the JFXPanel
            JPanel jPanel = new JPanel(new BorderLayout());
            jPanel.setOpaque(true);
            jPanel.add(fxPanel, BorderLayout.CENTER);

            // Add the JPanel to the videoPanel
            videoPanel.setLayout(new BorderLayout());
            videoPanel.add(jPanel, BorderLayout.CENTER);
            videoPanel.setOpaque(true);

            // Get the top-level container (frame or window)
            Container container = SwingUtilities.getWindowAncestor(videoPanel);

            // Create button panel
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            buttonPanel.setOpaque(false); // Transparent panel
            videoPanel.add(buttonPanel, BorderLayout.SOUTH);

            // Add buttons
            for (int i = 1; i <= 4; i++) {
                JButton button = new JButton("Button " + i);
                button.setPreferredSize(new Dimension(100, 30)); // Set preferred size
                button.setVisible(false); // Initially hide the buttons
                buttonPanel.add(button);
            }

            // Add listener to detect when the video ends
            mediaPlayer.setOnEndOfMedia(() -> {
                // Make the buttons visible
                for (Component component : buttonPanel.getComponents()) {
                    component.setVisible(true);
                }
            });

            // Assuming jPanel is an instance of CustomPanel
            jPanel.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    // Get the new size of the panel
                    Dimension newSize = jPanel.getSize();
                    double newWidth = newSize.getWidth();
                    double newHeight = newSize.getHeight();

                    // Ensure media and mediaView are properly initialized
                    if (media != null && mediaView != null) {
                        // Get the original dimensions of the video
                        double originalWidth = media.getWidth();
                        double originalHeight = media.getHeight();

                        // Ensure original dimensions are valid
                        if (originalWidth > 0 && originalHeight > 0) {
                            // Calculate the ratio of the panel size to the original video size
                            double widthRatio = newWidth / originalWidth;
                            double heightRatio = newHeight / originalHeight;

                            // Determine the scaling factor based on the smaller ratio to maintain aspect ratio
                            double scaleFactor = Math.min(widthRatio, heightRatio);

                            // Calculate the scaled dimensions
                            double scaledWidth = originalWidth * scaleFactor;
                            double scaledHeight = originalHeight * scaleFactor;

                            // Center the MediaView within the panel
                            double offsetX = (newWidth - scaledWidth) / 2;
                            double offsetY = (newHeight - scaledHeight) / 2;

                            // Set the dimensions and position of the MediaView
                            mediaView.setFitWidth(scaledWidth);
                            mediaView.setFitHeight(scaledHeight);
                            mediaView.setLayoutX(offsetX);
                            mediaView.setLayoutY(offsetY);
                        } else {
                            // Handle invalid original dimensions
                            System.err.println("Invalid original dimensions of the video.");
                        }
                    } else {
                        // Handle uninitialized media or mediaView
                        System.err.println("Media or mediaView is not properly initialized.");
                    }
                }

            });

            // Add a component listener to track JFrame resizing
            container.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    // Get the new size of the JFrame
                    Dimension newSize = container.getSize();
                    double newWidth = newSize.getWidth();
                    double newHeight = newSize.getHeight();

                    // Ensure media and mediaView are properly initialized
                    if (media != null && mediaView != null) {
                        // Get the original dimensions of the video
                        double originalWidth = media.getWidth();
                        double originalHeight = media.getHeight();

                        // Ensure original dimensions are valid
                        if (originalWidth > 0 && originalHeight > 0) {
                            // Calculate the aspect ratio of the video
                            double videoAspectRatio = originalWidth / originalHeight;

                            // Calculate the aspect ratio of the JFrame
                            double frameAspectRatio = newWidth / newHeight;

                            // Calculate the scaled dimensions
                            double scaledWidth, scaledHeight;

                            // Adjust the size of the videoPanel based on the aspect ratio
                            if (videoAspectRatio > frameAspectRatio) {
                                // Video is wider, adjust height
                                scaledWidth = newWidth;
                                scaledHeight = newWidth / videoAspectRatio;
                                videoPanel.setPreferredSize(new Dimension((int) scaledWidth, (int) scaledHeight));
                            } else {
                                // Video is taller, adjust width
                                scaledWidth = newHeight * videoAspectRatio;
                                scaledHeight = newHeight;
                                videoPanel.setPreferredSize(new Dimension((int) scaledWidth, (int) scaledHeight));
                            }

                            // Center the MediaView within the panel
                            double offsetX = (newWidth - scaledWidth) / 2;
                            double offsetY = (newHeight - scaledHeight) / 2;

                            // Set the dimensions and position of the MediaView
                            mediaView.setFitWidth(scaledWidth);
                            mediaView.setFitHeight(scaledHeight);
                            mediaView.setLayoutX(offsetX);
                            mediaView.setLayoutY(offsetY);
                        } else {
                            // Handle invalid original dimensions
                            System.err.println("Invalid original dimensions of the video.");
                        }
                    } else {
                        // Handle uninitialized media or mediaView
                        System.err.println("Media or mediaView is not properly initialized.");
                    }

                    // Request a layout update to adjust the size of the videoPanel
                    videoPanel.revalidate();
                }
            });

            // Play the video
            mediaPlayer.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void disposeMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
            mediaPlayer = null; // Reset mediaPlayer to null after disposal
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        videoPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 31, 31));

        videoPanel.setBackground(new java.awt.Color(31, 31, 31));
        videoPanel.setForeground(new java.awt.Color(204, 204, 204));
        videoPanel.setPreferredSize(new java.awt.Dimension(1200, 720));

        startButton.setBackground(new java.awt.Color(204, 204, 0));
        startButton.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        startButton.setForeground(new java.awt.Color(51, 51, 51));
        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout videoPanelLayout = new javax.swing.GroupLayout(videoPanel);
        videoPanel.setLayout(videoPanelLayout);
        videoPanelLayout.setHorizontalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(videoPanelLayout.createSequentialGroup()
                .addContainerGap(505, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(507, Short.MAX_VALUE))
        );
        videoPanelLayout.setVerticalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(videoPanelLayout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(videoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(videoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jMenu1.setText("Back");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        disposeMediaPlayer();
        new LearnerMenuScreen(selectedLanguage, nicNo).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        initVideoInternalFrame();
        startButton.setVisible(false);
    }//GEN-LAST:event_startButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestScreen(selectedLanguage, nicNo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel videoPanel;
    // End of variables declaration//GEN-END:variables
}
