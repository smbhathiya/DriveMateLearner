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
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

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

    private JLabel questionLabel;
    private JButton[] buttons = new JButton[4];
    private String[] questions;
    private Map<Integer, String[]> videoButtonTexts;

    int answersCount = 1;

    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedDate = currentDate.format(dateFormatter);
    String formattedTime = currentTime.format(timeFormatter);

    Font questionFont = new Font("Nirmala UI", Font.BOLD, 16);
    Font buttonFont = new Font("Nirmala UI", Font.BOLD, 14);

    JButton confirmButton = new JButton("Confirm");

    public TestScreen(String selectedLanguage, String nicNo) {
        this.selectedLanguage = selectedLanguage;
        this.nicNo = nicNo;
        this.questions = QList.getQuestions(selectedLanguage);
        this.videoButtonTexts = QList.getVideoButtonTexts(selectedLanguage);

        Image iconl = new ImageIcon(getClass().getResource("/res/DML.png")).getImage();
        this.setIconImage(iconl);

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
            disposeMediaPlayer(); // Dispose of the previous mediaPlayer before creating a new one
            mediaPlayer = new MediaPlayer(media);

            MediaView mediaView = new MediaView(mediaPlayer);
            mediaView.setFitWidth(1920);
            mediaView.setFitHeight(1080);

            Group group = new Group();
            group.getChildren().add(mediaView);

            Scene scene = new Scene(group, Color.rgb(31, 31, 31));

            fxPanel.setScene(scene);

            JPanel jPanel = new JPanel(new BorderLayout());
            jPanel.setOpaque(true);
            jPanel.add(fxPanel, BorderLayout.CENTER);

            videoPanel.setLayout(new BorderLayout());
            videoPanel.add(jPanel, BorderLayout.CENTER);
            videoPanel.setOpaque(true);

            Container container = SwingUtilities.getWindowAncestor(videoPanel);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            buttonPanel.setOpaque(false); // Transparent panel
            videoPanel.add(buttonPanel, BorderLayout.SOUTH);

            JPanel questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            questionPanel.setOpaque(false); // Transparent panel
            questionLabel = new JLabel(questions[currentVideoIndex - 1]);
            questionLabel.setFont(questionFont);
            questionLabel.setForeground(java.awt.Color.WHITE);
            questionLabel.setVisible(false); // Make question label visible
            questionPanel.add(questionLabel);
            buttonPanel.add(questionPanel);

            confirmButton.setFont(buttonFont);

            JPanel buttonRow1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            buttonRow1.setOpaque(false); // Transparent panel
            JPanel buttonRow2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            buttonRow2.setOpaque(false); // Transparent panel

            for (int i = 0; i < 4; i++) {
                buttons[i] = new JButton();
                buttons[i].setPreferredSize(new Dimension(550, 65)); // Set preferred size
                buttons[i].setFont(buttonFont);
                buttons[i].setForeground(new java.awt.Color(0x1F1F1F));
                buttons[i].setBackground(new java.awt.Color(0xFFFF00));
                buttons[i].setVisible(false); // Make buttons visible

                if (i < 2) {
                    buttonRow1.add(buttons[i]);
                } else {
                    buttonRow2.add(buttons[i]);
                }

                final int answerIndex = i;
                buttons[i].addActionListener((ActionEvent e) -> {
                    selectedAnswer = buttons[answerIndex].getText();
                    System.out.println("Selected answer: " + selectedAnswer);
                });

                buttons[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        buttons[answerIndex].setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        buttons[answerIndex].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                });

            }

            buttonPanel.add(buttonRow1);
            buttonPanel.add(buttonRow2);

            JPanel confirmPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            confirmPanel.setOpaque(false); // Transparent panel
            confirmButton.setPreferredSize(new Dimension(200, 40));
            confirmButton.setVisible(false); // Make confirm button visible
            confirmPanel.add(confirmButton);
            buttonPanel.add(confirmPanel);

            confirmButton.addActionListener((ActionEvent e) -> {
                if (selectedAnswer != null) {
                    String correctAnswer = videoButtonTexts.get(currentVideoIndex - 1)[0];
                    if (selectedAnswer.equals(correctAnswer)) {
                        score++;
                        System.out.println("Correct answer! Current score: " + score);
                    } else {
                        System.out.println("Wrong answer. Current score: " + score);
                    }

                    currentVideoIndex++;
                    if (currentVideoIndex <= questions.length) {
                        String nextVideoPath = folderPath + "/resources/videos/" + currentVideoIndex + ".mp4";
                        Media nextMedia = new Media(new File(nextVideoPath).toURI().toString());
                        disposeMediaPlayer(); // Ensure previous mediaPlayer is disposed
                        mediaPlayer = new MediaPlayer(nextMedia);
                        mediaView.setMediaPlayer(mediaPlayer);
                        mediaPlayer.play();

                        questionLabel.setVisible(false);
                        for (JButton button : buttons) {
                            button.setVisible(false);
                        }
                        confirmButton.setVisible(false);

                        mediaPlayer.setOnEndOfMedia(() -> {
                            questionLabel.setText(questions[currentVideoIndex - 1]);
                            updateButtonLabels();
                            questionLabel.setVisible(true);
                            for (JButton button : buttons) {
                                button.setVisible(true);
                            }
                            confirmButton.setVisible(true);
                        });
                    } else {
                        System.out.println("Test completed. Final score: " + score);
                        saveFinalScore(); 

                        disposeMediaPlayer();
                        Platform.setImplicitExit(false);
                        SwingUtilities.invokeLater(() -> new TestResults(selectedLanguage, score, nicNo).setVisible(true));
                        this.dispose();
                    }
                } else {
                    System.out.println("Please select an answer before confirming.");
                }
            });

            // Add listener to detect when the video ends
            mediaPlayer.setOnEndOfMedia(() -> {
                questionLabel.setText(questions[currentVideoIndex - 1]);
                updateButtonLabels();

                questionLabel.setVisible(true);
                for (JButton button : buttons) {
                    button.setVisible(true);
                }
                confirmButton.setVisible(true);
            });

            jPanel.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    resizeMediaView(jPanel, mediaView);
                }
            });

            container.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    resizeMediaView(jPanel, mediaView);
                }
            });

            mediaPlayer.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveFinalScore() {
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
    }

    private void disposeMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
            mediaPlayer = null;
        }
    }


    private void updateButtonLabels() {
        if (currentVideoIndex <= questions.length) {
            List<String> answers = new ArrayList<>(List.of(videoButtonTexts.get(currentVideoIndex - 1)));
            Collections.shuffle(answers);

            String correctAnswer = videoButtonTexts.get(currentVideoIndex - 1)[0];
            System.out.println("Question No. " + answersCount);
            answersCount += 1;

            for (int i = 0; i < 4; i++) {
                String answer = answers.get(i);
                buttons[i].setText(formatButtonText(buttons[i], answer));
                // Check if the answer matches the correct answer AND selectedAnswer is null
                if (answer.equals(correctAnswer) && selectedAnswer == null) {
                    selectedAnswer = buttons[i].getText();
                }
            }
        }
    }

    private String formatButtonText(JButton button, String text) {
        int btnWidth = 550;
        FontMetrics fontMetrics = button.getFontMetrics(button.getFont());
        int textWidth = fontMetrics.stringWidth(text);

        if (textWidth > btnWidth) {
            return "<html><div style='text-align: center;'>" + text.replaceAll("\n", "<br/>") + "</div></html>";
        } else {
            return text;
        }
    }

    private void resizeMediaView(Component container, MediaView mediaView) {
        Dimension newSize = container.getSize();
        double newWidth = newSize.getWidth();
        double newHeight = newSize.getHeight();

        double originalWidth = 1920;
        double originalHeight = 1080;

        if (originalWidth > 0 && originalHeight > 0) {
            double videoAspectRatio = originalWidth / originalHeight;

            double containerAspectRatio = newWidth / newHeight;

            double scaledWidth, scaledHeight;

            if (videoAspectRatio > containerAspectRatio) {
                scaledWidth = newWidth;
                scaledHeight = scaledWidth / videoAspectRatio;
            } else {
                scaledHeight = newHeight;
                scaledWidth = scaledHeight * videoAspectRatio;
            }

            mediaView.setFitWidth(scaledWidth);
            mediaView.setFitHeight(scaledHeight);

            double offsetX = (newWidth - scaledWidth) / 2;
            double offsetY = (newHeight - scaledHeight) / 2;

            mediaView.setTranslateX(offsetX);
            mediaView.setTranslateY(offsetY);
        } else {
            System.err.println("Invalid original dimensions of the video.");
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
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 950));

        videoPanel.setBackground(new java.awt.Color(31, 31, 31));
        videoPanel.setForeground(new java.awt.Color(204, 204, 204));
        videoPanel.setPreferredSize(new java.awt.Dimension(1100, 900));

        startButton.setBackground(new java.awt.Color(255, 255, 0));
        startButton.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        startButton.setForeground(new java.awt.Color(31, 31, 31));
        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/play-button-arrowhead.png"))); // NOI18N
        startButton.setText("START");
        startButton.setBorder(null);
        startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startButton.setMaximumSize(new java.awt.Dimension(300, 100));
        startButton.setPreferredSize(new java.awt.Dimension(350, 100));
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
                .addContainerGap(369, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(394, Short.MAX_VALUE))
        );
        videoPanelLayout.setVerticalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, videoPanelLayout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(416, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(videoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1113, Short.MAX_VALUE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(videoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                .addContainerGap(10, Short.MAX_VALUE))
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
        UIManager.put("OptionPane.messageFont", new Font("Nirmala UI", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Nirmala UI", Font.PLAIN, 14));

        String msg;

        switch (selectedLanguage) {
            case "Sinhala":
                msg = "ඔබට පිටවීමට අවශ්‍ය බව විශ්වාසද?";
                break;
            case "Tamil":
                msg = "நிச்சயமாக வெளியேற விரும்புகிறீர்களா?";
                break;
            case "English":
            default:
                msg = "Are you sure you want to Exit?";
                break;
        }

        int response = JOptionPane.showConfirmDialog(
                null,
                msg,
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            disposeMediaPlayer();
            Platform.setImplicitExit(false);
            new LearnerMenuScreen(selectedLanguage, nicNo).setVisible(true);
            this.dispose();
        }

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
