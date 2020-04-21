/* PACKAGE PATH */
package edu.csus.csc131.euc.view.panels;

/*Library Imports*/
import javax.swing.*;
import java.awt.*;
import edu.csus.csc131.euc.view.panels.subpanels.*;

public class ViewCalculatePanel extends Panel {

<<<<<<< HEAD
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
=======
    /* Constants */
    // Main Sub Panels Size 
    private final Dimension USAGE_DETAILS_SUB_PANEL_SIZE = new Dimension(1013, 393);  
    private final Dimension SUMMARY_DETAILS_SUB_PANEL_SIZE = new Dimension(1013, 393);  

    // Sub Panels Size 
    // Rounded 
    private final Dimension SEASON_DETAIL_PANEL_SIZE = new Dimension(230, 73); 
    private final Dimension USAGE_COST_DETAIL_PANEL_SIZE = new Dimension(870, 190); 

    // JPanel 
    private final Dimension TOTAL_USAGE_PANEL_SIZE = new Dimension(450,100); 
    private final Dimension TOTAL_COST_PANEL_SIZE = new Dimension(450,100); 
>>>>>>> 19aa706a9f6ba03a5913c3100597850ec02dd68c

    // Titles
    private final Dimension USAGE_DETAIL_TITLE_SIZE = new Dimension(270,40);

<<<<<<< HEAD
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
=======
    // Padding 
    private static final Insets GLOBAL_PADDING = new Insets(10, 10, 10, 10);
    
    // Cost Usage Sub-Panels Constants
    private final Dimension PANEL_1_SIZE = new Dimension((int) USAGE_COST_DETAIL_PANEL_SIZE.getWidth()/5 , (int) USAGE_COST_DETAIL_PANEL_SIZE.getHeight());
    private final Dimension PANEL_2_SIZE = new Dimension((int) USAGE_COST_DETAIL_PANEL_SIZE.getWidth()/5 * 3 , (int) USAGE_COST_DETAIL_PANEL_SIZE.getHeight());
    private final Dimension PANEL_3_SIZE = new Dimension((int) USAGE_COST_DETAIL_PANEL_SIZE.getWidth()/5 , (int) USAGE_COST_DETAIL_PANEL_SIZE.getHeight());

    /* INSTANCE VARIABLES */

    /* Main Sub Panels */
    private JPanel usagedetailspanel, summarydetailspanel; 

    /* Usage Details: Main Sub Panel Components */
    // Labels 
    private JLabel usagetitle; 
    // Usage Details: Sub Panels
    private RoundedPanel seasondetailspanel, usagecostdetailspanel;
    
    /* Usage Details: Sub Panel Components */
    // Season Details Comps & Navigation Comps
    private JLabel seasondetailtitle, seasonicon, seasondetailsdate, navrightbutton, navleftbutton;

    // Usage Cost Comps
    // Labels for Start & End Time 
    private JTextField usagestarttime, usageendtime;
    // 1st Column: Usage (Labels)
    private JLabel usagecosttotalusagelbl = new JLabel("Total: ");
    private JLabel usagecostnonpeakusagelbl = new JLabel("Non-Peak: ");
    private JLabel usagecostmidpeakusagelbl = new JLabel("Non-Peak: ");
    private JLabel usagecostpeakusagelbl = new JLabel("Peak: ");
    // 1st Column: Usage (Values)
    private JLabel usagecosttotalusage = new JLabel("24.383 kWH"); 
    private JLabel usagecostnonpeakusage = new JLabel("12.192 kWH"); 
    private JLabel usagecostmidpeakusage = new JLabel("9.143 kWH"); 
    private JLabel usagecostpeakusage = new JLabel("3.048 kWH"); 
    // 2nd Column: Usage (Labels)
    private JLabel usagecosttotalcostlbl = new JLabel("Total Cost: ");
    private JLabel usagecostnonpeakcostlbl = new JLabel("Cost Non-Peak: ");
    private JLabel usagecostmidpeakcostlbl = new JLabel(" Cost Non-Peak: ");
    private JLabel usagecostpeakcostlbl = new JLabel("Cost Peak: ");
    // 2nd Column: Usage (Values)
    private JLabel usagecosttotalcost = new JLabel("$3.89"); 
    private JLabel usagecostnonpeakcost = new JLabel("$1.47"); 
    private JLabel usagecostmidpeakcost = new JLabel("$1.53");  
    private JLabel usagecostpeakcost = new JLabel("$0.89"); 

