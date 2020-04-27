/* PACKAGE PATH */
package edu.csus.csc131.euc.controller;

/* Library Imports */
// AWT Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Swing Imports
import javax.swing.*;
import java.awt.*;

// IO Imports
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import edu.csus.csc131.euc.controller.actionlistener.modelactionlisteners.*;
import edu.csus.csc131.euc.model.data.Day;
import edu.csus.csc131.euc.view.panels.ViewCalculatePanel;
import edu.csus.csc131.euc.model.data.Profile;
import edu.csus.csc131.euc.model.data.Rates;

public class Controller {
    // Instance Variables for Controller
    private View view;
    private final Model model;

    // current Day Index
    private int dayIndex;
    private boolean isSummer = true;

    public Controller(final Model m, final View v) {
        this.model = m;
        this.view = v;
        dayIndex = 0;

        // Initializers for the Controller
        initializeView();
        initializeActionListeners();
    }

    // Initializes all action listeners
    public void initializeActionListeners() {

        /* Action Listeners for Main Panel */

        // Set AL for Panels
        view.getMainPanel().getImportJsonButton()
                .addActionListener(new PanelSwitchButtonListener(view, "Import JSON Panel"));
        view.getMainPanel().getManualInputButton()
                .addActionListener(new PanelSwitchButtonListener(view, "Manual Input Panel"));
        view.getMainPanel().getViewCalcButton()
                .addActionListener(new PanelSwitchButtonListener(view, "View & Calculate Panel"));

        // Action Listener for Add Entry button
        view.getManualInputPanel().getAddEntryButton().addActionListener(new AddEntryListener());
        // view.getManualInputPanel().getAddEntryButton().addActionListener(new modelActionListener(view));

        // Focus Listener for UsageTextField and date
        view.getManualInputPanel().getEnterUsageField().addFocusListener(new Focus());
        view.getManualInputPanel().getEnterDateField().addFocusListener(new Focus());
        // Set AL for Buttons in Import JSON Panel
        // For Button Views
        view.getImportPanel().getAddNewFileButton().addActionListener(new IJPanelButtonViewListener(view));
        view.getImportPanel().getBrowseButton().addActionListener(new IJPanelButtonViewListener(view));
        view.getImportPanel().getImportButton().addActionListener(new IJPanelButtonViewListener(view));
        view.getImportPanel().getImportButton().addActionListener(new IJPanelIBActionListener(view, model, this));

        // Set AL for View Calculate Panel
        view.getViewCalculatePanel().getNavLeftButton().addActionListener(new ArrowNavigation());
        view.getViewCalculatePanel().getNavRightButton().addActionListener(new ArrowNavigation());
        view.getViewCalculatePanel().getSeasonToggleButton().addActionListener(new SummerToggle());
        view.getViewCalculatePanel().getSubmitUserValuesButton().addActionListener(new InputRates());
        view.getViewCalculatePanel().getResetDefaultButton().addActionListener(new ResetDefault());

        // Set AL for Manual Input Panel
        view.getManualInputPanel().getEnterDateField().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent e) {
                final char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                   (c == KeyEvent.VK_BACK_SPACE) ||
                   (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))
                {
                  JOptionPane.showMessageDialog(null, "Please Enter Valid");
                  e.consume();
                }
            }

            @Override
            public void keyPressed(final KeyEvent e) {
                // Do Nothing

            }

            @Override
            public void keyReleased(final KeyEvent e) {
                // Do Nothing

            }
        });

    }

    public void createAndShowGUI() {
        // Display Window
        this.view.getFrame().pack();
        this.view.getFrame().setVisible(true);

        // RUN DEBUG PRINT OUTS FOR COMPONENTS HERE

        // DEBUG FOR PANEL SIZES
        System.out.println("Dim Frame: " + view.getFrame().getSize() );
        System.out.println("Dim Main Panel: " + view.getMainPanel().getPanel().getSize() );
        System.out.println("Dim View and Calculate Panel: " + view.getViewCalculatePanel().getPanel().getSize() );
        System.out.println("Dim Import Panel: " + view.getImportPanel().getPanel().getSize() );
        System.out.println("Dim Manual Input Panel: " + view.getManualInputPanel().getPanel().getSize() );

    }

    public void initializeView() {
        // Initialize the view
        final View v = new View();
        this.view = v;
    }

    public void updateComponentsViewCalculate(){
        final ViewCalculatePanel panel = view.getViewCalculatePanel();
        final Profile profile = model.getModelProfile();

        //updates the rate values
        if(isSummer){
            panel.displaySummerSeasonTitle();
            panel.getSummerMidPeakRate().setText(Float.toString(Rates.getMidPeakSummer()));
            panel.getSummerOffPeakRate().setText(Float.toString(Rates.getOffPeakSummer()));
            panel.getSummerPeakRate().setText(Float.toString(Rates.getPeakSummer()));
            panel.getSummerOffPeakPeriod().setText("Midnight - Noon");
            panel.getSummerMidPeakPeriod().setText("Noon - 5pm/8pm - Midnight");
        }
        else{
            panel.displayNonSummerSeasonTitle();
            panel.getSummerMidPeakRate().setText("N/A");
            panel.getSummerOffPeakRate().setText(Float.toString(Rates.getOffPeakNonSummer()));
            panel.getSummerPeakRate().setText(Float.toString(Rates.getPeakNonSummer()));
            panel.getSummerOffPeakPeriod().setText("Midnight - 5pm/ 8pm - Midnight");
            panel.getSummerMidPeakPeriod().setText("N/A");
        }


        //updates the total values by day
        panel.getUsageCostTotalCost().setText("<html>" + formatDecimals(profile.getTotalCostByDay(dayIndex)) + " <font size=3>kWH</font></html>");
        panel.getUsageCostTotalUsage().setText( panel.getDollarSign() + profile.getTotalUsageByDay(dayIndex));

        // Set up season detail dates 
        panel.getSeasonDetailDate().setText(profile.getDays().get(dayIndex).getDate());
        panel.getSeasonDetailPeriod().setText(profile.getDays().get(dayIndex).getPeriod());

        // If it is summer, display summer icon and summer ; Else display, non-summer icon and non-summer
        System.out.println("Boolean for this day: " + profile.getDays().get(dayIndex).isSummer());
        if(profile.getDays().get(dayIndex).isSummer()){ 
            panel.getSeasonDetailTitle().setText("Summer");
            panel.displaySummerIcon();
        }
        else { 
            panel.getSeasonDetailTitle().setText("Non-Summer");
            panel.displayNonSummerIcon();
        }


        //updates the total values
        panel.getTotalCost().setText(panel.getDollarSign() + formatDecimals(profile.calculateKWH()));
        panel.getTotalUsage().setText("<html>" + formatDecimals(profile.getTotalUsage()) + " <font size=5>kWH</font></html>" );

    }

    public String formatDecimals(final float value){
        final String s = String.format("%.2f", value);
        return s;
    }

    // Additional Action Listeners needs to be put into appropriate folders
    class AddEntryListener implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent e) {
            String date = view.getManualInputPanel().getEnterDateField().getText();
            int index =  view.getManualInputPanel().getEnterPeriodField().getSelectedIndex();
            int rows = view.getManualInputPanel().getModel().getRowCount();
            float usage = 0;

            // Set the summer/non-summer boolean 
            String[] dateArray = date.split("/");
            int month = Integer.parseInt(dateArray[0]);
            Object[] row = new Object[5];

            try{
                usage = Float.parseFloat(view.getManualInputPanel().getEnterUsageField().getText());

                //Add's a row to View and Calculate Panel
                row[0] = view.getManualInputPanel().getEnterDateField().getText(); 
                row[1] = view.getManualInputPanel().getEnterPeriodField().getSelectedItem().toString();
                row[2] = view.getManualInputPanel().getEnterUsageField().getText();
                row[3] = "edit";
                row[4] = "X";
                view.getManualInputPanel().getModel().addRow(row);

                //Alternate Row Colors
                if(rows % 2 == 1) {
                    view.getManualInputPanel().getTable().setBackground(Color.WHITE);
                } else {
                    // view.getManualInputPanel().getTable().setBackground(Color.blue);
                }

                //always uses summer rates for now
                Day day = new Day(date, true);

                //if between start of June and before October
                if(month > 6 && month < 10){
                    day.setSummer(true);
                }else{
                    day.setSummer(false); 
                }

                day.setUsage(usage, index);
                day.setPeriod(index + ":00 - " + (int)(index+1) + ":00");

                model.getModelProfile().addDay(day);
                view.getManualInputPanel().getEnterDateField().setText("mm/dd/yyyy");
                view.getManualInputPanel().getEnterPeriodField().setSelectedIndex(0);
                view.getManualInputPanel().getEnterUsageField().setText("Enter Usage");

                updateComponentsViewCalculate();
            }
            catch(final Exception ex){
                System.out.println("Usage has to be float!");
                JOptionPane.showMessageDialog(view.getFrame(), "Usage has to be a number.");
            }

        }
    }

    class Focus implements FocusListener {

        @Override
        public void focusGained(final FocusEvent e) {
           final JTextField j = (JTextField) e.getSource();
           j.selectAll();

        }

        @Override
        public void focusLost(final FocusEvent e) {
            //nothing

        }

    }

    class ArrowNavigation implements ActionListener{
        @Override
        public void actionPerformed(final ActionEvent e) {
            final JButton b = (JButton) e.getSource();
            try {
                model.getModelProfile().getDays().get(dayIndex-1);
                if(b.equals(view.getViewCalculatePanel().getNavLeftButton())){
                    dayIndex--;
                    updateComponentsViewCalculate();
                }
            }
            catch (final Exception ex){
            }
            try{
                model.getModelProfile().getDays().get(dayIndex+1);
                if(b.equals(view.getViewCalculatePanel().getNavRightButton())) {
                    dayIndex++;
                    updateComponentsViewCalculate();
                }
            }
            catch (Exception ex){
            }
            System.out.println("Navigation button pressed!");
        }
    }

    class SummerToggle implements ActionListener{

        @Override
        public void actionPerformed(final ActionEvent e) {
           isSummer = !isSummer;
           updateComponentsViewCalculate();

        }

    }

    class InputRates implements ActionListener{

        @Override
        public void actionPerformed(final ActionEvent e) {

            try{
                if(isSummer){
                    model.getModelProfile().getSummerRates().setPeakSummer(Float.parseFloat(view.getViewCalculatePanel().getSummerPeakRate().getText()));
                    model.getModelProfile().getSummerRates().setMidPeakSummer(Float.parseFloat(view.getViewCalculatePanel().getSummerMidPeakRate().getText()));
                    model.getModelProfile().getSummerRates().setOffPeakSummer(Float.parseFloat(view.getViewCalculatePanel().getSummerOffPeakRate().getText()));
                }
                else{
                    model.getModelProfile().getNonSummerRates().setPeakSummer(Float.parseFloat(view.getViewCalculatePanel().getSummerPeakRate().getText()));
                    model.getModelProfile().getNonSummerRates().setMidPeakSummer(Float.parseFloat(view.getViewCalculatePanel().getSummerMidPeakRate().getText()));
                    model.getModelProfile().getNonSummerRates().setOffPeakSummer(Float.parseFloat(view.getViewCalculatePanel().getSummerOffPeakRate().getText()));
                }

                model.getModelProfile().resetToNewRates();
                updateComponentsViewCalculate();
            }
            catch(final Exception ex){
                JOptionPane.showMessageDialog(view.getFrame(), "Rate values have to be a number.");
            }

        }
    }

    class ResetDefault implements ActionListener{

        @Override
        public void actionPerformed(final ActionEvent e) {
            model.getModelProfile().resetDefault();
            updateComponentsViewCalculate();
        }
    }

}


