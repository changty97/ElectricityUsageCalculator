/* PACKAGE PATH */ 
package edu.csus.csc131.euc.view.panels;

/* Library Imports */
import javax.swing.*; 
import java.awt.*;

public class Panel {
    
    /* Panel for this class */
    private JPanel panel;
    /* Set Constraints variable for GridBagLayout */ 
    private GridBagConstraints c = new GridBagConstraints();
    
    /* Constant Colors */
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    private Color BACKGROUND_COLOR;

    public Panel() {
        initializePanel();
    }

    /* Functions for Manual Input Panel */ 
    // Initialize Panel 
    public void initializePanel(){
        /* Panel Initializations */
        panel = new JPanel(new GridBagLayout()); 

        // Set Panel Color
        if(this.BACKGROUND_COLOR == null) {
            this.panel.setBackground(this.DEFAULT_BACKGROUND_COLOR);
        }
        else
            this.panel.setBackground(this.BACKGROUND_COLOR);

    }

    // Setter 
    public void setBackgroundColor(Color c) { this.BACKGROUND_COLOR = c; }
    public void setGridbagInsets(int left, int right, int top, int bottom){ c.insets = new Insets(left,right,top,bottom); }

    // Getter 
    public JPanel getPanel(){ return this.panel; }
    public GridBagConstraints getGridbagConstraints(){ return this.c; }

    /* Functions for Panel */ 
    public void setButtonConstraints(JButton button, int gridx, int gridy) {
        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Adding the button constraints to the main panel
        panel.add(button, c);
    }

    //Overloaded setButton Function
    public void setButtonConstraints(JButton button, int gridx, int gridy, Dimension preferredSize) {
        // Setting the preferred size of the button
        button.setPreferredSize(preferredSize);

        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Adding the button constraints to the main panel
        panel.add(button, c);
    }

    public void setTextFieldConstraints(JTextField text, int gridx, int gridy) {
        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Adding the button constraints to the main panel
        panel.add(text, c);
    }

    //Overloaded setTextField Function
    public void setTextFieldConstraints(JTextField text, int gridx, int gridy, Dimension preferredSize) {
        // Setting the preferred size of the text field
        text.setPreferredSize(preferredSize);

        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Adding the button constraints to the main panel
        panel.add(text, c);
    }

    public void setScrollPaneConstraints(JScrollPane scrollpane, int gridx, int gridy) {
        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Adding the button constraints to the main panel
        panel.add(scrollpane, c);
    }

    //Overloaded setScrollPane Function
    public void setScrollPaneConstraints(JScrollPane scrollpane, int gridx, int gridy, Dimension preferredSize) {
        // Setting the preferred size of the text field
        scrollpane.setPreferredSize(preferredSize);

        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Adding the button constraints to the main panel
        panel.add(scrollpane, c);
    }

    public void setScrollBarConstraints(JScrollBar scrollbar, int gridx, int gridy) {
        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Adding the button constraints to the main panel
        panel.add(scrollbar, c);
    }

    //Overloaded setScrollBar Function
    public void setScrollBarConstraints(JScrollBar scrollbar, int gridx, int gridy, Dimension preferredSize) {
        // Setting the preferred size of the text field
        scrollbar.setPreferredSize(preferredSize);

        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Adding the button constraints to the main panel
        panel.add(scrollbar, c);
    }

    public void setLabelConstraints(JLabel label, int gridx, int gridy) {
        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Adding the button constraints to the main panel
        panel.add(label, c);
    }

    //Overloaded setLabel Function
    public void setLabelConstraints(JLabel label, int gridx, int gridy, Dimension preferredSize) {
        // Setting the preferred size of the text field
        label.setPreferredSize(preferredSize);

        // Setting the X-Axis and Y-Axis
        c.gridx = gridx;
        c.gridy = gridy;

        // Adding the button constraints to the main panel
        panel.add(label, c);
    }
}