    /* Summary Details: Main Sub Panel Components */
    // Title Label 
    private JLabel summarytitle;
    // Sub-Title Labels 
    private JLabel seasonsummarytitle = new JLabel("Summer"); // Can be Summer or Non-Summer 
    private JLabel offpeaktitle = new JLabel("Off-Peak"); 
    private JLabel midpeaktitle = new JLabel("Mid-Peak"); 
    private JLabel peaktitle = new JLabel("Peak"); 

    // Rate and Period Labels
    private JLabel [] ratelbls = { new JLabel("Rate: ") , new JLabel("Rate: "), new JLabel("Rate: "), new JLabel("Rate: "), new JLabel("Rate: ") };
    private JLabel [] periodlbls = { new JLabel("Period: ") , new JLabel("Period: "), new JLabel("Period: "), new JLabel("Period: "), new JLabel("Period: ") };

    // Buttons for Summary Details 
    private JButton seasontoggle = new JButton("Summer/Non-Summer"); 
    private JButton resetdefault = new JButton("Reset Default Values"); 
    private JButton submituservaluesbutton = new JButton("Submit Values"); 

    // Values - Summer
    private JTextField summeroffpeakrate = new JTextField("$0.1209 / kWH"); 
    private JTextField summeroffpeakperiod = new JTextField("Midnight - Noon");
    private JTextField summermidpeakrate = new JTextField("$0.1671 / kWH");
    private JTextField summermidpeakperiod = new JTextField("Noon - 5pm"); 
    private JTextField summerpeakrate = new JTextField("$0.2941 / kWH"); 
    private JTextField summerpeakperiod = new JTextField("5PM - 8PM");

    // Values - Non-summer
    private JTextField nonsummeroffpeakrate = new JTextField("$0.1388 / kWH"); 
    private JTextField nonsummeroffpeakperiod = new JTextField("5PM - 8PM");
    private JTextField nonsummerpeakrate = new JTextField("$0.1006 / kWH"); 
    private JTextField nonsummerpeakperiod = new JTextField("Midnight - 5PM , 5PM - 8PM");

    // Summary Details: Section Panels 
    private JPanel summarydetailwestgrouppanels = new JPanel( new CardLayout() ); 
    private JPanel summarydetailwestpanelsummer = new JPanel( new GridBagLayout() );
    private JPanel summarydetailwestpanelnonsummer = new JPanel( new GridBagLayout() );
    private JPanel summarydetaileastpanel = new JPanel( new GridBagLayout() ); 

    // Summary Details: Sub-Panels
    private RoundedPanel totalusagepanel, totalcostpanel;
    
    /* Summary Details: Sub Panel Components */
    // Total Usage Panel Comps
    // Label
    JLabel totalusagepaneltitle = new JLabel("Total Usage"); 
    // Value
    private JLabel totalusage;

    // Total Cost Panel Comps
    // Label
    JLabel totalcostpaneltitle = new JLabel("Total Cost"); 
    // Value
    private JLabel totalcost;

>>>>>>> 19aa706a9f6ba03a5913c3100597850ec02dd68c

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
<<<<<<< HEAD
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
=======
    // Setters - Season Detail Panel  
    public void setSeasonDetailTitle(JLabel t) { this.seasondetailtitle = t; }
    public void setSeasonDetailDate(JLabel t) { this.seasondetailsdate = t; }

    // Setters - Usage Details - Start & End 
    public void setUsageStartTime(JTextField t) { this.usagestarttime = t; }
    public void setUsageEndTime(JTextField t) { this.usageendtime = t; }

    // Setters - Usage Details - Usage 
    public void setUsageDayTotal(JLabel t) { this.usagecosttotalusage = t; }
    public void setUsageNonPeak(JLabel t) { this.usagecostnonpeakusage = t; }
    public void setUsageMidPeak(JLabel t) { this.usagecostmidpeakusage = t; }
    public void setUsagePeak(JLabel t) { this.usagecostpeakusage = t; }

    // Setters - Usage Details - Cost 
    public void setCostDayTotal(JLabel t) { this.usagecosttotalcost = t; }
    public void setCostNonPeak(JLabel t) { this.usagecostnonpeakcost = t; }
    public void setCostMidPeak(JLabel t) { this.usagecostmidpeakcost = t; }
    public void setCostPeak(JLabel t) { this.usagecostpeakcost = t; }

