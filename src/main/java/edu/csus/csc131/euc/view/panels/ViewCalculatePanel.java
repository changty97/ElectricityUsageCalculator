/* PACKAGE PATH */
package edu.csus.csc131.euc.view.panels;

/*Library Imports*/
import javax.swing.*;
import java.awt.*; 
import edu.csus.csc131.euc.view.panels.subpanels.*; 

public class ViewCalculatePanel extends Panel {

    /* Constants */
    // Main Sub Panels Size 
    private final Dimension USAGE_DETAILS_SUB_PANEL_SIZE = new Dimension(1013, 393);  
    private final Dimension SUMMARY_DETAILS_SUB_PANEL_SIZE = new Dimension(1013, 393);  

    // Sub Panels Size 
    // Rounded 
    private final Dimension SEASON_DETAIL_PANEL_SIZE = new Dimension(230, 73); 
    private final Dimension USAGE_COST_DETAIL_PANEL_SIZE = new Dimension(870, 190); 
    private final Dimension TOTAL_USAGE_PANEL_SIZE = new Dimension(450,100); 
    private final Dimension TOTAL_COST_PANEL_SIZE = new Dimension(450,100); 

    // Titles 
    private final Dimension USAGE_DETAIL_TITLE_SIZE = new Dimension(270,40); 

    // Sizes of Sub Panels of Usage Cost Panel 
    private final Dimension PANEL_1_SIZE = new Dimension((int) USAGE_COST_DETAIL_PANEL_SIZE.getWidth()/5 , (int) USAGE_COST_DETAIL_PANEL_SIZE.getHeight());
    private final Dimension PANEL_2_SIZE = new Dimension((int) USAGE_COST_DETAIL_PANEL_SIZE.getWidth()/5 * 3 , (int) USAGE_COST_DETAIL_PANEL_SIZE.getHeight());
    private final Dimension PANEL_3_SIZE = new Dimension((int) USAGE_COST_DETAIL_PANEL_SIZE.getWidth()/5 , (int) USAGE_COST_DETAIL_PANEL_SIZE.getHeight());
    
    // Instance Variables Organization
    // README: Understands structure below if you plan to add instance variables 
    // /*=============================================================
                /* mainsubpanelname : Main Panel */
                    /* mainsubpanelname : Name of Section 1 */
    //                        // Grouping of Elements in this section 
    //                        ...
    //                        .
    //                        .
    //                        . 
    //              /* mainsubpanelname : Name of Section n */
    //                        ... 
                    /* mainsubpanelname : Sub Panels */ 
    //                        .
    //                        .
    //                        .
                        /* subpanelname : Sub Panel 1 */ 
                            /* subpanelname : Name of Section 1 */ 
                                // Grouping of Elements in this section 
    //                            ...
    //                            .
    //                            .
    //                            .
                                // Component Group n 
                            /* subpanelname : Name of Section n */
                                // Grouping of Elements in this section 
    //                            ...
    //                           
  
    // -------------------------------------------------------------

            //... START NEW MAINPANEL LIKE ABOVE            

    // ===================== END README ==============================

    /* START INSTANCE VARIABLES */ 
    // -------------------------------------------------------------

    /* usagedetailsmainpanel : Main Panel */ 
        private JPanel usagedetailsmainpanel = new JPanel(new GridBagLayout()); 

        /* usagedetailsmainpanel: Components */
        // Title Label 
            private JLabel usagetitle = new JLabel("Usage Details"); 

        /* usagedetailsmainpanel : Sub Panels */ 
            /* usagecostdetailspanel : Sub Panel 1 */ 
                private RoundedPanel usagecostdetailspanel = new RoundedPanel(); 
            /* usagecostdetailspanel: Components */
                // General Navigation 
                    private JButton navrightbutton = new JButton( new ImageIcon("src\\main\\assets\\viewandcalculateres\\nextdaybutton.png")); 
                    private JButton navleftbutton = new JButton( new ImageIcon("src\\main\\assets\\viewandcalculateres\\previousdaybutton.png"));
                // General Labels 
                    private JLabel usagestarttime = new JLabel("Usage Start Time"); 
                    private JLabel usageendtime = new JLabel("Usage End Time"); 
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

