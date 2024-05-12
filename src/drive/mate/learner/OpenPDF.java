package drive.mate.learner;

import javax.swing.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class OpenPDF {

    public static void openPDF(String language) {
        // Path to the PDF file for the selected language
        String pdfPath = "/pdf/" + language + ".pdf";

        // Get the URL of the PDF file
        URL pdfURL = OpenPDF.class.getResource(pdfPath);
        if (pdfURL != null) {
            try {
                // Convert the URL to a URI and then to a File
                File pdfFile = new File(pdfURL.toURI());

                // Open the PDF file in a new JFrame
                SwingUtilities.invokeLater(() -> {
                    try {
                        new PDFViewerFrame(pdfFile).setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error opening PDF: " + e.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
            } catch (URISyntaxException ex) {
                // Handle exception if unable to open the PDF file
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error opening PDF: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Display an error message if the PDF file cannot be found
            JOptionPane.showMessageDialog(null, "PDF file not found for language: " + language,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
