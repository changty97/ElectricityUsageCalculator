/* PACKAGE PATH */ 
package edu.csus.csc131.euc.View.Panels;

/* Local Imports */
import javax.swing.*; 
import java.awt.*; 

public class ViewCalculatePanel{

    /* Constants */
    private static final Color BACKGROUND_COLOR = Color.lightGray;
    private static final Dimension DIMENSION_TEXTFIELD = new Dimension(100, 25);
    
    /* Panel for this class */
    private JPanel panel = new JPanel(new GridBagLayout()); 

    /* Instance Variables */
    private JButton navrightbutton, navleftbutton;
    private JTextField usagetotalday, usagenonpeak, usagemidpeak, usagepeak,
        costtotalday, costnonpeak, costmidpeak, costpeak, totalusage, totalcost,
        summeroffpeak, summermidpeak, summerpeak, nonsummeroffpeak, nonsummerpeak, usagestarttime, usageendtime;

    // Labels
    JLabel summarytitle, usagetitle, usagestarttimetitle, usageendtimetitle; 

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
    public void setUsageStartTime(JTextField t) { this.usagestarttime = t; }
    public void setUsageEndTime(JTextField t) { this.usageendtime = t; }

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
    // Getters - Panel 
    public JPanel getPanel(){ return this.panel; }

    // Getters - Navigational Buttons 
    public JButton getNavigateRightButton() { return this.navrightbutton; }
    public JButton getNavigateLeftButton() { return this.navleftbutton; }

    // Getters - Usage Details - Usage 
    public JTextField getUsageDayTotal() { return this.usagetotalday; }
    public JTextField getUsageNonPeak() { return this.usagenonpeak; }
    public JTextField getUsageMidPeak() { return this.usagemidpeak; }
    public JTextField getUsagePeak() { return this.usagepeak; }
    public JTextField getUsageStartTime() { return this.usagestarttime; }
    public JTextField getUsageEndTime() { return this.usageendtime; }
    
    // Getters - Usage Details - Cost 
    public JTextField getCostDayTotal() { return this.costtotalday; }
    public JTextField getCostNonPeak() { return this.costnonpeak; }
    public JTextField getCostMidPeak() { return this.costmidpeak; }
    public JTextField getCostPeak() { return this.costpeak; }

    // Getters - Summary Details - Summer 
    public JTextField getSummerOffPeak() { return this.summeroffpeak; }
    public JTextField getSummerMidPeak() { return this.summermidpeak; }
    public JTextField getSummerPeak() { return this.summerpeak; }

    // Getters - Summary Details - Non-Summer
    public JTextField getNonSummerOffPeak() { return this.nonsummeroffpeak; }
    public JTextField getNonSummerPeak() { return this.nonsummerpeak; }

    // Getters - Total Details
    public JTextField getTotalUsage() { return this.totalusage; }
    public JTextField getTotalCost() { return this.totalcost; }

    /* Functions for ViewCalculate Panel*/ 

    // Initialize Panel 
    public void initializePanel(){
        /* Panel Initializations */ 
        panel = new JPanel(new GridBagLayout()); 
        // Set Background Color 
        this.panel.setBackground(BACKGROUND_COLOR);
    }

    // Intialize All Components 
    public void initializeComponents(){
        /* Instantiate all components of panel here */ 
        // Usage Details 
        this.usagetitle = new JLabel("Usage Details"); 
        this.usagestarttimetitle = new JLabel("Usage Start Time"); 
        this.usageendtimetitle = new JLabel("Usage End Time"); 

        // Usage Nav Buttons 
        this.navrightbutton = new JButton(">");
        this.navleftbutton = new JButton("<");

        // Usage Text Fields - Usage
        this.usagetotalday = new JTextField("Total Usage (day)");
        this.usagenonpeak = new JTextField("Usage Non-Peak");
        this.usagemidpeak = new JTextField("Usage Mid-Peak");
        this.usagepeak = new JTextField("Usage Peak");
        this.usagestarttime = new JTextField("Usage Start Time");
        this.usageendtime = new JTextField("Usage Start Time");

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
        this.usagetotalday.setPreferredSize(DIMENSION_TEXTFIELD); this.usagetotalday.setEditable(false);
        this.usagenonpeak.setPreferredSize(DIMENSION_TEXTFIELD); this.usagenonpeak.setEditable(false);
        this.usagemidpeak.setPreferredSize(DIMENSION_TEXTFIELD); this.usagemidpeak.setEditable(false);
        this.usagepeak.setPreferredSize(DIMENSION_TEXTFIELD); this.usagepeak.setEditable(false);
        this.usagestarttime.setPreferredSize(DIMENSION_TEXTFIELD); this.usagestarttime.setEditable(false);
        this.usageendtime.setPreferredSize(DIMENSION_TEXTFIELD); this.usageendtime.setEditable(false);

        this.costtotalday.setPreferredSize(DIMENSION_TEXTFIELD); this.costtotalday.setEditable(false);
        this.costnonpeak.setPreferredSize(DIMENSION_TEXTFIELD); this.costnonpeak.setEditable(false);
        this.costmidpeak.setPreferredSize(DIMENSION_TEXTFIELD); this.costmidpeak.setEditable(false);
        this.costpeak.setPreferredSize(DIMENSION_TEXTFIELD); this.costpeak.setEditable(false);

        // Summary Details 
        this.summeroffpeak.setPreferredSize(DIMENSION_TEXTFIELD);
        this.summermidpeak.setPreferredSize(DIMENSION_TEXTFIELD);
        this.summerpeak.setPreferredSize(DIMENSION_TEXTFIELD);
        this.nonsummeroffpeak.setPreferredSize(DIMENSION_TEXTFIELD);
        this.nonsummerpeak.setPreferredSize(DIMENSION_TEXTFIELD);

        // Total 
        this.totalusage.setPreferredSize(DIMENSION_TEXTFIELD); this.totalusage.setEditable(false);
        this.totalcost.setPreferredSize(DIMENSION_TEXTFIELD); this.totalcost.setEditable(false);
    }

