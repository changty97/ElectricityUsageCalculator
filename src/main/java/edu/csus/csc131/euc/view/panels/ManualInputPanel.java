/* PACKAGE PATH */
package edu.csus.csc131.euc.view.panels;

/* Library Imports */
import javax.swing.*;
import java.awt.*;


public class ManualInputPanel extends Panel{

    /* Constants */
    private static final Dimension DIMENSION_TEXTFIELD = new Dimension(100, 25);
    private static final Dimension DIMENSION_SCROLL_PANE = new Dimension(200, 200);
    private static final Dimension DIMENSION_SCROLL_BAR = new Dimension(20, 200);
    private static final int HOURS = 24;

    // Padding
    private static final Insets GLOBAL_PADDING = new Insets(10, 10, 10, 10);

    // Instance Elements
    private JButton addentrybutton;
    private JList<String> list;
    private JScrollBar scrollbar;
    private JScrollPane scrollpane;
    private JTextField enterdatefield, enterusagefield;
    private JComboBox<String> enterperiodfield;
    private DefaultListModel<String> listModel;


    // Constructor
    public ManualInputPanel() {
        /* Intializers for this Panel */
        setBackgroundColor(Color.LIGHT_GRAY);
        initializePanel();
        initializeComponents();
        intializeComponentPreferences();
        intializeConstraints();
    }

    // Setters
    public void setAddEntryButton(JButton b) { this.addentrybutton = b; }
    public void setScrollBar(JScrollBar s) { this.scrollbar = s; }
    public void setScrollPane(JScrollPane s) { this.scrollpane = s; }
    public void setEnterDateField(JTextField t) { this.enterdatefield = t; }
    public void setEnterPeriodField(JComboBox<String> t) { this.enterperiodfield = t; }
    public void setEnterUsageField(JTextField t) { this.enterusagefield = t; }

    // Getters
    public JButton getAddEntryButton() { return this.addentrybutton; }
    public JScrollBar getScrollBar() { return this.scrollbar; }
    public JScrollPane getScrollPane() { return this.scrollpane; }
    public JTextField getEnterDateField() { return this.enterdatefield; }
    public JComboBox<String> getEnterPeriodField() { return this.enterperiodfield; }
    public JTextField getEnterUsageField() { return this.enterusagefield; }
    public DefaultListModel<String> getListModel(){ return listModel;}



    // Intialize All Components
    public void initializeComponents(){
       /* Instantiate all components of panel here */
       this.addentrybutton = new JButton("Add Entry");
       this.scrollbar = new JScrollBar(JScrollBar.VERTICAL,0,100,0,255);
       this.enterdatefield = new JTextField("Enter Date");
       this.enterperiodfield = new JComboBox<>();
       enterperiodfield.setEditable(false);

       for(int i = 0; i < HOURS; i++){
           enterperiodfield.addItem(i + ":00 - " + (int)(i+1) + ":00");
       }

       this.enterusagefield = new JTextField("Enter Usage");

       // Instantiate list components


       listModel = new DefaultListModel<String>();
       //add listModel to list to dynamically be able to change the list
       this.list = new JList<>(listModel);
       this.scrollpane = new JScrollPane(this.list);

       //sets the date field and usage field to be focusable
       enterdatefield.setFocusable(true);
       enterusagefield.setFocusable(true);

    }

    // Intializes Preferences for each Component
    public void intializeComponentPreferences(){
        /* Component Preferences */
        this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.list.setLayoutOrientation(JList.VERTICAL);
        this.list.setVisibleRowCount(-1);
    }

    // Initializes Constraints for GridBag Layout
    public void intializeConstraints(){

        // Add Entry Button constraints
        setButtonConstraints(this.addentrybutton, 0, 0, null, GLOBAL_PADDING);

        // All Text Field Constraints
        setTextFieldConstraints(this.enterdatefield, 4, 1, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setConstraints(this.enterperiodfield, 4, 2, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.enterusagefield, 4, 3, DIMENSION_TEXTFIELD, GLOBAL_PADDING);

        // Scroll Pane constraints
        setScrollPaneConstraints(this.scrollpane, 1, 1, DIMENSION_SCROLL_PANE, GLOBAL_PADDING);

        // Scroll Bar constraints
        setScrollBarConstraints(this.scrollbar, 3, 1, DIMENSION_SCROLL_BAR, GLOBAL_PADDING);
    }
}