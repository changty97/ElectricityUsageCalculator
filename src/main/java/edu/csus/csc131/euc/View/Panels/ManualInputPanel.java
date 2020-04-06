/* PACKAGE PATH */ 
package edu.csus.csc131.euc.View.Panels;

/* Library  Imports */
import javax.swing.*; 
import java.awt.*; 

public class ManualInputPanel{

    /* Panel for this class */
    private JPanel panel = new JPanel(); 

    // Instance Elements
    private JButton addentrybutton;
    private JScrollBar scrollbar;
    private JScrollPane scrollpane;
    private JTextField enterdatefield, enterperiodfield, enterusagefield;

    // Labels
    // Title Label temporary to denote which panel is used 
    JLabel templabel = new JLabel("This is the Manual Input Panel");

    // Constructor
    public ManualInputPanel() {
        // Set Panel Color
        this.panel.setBackground(Color.GREEN);

        // Create Layout manager for this frame 
        this.panel.setLayout(new BorderLayout());

        /* Instantiate all components of panel here */ 
        
        // Set position of templabel 
        templabel.setHorizontalAlignment(JLabel.CENTER);
        templabel.setVerticalAlignment(JLabel.CENTER); 
        this.panel.add(templabel, BorderLayout.CENTER);
    }

    // Setters
    public void setAddEntryButton(JButton b) { this.addentrybutton = b; }
    public void setScrollBar(JScrollBar s) { this.scrollbar = s; }
    public void setScrollPane(JScrollPane s) { this.scrollpane = s; }
    public void setEnterDateField(JTextField t) { this.enterdatefield = t; }
    public void setEnterPeriodField(JTextField t) { this.enterperiodfield = t; }
    public void setEnterUsageField(JTextField t) { this.enterusagefield = t; }

    // Getters
    public JButton getAddEntryButton() { return this.addentrybutton; }
    public JScrollBar getScrollBar() { return this.scrollbar; }
    public JScrollPane getScrollPane() { return this.scrollpane; }
    public JTextField getEnterDateField() { return this.enterdatefield; }
    public JTextField getEnterPeriodField() { return this.enterperiodfield; }
    public JTextField getEnterUsageField() { return this.enterusagefield; }
    public JPanel getPanel(){ return this.panel; }

}