    // Setters - Summary Details - Summer 
    public void setSummerOffPeakRate(JTextField t) { this.summeroffpeakrate = t; }
    public void setSummerOffPeakPeriod(JTextField t) { this.summeroffpeakrate = t; }
    public void setSummerMidPeakRate(JTextField t) { this.summermidpeakrate = t; }
    public void setSummerMidPeakPeriod(JTextField t) { this.summermidpeakperiod = t; }
    public void setSummerPeakRate(JTextField t) { this.summerpeakrate = t; }
    public void setSummerPeakPeriod(JTextField t) { this.summerpeakperiod = t; }
>>>>>>> 19aa706a9f6ba03a5913c3100597850ec02dd68c

    // Setters - Summary Details - Non-Summer
    public void setNonSummerOffPeakRate(JTextField t) { this.nonsummeroffpeakrate = t; }
    public void setNonSummerOffPeakPeriod(JTextField t) { this.nonsummeroffpeakperiod = t; }
    public void setNonSummerPeakRate(JTextField t) { this.nonsummerpeakrate = t; }
    public void setNonSummerPeakPeriod(JTextField t) { this.nonsummerpeakperiod = t; }

    // Setters - Total Details
    public void setTotalUsage(JLabel t) { this.totalusage = t; }
    public void setTotalCost(JLabel t) { this.totalcost = t; }

    /* Getters */

<<<<<<< HEAD
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
=======
    // Getters - Season Detail Panel
    public JLabel getSeasonDetailTitle() { return this.seasondetailtitle; }
    public JLabel getSeasonDetailDate() { return this.seasondetailsdate; }

    // Getters - Navigational Buttons 
    public JLabel getNavigateRightButton() { return this.navrightbutton; }
    public JLabel getNavigateLeftButton() { return this.navleftbutton; }

    // Getters - Start & End 
    public JTextField getUsageStartTime() { return this.usagestarttime; }
    public JTextField getUsageEndTime() { return this.usageendtime; }

    // Getters - Usage Details - Usage 
    public JLabel getUsageDayTotal() { return this.usagecosttotalusage; }
    public JLabel getUsageNonPeak() { return this.usagecostnonpeakusage; }
    public JLabel getUsageMidPeak() { return this.usagecostmidpeakusage; }
    public JLabel getUsagePeak() { return this.usagecostpeakusage; }

    
    // Getters - Usage Details - Cost 
    public JLabel getCostDayTotal() { return this.usagecosttotalcost; }
    public JLabel getCostNonPeak() { return this.usagecostnonpeakcost; }
    public JLabel getCostMidPeak() { return this.usagecostmidpeakcost; }
    public JLabel getCostPeak() { return this.usagecostpeakcost; }

    // Getters - Summary Details - Summer 
    public JTextField getSummerOffPeakRate(JTextField t) { return this.summeroffpeakrate; }
    public JTextField getSummerOffPeakPeriod(JTextField t) { return this.summeroffpeakrate; }
    public JTextField getSummerMidPeakRate(JTextField t) { return this.summermidpeakrate; }
    public JTextField getSummerMidPeakPeriod(JTextField t) { return this.summermidpeakperiod; }
    public JTextField getSummerPeakRate(JTextField t) { return this.summerpeakrate; }
    public JTextField getSummerPeakPeriod(JTextField t) { return this.summerpeakperiod; }
>>>>>>> 19aa706a9f6ba03a5913c3100597850ec02dd68c

    // Getters - Summary Details - Non-Summer
    public JTextField getNonSummerOffPeakRate(JTextField t) { return this.nonsummeroffpeakrate; }
    public JTextField getNonSummerOffPeakPeriod(JTextField t) { return this.nonsummeroffpeakperiod; }
    public JTextField getNonSummerPeakRate(JTextField t) { return this.nonsummerpeakrate; }
    public JTextField getNonSummerPeakPeriod(JTextField t) { return this.nonsummerpeakperiod; }

    // Getters - Total Details
    public JLabel getTotalUsage() { return this.totalusage; }
    public JLabel getTotalCost() { return this.totalcost; }

    /* Functions for ViewCalculate Panel*/