            /* seasondetailspanel : Sub Panel 2 */ 
                private RoundedPanel seasondetailspanel = new RoundedPanel(); 
            /* seasondetailspanel: Components */
                // Labels
                    private JLabel seasondetailtitle = new JLabel("Summer"); 
                    private JLabel seasondetailsdate = new JLabel("June 1 - September 30");
                // Icon
                    private JLabel seasonicon = new JLabel( new ImageIcon("src\\main\\assets\\viewandcalculateres\\summericon.png"));


    // -------------------------------------------------------------

    /* Main Subpanel: Summary Details Panel */ 
        private JPanel summarydetailsmainpanel = new JPanel(new GridBagLayout()); 

        /* summarydetailsmainpanel: Components */
        // Title Label 
            private JLabel summarytitle = new JLabel("Summary Details");

        /* summarydetailsmainpanel : Sub Panels */

            /* usagecostdetailspanel : Sub Panel 1 */ 
                private JPanel summarydetailwestgrouppanels = new JPanel(new CardLayout());

            /* summarydetailwestgrouppanels: Components */
                // General Labels 
                    private JLabel seasonsummarytitle = new JLabel("Summer"); // Can be Summer or Non-Summer 
                    private JLabel offpeaktitle = new JLabel("Off-Peak"); 
                    private JLabel midpeaktitle = new JLabel("Mid-Peak"); 
                    private JLabel peaktitle = new JLabel("Peak"); 
                    private JLabel [] ratelbls = { new JLabel("Rate: ") , new JLabel("Rate: "), new JLabel("Rate: "), new JLabel("Rate: "), new JLabel("Rate: ") };
                    private JLabel [] periodlbls = { new JLabel("Period: ") , new JLabel("Period: "), new JLabel("Period: "), new JLabel("Period: "), new JLabel("Period: ") };

                // summarydetailwestpanelsummer : Sub Panel 1 of summarydetailwestgrouppanels
                    private JPanel summarydetailwestpanelsummer = new JPanel(new GridBagLayout());

                    // summarydetailwestpanelsummer : Components
                        private JTextField summeroffpeakrate = new JTextField("$0.1209 / kWH"); 
                        private JTextField summeroffpeakperiod = new JTextField("Midnight - Noon");
                        private JTextField summermidpeakrate = new JTextField("$0.1671 / kWH");
                        private JTextField summermidpeakperiod = new JTextField("Noon - 5pm"); 
                        private JTextField summerpeakrate = new JTextField("$0.2941 / kWH"); 
                        private JTextField summerpeakperiod = new JTextField("5PM - 8PM");

                // summarydetailwestpanelnonsummer : Sub Panel 2 of summarydetailwestgrouppanels
                    private JPanel summarydetailwestpanelnonsummer = new JPanel(new GridBagLayout());

                    // summarydetailwestpanelnonsummer : Components
                        private JTextField nonsummeroffpeakrate = new JTextField("$0.1388 / kWH"); 
                        private JTextField nonsummeroffpeakperiod = new JTextField("5PM - 8PM");
                        private JTextField nonsummerpeakrate = new JTextField("$0.1006 / kWH"); 
                        private JTextField nonsummerpeakperiod = new JTextField("Midnight - 5PM , 5PM - 8PM");

            /* usagecostdetailspanel : Sub Panel 2 */

            private JPanel summarydetaileastpanel = new JPanel(new GridBagLayout());

            /* summarydetaileastpanel: Components */
                // Buttons for Summary Details 
                    private JButton seasontoggle = new JButton("Summer/Non-Summer"); 
                    private JButton resetdefault = new JButton("Reset Default Values"); 
                    private JButton submituservaluesbutton = new JButton("Submit Values"); 

                // totalusagepanel : Sub Panel 1 of summarydetaileastpanel
                private RoundedPanel totalusagepanel = new RoundedPanel(); 

                    // totalusagepanel : Components
                        // Label
                            JLabel totalusagepaneltitle = new JLabel("Total Usage"); 
                        // Value
                            private JLabel totalusage = new JLabel("<html>58.73 <font size=5>kWH</font></html>");

                // totalcostpanel : Sub Panel 2 of summarydetaileastpanel
                    private RoundedPanel totalcostpanel = new RoundedPanel(); 

                    // totalcostpanel : Components
                        // Label
                            JLabel totalcostpaneltitle = new JLabel("Total Cost");
                        // Value
                            private JLabel totalcost = new JLabel("$ 21.94");

