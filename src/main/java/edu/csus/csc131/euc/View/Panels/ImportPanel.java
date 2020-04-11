/* PACKAGE PATH */ 
package edu.csus.csc131.euc.View.Panels;

/* Library Imports */
import javax.swing.*; 
import java.awt.*;

public class ImportPanel{

    /* Constants */ 
    private static final Color BACKGROUND_COLOR = Color.ORANGE;
    private static final Dimension IMPORT_FIELD_DIMENSIONS = new Dimension(750, 50); 
    private static final Dimension BROWSE_BUTTON_DIMENSIONS = new Dimension(165, 50);
    private static final Dimension IMPORT_BUTTON_DIMENSIONS = new Dimension(410,75);

    /* Panel for this class */
    private JPanel panel;

    /* Instance Variables */
    private JButton importbutton, browsebutton;
    private JTextField importfield;
    private DragBoxDraw dragbox;

    // Constructor
    public ImportPanel() {
        /* Intializers for this Panel */
        initializePanel(); 
        initializeComponents(); 
        intializeComponentPreferences();
        intializeConstraints(); 
    }

    // Private Class to draw the DragBox using Graphic override
    private class DragBoxDraw extends JPanel {

        /* Constants */ 
        private Dimension DRAG_FILE_PANEL_DIMENSIONS = new Dimension(920, 332);
        private Point DRAG_FILE_RECT_ORIGIN = new Point(0,0);
        private Point DRAG_FILE_LABEL_ORIGIN = new Point(332, 332);       

        // Seriable ID 
        private static final long serialVersionUID = 1L;

        // Initialize Panel to draw the drag box
        public DragBoxDraw(){
            this.setPreferredSize(DRAG_FILE_PANEL_DIMENSIONS);
            this.setSize(DRAG_FILE_PANEL_DIMENSIONS);
        }

        @Override
        protected void paintComponent(Graphics g) {

            // Setting Rectangle Parameters 
            Graphics2D g2 = (Graphics2D) g; 
            super.paintComponent(g2); 

            // Rectangle Attributes 
            int thickness = 2; 

            // Create Rectangle 
            Rectangle rect = new Rectangle(
                DRAG_FILE_RECT_ORIGIN.x, 
                DRAG_FILE_RECT_ORIGIN.y , 
                DRAG_FILE_PANEL_DIMENSIONS.width-1, 
                DRAG_FILE_PANEL_DIMENSIONS.height-1
            );

            // Create Border 
            float dash1[] = {10.0f};
            BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);

            // Update Parameters 
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(thickness));
            g2.setStroke(dashed);

            // Draw Rectangle 
            g2.draw(rect);

            // String Attributes 
            g2.setColor(Color.black);
            g2.setFont(new Font("TimesRoman", Font.PLAIN, 20));

            // Draw Rectangle String 
            g2.drawString("Browse or Drag Files Here", DRAG_FILE_LABEL_ORIGIN.x, DRAG_FILE_LABEL_ORIGIN.y/2);

        }
    }

    // Setters
    public void setImportField(String t) { this.importfield = new JTextField(t); }

    // Getters
    public JButton getImportButton() { return this.importbutton; }
    public JButton getBrowseButton() { return this.browsebutton; }
    public JTextField getImportField() { return this.importfield; }
    public JPanel getPanel(){ return this.panel; }

    /* Functions for Import Panel */ 

    // Intialize Panel 
    public void initializePanel(){
        /* Panel Initializations */ 
        panel = new JPanel(new GridBagLayout()); 

        // Set Background color 
        panel.setBackground(BACKGROUND_COLOR);
    }

    // Intialize All Components 
    public void initializeComponents(){
        /* Instantiate all components of panel here */ 
        // import field
        this.importfield = new JTextField(" C:\\...\\Desktop... "); 

        // browse button
        this.browsebutton = new JButton("Browse"); 

        // Drag Box 
        this.dragbox = new DragBoxDraw(); 

        // import button 
        this.importbutton = new JButton("Import JSON");
    }

    // Intializes Preferences for each Component 
    public void intializeComponentPreferences(){
        /* Component Preferences */ 
        // import field
        this.importfield.setPreferredSize(IMPORT_FIELD_DIMENSIONS);

        // browse button
        this.browsebutton.setPreferredSize(BROWSE_BUTTON_DIMENSIONS);

        // import button 
        this.importbutton.setPreferredSize(IMPORT_BUTTON_DIMENSIONS);
    }

    // Initializes Constraints for GridBag Layout 
    public void intializeConstraints(){
        /* Set Constraints for GridBagLayout for each component */ 
        GridBagConstraints c = new GridBagConstraints(); 

        // Set insets for each element (Left, Right, Top, Bottom)
        c.insets = new Insets(0,0,20,0);

        // importfield constraints
        c.gridx = 0; c.gridy = 0; 
        panel.add(importfield, c); 

        // browse button constraints 
        c.gridx = 1; c.gridy = 0;
        panel.add(browsebutton, c); 

        // dragbox constraints 
        c.gridx = 0; c.gridy = 1; 
        panel.add(dragbox, c);

        // importbutton Constraints 
        c.gridx = 0; c.gridy = 2; 
        panel.add(importbutton, c); 

    }
}