    // Intialize All Components
    public void initializeComponents(){
<<<<<<< HEAD
        /* Instantiate all components of panel here */
        // Usage Details
        this.usagetitle = new JLabel("Usage Details");
        this.usagestarttimetitle = new JLabel("Usage Start Time");
        this.usageendtimetitle = new JLabel("Usage End Time");

        // Usage Nav Buttons
        this.navrightbutton = new JButton(">");
        this.navleftbutton = new JButton("<");
=======
        // Initialize Main Sub Panels 
        this.usagedetailspanel = new JPanel(new GridBagLayout()); 
        this.summarydetailspanel = new JPanel(new GridBagLayout()); 

        // Initalize Sub Panels 
        this.seasondetailspanel = new RoundedPanel(); 
        this.usagecostdetailspanel = new RoundedPanel(); 
        this.totalusagepanel = new RoundedPanel();
        this.totalcostpanel = new RoundedPanel();

        /* Instantiate all components of panel here */ 
        // Season Detail Panel Elements 
        this.seasondetailtitle = new JLabel("Summer"); 
        this.seasonicon = new JLabel( new ImageIcon("src\\main\\assets\\viewandcalculateres\\summericon.png"));
        this.seasondetailsdate = new JLabel("June 1 - September 30"); 

        // Usage Details 
        this.usagetitle = new JLabel("Usage Details"); 
        this.usagestarttime = new JTextField("Usage Start Time"); 
        this.usageendtime = new JTextField("Usage End Time"); 

        // Usage Nav Buttons 
        this.navrightbutton = new JLabel( new ImageIcon("src\\main\\assets\\viewandcalculateres\\nextdaybutton.png"));
        this.navleftbutton = new JLabel( new ImageIcon("src\\main\\assets\\viewandcalculateres\\previousdaybutton.png"));
>>>>>>> 19aa706a9f6ba03a5913c3100597850ec02dd68c

        // Usage Text Fields - Usage
        this.usagestarttime = new JTextField("Usage Start Time");
        this.usageendtime = new JTextField("Usage Start Time");

<<<<<<< HEAD
        // Usage Text Fields - Cost
        this.costtotalday = new JTextField("Total Cost (day)");
        this.costnonpeak = new JTextField("Cost Non-Peak");
        this.costmidpeak = new JTextField("Cost Mid-Peak");
        this.costpeak = new JTextField("Cost Peak");

        // Summary Details
=======
        // Summary Details 
>>>>>>> 19aa706a9f6ba03a5913c3100597850ec02dd68c
        this.summarytitle = new JLabel("Summary Details");

        // Total Details
<<<<<<< HEAD
        this.totalusage = new JTextField("Total Usage");
        this.totalcost = new JTextField("Total Cost");


=======
        this.totalusage = new JLabel("<html>58.73 <font size=5>kWH</font></html>");
        this.totalcost = new JLabel("$ 21.94");
>>>>>>> 19aa706a9f6ba03a5913c3100597850ec02dd68c
    }

    // Intializes Preferences for each Component
    public void intializeComponentPreferences(){
<<<<<<< HEAD
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
=======
        /* Component Preferences */ 
        // Set Usage Main Sub Panel Size
        usagedetailspanel.setMinimumSize(USAGE_DETAILS_SUB_PANEL_SIZE); 
        usagedetailspanel.setPreferredSize(USAGE_DETAILS_SUB_PANEL_SIZE);

        // Set Summary Detail Main Sub Panel Size
        summarydetailspanel.setMinimumSize(SUMMARY_DETAILS_SUB_PANEL_SIZE); 
        summarydetailspanel.setPreferredSize(SUMMARY_DETAILS_SUB_PANEL_SIZE);
>>>>>>> 19aa706a9f6ba03a5913c3100597850ec02dd68c

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

<<<<<<< HEAD
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
=======
>>>>>>> 19aa706a9f6ba03a5913c3100597850ec02dd68c
    }

