package drive.mate.learner;

import java.io.File;

public class OpenPDF {

    public static void openPDF(String language) {
        //Path to the PDF file for the selected language
        //only for testing
        String pdfPath = "C:/Users/smbha/OneDrive/Documents/NetBeansProjects/PROJECT/Drive Mate Learner/test/pdf/" + language + ".pdf";

        //path should change to this when build
//        String folderPath = System.getProperty("user.dir");
//        String pdfPath = folderPath + "/pdf/" + language + ".pdf";


        // Attempt to open the PDF file
        File pdfFile = new File(pdfPath); // Handle exception if unable to open the PDF file
        if (pdfFile.exists()) {
            new PDFViewerFrame(pdfFile,900,600).setVisible(true);
        } else {
            System.out.println("PDF file not found for language: " + language);
        }
    }
}
