/* PACKAGE PATH */ 
package edu.csus.csc131.euc.View.Panels;

/* Library Imports */
import javax.swing.*; 
import java.awt.*;

public class ImportPanel{

    /* Panel for this class */
    private JPanel panel = new JPanel(); 

    // Variables
    private JButton importbutton, browsebutton, dragbox;
    private JTextField importfield;

    // Labels
    // Title Label temporary to denote which panel is used 
    JLabel templabel = new JLabel("This is the Import JSON Panel");

    // Constructor
    public ImportPanel() {
        // Set Background color 
        panel.setBackground(Color.ORANGE);

        // Create Layout manager for this frame 
        this.panel.setLayout(new BorderLayout());

        /* Instantiate all components of panel here */ 
        
        // Set position of templabel 
        templabel.setHorizontalAlignment(JLabel.CENTER);
        templabel.setVerticalAlignment(JLabel.CENTER); 
        this.panel.add(templabel, BorderLayout.CENTER);
    }

    // Setters
    public void setImportButton(JButton b) { this.importbutton = b; }
    public void setBrowseButton(JButton b) { this.browsebutton = b; }
    public void setDragBox(JButton b) { this.dragbox = b; }
    public void setImportField(JTextField t) { this.importfield = t; }

    // Getters
    public JButton getImportButton() { return this.importbutton; }
    public JButton getBrowseButton() { return this.browsebutton; }
    public JButton getDragBox() { return this.dragbox; }
    public JTextField getImportField() { return this.importfield; }
    public JPanel getPanel(){ return this.panel; }

}