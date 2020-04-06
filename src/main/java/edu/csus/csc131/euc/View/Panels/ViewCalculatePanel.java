/* PACKAGE PATH */ 
package edu.csus.csc131.euc.View.Panels;

/* Local Imports */
import javax.swing.*; 
import java.awt.*; 

public class ViewCalculatePanel{

    /* Panel for this class */
    private JPanel panel = new JPanel(); 

    // Variables
    private JButton navrightbutton, navleftbutton;

    // Labels
    // Title Label temporary to denote which panel is used 
    JLabel templabel = new JLabel("This is the View & Calculate Panel");

    // Constructor
    public ViewCalculatePanel() {
        // Set Background Color 
        this.panel.setBackground(Color.LIGHT_GRAY);

        // Create Layout manager for this frame 
        this.panel.setLayout(new BorderLayout());

        /* Instantiate all components of panel here */ 
        
        // Set position of templabel 
        templabel.setHorizontalAlignment(JLabel.CENTER);
        templabel.setVerticalAlignment(JLabel.CENTER); 
        this.panel.add(templabel, BorderLayout.CENTER);
    }

    // Setters
    public void setNavigateRightButton(JButton b) { this.navrightbutton = b; }
    public void setNavigateLeftButton(JButton b) { this.navleftbutton = b; }

    // Getters
    public JButton getNavigateRightButton() { return this.navrightbutton; }
    public JButton getNavigateLeftButton() { return this.navleftbutton; }
    public JPanel getPanel(){ return this.panel; }

}