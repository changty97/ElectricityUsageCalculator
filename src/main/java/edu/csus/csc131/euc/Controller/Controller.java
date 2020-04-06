/* PACKAGE PATH */
package edu.csus.csc131.euc.Controller;

/* Local Imports */
import edu.csus.csc131.euc.View.*;
import edu.csus.csc131.euc.Model.Model;

/* Library Imports */
import java.awt.event.*;
import edu.csus.csc131.euc.View.*;
import edu.csus.csc131.euc.Model.Model;

import javax.swing.*; 
import java.awt.*;

public class Controller {
    // Instance Variables for Controller
    private View view;
    private Model model;

    public Controller(Model m, View v) {
        this.model = m;
        this.view = v;

        // Initializers for the Controller
        initializeView();
        initializeActionListeners();
    }

    // Initializes all action listeners 
    public void initializeActionListeners(){
        // Action Listeners for Main Panel 
        view.getMainPanel().getImportJsonButton().addActionListener(new ImportJSONPanelButtonListener());
        view.getMainPanel().getManualInpuButton().addActionListener(new ManualInputButtonListener());
        view.getMainPanel().getViewCalcButton().addActionListener(new ViewCalculateButtonListener());
    }

    public void createAndShowGUI() {
        // Display Window
        this.view.getFrame().pack();
        this.view.getFrame().setVisible(true);
    }

    public void initializeView() {
        // Initialize the view
        View v = new View();
        this.view = v;
    }

    /* IMPLEMENTED BUTTON ACTION LISTENERS HERE */ 

    // MAIN PANEL ACTION LISTENERS 
    class ImportJSONPanelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout panels = (CardLayout) view.getPanels().getLayout();
            panels.show(view.getPanels(), "Import JSON Panel"); 
        }
    }

    class ManualInputButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout panels = (CardLayout) view.getPanels().getLayout();
            panels.show(view.getPanels(), "Manual Input Panel"); 
        }
    }

    class ViewCalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout panels = (CardLayout) view.getPanels().getLayout();
            panels.show(view.getPanels(), "View & Calculate Panel"); 
        }
    }

    // MANUAL INPUT ACTION LISTENERS 

    // VIEW CALCULATE ANCTION LISTENERS 

    // IMPORT JSON PANEL ACTION LISTENERS 


}



