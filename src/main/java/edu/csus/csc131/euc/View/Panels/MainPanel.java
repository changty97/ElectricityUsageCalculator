/* PACKAGE PATH */ 
package edu.csus.csc131.euc.View.Panels;

/* Library Imports */ 
import javax.swing.*; 
import java.awt.*; 

public class MainPanel extends Panel {
    /* CONSTANTS */ 
    private final Dimension PANEL_SIZE = new Dimension(360, 810); 


    /* Elements for the Main Frame */
    private JButton importjsonbutton, manualinputbutton, viewcalcbutton;

    /* Labels */ 
    private JLabel titleapp; 

    // Constructor 
    public MainPanel(){ 
        /* Setting attributes for this Panel */ 
        setBackgroundColor(2, 29, 62);
        setPanelSize(PANEL_SIZE); 

        /* Initializers */ 
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
        this.importjsonbutton = new JButton("Add File"); 
        this.manualinputbutton = new JButton("Enter Usage"); 
        this.viewcalcbutton = new JButton("View & Calculate"); 

        // Instantiate Labels
        this.titleapp = new JLabel("Electricity Usage Calculator"); 
        this.titleapp.setFont(new Font("Poppins", Font.PLAIN, 20));
        this.titleapp.setForeground(Color.WHITE); 
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
        logo.setForeground(Color.WHITE);
        setGridbagInsets(290, 0, 50, 0);
        setLabelConstraints(logo, 0, 4);
    }

}
