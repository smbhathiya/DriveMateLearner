package drive.mate.learner;


import java.io.File;

public class OpenPDF {

    public static void openPDF(String language) {
        // Path to the PDF file for the selected language
        String pdfPath = "C:/Users/smbha/OneDrive/Documents/NetBeansProjects/PROJECT/Drive Mate Learner/test/pdf/" + language + ".pdf";
        

        // Attempt to open the PDF file
        File pdfFile = new File(pdfPath); // Handle exception if unable to open the PDF file
        if (pdfFile.exists()) {
            new PDFViewerFrame(pdfFile).setVisible(true);
        } else {
            System.out.println("PDF file not found for language: " + language);
        }
    }
}