    /* END INSTANCE VARIABLES */ 
    // -------------------------------------------------------------

    // Constructor
    public ViewCalculatePanel() {
        /* Intializers for this Panel */ 
        setBackgroundColor(Color.lightGray);
        initializePanel(); 
        intializeComponentPreferences();
        intializeConstraints(); 
    }

    //   Setters and Getters
    //   README: Understand structure below if you plan to add setters and getters 
    // /*=============================================================
    //   EX: 
            /* Setters */ 
/* 
            //panelname    
            method() 
                .
                .
                .

                etc. 
            
            /* Getters */ 
/*
            //panelname
            method()
                .
                .
                .

                etc.
*/
    //
    // ===================== END README =============================
    
    /* START SETTERS AND GETTERS */ 
    // -------------------------------------------------------------

    /* Setters */
    // usagecostdetailspanel
    public void setUsageStartTime(String usagestarttime){ this.usagestarttime.setText(usagestarttime); }
    public void setUsageEndTime(String usageendtime){ this.usagestarttime.setText(usageendtime); }

    public void setUsageCostTotalUsage(float d){ this.usagecosttotalusage.setText( Float.toString(d) ); }
    public void setUsageCostNonPeakUsage(float d){ this.usagecostnonpeakusage.setText( Float.toString(d) ); }
    public void setUsageCostMidPeakUsage(float d){ this.usagecostmidpeakusage.setText( Float.toString(d) ); } 
    public void setUsageCostPeakUsage(float d){ this.usagecostpeakusage.setText( Float.toString(d) ); }

    public void setUsageCostTotalCost(float d){ this.usagecosttotalcost.setText( Float.toString(d) ); }
    public void setUsageCostNonPeakCost(float d){ this.usagecostnonpeakcost.setText( Float.toString(d) ); }
    public void setUsageCostMidPeakCost(float d){ this.usagecostmidpeakcost.setText( Float.toString(d) ); } 
    public void setUsageCostPeakCost(float d){ this.usagecostpeakcost.setText( Float.toString(d) ); }

    // seasondetailspanel
    public void setSeasonDetailTitle(String s){ this.seasondetailtitle.setText(s); }
    public void setSeasonDetailDate(String s){ this.seasondetailsdate.setText(s); }
    public void setSeasonIcon(JLabel i){ this.seasonicon = i; }

    // summarydetailwestpanelsummer
    public void setSummerOffPeakRate(float f){ this.summeroffpeakrate.setText(Float.toString(f)); }
    public void setSummerOffPeakPeriod(float f){ this.summeroffpeakperiod.setText(Float.toString(f)); }
    public void setSummerOffMidPeakRate(float f){ this.summermidpeakrate.setText(Float.toString(f)); }
    public void setSummerOffMidPeakPeriod(float f){this.summermidpeakperiod.setText(Float.toString(f)); }
    public void setSummerPeakRate(float f){ this.summerpeakrate.setText(Float.toString(f)); }
    public void setSummerPeakPeriod(float f){ this.summerpeakperiod.setText(Float.toString(f)); }
    
    // summarydetailwestpanelnonsummer
    public void setNonSummerOffPeakRate(float f){ this.nonsummeroffpeakrate.setText(Float.toString(f)); }
    public void setNonSummerOffPeakPeriod(float f){ this.nonsummeroffpeakperiod.setText(Float.toString(f)); }
    public void setNonSummerPeakRate(float f){ this.nonsummerpeakperiod.setText(Float.toString(f)); }
    public void setNonSummerPeakPeriod(float f){ this.nonsummerpeakperiod.setText(Float.toString(f)); }

    // totalusagepanel
    public void setTotalUsage(float f){ this.totalusage.setText(Float.toString(f)); }

    // totalcostpanel
    public void setTotalCost(float f){ this.totalcost.setText(Float.toString(f)); }

    /* Getters */
    // usagecostdetailspanel
    public JButton getNavRightButton(){ return this.navrightbutton; }
    public JButton getNavLeftButton(){ return this.navleftbutton; }

    public JLabel getUsageCostTotalUsage(){  return this.usagecosttotalusage; }
    public JLabel getUsageCostNonPeakUsage(){  return this.usagecostnonpeakusage; }
    public JLabel getUsageCostMidPeakUsage(){  return this.usagecostmidpeakusage; }
    public JLabel getUsageCostPeakUsage(){  return this.usagecostpeakusage; }

