/* PACKAGE PATH */
package edu.csus.csc131.euc.controller;

/* Library Imports */
// AWT Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Swing Imports
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

// Simple Local Import
import edu.csus.csc131.euc.libraries.simple.JSONArray;
import edu.csus.csc131.euc.libraries.simple.JSONObject;
import edu.csus.csc131.euc.libraries.simple.parser.JSONParser;
import edu.csus.csc131.euc.libraries.simple.parser.ParseException;

public class Controller {
    // Instance Variables for Controller
    private View view;
    private Model model;
    private File file;

    public Controller(Model m, View v) {
        this.model = m;
        this.view = v;
        this.file = null;

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
        ib.addActionListener(new PanelSwitchButtonListener(view, ib, "Import JSON Panel"));
        mb.addActionListener(new PanelSwitchButtonListener(view, mb, "Manual Input Panel"));
        vcb.addActionListener(new PanelSwitchButtonListener(view, vcb, "View & Calculate Panel"));

        // Action Listener for Import JSON Panel
        view.getImportPanel().getBrowseButton().addActionListener(new BrowseButtonListener());
        view.getImportPanel().getImportButton().addActionListener(new ImportButtonListener());

        // Action Listener for Add Entry button
        view.getManualInputPanel().getAddEntryButton().addActionListener(new AddEntryListener());

        // Focus Listener for UsageTextField and date
        view.getManualInputPanel().getEnterUsageField().addFocusListener(new Focus());
        view.getManualInputPanel().getEnterDateField().addFocusListener(new Focus());
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

    // IMPORT JSON PANEL ACTION LISTENERS - PS: NEEDS TO BE MOVED TO MODEL ACTION LISTENER
    class BrowseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();

            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Locate JSON to import");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setMultiSelectionEnabled(false);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON File", "json"));

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
                System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
                System.out.println("getSelectedFile(): "+ chooser.getSelectedFile());
                System.out.println("getAbsolutePath(): "+ file.getAbsolutePath());

                // Set new import field text
                view.getImportPanel().getImportField().setText("" + chooser.getSelectedFile());
            } else {
                System.out.println("No Selection ");
                file = null;
            }
        }
    }

    class ImportButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JSONParser parser = new JSONParser();

            try (Reader reader = new FileReader(file)) {

                JSONObject jsonObject = (JSONObject) parser.parse(reader);

                // Imports the data to the model for the profileID (userId), unit, and siteTimeZoneId
                model.getModelProfile().setProfileID(Integer.parseInt(jsonObject.get("userId").toString()));
                model.getModelProfile().setProfileUnit((String) jsonObject.get("unit"));
                model.getModelProfile().setProfileSiteTimeZoneID((String) jsonObject.get("siteTimeZoneId"));

                JSONArray reads = (JSONArray) jsonObject.get("reads");
                //TEST// System.out.println(jsonObject);

                // Imports the data to the model under read: for the startTime, endTime, and value
                for (int i = 0; i < reads.size(); i++) {
                    JSONObject readsInternalObject = new JSONObject((JSONObject)reads.get(i));
                    String startTime = readsInternalObject.get("startTime").toString();
                    String endTime = readsInternalObject.get("endTime").toString();
                    double value = (double) readsInternalObject.get("value");
                    //TEST// System.out.println("startTime: " + startTime + ", endTime: " + endTime + ", value: " + value);

                    model.getModelRates().setStartTimeAtIndex(startTime, i);
                    model.getModelRates().setEndTimeAtIndex(endTime, i);
                    model.getModelRates().setRateAtIndex((float) value, i);
                    //TEST// System.out.println("startTime: " + model.getModelRates().getStartTimeAtIndex(i) + ", endTime: " + model.getModelRates().getEndTimeAtIndex(i) + ", value: " + model.getModelRates().getRateAtIndex(i));
                }

                // Set a default view for view/calcuate which takes the datetime of the first rate in the array.
                // In this case, after importing the program, the index will be at 0 and we will see the start/end
                // time and the rate in the beginning of the dataset in the JSON file.
                model.setModelIndex(0); // this will always set the index value to 0 at import.
                view.getViewCalculatePanel().getUsageStartTime().setText(model.getModelRates().getStartTimeAtIndex(model.getModelIndex()));
                view.getViewCalculatePanel().getUsageEndTime().setText(model.getModelRates().getEndTimeAtIndex(model.getModelIndex()));

            } catch (IOException exception) { exception.printStackTrace();
            } catch (IndexOutOfBoundsException exception) { exception.printStackTrace();
            } catch (ParseException exception) { exception.printStackTrace();
            } catch (NullPointerException exception) { System.out.println("No file selected."); }
        }
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


