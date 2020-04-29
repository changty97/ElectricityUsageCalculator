/* PACKAGE PATH */
package edu.csus.csc131.euc.controller;

/* Library Imports */
// Util Imports 
import java.util.regex.Pattern;

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
import javax.swing.table.*;

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
import edu.csus.csc131.euc.model.data.Record;

public class Controller {
    // Instance Variables for Controller
    private View view;
    private final Model model;

    // current Day Index
    private int dayIndex;
    private boolean isSummer = true;
    private ImageRenderer Edit = new ImageRenderer(new JCheckBox(), "src\\main\\assets\\manualinputres\\editfield.png");
    private ImageRenderer Delete = new ImageRenderer(new JCheckBox(), "src\\main\\assets\\manualinputres\\deletebutton.png");
    private Object[] row = new Object[5];
    private int rowCount;

    public Controller(final Model m, final View v) {
        this.model = m;
        this.view = v;
        dayIndex = 0;

        // Initializers for the Controller
        initializeView();
        initializeActionListeners();
        updateComponentsViewCalculate(false);
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
        // Edit.getButton().addActionListener(new EditRowListener());
        // Delete.getButton().addActionListener(new DeleteRowListener());

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
        view.getViewCalculatePanel().getSubmitUserValuesButton().addActionListener(new InputPeriod());
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

    public void updateComponentsViewCalculate(boolean isResetDefault){
        final ViewCalculatePanel panel = view.getViewCalculatePanel();
        final Profile profile = model.getModelProfile();

        //updates the rate values
        if(isSummer){
            panel.displaySummerSeasonTitle();
            panel.getSummerMidPeakRate().setText(Float.toString(Rates.getMidPeakSummer()));
            panel.getSummerOffPeakRate().setText(Float.toString(Rates.getOffPeakSummer()));
            panel.getSummerPeakRate().setText(Float.toString(Rates.getPeakSummer()));

            if (isResetDefault){
                panel.getSummerOffPeakPeriod().setText("00:00 to 12:00");
                panel.getSummerMidPeakPeriod().setText("12:00 to 17:00 20:00 to 00:00");
                panel.getSummerPeakPeriod().setText("17:00 to 20:00");
                panel.displaySummerSeasonTitle();
            }

        }
        else{
            panel.displayNonSummerSeasonTitle();
            panel.getSummerOffPeakRate().setText(Float.toString(Rates.getOffPeakNonSummer()));
            panel.getSummerPeakRate().setText(Float.toString(Rates.getPeakNonSummer()));


            System.out.println(panel.getSummerOffPeakRate().getText());

            if (isResetDefault){
                panel.getSummerMidPeakRate().setText("N/A");
                panel.getSummerOffPeakPeriod().setText("00:00 to 17:00 20:00 to 00:00");
                panel.getSummerMidPeakPeriod().setText("N/A");
                panel.getSummerPeakPeriod().setText("17:00 to 20:00");
            }

            panel.displayNonSummerSeasonTitle();
        }

        try{
            //updates the total values by day
            panel.getUsageCostTotalCost().setText(panel.getDollarSign() + formatDecimals(profile.getTotalCostByDay(dayIndex), 2));
            panel.getUsageCostTotalUsage().setText( "<html>" + formatDecimals(profile.getTotalUsageByDay(dayIndex), 4) + " <font size=3>kWH</font></html>");

            // Set up season detail dates
            panel.getSeasonDetailDate().setText(profile.getDays().get(dayIndex).getDate());

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

        }
        catch(Exception e){

        }
        //updates the total values
        panel.getTotalCost().setText(panel.getDollarSign() + formatDecimals(profile.calculateKWH(), 2));
        panel.getTotalUsage().setText("<html>" + formatDecimals(profile.getTotalUsage(), 2) + " <font size=5>kWH</font></html>" );
        model.getModelProfile().dumpValues();
    }

    public String formatDecimals(final float value, int decimal){
        final String s = String.format("%."+decimal+"f", value);
        return s;
    }

    public ImageRenderer getEdit(){
        return Edit;
    }

    public ImageRenderer getDelete(){
        return Delete;
    }

    // Additional Action Listeners needs to be put into appropriate folders
    //Function to set Jbutton Icon to the Table
        // class ImageRenderer extends DefaultTableCellRenderer {
        //     private JButton btn;

        //     public ImageRenderer(String file) {
        //         btn = new JButton(new ImageIcon(file));
        //     }

        //     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        //         boolean hasFocus, int row, int column) {
        //             //Alternate background color for button
        //             btn.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
        //             btn.setText((String) value);
        //             btn.setBorderPainted(false);
        //       return btn;
        //     }

        //     //setter
        //     public void setButton(JButton b) { this.btn = b; }

        //     //getter
        //     public JButton getButton() { return this.btn; }
        //   }
    
          public class ImageRenderer extends DefaultCellEditor {
            protected JButton button;
            // private String label;
            private boolean isPushed;
           
            public ImageRenderer(JCheckBox checkBox, String file) {
              super(checkBox);
              button = new JButton(new ImageIcon(file));
            }
           
            public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            //   if (isSelected) {
            //     button.setForeground(table.getSelectionForeground());
            //     button.setBackground(table.getSelectionBackground());
            //   } else {
            //     button.setForeground(table.getForeground());
            //     button.setBackground(table.getBackground());
            //   }
            //   label = (value == null) ? "" : value.toString();
            //   button.setText(label);
              button.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
              button.setBorderPainted(false);
              isPushed = true;
              return button;
            }

             //setter
             public void setButton(JButton b) { this.button = b; }

             //getter
             public JButton getButton() { return this.button; }
           
          }