    // Initializes Constraints for GridBag Layout
    public void intializeConstraints(){
<<<<<<< HEAD
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

=======
        /* MAIN SUB PANEL CONSTRAINTS */

        // Usage Details Main Sub Panel 
        // Regular Attributes
        usagedetailspanel.setBackground(new Color(13, 156, 204));
        // Grid Bag Attributes 
        GridBagConstraints c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0; 
        c.gridx = 0; 
        c.gridy = 0; 
        c.anchor = GridBagConstraints.NORTH; 
        getPanel().add(usagedetailspanel, c);

        // Summary Detail Main Sub Panel 
        // Regular Attributes
        summarydetailspanel.setBackground(Color.WHITE);
        // Grid Bag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0; 
        c.gridx = 0; 
        c.gridy = 1;
        c.ipadx = c.ipady = 50; 
        c.anchor = GridBagConstraints.SOUTH; 
        getPanel().add(summarydetailspanel, c);

        /* MAIN SUB PANEL COMPONENTS  */

        /* Usage Details Main Sub Panel */
        // Main Sub Panel Title 
        // Regular Attributes
        usagetitle.setForeground(Color.WHITE);
        usagetitle.setFont(new Font("Poppins", Font.BOLD, 30)); 
        // Grid Bag Attributes
        c = new GridBagConstraints();
        c.weightx = c.weighty = 1.0;
        c.gridwidth = 2; 
        c.gridx = 0; 
        c.gridy = 0; 
        c.insets = new Insets(50,0,0,230); 
        usagedetailspanel.add(usagetitle, c);

        // Season Details Sub Panel
        // Regular Attributes
        // Grid Bag Attributes
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0; 
        c.anchor = GridBagConstraints.EAST; 
        c.gridwidth = 1; 
        c.gridx = 2; 
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0); 
        usagedetailspanel.add(seasondetailspanel, c);

        // Usage Cost Details Sub Panel
        // Regular Attributes
        // Grid Bag Attributes
        // Label Attributes
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.anchor = GridBagConstraints.WEST; 
        c.gridwidth = 2; 
        c.gridx = 1; 
        c.gridy = 1;
        c.insets = new Insets(0,70,20,50);
        usagedetailspanel.add(usagecostdetailspanel, c);
        

        JPanel usagecostleft = new JPanel(new GridBagLayout());
        usagecostleft.setMinimumSize(PANEL_1_SIZE);
        usagecostleft.setSize(PANEL_1_SIZE);
        usagecostleft.setPreferredSize(PANEL_1_SIZE);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.WEST;
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 0;
        usagecostdetailspanel.add(usagecostleft);

        JPanel usagecostcenter = new JPanel(new GridBagLayout());
        usagecostcenter.setMinimumSize(PANEL_2_SIZE);
        usagecostcenter.setSize(PANEL_2_SIZE);
        usagecostcenter.setPreferredSize(PANEL_2_SIZE);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 0;
        usagecostdetailspanel.add(usagecostcenter);

        JPanel usagecostright = new JPanel(new GridBagLayout());
        usagecostright.setMinimumSize(PANEL_3_SIZE);
        usagecostright.setSize(PANEL_3_SIZE);
        usagecostright.setPreferredSize(PANEL_3_SIZE);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 0;
        usagecostdetailspanel.add(usagecostright);

        // Navigation Attributes
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.WEST;
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        usagecostleft.add(navleftbutton, c);
    
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.EAST;
        c.weightx = 1.0;
        c.weighty = 4.0;
        c.gridx = 6; 
        c.gridy = 2;
        c.insets = new Insets(0,0,0,0);
        usagecostright.add(navrightbutton, c);

