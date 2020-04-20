/* PACKAGE PATH */
package edu.csus.csc131.euc.view.panels;

/*Library Imports*/
import javax.swing.*;
import java.awt.*;
import edu.csus.csc131.euc.view.panels.subpanels.*;

public class ViewCalculatePanel extends Panel {

    // Main Sub Panels
    JPanel usagedetailspanel, summarydetailspanel;

    // Sub Panels
    RoundedPanel seasondetailspanel, usagecostdetailspanel;
    JPanel totalusagepanel, totalcostpanel;

    /* Constants */
    private static final Dimension DIMENSION_TEXTFIELD = new Dimension(100, 25);

    // Main Sub Panels Size
    private final Dimension MAIN_SUB_PANEL_SIZE = new Dimension(1013, 393);

    // Sub Panels Size
    // Rounded
    private final Dimension SEASON_DETAIL_PANEL_SIZE = new Dimension(270, 73);
    private final Dimension USAGE_COST_DETAIL_PANEL_SIZE = new Dimension(870, 190);

    // JPanel
    private final Dimension TOTAL_USAGE_PANEL_SIZE = new Dimension(580,130);
    private final Dimension TOTAL_COST_PANEL_SIZE = new Dimension(580,130);

    // Titles
    private final Dimension USAGE_DETAIL_TITLE_SIZE = new Dimension(270,40);

    // Padding
    private static final Insets GLOBAL_PADDING = new Insets(10, 10, 10, 10);

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
        setBackgroundColor(Color.lightGray);
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

        // Initialize Main Sub Panels
        usagedetailspanel = new JPanel(new GridBagLayout());
        summarydetailspanel = new JPanel(new GridBagLayout());

        // Init Rounded Sub Panels
        seasondetailspanel = new RoundedPanel();
        usagecostdetailspanel = new RoundedPanel();

        // Init Sub Panels
        totalusagepanel = new JPanel();
        totalcostpanel = new JPanel();

        // Set Usage Main Sub Panel Size
        usagedetailspanel.setMinimumSize(MAIN_SUB_PANEL_SIZE);
        usagedetailspanel.setPreferredSize(MAIN_SUB_PANEL_SIZE);

        // Set Summary Detail Main Sub Panel Size
        summarydetailspanel.setMinimumSize(MAIN_SUB_PANEL_SIZE);
        summarydetailspanel.setPreferredSize(MAIN_SUB_PANEL_SIZE);

        // Set Season Detail Sub Panel Size
        seasondetailspanel.setMinimumSize(SEASON_DETAIL_PANEL_SIZE);
        seasondetailspanel.setPreferredSize(SEASON_DETAIL_PANEL_SIZE);

        // Set Usage Detail Sub Panel Size
        usagecostdetailspanel.setMinimumSize(USAGE_COST_DETAIL_PANEL_SIZE);
        usagecostdetailspanel.setPreferredSize(USAGE_COST_DETAIL_PANEL_SIZE);

        // Set Total Usage Sub Panel Size
        totalusagepanel.setMinimumSize(TOTAL_USAGE_PANEL_SIZE);
        totalusagepanel.setPreferredSize(TOTAL_USAGE_PANEL_SIZE);

        // Set Total Cost Sub Panel Size
        totalcostpanel.setMinimumSize(TOTAL_COST_PANEL_SIZE);
        totalcostpanel.setPreferredSize(TOTAL_COST_PANEL_SIZE);

        // TITLE Sizes
        usagetitle.setPreferredSize(USAGE_DETAIL_TITLE_SIZE);

        // Usage Details
        this.usagetotalday.setPreferredSize(DIMENSION_TEXTFIELD); this.usagetotalday.setEditable(false);
        this.usagenonpeak.setPreferredSize(DIMENSION_TEXTFIELD); this.usagenonpeak.setEditable(false);
        this.usagemidpeak.setPreferredSize(DIMENSION_TEXTFIELD); this.usagemidpeak.setEditable(false);
        this.usagepeak.setPreferredSize(DIMENSION_TEXTFIELD); this.usagepeak.setEditable(false);
        this.usagestarttime.setPreferredSize(DIMENSION_TEXTFIELD); this.usagestarttime.setEditable(false);
        this.usageendtime.setPreferredSize(DIMENSION_TEXTFIELD); this.usageendtime.setEditable(false);

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
        /* Main Sub Panel Constraints */
        // Usage Details
        usagedetailspanel.setBackground(new Color(13, 156, 204));

        // GridBagConstraints c = new GridBagConstraints();
        // c.weightx = c.weighty = 1.0;
        // c.gridx = 0;
        // c.gridy = 0;
        // c.anchor = GridBagConstraints.NORTH;
        // getPanel().add(usagedetailspanel, c);

        // // Summary Detail
        // summarydetailspanel.setBackground(Color.WHITE);

        // c = new GridBagConstraints();
        // c.weightx = c.weighty = 1.0;
        // c.gridx = 0;
        // c.gridy = 1;
        // c.anchor = GridBagConstraints.SOUTH;
        // getPanel().add(summarydetailspanel, c);

        // /* Main Sub Panel Elements  */
        // // Usage Detail
        // // Main Sub Panel Title
        // usagetitle.setForeground(Color.WHITE);
        // usagetitle.setFont(new Font("Poppins", Font.BOLD, 30));