    class AddEntryListener implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent e) {
            String date = view.getManualInputPanel().getDatePicker().getTextField().getText();
            int month = view.getManualInputPanel().getDatePicker().getMonth();
            System.out.println(date);

            int index =  view.getManualInputPanel().getEnterPeriodField().getSelectedIndex();
            int rows = view.getManualInputPanel().getModel().getRowCount();

            // Set the summer/non-summer boolean
            if(!date.equals("")){
                try{
                    float usage = Float.parseFloat(view.getManualInputPanel().getEnterUsageField().getText());

                    //Add's a row to View and Calculate Panel
                    row[0] = view.getManualInputPanel().getDatePicker().getTextField().getText();
                    row[1] = view.getManualInputPanel().getEnterPeriodField().getSelectedItem().toString();
                    row[2] = String.format("%.4f", Float.parseFloat(view.getManualInputPanel().getEnterUsageField().getText()));
                    //Add Edit button
                    // view.getManualInputPanel().getTable().getColumn("Edit").setCellRenderer(Edit);
                    // view.getManualInputPanel().getTable().getColumn("Edit").setCellRenderer(new ButtonRenderer());
                    view.getManualInputPanel().getTable().getColumn("Edit").setCellEditor(Edit);
                    Edit.getButton().addActionListener(new EditRowListener());

                    //Add Delete Button
                    // view.getManualInputPanel().getTable().getColumn("Delete").setCellRenderer(Delete);
                    view.getManualInputPanel().getTable().getColumn("Delete").setCellEditor(Delete);
                    Delete.getButton().addActionListener(new DeleteRowListener());

                    //always uses summer rates for now
                    Day day = new Day(date, true);

                    boolean duplicateExists = (Record.findDuplicateDay(date) != -1);

                    //if there isn't a duplicate day
                    if(!duplicateExists){
                        //if between start of June and before October
                        System.out.println(month);
                        if(month >= 6 && month < 10){
                            day.setSummer(true);
                        }else{
                            day.setSummer(false);
                        }
                        System.out.println("summer:" + day.isSummer());
                        day.setUsage(usage, index);

                        model.getModelProfile().addDay(day);
                        Record.addRecord(new Record(date, index));
                        view.getManualInputPanel().getModel().addRow(row);
                        rowCount = view.getManualInputPanel().getModel().getRowCount() - 1;

                    }
                    //if there is a duplicate day
                    else{
                        //no duplicate record
                        if(Record.findDuplicate(date, index) == -1){

                            model.getModelProfile().getDay(date).setUsage(usage, index);
                            Record.addRecord(new Record(date, index));
                            view.getManualInputPanel().getModel().addRow(row);
                        }
                        else{
                            int result = JOptionPane.showConfirmDialog(
                                view.getFrame(), "Duplicate record found! Do you want to replace?", "Duplicate",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.YES_OPTION){

                                int rowNo = Record.findDuplicate(date, index);

                                //remove duplicate row
                                //model.getModelProfile().deleteRecord(date, index);
                                Record.deleteRecord(rowNo);
                                view.getManualInputPanel().getModel().removeRow(rowNo);

                                //sync day data
                                model.getModelProfile().getDay(date).setUsage(usage, index);
                                Record.addRecord(new Record(date, index));
                                view.getManualInputPanel().getModel().addRow(row);
                            }

                        }

                    }
                    view.getManualInputPanel().getEnterDateField().setText("mm/dd/yyyy");
                    view.getManualInputPanel().getEnterPeriodField().setSelectedIndex(0);
                    view.getManualInputPanel().getEnterUsageField().setText("Enter Usage");

                    updateComponentsViewCalculate(false);
                }
                catch(final NumberFormatException ex){
                    System.out.println("Usage has to be float!");
                    JOptionPane.showMessageDialog(view.getFrame(), "Usage has to be a number.");
                }
            }
            else{
                JOptionPane.showMessageDialog(view.getFrame(), "Choose a Date.");
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
                    updateComponentsViewCalculate(false);
                }
            }
            catch (final Exception ex){
            }
            try{
                model.getModelProfile().getDays().get(dayIndex+1);
                if(b.equals(view.getViewCalculatePanel().getNavRightButton())) {
                    dayIndex++;
                    updateComponentsViewCalculate(false);
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
           updateComponentsViewCalculate(false);
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
                    model.getModelProfile().getNonSummerRates().setPeakNonSummer(Float.parseFloat(view.getViewCalculatePanel().getSummerPeakRate().getText()));
                    model.getModelProfile().getNonSummerRates().setOffPeakNonSummer(Float.parseFloat(view.getViewCalculatePanel().getSummerOffPeakRate().getText()));
                }

                model.getModelProfile().resetToNewRates();
                updateComponentsViewCalculate(false);
            }
            catch(final Exception ex){
                JOptionPane.showMessageDialog(view.getFrame(), "Rate values have to be a number.");
            }
        }
    }

    class InputPeriod implements ActionListener{
        @Override
        public void actionPerformed(final ActionEvent e) {
            // Regex pattern for ' HH:MM to HH:MM , ' for one or more occurences 
            String pattern = "(([0-1]?[0-9]|2[0-3]):[0-5][0-9] to ([0-1]?[0-9]|2[0-3]):[0-5][0-9]\\s*){1,}"; 

            // Grab values for periods 
            String offpeak = view.getViewCalculatePanel().getSummerOffPeakPeriod().getText();
            String midpeak = view.getViewCalculatePanel().getSummerMidPeakPeriod().getText();
            String peak = view.getViewCalculatePanel().getSummerPeakPeriod().getText();

            boolean isOffPeakMatch = Pattern.matches(pattern, offpeak);
            boolean isMidPeakMatch = Pattern.matches(pattern, midpeak);
            boolean isPeakMatch = Pattern.matches(pattern, peak);

            System.out.println(offpeak);
            System.out.println(midpeak);
            System.out.println(peak);


            if(isSummer){
                if(offpeak != "00:00 to 12:00" && isOffPeakMatch){
                    JOptionPane.showMessageDialog(view.getFrame(), "New Off Peak Period: " + offpeak);
                        
                    // setPeriod( String Period, isSummer, isOffPeak, isMidPeak, isPeak )
                    model.getModelRates().setUserPeriod(offpeak, isSummer, true, false, false); 
                }
                else{
                    JOptionPane.showMessageDialog(view.getFrame(), "Invalid Off Peak: Format is HH:MM to HH:MM ...");
                    view.getViewCalculatePanel().getSummerOffPeakPeriod().setText("00:00 to 12:00");
                }

                if(midpeak != "12:00 to 17:00 0:00 to 00:00" && isMidPeakMatch){
                    JOptionPane.showMessageDialog(view.getFrame(), "New Mid Peak Period: " + midpeak);
                    view.getViewCalculatePanel().getSummerMidPeakPeriod().setText("12:00 to 17:00 0:00 to 00:00");
                    model.getModelRates().setUserPeriod(midpeak, isSummer, false, true, false); 
                }
                else{
                    JOptionPane.showMessageDialog(view.getFrame(), "Invalid Mid Peak: Format is HH:MM to HH:MM ...");

                }
                if(peak != "17:00 to 20:00" && isPeakMatch){
                    JOptionPane.showMessageDialog(view.getFrame(), "New Peak Period: " + peak);
                    model.getModelRates().setUserPeriod(peak, isSummer, false, false, true); 
                }
                else{
                    JOptionPane.showMessageDialog(view.getFrame(), "Invalid Peak: Format is HH:MM to HH:MM ...");
                    view.getViewCalculatePanel().getSummerPeakPeriod().setText("17:00 to 20:00");
                }
            }
            else{
                if(offpeak != "00:00 to 17:00 20:00 to 00:00"){
                    JOptionPane.showMessageDialog(view.getFrame(), "New Off Peak Period: " + offpeak);
                    view.getViewCalculatePanel().getSummerOffPeakPeriod().setText("00:00 to 17:00 20:00 to 00:00");
                    model.getModelRates().setUserPeriod(offpeak, isSummer, true, false, false); 
                }
                else{
                    JOptionPane.showMessageDialog(view.getFrame(), "Invalid Off Peak: Format is HH:MM to HH:MM ...");

                }
                if(peak != "17:00 20:00" && isPeakMatch){
                    JOptionPane.showMessageDialog(view.getFrame(), "New Peak Period: " + peak);
                    model.getModelRates().setUserPeriod(peak, isSummer, false, false, true); 
                }
                else{
                    JOptionPane.showMessageDialog(view.getFrame(), "Invalid Peak: Format is HH:MM to HH:MM ...");
                    view.getViewCalculatePanel().getSummerPeakPeriod().setText("17:00 to 20:00");
                }
            }

            // Set new user rates
            // model.getModelRates().setRate(model.getModelRates().setUserRates(isSummer));
        }
    }

    class ResetDefault implements ActionListener{
        @Override
        public void actionPerformed(final ActionEvent e) {
            model.getModelProfile().resetDefault();
            updateComponentsViewCalculate(true);
        }
    }

    class EditRowListener implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent e) {
            System.out.println("Edit clicked!");
            view.getManualInputPanel().getEnterDateField().setText(view.getManualInputPanel().getModel().getValueAt(view.getManualInputPanel().getTable().getSelectedRow(), 0).toString());   
            view.getManualInputPanel().getEnterPeriodField().setSelectedIndex(view.getManualInputPanel().getTable().getSelectedRow()); //set to what ever the user clicked edit on
            view.getManualInputPanel().getEnterUsageField().setText(view.getManualInputPanel().getModel().getValueAt(view.getManualInputPanel().getTable().getSelectedRow(), 2).toString());
        }
    }

    class DeleteRowListener implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent e) {
            System.out.println("Delete Clicked");
            view.getManualInputPanel().getModel().removeRow(rowCount);
        }
    }


}