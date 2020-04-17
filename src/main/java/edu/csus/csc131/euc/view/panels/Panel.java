/* PACKAGE PATH */ 
package edu.csus.csc131.euc.view.panels;

/* Library Imports */
import javax.swing.*; 
import java.awt.*;

public class Panel {
    /* Panel for this class */
    private JPanel panel;

    /* Set Constraints variable for GridBagLayout */ 
    private GridBagLayout gb = new GridBagLayout(); 
    private GridBagConstraints c = new GridBagConstraints();
    
    /* Constant Colors */
    private final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    private Color BACKGROUND_COLOR;

    public Panel() {
        initializePanel();
    }

    /* Functions for Manual Input Panel */ 
    // Initialize Panel 
    public void initializePanel(){
        /* Panel Initializations */
        panel = new JPanel(gb); 

        // Set Panel Color
        if(this.BACKGROUND_COLOR == null) {
            this.panel.setBackground(this.DEFAULT_BACKGROUND_COLOR);
        }
        else
            this.panel.setBackground(this.BACKGROUND_COLOR);

    }

    // Setters
    public void setBackgroundColor(Color c) { this.BACKGROUND_COLOR = c; }
    public void setPanelSize(Dimension s){ panel.setSize(s); }

    // Overloaded with RGB 
    public void setBackgroundColor(int r, int g, int b) { 
        Color c = new Color(r, g, b); 
        this.BACKGROUND_COLOR = c; 
    }

    // If all elements are using the same padding 
    public void setGlobalGridbagInsets(Insets i){ c.insets = i; }

    // Getters
    public JPanel getPanel(){ return this.panel; }
    public GridBagConstraints getGridbagConstraints(){ return this.c; }
    public GridBagLayout getGridBagLayout(){ return this.gb; }

    /* Functions for Panel */ 
    public void setButtonConstraints(JButton button, int gridx, int gridy, Dimension preferredSize, Insets inset) {
        // Set new GridBagConstraints per element 
        c = new GridBagConstraints();

        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Setting the preferred size of the button
        if( preferredSize != null ){ button.setPreferredSize(preferredSize); }

        // Setting the padding 
        if( inset != null ){  c.insets = inset; }

        // Adding the button constraints to the main panel
        panel.add(button, c);
    }

    public void setTextFieldConstraints(JTextField text, int gridx, int gridy, Dimension preferredSize, Insets inset) {
        // Set new GridBagConstraints per element 
        c = new GridBagConstraints();

        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Setting the preferred size of the button
        if( preferredSize != null ){ text.setPreferredSize(preferredSize); }

        // Setting the padding 
        if( inset != null ){  c.insets = inset; }

        // Adding the button constraints to the main panel
        panel.add(text, c);
    }

    public void setScrollPaneConstraints(JScrollPane scrollpane, int gridx, int gridy, Dimension preferredSize, Insets inset) {
        // Set new GridBagConstraints per element 
        c = new GridBagConstraints();

        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Setting the preferred size of the button
        if( preferredSize != null ){ scrollpane.setPreferredSize(preferredSize); }

        // Setting the padding 
        if( inset != null ){  c.insets = inset; }

        // Adding the button constraints to the main panel
        panel.add(scrollpane, c);
    }


    public void setScrollBarConstraints(JScrollBar scrollbar, int gridx, int gridy, Dimension preferredSize, Insets inset) {
        // Set new GridBagConstraints per element 
        c = new GridBagConstraints();

        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Setting the preferred size of the button
        if( preferredSize != null ){ scrollbar.setPreferredSize(preferredSize); }

        // Setting the padding 
        if( inset != null ){  c.insets = inset; }

        // Adding the button constraints to the main panel
        panel.add(scrollbar, c);
    }

    public void setLabelConstraints(JLabel label, int gridx, int gridy, Dimension preferredSize, Insets inset) {
        // Set new GridBagConstraints per element 
        c = new GridBagConstraints();

        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Setting the preferred size of the button
        if( preferredSize != null ){ label.setPreferredSize(preferredSize); }

        // Setting the padding 
        if( inset != null ){  c.insets = inset; }

        // Adding the button constraints to the main panel
        panel.add(label, c);
    }

}