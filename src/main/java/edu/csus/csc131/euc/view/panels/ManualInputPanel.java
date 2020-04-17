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

    // Padding 
    private static final Insets GLOBAL_PADDING = new Insets(10, 10, 10, 10); 

    // Instance Elements
    private JButton addentrybutton;
    private JList list;
    private JScrollBar scrollbar;
    private JScrollPane scrollpane;
    private JTextField enterdatefield, enterperiodfield, enterusagefield;

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
    public void setEnterPeriodField(JTextField t) { this.enterperiodfield = t; }
    public void setEnterUsageField(JTextField t) { this.enterusagefield = t; }

    // Getters
    public JButton getAddEntryButton() { return this.addentrybutton; }
    public JScrollBar getScrollBar() { return this.scrollbar; }
    public JScrollPane getScrollPane() { return this.scrollpane; }
    public JTextField getEnterDateField() { return this.enterdatefield; }
    public JTextField getEnterPeriodField() { return this.enterperiodfield; }
    public JTextField getEnterUsageField() { return this.enterusagefield; }

  

    // Intialize All Components 
    public void initializeComponents(){
       /* Instantiate all components of panel here */ 
       this.addentrybutton = new JButton("Add Entry");
       this.scrollbar = new JScrollBar(JScrollBar.VERTICAL,0,100,0,255);
       this.scrollpane = new JScrollPane();
       this.enterdatefield = new JTextField("Enter Date");
       this.enterperiodfield = new JTextField("Enter Period");
       this.enterusagefield = new JTextField("Enter Usage");

       // Instantiate list components
       String[] data = {"one","two","three"}; //Test
       this.list = new JList(data); //Test
       this.scrollpane = new JScrollPane(this.list); //Test
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
        setTextFieldConstraints(this.enterperiodfield, 4, 2, DIMENSION_TEXTFIELD, GLOBAL_PADDING);
        setTextFieldConstraints(this.enterusagefield, 4, 3, DIMENSION_TEXTFIELD, GLOBAL_PADDING);

        // Scroll Pane constraints
        setScrollPaneConstraints(this.scrollpane, 1, 1, DIMENSION_SCROLL_PANE, GLOBAL_PADDING);

        // Scroll Bar constraints
        setScrollBarConstraints(this.scrollbar, 3, 1, DIMENSION_SCROLL_BAR, GLOBAL_PADDING);
    }
}