    public JLabel getUsageCostTotalCost(){  return this.usagecosttotalcost; }
    public JLabel getUsageCostNonPeakCost(){  return this.usagecostnonpeakcost; }
    public JLabel getUsageCostMidPeakCost(){  return this.usagecostmidpeakcost; }
    public JLabel getUsageCostPeakCost(){  return this.usagecostpeakcost; }

    // seasondetailspanel
    public JLabel getSeasonDetailTitle(String s){ return this.seasondetailtitle; }
    public JLabel getSeasonDetailDate(String s){ return this.seasondetailsdate; }
    public JLabel getSeasonIcon(JLabel i){ return this.seasonicon; }

    //summarydetailwestpanelsummer
    public JTextField getSummerOffPeakRate(float f){ return this.summeroffpeakrate; }
    public JTextField getSummerOffPeakPeriod(float f){ return this.summeroffpeakperiod; }
    public JTextField getSummerOffMidPeakRate(float f){ return this.summermidpeakrate; }
    public JTextField getSummerOffMidPeakPeriod(float f){return this.summermidpeakperiod; }
    public JTextField getSummerPeakRate(float f){ return this.summerpeakrate; }
    public JTextField getSummerPeakPeriod(float f){ return this.summerpeakperiod; }
    
    //summarydetailwestpanelnonsummer
    public JTextField getNonSummerOffPeakRate(float f){ return this.nonsummeroffpeakrate; }
    public JTextField getNonSummerOffPeakPeriod(float f){ return this.nonsummeroffpeakperiod; }
    public JTextField getNonSummerPeakRate(float f){ return this.nonsummerpeakperiod; }
    public JTextField getNonSummerPeakPeriod(float f){ return this.nonsummerpeakperiod; }

    // totalusagepanel
    public JLabel getTotalUsage(float f){ return this.totalusage; }

    // totalcostpanel
    public JLabel getTotalCost(float f){ return this.totalcost; }

    /* END SETTERS AND GETTERS */ 
    // -------------------------------------------------------------

    /* Functions for ViewCalculate Panel*/ 

    // Intializes Preferences for each Component 
    public void intializeComponentPreferences(){
        /* Component Preferences */ 
        // Set Usage Main Sub Panel Size
        usagedetailsmainpanel.setMinimumSize(USAGE_DETAILS_SUB_PANEL_SIZE); 
        usagedetailsmainpanel.setPreferredSize(USAGE_DETAILS_SUB_PANEL_SIZE);

        // Set Summary Detail Main Sub Panel Size
        summarydetailsmainpanel.setMinimumSize(SUMMARY_DETAILS_SUB_PANEL_SIZE); 
        summarydetailsmainpanel.setPreferredSize(SUMMARY_DETAILS_SUB_PANEL_SIZE);

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

    }

    // Initializes Constraints for GridBag Layout 
    public void intializeConstraints(){
        /* MAIN SUB PANEL CONSTRAINTS */

        // Usage Details Main Sub Panel 
        // Regular Attributes
        usagedetailsmainpanel.setBackground(new Color(13, 156, 204));
        // Grid Bag Attributes 
        GridBagConstraints c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0; 
        c.gridx = 0; 
        c.gridy = 0; 
        c.anchor = GridBagConstraints.NORTH; 
        getPanel().add(usagedetailsmainpanel, c);

        // Summary Detail Main Sub Panel 
        // Regular Attributes
        summarydetailsmainpanel.setBackground(Color.WHITE);
        // Grid Bag Attributes 
        c = new GridBagConstraints(); 
        c.weightx = c.weighty = 1.0; 
        c.gridx = 0; 
        c.gridy = 1;
        c.ipadx = c.ipady = 50; 
        c.anchor = GridBagConstraints.SOUTH; 
        getPanel().add(summarydetailsmainpanel, c);

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
        usagedetailsmainpanel.add(usagetitle, c);

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
        usagedetailsmainpanel.add(seasondetailspanel, c);

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
        usagedetailsmainpanel.add(usagecostdetailspanel, c);
        

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
        summarydetailsmainpanel.add(summarydetailwestgrouppanels, c); 

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
        summarydetailsmainpanel.add(summarydetaileastpanel, c); 
    
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
        summarydetailsmainpanel.add(summarytitle, c); 
 
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
        
    }

}
