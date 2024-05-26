package drive.mate.learner;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

/**
 *
 * @author smbha
 */
public class TestScreen extends javax.swing.JFrame {

    private static String selectedLanguage;
    private static String nicNo;
    private MediaPlayer mediaPlayer;
    private int currentVideoIndex = 1;
    private int score = 0;
    private String selectedAnswer = null;

    /**
     * Creates new form TestScreen
     */
    private JLabel questionLabel;
    private JButton[] buttons = new JButton[4];
    private String[] questions;
    private Map<Integer, String[]> videoButtonTexts;

    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedDate = currentDate.format(dateFormatter);
    String formattedTime = currentTime.format(timeFormatter);

    Font questionFont = new Font("Nirmala UI", Font.BOLD, 16);
    Font buttonFont = new Font("Nirmala UI", Font.PLAIN, 14);

    JButton confirmButton = new JButton("Confirm");

    public TestScreen(String selectedLanguage, String nicNo) {
        this.selectedLanguage = selectedLanguage;
        this.nicNo = nicNo;
        this.questions = QList.getQuestions(selectedLanguage);
        this.videoButtonTexts = QList.getVideoButtonTexts(selectedLanguage);
        initComponents();

        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                AlertMessages.conformExit();
            }
        });

        if (selectedLanguage.equals("Sinhala")) {
            startButton.setText("ආරම්භ කරන්න");
            backBtn.setText("ආපසු");
            confirmButton.setText("තහවුරු කරන්න");
            
        } else if (selectedLanguage.equals("Tamil")) {
            startButton.setText("தொடங்கு");
            backBtn.setText("ஆதரி");
            confirmButton.setText("உறுதி செய்");
        }

    }

    private void initVideoInternalFrame() {
        try {
            // Path to the current video
            String folderPath = System.getProperty("user.dir");
            String videoPath = folderPath + "/resources/videos/" + currentVideoIndex + ".mp4";

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

            // Create the main button panel with BoxLayout (Y_AXIS)
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            buttonPanel.setOpaque(false); // Transparent panel
            videoPanel.add(buttonPanel, BorderLayout.SOUTH);

            // Add question label in a separate JPanel
            JPanel questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            questionPanel.setOpaque(false); // Transparent panel
            questionLabel = new JLabel(questions[currentVideoIndex - 1]);
            questionLabel.setFont(questionFont);
            questionLabel.setForeground(java.awt.Color.WHITE);
            questionLabel.setVisible(false); // Make question label visible
            questionPanel.add(questionLabel);
            buttonPanel.add(questionPanel);

            confirmButton.setFont(buttonFont);

            // Add buttons in two rows using nested JPanels
            JPanel buttonRow1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            buttonRow1.setOpaque(false); // Transparent panel
            JPanel buttonRow2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            buttonRow2.setOpaque(false); // Transparent panel

            for (int i = 0; i < 4; i++) {
                buttons[i] = new JButton();
                buttons[i].setPreferredSize(new Dimension(550, 40)); // Set preferred size
                buttons[i].setFont(buttonFont);
                buttons[i].setVisible(false); // Make buttons visible

                // Add buttons to respective rows
                if (i < 2) {
                    buttonRow1.add(buttons[i]);
                } else {
                    buttonRow2.add(buttons[i]);
                }

                // Add action listener to buttons
                final int answerIndex = i;
                buttons[i].addActionListener((ActionEvent e) -> {
                    // Handle button click
                    selectedAnswer = buttons[answerIndex].getText();
                    System.out.println("Selected answer: " + selectedAnswer);
                });
            }

            buttonPanel.add(buttonRow1);
            buttonPanel.add(buttonRow2);

            // Add confirm button in a separate JPanel
            JPanel confirmPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            confirmPanel.setOpaque(false); // Transparent panel
            confirmButton.setPreferredSize(new Dimension(200, 40));
            confirmButton.setVisible(false); // Make confirm button visible
            confirmPanel.add(confirmButton);
            buttonPanel.add(confirmPanel);

            confirmButton.addActionListener((ActionEvent e) -> {
                if (selectedAnswer != null) {
                    // Check if the selected answer is correct
                    if (selectedAnswer.equals(videoButtonTexts.get(currentVideoIndex - 1)[0])) {
                        score++;
                        System.out.println("Correct answer! Current score: " + score);
                    } else {
                        System.out.println("Wrong answer. Current score: " + score);
                    }
                    // Load the next video or show final score
                    currentVideoIndex++;
                    if (currentVideoIndex <= questions.length) {
                        String nextVideoPath = folderPath + "/resources/videos/" + currentVideoIndex + ".mp4";
                        Media nextMedia = new Media(new File(nextVideoPath).toURI().toString());
                        mediaPlayer.stop();
                        mediaPlayer = new MediaPlayer(nextMedia);
                        mediaView.setMediaPlayer(mediaPlayer);
                        mediaPlayer.play();
                        // Hide the buttons and question again
                        for (Component component1 : buttonPanel.getComponents()) {
                            component1.setVisible(false);
                        }
                        confirmButton.setVisible(false);
                        selectedAnswer = null; // Reset selected answer
                        // Add listener to detect when the next video ends
                        mediaPlayer.setOnEndOfMedia(() -> {
                            // Update button texts and question
                            questionLabel.setText(questions[currentVideoIndex - 1]);
                            updateButtonLabels();
                            // Make the buttons and question visible
                            for (Component component2 : buttonPanel.getComponents()) {
                                component2.setVisible(true);
                            }
                            confirmButton.setVisible(true);
                        });
                    } else {
                        // All questions have been answered, show final score
                        System.out.println("Test completed. Final score: " + score);
                        try (Connection connection = DatabaseConnection.getConnection()) {
                            // Prepare SQL statement to insert final score into the database
                            String insertQuery = "INSERT INTO marks (nicno, date, time, marks) VALUES (?, ?, ?, ?)";
                            try (PreparedStatement stmt = connection.prepareStatement(insertQuery)) {
                                // Set parameters for the prepared statement
                                stmt.setString(1, nicNo);
                                stmt.setString(2, formattedDate);
                                stmt.setString(3, formattedTime);
                                stmt.setInt(4, score);

                                // Execute the insert statement
                                int rowsAffected = stmt.executeUpdate();
                                if (rowsAffected > 0) {
                                    System.out.println("Final score saved in the database.");
                                } else {
                                    System.out.println("Failed to save final score in the database.");
                                }
                            }
                        } catch (SQLException ex) {
                            System.err.println("Error while saving final score in the database: " + ex.getMessage());
                            ex.printStackTrace();
                        }
                        for (Component component3 : buttonPanel.getComponents()) {
                            component3.setVisible(false);
                        }
                        confirmButton.setVisible(false);

                        //SHOW STATUS FRAME
                        disposeMediaPlayer();
                        Platform.setImplicitExit(false);
                        SwingUtilities.invokeLater(() -> new StatusFrame(selectedLanguage, score, nicNo).setVisible(true));
                        //this.dispose();

                    }
                } else {
                    System.out.println("Please select an answer before confirming.");
                }
            });

            // Add listener to detect when the video ends
            mediaPlayer.setOnEndOfMedia(() -> {
                // Update button texts and question
                questionLabel.setText(questions[currentVideoIndex - 1]);
                updateButtonLabels();

                // Make the buttons and question visible
                questionLabel.setVisible(true);
                for (JButton button : buttons) {
                    button.setVisible(true);
                }
                confirmButton.setVisible(true);
            });

            // Assuming jPanel is an instance of CustomPanel
            jPanel.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    resizeMediaView(jPanel, media, mediaView);
                }
            });

            // Add a component listener to track JFrame resizing
            container.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    resizeMediaView(container, media, mediaView);
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

    private void updateButtonLabels() {
        if (currentVideoIndex <= questions.length) {
            List<String> answers = new ArrayList<>(List.of(videoButtonTexts.get(currentVideoIndex - 1)));
            Collections.shuffle(answers);
            for (int i = 0; i < 4; i++) {
                buttons[i].setText(answers.get(i));
            }
        }
    }

