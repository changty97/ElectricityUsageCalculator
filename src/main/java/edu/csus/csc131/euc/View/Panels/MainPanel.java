/* PACKAGE PATH */ 
package edu.csus.csc131.euc.View.Panels;

/* Library Imports */ 
import javax.swing.*; 
import java.awt.*; 

public class MainPanel{

    /* Constants */ 
    private static final Color BACKGROUND_COLOR = Color.CYAN;

    /* Panel for this Class */
    private JPanel panel;

    /* Elements for the Main Frame */
    private JButton importjsonbutton, manualinputbutton, viewcalcbutton;

    /* Labels */ 
    private JLabel titleapp; 

    // Constructor 
    public MainPanel(){ 
        /* Initializers for this Panel */ 
        initializePanel(); 
        initializeComponents(); 
        intializeComponentPreferences();
        intializeConstraints(); 
    }

    // Getters
    public JPanel getPanel(){ return this.panel; }
    public JButton getImportJsonButton(){ return this.importjsonbutton; }
    public JButton getManualInpuButton(){ return this.manualinputbutton; }
    public JButton getViewCalcButton(){ return this.viewcalcbutton; }

    /* Functions for Main Panel */ 

    // Intialize Panel 
    public void initializePanel(){
        /* Panel Initializations */ 
        panel = new JPanel(new GridBagLayout()); 

        // Set Panel Color 
        panel.setBackground(BACKGROUND_COLOR); 
    }

    // Intialize All Components 
    public void initializeComponents(){
        /* Instantiate all components of panel here */ 
        // Instantiate Buttons
        this.importjsonbutton = new JButton("Import JSON"); 
        this.manualinputbutton = new JButton("Manual Input"); 
        this.viewcalcbutton = new JButton("View & Calculate"); 

        // Instantiate Labels 
        this.titleapp = new JLabel("Electricity Usage Calculator"); 
    }

    // Intializes Preferences for each Component 
    public void intializeComponentPreferences(){}

    // Initializes Constraints for GridBag Layout 
    public void intializeConstraints(){
        /* Set Constraints for GridBagLayout for each component */ 
        GridBagConstraints c = new GridBagConstraints(); 

        // Set insets for each element (Left, Right, Top, Bottom)
        c.insets = new Insets(10,10,10,10);

        // titleapp Label constraints 
        c.gridx = 0;
        c.gridy = 0;
        panel.add(titleapp, c); 

        // Import JSON Button constraints 
        c.gridx = 0; 
        c.gridy = 1; 
        panel.add(this.importjsonbutton, c); 

        // Manual Input Button constraints 
        c.gridx = 0; 
        c.gridy = 2; 
        panel.add(this.manualinputbutton, c); 

        // View Calculate Button constraints 
        c.gridx = 0; 
        c.gridy = 3; 
        panel.add(this.viewcalcbutton, c); 
    }

}
