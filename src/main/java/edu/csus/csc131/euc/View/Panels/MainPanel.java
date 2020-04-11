/* PACKAGE PATH */ 
package edu.csus.csc131.euc.View.Panels;

/* Library Imports */ 
import javax.swing.*; 
import java.awt.*; 

public class MainPanel extends Panel {
    /* Elements for the Main Frame */
    private JButton importjsonbutton, manualinputbutton, viewcalcbutton;

    /* Labels */ 
    private JLabel titleapp; 

    // Constructor 
    public MainPanel(){ 
        /* Initializers for this Panel */ 
        setBackgroundColor(2, 29, 62);
        initializePanel(); 
        initializeComponents(); 
        intializeConstraints(); 
    }

    // Getters
    public JButton getImportJsonButton(){ return this.importjsonbutton; }
    public JButton getManualInpuButton(){ return this.manualinputbutton; }
    public JButton getViewCalcButton(){ return this.viewcalcbutton; }

    /* Functions for Main Panel */ 

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

    // Initializes Constraints for GridBag Layout 
    public void intializeConstraints(){
        // Set insets for each element (Left, Right, Top, Bottom)
        setGridbagInsets(0, 0, 0, 0);

        // Import JSON Button constraints 
        setButtonConstraints(this.importjsonbutton, 0, 1);

        // Manual Input Button constraints 
        setButtonConstraints(this.manualinputbutton, 0, 2);

        // View Calculate Button constraints 
        setButtonConstraints(this.viewcalcbutton, 0, 3);

        // titleapp Label constraints 
        setGridbagInsets(55, 0, 290, 0);
        setLabelConstraints(titleapp, 0, 0);

        // Label for Bottom Of Main Panel 
        JLabel logo = new JLabel("Logo Goes Here");
        setGridbagInsets(290, 0, 50, 0);
        setLabelConstraints(logo, 0, 4);
    }

}