private void resizeMediaView(Component container, Media media, MediaView mediaView) {
    // Get the new size of the container
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

            // Calculate the aspect ratio of the container
            double containerAspectRatio = newWidth / newHeight;

            // Calculate the scaled dimensions
            double scaledWidth, scaledHeight;

            // Check if the video aspect ratio is wider than the container aspect ratio
            if (videoAspectRatio > containerAspectRatio) {
                // Video is wider, fit width to container and adjust height accordingly
                scaledWidth = newWidth;
                scaledHeight = scaledWidth / videoAspectRatio;
            } else {
                // Video is taller, fit height to container and adjust width accordingly
                scaledHeight = newHeight;
                scaledWidth = scaledHeight * videoAspectRatio;
            }

            // Set the dimensions of the MediaView to fit inside the container
            mediaView.setFitWidth(scaledWidth);
            mediaView.setFitHeight(scaledHeight);

            // Center the MediaView within the container
            double offsetX = (newWidth - scaledWidth) / 2;
            double offsetY = (newHeight - scaledHeight) / 2;

            // Set the position of the MediaView
            mediaView.setTranslateX(offsetX);
            mediaView.setTranslateY(offsetY);
        } else {
            // Handle invalid original dimensions
            System.err.println("Invalid original dimensions of the video.");
        }
    } else {
        // Handle uninitialized media or mediaView
        System.err.println("Media or mediaView is not properly initialized.");
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
        backBtn = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 31, 31));

        videoPanel.setBackground(new java.awt.Color(31, 31, 31));
        videoPanel.setForeground(new java.awt.Color(204, 204, 204));
        videoPanel.setPreferredSize(new java.awt.Dimension(1200, 1000));

        startButton.setBackground(new java.awt.Color(204, 204, 0));
        startButton.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        startButton.setForeground(new java.awt.Color(51, 51, 51));
        startButton.setText("START");
        startButton.setMaximumSize(new java.awt.Dimension(200, 80));
        startButton.setPreferredSize(new java.awt.Dimension(250, 60));
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout videoPanelLayout = new javax.swing.GroupLayout(videoPanel);
        videoPanel.setLayout(videoPanelLayout);
        videoPanelLayout.setHorizontalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, videoPanelLayout.createSequentialGroup()
                .addContainerGap(462, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(488, Short.MAX_VALUE))
        );
        videoPanelLayout.setVerticalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, videoPanelLayout.createSequentialGroup()
                .addContainerGap(467, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(473, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(videoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(videoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/back.png"))); // NOI18N
        backBtn.setText("Back");
        backBtn.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });
        jMenuBar1.add(backBtn);

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

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        disposeMediaPlayer();
        Platform.setImplicitExit(false);
        new LearnerMenuScreen(selectedLanguage, nicNo).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

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
            java.util.logging.Logger.getLogger(TestScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JMenu backBtn;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton startButton;
    public javax.swing.JPanel videoPanel;
    // End of variables declaration//GEN-END:variables
}
