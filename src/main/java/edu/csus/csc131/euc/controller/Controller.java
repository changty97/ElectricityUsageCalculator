/* PACKAGE PATH */
package edu.csus.csc131.euc.controller;

/* Library Imports */
// AWT Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Swing Imports
import javax.swing.*;
// Swing Imports
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

// IO Imports
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

/*
// Util Imports
import java.util.Date;
import java.util.Iterator;
import java.text.DateFormat;

// Text Imports
import java.text.SimpleDateFormat;
import java.text.DateFormat;
*/

/* Local Imports */
// Local MVC Imports
import edu.csus.csc131.euc.view.View;
import edu.csus.csc131.euc.model.Model;
import edu.csus.csc131.euc.controller.actionlistener.viewactionlisteners.*;
import edu.csus.csc131.euc.model.data.Day;
import edu.csus.csc131.euc.controller.actionlistener.modelactionlisteners.*;
// import edu.csus.csc131.euc.controller.actionlistener.modelactionlisteners.*;

// Simple Local Import
import edu.csus.csc131.euc.libraries.simple.JSONArray;
import edu.csus.csc131.euc.libraries.simple.JSONObject;
import edu.csus.csc131.euc.libraries.simple.parser.JSONParser;
import edu.csus.csc131.euc.libraries.simple.parser.ParseException;

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

        /* Action Listeners for Main Panel */

        // Get References to Buttons
        JButton ib = view.getMainPanel().getImportJsonButton();
        JButton mb = view.getMainPanel().getManualInputButton();
        JButton vcb = view.getMainPanel().getViewCalcButton();

        // Set AL for Panels
        ib.addActionListener(new PanelSwitchButtonListener(view, "Import JSON Panel"));
        mb.addActionListener(new PanelSwitchButtonListener(view, "Manual Input Panel"));
        vcb.addActionListener(new PanelSwitchButtonListener(view,  "View & Calculate Panel"));

        // Set AL for Panels
        view.getMainPanel().getImportJsonButton().addActionListener(new PanelSwitchButtonListener(view, "Import JSON Panel"));
        view.getMainPanel().getManualInputButton().addActionListener(new PanelSwitchButtonListener(view, "Manual Input Panel"));
        view.getMainPanel().getViewCalcButton().addActionListener(new PanelSwitchButtonListener(view,"View & Calculate Panel"));

        // Action Listener for Add Entry button
        view.getManualInputPanel().getAddEntryButton().addActionListener(new AddEntryListener());

        // Focus Listener for UsageTextField and date
        view.getManualInputPanel().getEnterUsageField().addFocusListener(new Focus());
        view.getManualInputPanel().getEnterDateField().addFocusListener(new Focus());
        // Set AL for Buttons in Import JSON Panel
        // For Button Views
        view.getImportPanel().getBrowseButton().addActionListener(new IJPanelButtonViewListener(view));
        view.getImportPanel().getImportButton().addActionListener(new IJPanelButtonViewListener(view));
        view.getImportPanel().getImportButton().addActionListener(new IJPanelIBActionListener(view, model));

    }

    public void createAndShowGUI() {
        // Display Window
        this.view.getFrame().pack();
        this.view.getFrame().setVisible(true);

        // DEBUG FOR PANEL SIZES
        System.out.println("Dim Frame: " + view.getFrame().getSize() );
        System.out.println("Dim Main Panel: " + view.getMainPanel().getPanel().getSize() );
        System.out.println("Dim View and Calculate Panel: " + view.getViewCalculatePanel().getPanel().getSize() );
        System.out.println("Dim Import Panel: " + view.getImportPanel().getPanel().getSize() );
        System.out.println("Dim Manual Input Panel: " + view.getManualInputPanel().getPanel().getSize() );
    }

    public void initializeView() {
        // Initialize the view
        View v = new View();
        this.view = v;
    }


    class AddEntryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String date = view.getManualInputPanel().getEnterDateField().getText();
            int index =  view.getManualInputPanel().getEnterPeriodField().getSelectedIndex();
            float usage = 0;
            try{
                usage = Float.parseFloat(view.getManualInputPanel().getEnterUsageField().getText());
                Day day = new Day(date);
                day.setUsage(usage, index);
                model.getModelProfile().addDay(day);
                view.getManualInputPanel().getListModel().addElement(date + " " + index + ":00 - " + (int)(index+1) + ":00" + " " + usage);
                view.getManualInputPanel().getEnterDateField().setText("Enter Date");
                view.getManualInputPanel().getEnterPeriodField().setSelectedIndex(0);
                view.getManualInputPanel().getEnterUsageField().setText("Enter Usage");
            }
            catch(Exception ex){
                System.out.println("Usage has to be float!");
                JOptionPane.showMessageDialog(view.getFrame(), "Usage has to be a number.");
            }

        }
    }
    class Focus implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
           JTextField j = (JTextField) e.getSource();
           j.selectAll();

        }

        @Override
        public void focusLost(FocusEvent e) {
            //nothing

        }

    }
}


