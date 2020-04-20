/* PACKAGE PATH */
package edu.csus.csc131.euc.view.panels;

/*Library Imports*/
import javax.swing.*;
import java.awt.*; 
import edu.csus.csc131.euc.view.panels.subpanels.*; 

public class ViewCalculatePanel extends Panel {

    /* Constants */
    private static final Dimension DIMENSION_TEXTFIELD = new Dimension(100, 25);

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

    // Titles 
    private final Dimension USAGE_DETAIL_TITLE_SIZE = new Dimension(270,40); 

    // Padding 
    private static final Insets GLOBAL_PADDING = new Insets(10, 10, 10, 10);   

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
    private JPanel totalusagepanel, totalcostpanel;
    
    /* Summary Details: Sub Panel Components */
    // Total Usage Panel Comps
    // Label
    JLabel totalusagepaneltitle = new JLabel("Total Usage"); 
    // Value
    private JTextField totalusage;

    // Total Cost Panel Comps
    // Label
    JLabel totalcostpaneltitle = new JLabel("Total Cost"); 
    // Value
    private JTextField totalcost;


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

    // Setters - Summary Details - Non-Summer
    public void setNonSummerOffPeakRate(JTextField t) { this.nonsummeroffpeakrate = t; }
    public void setNonSummerOffPeakPeriod(JTextField t) { this.nonsummeroffpeakperiod = t; }
    public void setNonSummerPeakRate(JTextField t) { this.nonsummerpeakrate = t; }
    public void setNonSummerPeakPeriod(JTextField t) { this.nonsummerpeakperiod = t; }

    // Setters - Total Details
    public void setTotalUsage(JTextField t) { this.totalusage = t; }
    public void setTotalCost(JTextField t) { this.totalcost = t; }

    /* Getters */

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

    // Getters - Summary Details - Non-Summer
    public JTextField getNonSummerOffPeakRate(JTextField t) { return this.nonsummeroffpeakrate; }
    public JTextField getNonSummerOffPeakPeriod(JTextField t) { return this.nonsummeroffpeakperiod; }
    public JTextField getNonSummerPeakRate(JTextField t) { return this.nonsummerpeakrate; }
    public JTextField getNonSummerPeakPeriod(JTextField t) { return this.nonsummerpeakperiod; }

    // Getters - Total Details
    public JTextField getTotalUsage() { return this.totalusage; }
    public JTextField getTotalCost() { return this.totalcost; }

    /* Functions for ViewCalculate Panel*/ 

    // Intialize All Components 
    public void initializeComponents(){
        // Initialize Main Sub Panels 
        this.usagedetailspanel = new JPanel(new GridBagLayout()); 
        this.summarydetailspanel = new JPanel(new GridBagLayout()); 

        // Initalize Sub Panels 
        this.seasondetailspanel = new RoundedPanel(); 
        this.usagecostdetailspanel = new RoundedPanel(); 
        this.totalusagepanel = new JPanel(new GridBagLayout());
        this.totalcostpanel = new JPanel(new GridBagLayout());  

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

        // Usage Text Fields - Usage
        this.usagestarttime = new JTextField("Usage Start Time");
        this.usageendtime = new JTextField("Usage Start Time");

        // Summary Details 
        this.summarytitle = new JLabel("Summary Details");

        // Total Details
        this.totalusage = new JTextField("Total Usage");
        this.totalcost = new JTextField("Total Cost");
    }

    // Intializes Preferences for each Component 
    public void intializeComponentPreferences(){
        /* Component Preferences */ 
        // Set Usage Main Sub Panel Size
        usagedetailspanel.setMinimumSize(USAGE_DETAILS_SUB_PANEL_SIZE); 
        usagedetailspanel.setPreferredSize(USAGE_DETAILS_SUB_PANEL_SIZE);

        // Set Summary Detail Main Sub Panel Size
        summarydetailspanel.setMinimumSize(SUMMARY_DETAILS_SUB_PANEL_SIZE); 
        summarydetailspanel.setPreferredSize(SUMMARY_DETAILS_SUB_PANEL_SIZE);

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

        // Total 
        this.totalusage.setEditable(false);
        this.totalcost.setEditable(false);

        // Summary Detail Comp. 

    }

    // Initializes Constraints for GridBag Layout 
    public void intializeConstraints(){
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
        c.ipadx = c.ipady = 100; 
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
        // Navigation Attributes
        c.insets = new Insets(0,30,20,50);
        usagecostdetailspanel.add(navleftbutton, c);
    
        c.insets = new Insets(0,750,20,0);
        usagecostdetailspanel.add(navrightbutton, c);

        usagecosttotalusagelbl.setFont(new Font("Poppins", Font.BOLD, 20));
        c.insets = new Insets(0,150,150,0);
        usagecostdetailspanel.add(usagecosttotalusagelbl, c);

        usagecostnonpeakusagelbl.setFont(new Font("Poppins", Font.BOLD, 20));
        c.insets = new Insets(0,150,110,0);
        usagecostdetailspanel.add(usagecostnonpeakusagelbl, c);
       
        usagecostmidpeakusagelbl.setFont(new Font("Poppins", Font.BOLD, 20));
        c.insets = new Insets(0,150,70,0);
        usagecostdetailspanel.add(usagecostmidpeakusagelbl, c);
       
        usagecostpeakusagelbl.setFont(new Font("Poppins", Font.BOLD, 20));
        c.insets = new Insets(0,150,30,0);
        usagecostdetailspanel.add(usagecostpeakusagelbl, c);
       
        // // 1st Column: Usage (Values)
        // usagecosttotalusage.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecosttotalusage, c);
       
        // usagecostnonpeakusage.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecostnonpeakusage, c);
       
        // usagecostmidpeakusage.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecostmidpeakusage, c);
       
        // usagecostpeakusage.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecostpeakusage, c);
       
        // 2nd Column: Usage (Labels)
        // usagecosttotalcostlbl.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecosttotalcostlbl, c);
       
        // usagecostnonpeakcostlbl.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecostnonpeakcostlbl, c);
       
        // usagecostmidpeakcostlbl.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecostmidpeakcostlbl, c);
       
        // usagecostpeakcostlbl.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecostpeakcostlbl, c);
       
        // 2nd Column: Usage (Values)
        // usagecosttotalcost.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecosttotalcost, c);
       
        // usagecostnonpeakcost.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecostnonpeakcost, c);
       
        // usagecostmidpeakcost.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecostmidpeakcost, c);
       
        // usagecostpeakcost.setFont(new Font("Poppins", Font.BOLD, 20));
        // c.insets = new Insets(0,150,150,0);
        // usagecostdetailspanel.add(usagecostpeakcost, c);

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
        seasontoggle.setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 0;
        c.insets = new Insets(25,0,0,0);
        c.anchor = GridBagConstraints.WEST; 
        summarydetaileastpanel.add(seasontoggle, c);

        // Reset Default Button
        resetdefault.setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 1;
        c.insets = new Insets(5,0,0,5);
        c.anchor = GridBagConstraints.WEST; 
        summarydetaileastpanel.add(resetdefault, c);

        // Reset Default Button
        submituservaluesbutton.setFont(new Font("Poppins", Font.BOLD, 15));
        // GridBag Attributes 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 2;
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
        c.gridy = 3;
        c.insets = new Insets(5,0,0,5);
        summarydetaileastpanel.add(totalusagepanel, c); 

        // Total Cost Sub Panel 
        // Regular Attributes
        totalcostpanel.setBackground(new Color(76,175,106));
        // GridBag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0;
        c.gridx = 0; 
        c.gridy = 4;
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
        
    }

}
