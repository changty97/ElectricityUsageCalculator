/* PACKAGE PATH */
package edu.csus.csc131.euc.controller;

import java.awt.CardLayout;
/* Library Imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/* import java.nio.file.Files;
import java.util.Date;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;*/
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/* Local Imports */
import edu.csus.csc131.euc.view.View;
import edu.csus.csc131.euc.model.Model;
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
        // Action Listeners for Main Panel 
        view.getMainPanel().getImportJsonButton().addActionListener(new ImportJSONPanelButtonListener());
        view.getMainPanel().getManualInpuButton().addActionListener(new ManualInputButtonListener());
        view.getMainPanel().getViewCalcButton().addActionListener(new ViewCalculateButtonListener());

        // Action Listener for Import JSON Panel
        view.getImportPanel().getBrowseButton().addActionListener(new BrowseButtonListener());
        view.getImportPanel().getImportButton().addActionListener(new ImportButtonListener());
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

    // class AddEntryButtonListener implements ActionListener{
    //     @Override 
    //     public void actionPerformed(ActionEvent e){
    //         ...
    //     }
    // }

    // MANUAL INPUT ACTION LISTENERS 

    // VIEW CALCULATE ANCTION LISTENERS 

    // IMPORT JSON PANEL ACTION LISTENERS 
    class BrowseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();

            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Locat JSON to import");
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
}



