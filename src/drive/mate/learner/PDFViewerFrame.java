package drive.mate.learner;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PDFViewerFrame extends JFrame {

    private final File pdfFile;
    private float currentDPI = 100; // Initial DPI value

    public PDFViewerFrame(File pdfFile) {
        this.pdfFile = pdfFile;
        setTitle("PDF Viewer");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadPDF();
    }

    private void loadPDF() {
        try (PDDocument document = Loader.loadPDF(pdfFile)) {
            PDFRenderer renderer = new PDFRenderer(document);
            int numPages = document.getNumberOfPages();

            // Create a panel to contain the pages
            JPanel panel = new JPanel(new GridLayout(numPages, 1));

            // Add each page as an image to the panel
            for (int i = 0; i < numPages; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, currentDPI, ImageType.RGB);
                ImageIcon icon = new ImageIcon(image);
                JLabel label = new JLabel(icon);
                panel.add(label);
            }

            // Wrap the panel in a JScrollPane for scrolling
            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            
            scrollPane.addMouseWheelListener(new MouseWheelListener() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    // Increase or decrease the scroll speed based on the mouse wheel rotation
                    if (e.getWheelRotation() < 0) {
                        // Mouse wheel moved up (zoom in)
                        scrollPane.getVerticalScrollBar().setUnitIncrement(10); // Adjust the increment as needed
                    } else {
                        // Mouse wheel moved down (zoom out)
                        scrollPane.getVerticalScrollBar().setUnitIncrement(10); // Adjust the increment as needed
                    }
                }
            });

            // Add zoom-in and zoom-out buttons
            JButton zoomInButton = new JButton("Zoom In");
            zoomInButton.addActionListener(new ZoomInActionListener());

            JButton zoomOutButton = new JButton("Zoom Out");
            zoomOutButton.addActionListener(new ZoomOutActionListener());

            // Create a panel for the buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(zoomInButton);
            buttonPanel.add(zoomOutButton);

            // Add the scroll pane and button panel to the frame
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(scrollPane, BorderLayout.CENTER);
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading PDF: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class ZoomInActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            currentDPI *= 1.1; // Increase DPI by 10%
            reloadPDF();
        }
    }

    private class ZoomOutActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            currentDPI /= 1.1; // Decrease DPI by 10%
            reloadPDF();
        }
    }
    
    

    private void reloadPDF() {
        // Get the content pane
        Container contentPane = getContentPane();
        // Clear existing components
        contentPane.removeAll();
        // Load PDF again
        loadPDF();
        // Revalidate and repaint content pane
        contentPane.revalidate();
        contentPane.repaint();
    }

    public static void main(String[] args) {
        File pdfFile = new File("path_to_your_pdf_file.pdf");
        SwingUtilities.invokeLater(() -> {
            PDFViewerFrame viewerFrame = new PDFViewerFrame(pdfFile);
            viewerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            viewerFrame.setVisible(true);
        });
    }
}