        // Panel Details
        //Labels
        //total lbl
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        usagecosttotalusagelbl.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecosttotalusagelbl, c);

        //non-peak lbl
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        usagecostnonpeakusagelbl.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostnonpeakusagelbl, c);
       
        //mid-peak lbl
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 2;
        c.insets = new Insets(0,0,0,0);
        usagecostmidpeakusagelbl.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostmidpeakusagelbl, c);
       
        //peak lbl
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 3;
        c.insets = new Insets(0,0,0,0);
        usagecostpeakusagelbl.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostpeakusagelbl, c);

        //total cost lbl
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 2; 
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        usagecosttotalcostlbl.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecosttotalcostlbl, c);

        // non cost lbl
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 2; 
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        usagecostnonpeakcostlbl.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostnonpeakcostlbl, c);

        // mid cost lbl
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 2; 
        c.gridy = 2;
        c.insets = new Insets(0,0,0,0);
        usagecostmidpeakcostlbl.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostmidpeakcostlbl, c);

        //  peak cost lbl
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 2; 
        c.gridy = 3;
        c.insets = new Insets(0,0,0,0);
        usagecostpeakcostlbl.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostpeakcostlbl, c);    

       
        // Usage (Values)
        // total usage
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 1; 
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        usagecosttotalusage.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecosttotalusage, c);
       
        // non usage
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 1; 
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        usagecostnonpeakusage.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostnonpeakusage, c);
       
        // mid usage
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 1; 
        c.gridy = 2;
        c.insets = new Insets(0,0,0,0);
        usagecostmidpeakusage.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostmidpeakusage, c);
       
        // peak usage
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 1; 
        c.gridy = 3;
        c.insets = new Insets(0,0,0,0);
        usagecostpeakusage.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostpeakusage, c);
       
       // total cost usage
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 3; 
        c.gridy = 0;
        c.insets = new Insets(0,0,0,0);
        usagecosttotalcost.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecosttotalcost, c);
       
        // total cost usage
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 3; 
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        usagecostnonpeakcost.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostnonpeakcost, c);
       
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 3; 
        c.gridy = 2;
        c.insets = new Insets(0,0,0,0);
        usagecostmidpeakcost.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostmidpeakcost, c);
       
        c.weightx = c.weighty = 1.0;
        c.gridx = 3; 
        c.gridy = 3;
        c.insets = new Insets(0,0,0,0);
        usagecostpeakcost.setFont(new Font("Poppins", Font.BOLD, 20));
        usagecostcenter.add(usagecostpeakcost, c);

        /* Summary Details Main Sub Panel */
        //  Summary West Panel
        // Regular Attributes
        summarydetailwestgrouppanels.setBackground(Color.WHITE);
        summarydetailwestpanelsummer.setBackground(Color.WHITE);
        summarydetailwestpanelnonsummer.setBackground(Color.WHITE);
        summarydetailwestgrouppanels.add(summarydetailwestpanelsummer, "summer"); 
        summarydetailwestgrouppanels.add(summarydetailwestpanelnonsummer, "nonsummer");

        // GridBag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.anchor = GridBagConstraints.WEST; 
        c.gridx = 0; 
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        c.fill = GridBagConstraints.VERTICAL;
        summarydetailspanel.add(summarydetailwestgrouppanels, c); 

        // Summary East Panel
        // Regular Attributes
        summarydetaileastpanel.setBackground(Color.WHITE);
        // GridBag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1; 
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        c.fill = GridBagConstraints.VERTICAL;
        summarydetailspanel.add(summarydetaileastpanel, c); 
    
        // Summary Details Panel Title
        // Regular Attributes
        summarytitle.setFont(new Font("Poppins", Font.BOLD, 30));
        // GridBag Attributes 
        c = new GridBagConstraints();
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 0;
        c.insets = new Insets(0,70,0,0);
        c.anchor = GridBagConstraints.WEST; 
        summarydetailspanel.add(summarytitle, c); 
 
        // Off Peak Label
        // Regular Attributes
        offpeaktitle.setFont(new Font("Poppins", Font.BOLD, 20));
        // GridBag Attributes
        c = new GridBagConstraints();
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 1;
        c.insets = new Insets(0,65,0,0);
        summarydetailwestpanelsummer.add(offpeaktitle, c);

        // Off Peak Rate Label 
        // Regular Attributes
        ratelbls[0].setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c = new GridBagConstraints();
        c.weightx = c.weighty = 1.0;
        c.gridx = 1; 
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.EAST;
        summarydetailwestpanelsummer.add(ratelbls[0], c); 

        // Off Peak Rate  
        // Regular Attributes
        summeroffpeakrate.setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c = new GridBagConstraints();
        c.weightx = c.weighty = 1.0;
        c.gridx = 2; 
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.WEST;
        summarydetailwestpanelsummer.add(summeroffpeakrate, c); 

        // Off Peak Period Label
        // Regular Attributes
        periodlbls[0].setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 1; 
        c.gridy = 2;
        c.insets = new Insets(0,75,0,0);
        c.anchor = GridBagConstraints.EAST; 
        summarydetailwestpanelsummer.add(periodlbls[0], c); 
        
        // Off Peak Period
        // Regular Attributes
        summeroffpeakperiod.setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 2; 
        c.gridy = 2;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.WEST; 
        summarydetailwestpanelsummer.add(summeroffpeakperiod, c);

        // Mid-peak Label 
        // Regular Attributes
        midpeaktitle.setFont(new Font("Poppins", Font.BOLD, 20));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 3;
        c.insets = new Insets(0,65,0,0);
        summarydetailwestpanelsummer.add(midpeaktitle, c);

        // Mid-peak Rate Label
        ratelbls[1].setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 1; 
        c.gridy = 3;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.EAST; 
        summarydetailwestpanelsummer.add(ratelbls[1], c); 

        // Mid-peak Rate
        summermidpeakperiod.setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 2; 
        c.gridy = 3;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.WEST; 
        summarydetailwestpanelsummer.add(summermidpeakrate, c);

        // Mid-peak Period Label
        periodlbls[1].setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 1; 
        c.gridy = 4;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.EAST; 
        summarydetailwestpanelsummer.add(periodlbls[1], c); 

        // Mid-peak Period
        summermidpeakrate.setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 2; 
        c.gridy = 4;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.WEST; 
        summarydetailwestpanelsummer.add(summermidpeakperiod, c); 

        // Peak Label
        peaktitle.setFont(new Font("Poppins", Font.BOLD, 20));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 5;
        c.insets = new Insets(0,100,0,0);
        summarydetailwestpanelsummer.add(peaktitle, c);

        // Peak Rate Label
        ratelbls[2].setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 1; 
        c.gridy = 5;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.EAST; 
        summarydetailwestpanelsummer.add(ratelbls[2], c); 

        // Peak Rate
        summerpeakrate.setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 2; 
        c.gridy = 5;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.WEST; 
        summarydetailwestpanelsummer.add(summerpeakrate, c); 

        // Peak Period label
        periodlbls[2].setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 1; 
        c.gridy = 6;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.EAST; 
        summarydetailwestpanelsummer.add(periodlbls[2], c);  

        // Peak Period
        summerpeakperiod.setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 2; 
        c.gridy = 6;
        c.insets = new Insets(0,0,0,0);
        c.anchor = GridBagConstraints.WEST; 
        summarydetailwestpanelsummer.add(summerpeakperiod, c);

        // Season Toggle Button
        // Regular Attributes
        seasontoggle.setFont(new Font("Poppins", Font.BOLD, 20));
        seasontoggle.setForeground(Color.WHITE);
        seasontoggle.setBackground(new Color(2, 29, 62));
        seasontoggle.setBorderPainted(false);
        seasontoggle.setFocusPainted(false);
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 2;
        c.insets = new Insets(25,0,0,0);
        c.anchor = GridBagConstraints.WEST; 
        summarydetaileastpanel.add(seasontoggle, c);

        // Reset Default Button
        // Regular Attributes
        resetdefault.setFont(new Font("Poppins", Font.BOLD, 20));
        resetdefault.setForeground(Color.WHITE);
        resetdefault.setBackground(new Color(2, 29, 62));
        resetdefault.setBorderPainted(false);
        resetdefault.setFocusPainted(false);
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 3;
        c.insets = new Insets(5,0,0,5);
        c.anchor = GridBagConstraints.WEST; 
        summarydetaileastpanel.add(resetdefault, c);

        // Reset Default Button
        // Regular Attributes
        submituservaluesbutton.setFont(new Font("Poppins", Font.BOLD, 20));
        submituservaluesbutton.setForeground(Color.WHITE);
        submituservaluesbutton.setBackground(new Color(62, 142, 37));
        submituservaluesbutton.setBorderPainted(false);
        submituservaluesbutton.setFocusPainted(false);
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 4;
        c.insets = new Insets(5,0,0,25);
        c.anchor = GridBagConstraints.WEST; 
        summarydetaileastpanel.add(submituservaluesbutton, c);

        // Total Usage Sub Panel
        // Regular Attributes
        totalusagepanel.setBackground(new Color(2,29,62));
        // GridBag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 0;
        c.insets = new Insets(5,0,0,5);
        summarydetaileastpanel.add(totalusagepanel, c); 

        // Total Cost Sub Panel 
        // Regular Attributes
        totalcostpanel.setBackground(new Color(76,175,106));
        // GridBag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 1;
        c.insets = new Insets(5,0,0,5);
        summarydetaileastpanel.add(totalcostpanel, c); 

        /* INDIVIDUAL SUB PANEL COMPONENT CONSTRAINTS */

        /* Season Details Components */ 

        // Season Detail Title 
        // Regular Attributes 
        seasondetailtitle.setFont(new Font("Poppins", Font.BOLD, 20)); 

        // GridBag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 0; 
        // (top, left, bottom, right)
        c.insets = new Insets(10,0,0,0); 
    
        seasondetailspanel.add(seasondetailtitle, c);

        // Season Icon
        // Regular Attributes 
        // GridBag Attributes 
        c = new GridBagConstraints();  
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.gridheight = 2;
        c.anchor = GridBagConstraints.CENTER; 
        c.gridx = 1; 
        c.gridy = 0; 
        c.insets = new Insets(0,0,0,0); 

        seasondetailspanel.add(seasonicon, c);

        // Season Date
        // Regular Attributes 
        seasondetailsdate.setFont(new Font("Poppins", Font.PLAIN, 12)); 

        // GridBag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.anchor = GridBagConstraints.NORTH; 
        c.gridx = 0; 
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0); 

        seasondetailspanel.add(seasondetailsdate, c);

        /* Total Usage Sub Panel Components */
        // Total Usage Label
        // Regular Attributes 
        totalusagepaneltitle.setFont(new Font("Poppins", Font.PLAIN, 30)); 
        totalusagepaneltitle.setForeground(Color.WHITE);
        totalusagepaneltitle.setHorizontalAlignment(SwingConstants.CENTER);

        // GridBag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.anchor = GridBagConstraints.CENTER; 
        c.gridx = 0; 
        c.gridy = 0; 
        c.insets = new Insets(0,0,0,0);

        totalusagepanel.add(totalusagepaneltitle, c);

        // Total Usage Value
        // Regular Attributes 
        totalusage.setFont(new Font("Poppins", Font.BOLD, 50)); 
        totalusage.setForeground(Color.WHITE);
        totalusage.setBackground(new Color(23, 104, 172));
        totalusage.setHorizontalAlignment(SwingConstants.CENTER);
        totalusage.setBounds(new Rectangle(300,75));
        totalusage.setOpaque(true); 

        // GridBag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.anchor = GridBagConstraints.CENTER; 
        c.gridx = 1; 
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL; 
        c.insets = new Insets(0,0,0,10); 

        totalusagepanel.add(totalusage, c);


        /* Total Cost Sub Panel Components */ 
        // Total Cost Label
        // Regular Attributes 
        totalcostpaneltitle.setFont(new Font("Poppins", Font.PLAIN, 30)); 
        totalcostpaneltitle.setForeground(Color.WHITE);
        totalcostpaneltitle.setHorizontalAlignment(SwingConstants.CENTER);

        // GridBag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.anchor = GridBagConstraints.CENTER; 
        c.gridx = 0; 
        c.gridy = 0; 
        c.insets = new Insets(0,0,0,0); 

        totalcostpanel.add(totalcostpaneltitle, c);

        // Total Cost Value   
        // Regular Attributes 
        totalcost.setFont(new Font("Poppins", Font.BOLD, 46)); 
        totalcost.setForeground(Color.WHITE);
        totalcost.setBackground(new Color(11, 83, 81));
        totalcost.setHorizontalAlignment(SwingConstants.CENTER);
        // totalcost.setBounds(new Rectangle(300,75));
        totalcost.setOpaque(true); 

        // GridBag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.anchor = GridBagConstraints.CENTER; 
        c.gridx = 1; 
        c.gridy = 0; 
        c.insets = new Insets(0,0,0,10); 
        c.fill = GridBagConstraints.HORIZONTAL; 

        totalcostpanel.add(totalcost, c);

        // public void setConstraints(JComponent pane, JComponent j, double weight, int gridwidth, int gridx, int gridy, Insets inset) {
        //     GridbagConstraints c = new GridbagConstraints();
        //     c.weightx = c.weighty = weight;
        //     c.anchor = GridBagConstraints.WEST; 
        //     c.gridwidth = gridwidth; 
        //     c.gridx = gridx; 
        //     c.gridy = gridy;
        //     c.insets = new Insets(0,70,20,50);
        //     pane.add(j, c); 
        // }
        
>>>>>>> 19aa706a9f6ba03a5913c3100597850ec02dd68c
    }


}
