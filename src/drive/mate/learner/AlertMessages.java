/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package drive.mate.learner;

import javax.swing.JOptionPane;

/**
 *
 * @author smbha
 */
public class AlertMessages {

    public static void conformExit() {
        int confirmExit = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to Exit?",
                "Exit",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmExit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void showFailedMessage(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Failed",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void showNullMessage(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Empty",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void invalidCredentialsMessage(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Failed",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}