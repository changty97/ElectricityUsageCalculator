/* PACKAGE PATH */ 
package edu.csus.csc131.euc.view.panels;

/* Library Imports */
import javax.swing.*; 
import java.awt.*;
import javax.swing.table.AbstractTableModel;

public class ManualInputPanel extends Panel{

    /* Constants */
    private static final Dimension DIMENSION_TEXTFIELD = new Dimension(100, 25);
    private static final Dimension DIMENSION_SCROLL_PANE = new Dimension(200, 200);

    // Padding 
    private static final Insets GLOBAL_PADDING = new Insets(10, 10, 10, 10); 

    // Instance Elements
    private JButton addentrybutton;
    private JList list;
    private JScrollPane scrollpane;
    private JTextField enterdatefield, enterperiodfield, enterusagefield;
    private Table table;

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
    // public void setScrollPane(JScrollPane s) { this.scrollpane = s; }
    public void setEnterDateField(JTextField t) { this.enterdatefield = t; }
    public void setEnterPeriodField(JTextField t) { this.enterperiodfield = t; }
    public void setEnterUsageField(JTextField t) { this.enterusagefield = t; }
    public void setAddTable(Table t) { this.table = t; }


    // Getters
    public JButton getAddEntryButton() { return this.addentrybutton; }
    // public JScrollPane getScrollPane() { return this.scrollpane; }
    public JTextField getEnterDateField() { return this.enterdatefield; }
    public JTextField getEnterPeriodField() { return this.enterperiodfield; }
    public JTextField getEnterUsageField() { return this.enterusagefield; }
    public Table getTable() { return this.table; }

  

    // Intialize All Components 
    public void initializeComponents(){
       /* Instantiate all components of panel here */ 
       this.addentrybutton = new JButton("Add Entry");
    //    this.scrollpane = new JScrollPane();
       this.enterdatefield = new JTextField("Enter Date");
       this.enterperiodfield = new JTextField("Enter Period");
       this.enterusagefield = new JTextField("Enter Usage");
       this.table = new Table();

       // Instantiate list components
    //    String[] data = {"one","two","three","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27"}; //Test
    //    this.list = new JList(data); //Test
    //    this.scrollpane = new JScrollPane(this.list); //Test
    }

    // Intializes Preferences for each Component 
    public void intializeComponentPreferences(){
        /* Component Preferences */ 
        // this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // this.list.setLayoutOrientation(JList.VERTICAL);
        // this.list.setVisibleRowCount(-1);
    }

    // Initializes Constraints for GridBag Layout 
    public void intializeConstraints(){

        

        // Add Entry Button constraints
        setButtonConstraints(this.addentrybutton, 0, 0, null, GLOBAL_PADDING);

        // All Text Field Constraints
        setTextFieldConstraints(this.enterdatefield, 4, 1, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.enterperiodfield, 4, 2, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.enterusagefield, 4, 3, DIMENSION_TEXTFIELD, GLOBAL_PADDING);

        setTableConstraints(this.table, 1, 1, GLOBAL_PADDING);
        // Scroll Pane constraints
        // setScrollPaneConstraints(this.scrollpane, 1, 1, DIMENSION_SCROLL_PANE, GLOBAL_PADDING);

    }

}