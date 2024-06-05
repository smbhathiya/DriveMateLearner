/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package drive.mate.learner;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.String;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author smbha
 */
public class UserLoginScreen extends javax.swing.JFrame {

    public static String selectedLanguage;
    public static String nicNo;

    /**
     * Creates new form UserLoginScreen
     */
    public UserLoginScreen(String selectedLanguage) {
        this.selectedLanguage = selectedLanguage;

        Image iconl = new ImageIcon(getClass().getResource("/res/DML.png")).getImage();
        this.setIconImage(iconl);

        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AlertMessages.conformExit(); // Call the method from AlertMessages class
            }
        });
        // Customize UI based on the selected language
        customizeUI();

        // Set default background color
        Color defaultColor = Color.decode("#FFFF00");
        Color hoverColor = Color.decode("#D8D822");

        loginbtn.setBackground(defaultColor);
        addHoverEffect(loginbtn, defaultColor, hoverColor);

    }

    private void addHoverEffect(JButton button, Color defaultColor, Color hoverColor) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(defaultColor);
            }
        });
    }

    private void customizeUI() {

        if (selectedLanguage.equals("English")) {
            loginbtn.setText("USER LOGIN");

        } else if (selectedLanguage.equals("Sinhala")) {
            loginbtn.setText("පරිශීලක ඇතුළුවීම");
            backBtn.setText("ආපසු");

        } else if (selectedLanguage.equals("Tamil")) {
            loginbtn.setText("பயனர் உள்நுழைவு");
            backBtn.setText("ஆதரி");
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
        jPanel2 = new javax.swing.JPanel();
        getNIC = new javax.swing.JTextField();
        loginbtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        backBtn = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 31, 31));

        jPanel2.setBackground(new java.awt.Color(31, 31, 31));

        getNIC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getNIC.setForeground(new java.awt.Color(255, 255, 255));
        getNIC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getNIC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 0)));
        getNIC.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getNIC.setPreferredSize(new java.awt.Dimension(280, 55));
        getNIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                getNICKeyPressed(evt);
            }
        });

        loginbtn.setBackground(new java.awt.Color(255, 255, 0));
        loginbtn.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        loginbtn.setForeground(new java.awt.Color(31, 31, 31));
        loginbtn.setText("Login");
        loginbtn.setBorder(null);
        loginbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginbtn.setPreferredSize(new java.awt.Dimension(280, 55));
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(getNIC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(getNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/back.png"))); // NOI18N
        backBtn.setText("BACK");
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

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        // Get the NIC number entered by the user
        nicNo = getNIC.getText();

        // Call a method to check if the user exists in the database
        if (isUserAvailable(nicNo)) {
            // User exists, navigate to LearnerMenuScreen with language and NIC number
            LearnerMenuScreen menuScreen = new LearnerMenuScreen(selectedLanguage, nicNo);
            menuScreen.setVisible(true);
            // Close the current UserLoginScreen
            dispose();
        } else {
            // User not available, show an alert or error message to the user
            JOptionPane.showMessageDialog(this, "User not available. Please check NIC number.");
        }
    }//GEN-LAST:event_loginbtnActionPerformed

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        new SelectLanguage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backBtnMouseClicked

    private void getNICKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_getNICKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginbtn.doClick();
        }
    }//GEN-LAST:event_getNICKeyPressed

    public static boolean isUserAvailable(String nicNo) {
        boolean userAvailable = false;

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE nicno = ?")) {

            stmt.setString(1, nicNo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // User exists
                    userAvailable = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAvailable;
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
            java.util.logging.Logger.getLogger(UserLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLoginScreen(selectedLanguage).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu backBtn;
    private javax.swing.JTextField getNIC;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginbtn;
    // End of variables declaration//GEN-END:variables
}
