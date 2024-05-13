/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package drive.mate.learner;

import static drive.mate.learner.DatabaseConnection.getConnection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import drive.mate.learner.SelectLanguage;
import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smbha
 */
public class LearnerMenuScreen extends javax.swing.JFrame {

    public static String selectedLanguage;
    public static String nicNo;
    public static String userName;

    /**
     * Creates new form LearnerMenuScreen
     */
    public LearnerMenuScreen(String selectedLanguage, String nicNo) {
        this.selectedLanguage = selectedLanguage;
        this.nicNo = nicNo;
        initComponents(); // Move initComponents() call to here

        // Get user name
        userName = getUserName(nicNo);
        this.userName = userName;

        // Set NIC number and user name labels
        nicnolbl.setText(nicNo);
        usernamelbl.setText(userName);

        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AlertMessages.conformExit();
            }
        });
    }

    public static String getUserName(String nicNo) {
        String userName = "";

        try (
                Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT name FROM users WHERE nicno = ?")) {

            stmt.setString(1, nicNo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    userName = rs.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userName;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernamelbl = new javax.swing.JLabel();
        nicnolbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        getExambtn = new javax.swing.JButton();
        getMaterialsbtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Learner Menu Screen");

        usernamelbl.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        usernamelbl.setForeground(new java.awt.Color(204, 204, 204));
        usernamelbl.setText("name");

        nicnolbl.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        nicnolbl.setForeground(new java.awt.Color(204, 204, 204));
        nicnolbl.setText("nic");

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel2.setText("NAME :");

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel3.setText("NIC :");

        getExambtn.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        getExambtn.setText("TEST");
        getExambtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getExambtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getExambtnActionPerformed(evt);
            }
        });

        getMaterialsbtn.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        getMaterialsbtn.setText("View Leaning Materials");
        getMaterialsbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getMaterialsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getMaterialsbtnActionPerformed(evt);
            }
        });

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/logout.png"))); // NOI18N
        jMenu1.setText("Logout");
        jMenu1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernamelbl)
                                    .addComponent(nicnolbl))))
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(getMaterialsbtn)
                        .addGap(63, 63, 63)
                        .addComponent(getExambtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(454, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nicnolbl))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(usernamelbl))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getExambtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getMaterialsbtn))
                .addContainerGap(372, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {getExambtn, getMaterialsbtn});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new SelectLanguage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void getExambtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getExambtnActionPerformed
        new TestScreen(selectedLanguage, nicNo).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_getExambtnActionPerformed

    private void getMaterialsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getMaterialsbtnActionPerformed
        OpenPDF.openPDF(selectedLanguage);
    }//GEN-LAST:event_getMaterialsbtnActionPerformed

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
            java.util.logging.Logger.getLogger(LearnerMenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LearnerMenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LearnerMenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LearnerMenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LearnerMenuScreen(selectedLanguage, nicNo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getExambtn;
    private javax.swing.JButton getMaterialsbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel nicnolbl;
    private javax.swing.JLabel usernamelbl;
    // End of variables declaration//GEN-END:variables
}