    // Initializes Constraints for GridBag Layout 
    public void intializeConstraints(){
        /* Set Constraints for GridBagLayout for each component */ 
        GridBagConstraints c = new GridBagConstraints();

        // Set insets for each element (Left, Right, Top, Bottom)
        c.insets = new Insets(10,10,10,10);

        /* Component Constraints */

        // USAGE DETAILS
        // Navigation Elements 
        c.gridx = 0; c.gridy = 1; panel.add(this.navleftbutton, c);
        c.gridx = 5; c.gridy = 1; panel.add(this.navrightbutton, c);

        // Usage Details - Title 
        c.gridx = 1; c.gridy = 0; panel.add(this.usagetitle, c); 
        c.gridx = 2; c.gridy = 0; panel.add(this.usagestarttimetitle, c); 
        c.gridx = 3; c.gridy = 0; panel.add(this.usagestarttime, c); 
        c.gridx = 4; c.gridy = 0; panel.add(this.usageendtimetitle, c); 
        c.gridx = 5; c.gridy = 0; panel.add(this.usageendtime, c); 

        // Usage Details - Usage - Labels
        c.gridx = 1; c.gridy = 1; panel.add(this.usagedetails[0], c);
        c.gridx = 1; c.gridy = 2; panel.add(this.usagedetails[1], c);
        c.gridx = 1; c.gridy = 3; panel.add(this.usagedetails[2], c);
        c.gridx = 1; c.gridy = 4; panel.add(this.usagedetails[3], c);

        // Usage Details - Usage - Data 
        c.gridx = 2; c.gridy = 1; panel.add(this.usagetotalday, c);
        c.gridx = 2; c.gridy = 2; panel.add(this.usagenonpeak, c);
        c.gridx = 2; c.gridy = 3; panel.add(this.usagemidpeak, c);
        c.gridx = 2; c.gridy = 4; panel.add(this.usagepeak, c);

        // Usage Details - Cost - Labels
        c.gridx = 3; c.gridy = 1; panel.add(this.usagedetails[4], c);
        c.gridx = 3; c.gridy = 2; panel.add(this.usagedetails[5], c);
        c.gridx = 3; c.gridy = 3; panel.add(this.usagedetails[6], c);
        c.gridx = 3; c.gridy = 4; panel.add(this.usagedetails[7], c);

        // Usage Details - Cost - Data 
        c.gridx = 4; c.gridy = 1; panel.add(this.costtotalday, c);
        c.gridx = 4; c.gridy = 2; panel.add(this.costnonpeak, c);
        c.gridx = 4; c.gridy = 3; panel.add(this.costmidpeak, c);
        c.gridx = 4; c.gridy = 4; panel.add(this.costpeak, c);
        
        c.gridx = 0; c.gridy = 5; panel.add(new JLabel(""), c); //Blank space

        // SUMMARY DETAILS
        // Summary Details - General Labels
        c.gridx = 0; c.gridy = 8; panel.add(this.summarydetails[2], c);
        c.gridx = 0; c.gridy = 9; panel.add(this.summarydetails[3], c);
        c.gridx = 0; c.gridy = 10; panel.add(this.summarydetails[4], c);

        // Summary Details - Title 
        c.gridx = 1; c.gridy = 6; panel.add(this.summarytitle, c);

        // Summary Details - Summer - Label
        c.gridx = 1; c.gridy = 7; panel.add(this.summarydetails[0], c);

        // Summary Details - Summer - Data
        c.gridx = 1; c.gridy = 8; panel.add(this.summeroffpeak, c);
        c.gridx = 1; c.gridy = 9; panel.add(this.summermidpeak, c);
        c.gridx = 1; c.gridy = 10; panel.add(this.summerpeak, c);

        // Summary Details - Non-Summer - Label 
        c.gridx = 2; c.gridy = 7; panel.add(this.summarydetails[1], c);

        // Summary Details - Non-Summer - Data
        c.gridx = 2; c.gridy = 8; panel.add(this.nonsummeroffpeak, c);
        c.gridx = 2; c.gridy = 10; panel.add(this.nonsummerpeak, c);

        // TOTAL DETAILS 
        // Total Details - General Labels 
        c.gridx = 3; c.gridy = 8; panel.add(this.totaldetails[0], c);
        c.gridx = 3; c.gridy = 9; panel.add(this.totaldetails[1], c);

        // Total Details - Data - Usage, Cost
        c.gridx = 4; c.gridy = 8; panel.add(this.totalusage, c);
        c.gridx = 4; c.gridy = 9; panel.add(this.totalcost, c);
        
    }

}