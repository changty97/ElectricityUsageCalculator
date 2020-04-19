/* PACKAGE PATH */
package edu.csus.csc131.euc.controller.actionlistener.modelactionlisteners;

/* Library Imports */
// AWT Imports 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// IO Imports 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

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

// Simple Local Import
import edu.csus.csc131.euc.libraries.simple.JSONArray;
import edu.csus.csc131.euc.libraries.simple.JSONObject;
import edu.csus.csc131.euc.libraries.simple.parser.JSONParser;
import edu.csus.csc131.euc.libraries.simple.parser.ParseException;

public class IJPanelIBActionListener implements ActionListener {
    // Instance Variables 
    View view; 
    Model model;

    public IJPanelIBActionListener(View v, Model m){
        this.view = v; 
        this.model = m; 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JSONParser parser = new JSONParser();

        // Throws a FILENOTFOUNDEXCEPTION which cascades into other issues.. need to debug this. 
        File file = new File(view.getImportPanel().getImportField().getText()); 
 
        try (Reader reader = new FileReader(file)) {
                
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // Imports the data to the model for the profileID (userId), unit, and siteTimeZoneId
            model.getModelProfile().setProfileID(Integer.parseInt(jsonObject.get("userId").toString()));
            model.getModelProfile().setProfileUnit((String) jsonObject.get("unit"));
            model.getModelProfile().setProfileSiteTimeZoneID((String) jsonObject.get("siteTimeZoneId"));

            JSONArray reads = (JSONArray) jsonObject.get("reads");
            //TEST
            System.out.println(jsonObject);

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
                
        }
        catch (IOException exception) { exception.printStackTrace(); } 
        catch (IndexOutOfBoundsException exception) { exception.printStackTrace(); } 
        catch (ParseException exception) { exception.printStackTrace(); } 
        catch (NullPointerException exception) { System.out.println("No file selected."); }
    }
} 

