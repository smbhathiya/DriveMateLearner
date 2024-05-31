/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package drive.mate.learner;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JFrame;
import javax.swing.UIManager;
import drive.mate.learner.LoadingScreen;
import drive.mate.learner.SelectLanguage;

/**
 *
 * @author smbha
 */
public class DriveMateLearner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            JFrame.setDefaultLookAndFeelDecorated(true); // Enable custom window decorations
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }
        LoadingScreen pb = new LoadingScreen();
        pb.setVisible(true);
        try{
            for(int x=0;x<=100;x++){
                Thread.sleep(25);
                pb.lbl.setText(Integer.toString(x)+"%");
                pb.jProgressBar.setValue(x);
            }
            SelectLanguage frame = new SelectLanguage();
            frame.setVisible(true);
            pb.setVisible(false);
        }catch(InterruptedException ex){
            
        }
    }

}
