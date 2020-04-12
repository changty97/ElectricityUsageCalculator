/* PACKAGE PATH */ 
package edu.csus.csc131.euc.view.panels;

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
        setBackgroundColor(Color.CYAN);
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
        setGridbagInsets(10,10,10,10);

        // titleapp Label constraints 
        setLabelConstraints(titleapp, 0, 0);

        // Import JSON Button constraints 
        setButtonConstraints(this.importjsonbutton, 0, 1);

        // Manual Input Button constraints 
        setButtonConstraints(this.manualinputbutton, 0, 2);

        // View Calculate Button constraints 
        setButtonConstraints(this.viewcalcbutton, 0, 3);
    }

}