        // c = new GridBagConstraints();
        // c.weightx = c.weighty = 1.0;
        // c.gridwidth = 2;
        // c.gridx = 0;
        // c.gridy = 0;
        // c.insets = new Insets(15,0,0,160);
        // usagedetailspanel.add(usagetitle, c);

        // //Season Details Sub Panel
        // c = new GridBagConstraints();
        // c.weightx = c.weighty = 1.0;
        // c.anchor = GridBagConstraints.EAST;
        // c.gridwidth = 1;
        // c.gridx = 2;
        // c.gridy = 0;
        // c.insets = new Insets(0,0,0,0);
        // usagedetailspanel.add(seasondetailspanel, c);


        // //Usage Cost Details Sub Panel
        // c = new GridBagConstraints();
        // c.weightx = c.weighty = 1.0;
        // c.anchor = GridBagConstraints.WEST;
        // c.gridwidth = 2;
        // c.gridx = 1;
        // c.gridy = 1;
        // c.insets = new Insets(0,70,0,50);
        // usagedetailspanel.add(usagecostdetailspanel, c);

        /* Component Constraints */

        // USAGE DETAILS
        // Navigation Elements
        setButtonConstraints(this.navleftbutton, 0, 1, null, GLOBAL_PADDING);
        setButtonConstraints(this.navrightbutton, 5, 1, null, GLOBAL_PADDING);

        // Usage Details - Title
        setLabelConstraints(this.usagetitle, 1, 0, null, GLOBAL_PADDING);
        setLabelConstraints(this.usagestarttimetitle, 2, 0, null, GLOBAL_PADDING);
        setTextFieldConstraints(this.usagestarttime, 3, 0, null, GLOBAL_PADDING);
        setLabelConstraints(this.usageendtimetitle, 4, 0, null, GLOBAL_PADDING);
        setTextFieldConstraints(this.usageendtime, 5, 0, null, GLOBAL_PADDING);

        // Usage Details - Usage - Labels
        setLabelConstraints(this.usagedetails[0], 1, 1, null, GLOBAL_PADDING);
        setLabelConstraints(this.usagedetails[1], 1, 2, null, GLOBAL_PADDING);
        setLabelConstraints(this.usagedetails[2], 1, 3, null, GLOBAL_PADDING);
        setLabelConstraints(this.usagedetails[3], 1, 4, null, GLOBAL_PADDING);

        // Usage Details - Usage - Data
        setTextFieldConstraints(this.usagetotalday, 2, 1, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.usagenonpeak, 2, 2, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.usagemidpeak, 2, 3, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.usagepeak, 2, 4, DIMENSION_TEXTFIELD, GLOBAL_PADDING);

        // Usage Details - Cost - Labels
        setLabelConstraints(this.usagedetails[4], 3, 1, null, GLOBAL_PADDING);
        setLabelConstraints(this.usagedetails[5], 3, 2, null, GLOBAL_PADDING);
        setLabelConstraints(this.usagedetails[6], 3, 3, null, GLOBAL_PADDING);
        setLabelConstraints(this.usagedetails[7], 3, 4, null, GLOBAL_PADDING);

        // Usage Details - Cost - Data
        setTextFieldConstraints(this.costtotalday, 4, 1, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.costnonpeak, 4, 2, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.costmidpeak, 4, 3, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.costpeak, 4, 4, DIMENSION_TEXTFIELD, GLOBAL_PADDING);

        //Blank space
        getGridbagConstraints().gridx = 0;
        getGridbagConstraints().gridy = 5;
        getPanel().add(new JLabel(""), getGridbagConstraints());

        // SUMMARY DETAILS
        // Summary Details - General Labels
        setLabelConstraints(this.summarydetails[2], 0, 8, null, GLOBAL_PADDING);
        setLabelConstraints(this.summarydetails[3], 0, 9, null, GLOBAL_PADDING);
        setLabelConstraints(this.summarydetails[4], 0, 10, null, GLOBAL_PADDING);

        // Summary Details - Title
        setLabelConstraints(this.summarytitle, 1, 6, null, GLOBAL_PADDING);

        // Summary Details - Summer - Label
        setLabelConstraints(this.summarydetails[0], 1, 7, null, GLOBAL_PADDING);

        // Summary Details - Summer - Data
        setTextFieldConstraints(this.summeroffpeak, 1, 8, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.summermidpeak, 1, 9, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.summerpeak, 1, 10, DIMENSION_TEXTFIELD, GLOBAL_PADDING);

        // Summary Details - Non-Summer - Label
        setLabelConstraints(this.summarydetails[1], 2, 7, null, GLOBAL_PADDING);

        // Summary Details - Non-Summer - Data
        setTextFieldConstraints(this.nonsummeroffpeak, 2, 8, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.nonsummerpeak, 2, 10, DIMENSION_TEXTFIELD, GLOBAL_PADDING);

        // TOTAL DETAILS
        // Total Details - General Labels
        setLabelConstraints(this.totaldetails[0], 3, 8, null, GLOBAL_PADDING);
        setLabelConstraints(this.totaldetails[1], 3, 9, null, GLOBAL_PADDING);

        // Total Details - Data - Usage, Cost
        setTextFieldConstraints(this.totalusage, 4, 8, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.totalcost, 4, 9, DIMENSION_TEXTFIELD, GLOBAL_PADDING);

    }


}
