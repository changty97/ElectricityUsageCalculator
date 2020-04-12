/* PACKAGE PATH */ 
package edu.csus.csc131.euc.view.panels;

/* Local Imports */
import javax.swing.*; 
import java.awt.*; 

public class ViewCalculatePanel extends Panel {

    /* Constants */
    private static final Dimension DIMENSION_TEXTFIELD = new Dimension(100, 25);
    

    /* Instance Variables */
    private JButton navrightbutton, navleftbutton;
    private JTextField usagetotalday, usagenonpeak, usagemidpeak, usagepeak,
        costtotalday, costnonpeak, costmidpeak, costpeak, totalusage, totalcost,
        summeroffpeak, summermidpeak, summerpeak, nonsummeroffpeak, nonsummerpeak;

    // Labels
    JLabel summarytitle, usagetitle; 

    JLabel [] totaldetails = {
        new JLabel("Total Usage"), 
        new JLabel("Total Cost")
    };

    JLabel [] summarydetails = {
        new JLabel("Summer"), 
        new JLabel("Non-Summer"), 
        new JLabel("Off-Peak:"), 
        new JLabel("Mid-Peak:"), 
        new JLabel("Peak:")
    };

    JLabel [] usagedetails = { 
        new JLabel("Total:"), 
        new JLabel("Non-Peak:"),
        new JLabel("Mid-Peak:"),
        new JLabel("Peak:"),
        new JLabel("Total Cost:"),
        new JLabel("Cost Non-Peak:"),
        new JLabel("Cost Mid-Peak:"),
        new JLabel("Cost Peak:")
    };

    // Constructor
    public ViewCalculatePanel() {
        /* Intializers for this Panel */ 
        setBackgroundColor(12, 159, 206);
        initializePanel(); 
        initializeComponents();
        intializeComponentPreferences();
        intializeConstraints(); 
    }

    /* Setters */
    // Setters - Usage Details - Usage 
    public void setUsageDayTotal(JTextField t) { this.usagetotalday = t; }
    public void setUsageNonPeak(JTextField t) { this.usagenonpeak = t; }
    public void setUsageMidPeak(JTextField t) { this.usagemidpeak = t; }
    public void setUsagePeak(JTextField t) { this.usagepeak = t; }

    // Setters - Usage Details - Cost 
    public void setCostDayTotal(JTextField t) { this.costtotalday = t; }
    public void setCostNonPeak(JTextField t) { this.costnonpeak = t; }
    public void setCostMidPeak(JTextField t) { this.costmidpeak = t; }
    public void setCostPeak(JTextField t) { this.costpeak = t; }

    // Setters - Summaery Details - Summer 
    public void setSummerOffPeak(JTextField t) { this.summeroffpeak = t; }
    public void setSummerMidPeak(JTextField t) { this.summermidpeak = t; }
    public void setSummerPeak(JTextField t) { this.summerpeak = t; }

    // Setters - Summary Details - Non-Summer
    public void setNonSummerOffPeak(JTextField t) { this.nonsummeroffpeak = t; }
    public void setNonSummerPeak(JTextField t) { this.nonsummerpeak = t; }

    // Setters - Total Details
    public void setTotalUsage(JTextField t) { this.totalusage = t; }
    public void setTotalCost(JTextField t) { this.totalcost = t; }

    /* Getters */

    // Getters - Navigational Buttons 
    public JButton getNavigateRightButton() { return this.navrightbutton; }
    public JButton getNavigateLeftButton() { return this.navleftbutton; }

    // Getters - Usage Details - Usage 
    public JTextField setUsageDayTotal() { return this.usagetotalday; }
    public JTextField setUsageNonPeak() { return this.usagenonpeak; }
    public JTextField setUsageMidPeak() { return this.usagemidpeak; }
    public JTextField setUsagePeak() { return this.usagepeak; }
    
    // Getters - Usage Details - Cost 
    public JTextField setCostDayTotal() { return this.costtotalday; }
    public JTextField setCostNonPeak() { return this.costnonpeak; }
    public JTextField setCostMidPeak() { return this.costmidpeak; }
    public JTextField setCostPeak() { return this.costpeak; }

    // Getters - Summary Details - Summer 
    public JTextField setSummerOffPeak() { return this.summeroffpeak; }
    public JTextField setSummerMidPeak() { return this.summermidpeak; }
    public JTextField setSummerPeak() { return this.summerpeak; }

    // Getters - Summary Details - Non-Summer
    public JTextField setNonSummerOffPeak() { return this.nonsummeroffpeak; }
    public JTextField setNonSummerPeak() { return this.nonsummerpeak; }

    // Getters - Total Details
    public JTextField setTotalUsage() { return this.totalusage; }
    public JTextField setTotalCost() { return this.totalcost; }

    /* Functions for ViewCalculate Panel*/ 

    // Intialize All Components 
    public void initializeComponents(){
        /* Instantiate all components of panel here */ 
        // Usage Details 
        this.usagetitle = new JLabel("Usage Details"); 

        // Usage Nav Buttons 
        this.navrightbutton = new JButton(">");
        this.navleftbutton = new JButton("<");

        // Usage Text Fields - Usage
        this.usagetotalday = new JTextField("Total Usage (day)");
        this.usagenonpeak = new JTextField("Usage Non-Peak");
        this.usagemidpeak = new JTextField("Usage Mid-Peak");
        this.usagepeak = new JTextField("Usage Peak");

        // Usage Text Fields - Cost
        this.costtotalday = new JTextField("Total Cost (day)");
        this.costnonpeak = new JTextField("Cost Non-Peak");
        this.costmidpeak = new JTextField("Cost Mid-Peak");
        this.costpeak = new JTextField("Cost Peak");

        // Summary Details 
        this.summarytitle = new JLabel("Summary Details");

        // Summary Text Fields
        this.summeroffpeak = new JTextField("Summer Off-Peak");
        this.summermidpeak = new JTextField("Summer Mid-Peak");
        this.summerpeak = new JTextField("Summer Peak");
        this.nonsummeroffpeak = new JTextField("Winter Off-Peak");
        this.nonsummerpeak = new JTextField("Winter Peak");

        // Total Details
        this.totalusage = new JTextField("Total Usage");
        this.totalcost = new JTextField("Total Cost");
    }

    // Intializes Preferences for each Component 
    public void intializeComponentPreferences(){
        /* Component Preferences */ 
        // Usage Details 
        this.usagetotalday.setEditable(false);
        this.usagenonpeak.setEditable(false);
        this.usagemidpeak.setEditable(false);
        this.usagepeak.setEditable(false);

        this.costtotalday.setEditable(false);
        this.costnonpeak.setEditable(false);
        this.costmidpeak.setEditable(false);
        this.costpeak.setEditable(false);

        // Total 
        this.totalusage.setEditable(false);
        this.totalcost.setEditable(false);
    }

    // Initializes Constraints for GridBag Layout 
    public void intializeConstraints(){
        // Set insets for each element (Left, Right, Top, Bottom)
        setGridbagInsets(10,10,10,10);

        /* Component Constraints */

        // USAGE DETAILS
        // Navigation Elements 
        setButtonConstraints(this.navleftbutton, 0, 1);
        setButtonConstraints(this.navrightbutton, 5, 1);

        // Usage Details - Title 
        setLabelConstraints(this.usagetitle, 1, 0);
        setLabelConstraints(this.usagestarttimetitle, 1, 0);
        setTextFieldConstraints(this.usagestarttime, 1, 0);
        setLabelConstraints(this.usageendtimetitle, 1, 0);
        setTextFieldConstraints(this.usageendtime, 1, 0);

        // Usage Details - Usage - Labels
        setLabelConstraints(this.usagedetails[0], 1, 1);
        setLabelConstraints(this.usagedetails[1], 1, 2);
        setLabelConstraints(this.usagedetails[2], 1, 3);
        setLabelConstraints(this.usagedetails[3], 1, 4);

        // Usage Details - Usage - Data 
        setTextFieldConstraints(this.usagetotalday, 2, 1, DIMENSION_TEXTFIELD);
        setTextFieldConstraints(this.usagenonpeak, 2, 2, DIMENSION_TEXTFIELD);
        setTextFieldConstraints(this.usagemidpeak, 2, 3, DIMENSION_TEXTFIELD);
        setTextFieldConstraints(this.usagepeak, 2, 4, DIMENSION_TEXTFIELD);

        // Usage Details - Cost - Labels
        setLabelConstraints(this.usagedetails[4], 3, 1);
        setLabelConstraints(this.usagedetails[5], 3, 2);
        setLabelConstraints(this.usagedetails[6], 3, 3);
        setLabelConstraints(this.usagedetails[7], 3, 4);

        // Usage Details - Cost - Data 
        setTextFieldConstraints(this.costtotalday, 4, 1, DIMENSION_TEXTFIELD);
        setTextFieldConstraints(this.costnonpeak, 4, 2, DIMENSION_TEXTFIELD);
        setTextFieldConstraints(this.costmidpeak, 4, 3, DIMENSION_TEXTFIELD);
        setTextFieldConstraints(this.costpeak, 4, 4, DIMENSION_TEXTFIELD);
        
        //Blank space
        getGridbagConstraints().gridx = 0; 
        getGridbagConstraints().gridy = 5; 
        getPanel().add(new JLabel(""), getGridbagConstraints()); 

        // SUMMARY DETAILS
        // Summary Details - General Labels
        setLabelConstraints(this.summarydetails[2], 0, 8);
        setLabelConstraints(this.summarydetails[3], 0, 9);
        setLabelConstraints(this.summarydetails[4], 0, 10);

        // Summary Details - Title 
        setLabelConstraints(this.summarytitle, 1, 6);

        // Summary Details - Summer - Label
        setLabelConstraints(this.summarydetails[0], 1, 7);

        // Summary Details - Summer - Data
        setTextFieldConstraints(this.summeroffpeak, 1, 8, DIMENSION_TEXTFIELD);
        setTextFieldConstraints(this.summermidpeak, 1, 9, DIMENSION_TEXTFIELD);
        setTextFieldConstraints(this.summerpeak, 1, 10, DIMENSION_TEXTFIELD);

        // Summary Details - Non-Summer - Label 
        setLabelConstraints(this.summarydetails[1], 2, 7);

        // Summary Details - Non-Summer - Data
        setTextFieldConstraints(this.nonsummeroffpeak, 2, 8, DIMENSION_TEXTFIELD);
        setTextFieldConstraints(this.nonsummerpeak, 2, 10, DIMENSION_TEXTFIELD);

        // TOTAL DETAILS 
        // Total Details - General Labels 
        setLabelConstraints(this.totaldetails[0], 3, 8);
        setLabelConstraints(this.totaldetails[1], 3, 9);

        // Total Details - Data - Usage, Cost
        setTextFieldConstraints(this.totalusage, 4, 8, DIMENSION_TEXTFIELD);
        setTextFieldConstraints(this.totalcost, 4, 9, DIMENSION_TEXTFIELD);
        
    }

}