/* PACKAGE PATH */ 
package edu.csus.csc131.euc.View.Panels;

/* Library Imports */
import javax.swing.*; 
import java.awt.*;

public class ManualInputPanel{

    /* Constants */
    private static final Color BACKGROUND_COLOR = Color.GREEN;
    private static final Dimension DIMENSION_TEXTFIELD = new Dimension(100, 25);
    private static final Dimension DIMENSION_SCROLL_PANE = new Dimension(200, 200);
    private static final Dimension DIMENSION_SCROLL_BAR = new Dimension(20, 200);

    /* Panel for this class */
    private JPanel panel;

    // Instance Elements
    private JButton addentrybutton;
    private JList list;
    private JScrollBar scrollbar;
    private JScrollPane scrollpane;
    private JTextField enterdatefield, enterperiodfield, enterusagefield;

    // Labels
    // Title Label temporary to denote which panel is used 
    JLabel templabel = new JLabel("This is the Manual Input Panel");

    // Constructor
    public ManualInputPanel() {
        /* Intializers for this Panel */ 
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
    public JPanel getPanel(){ return this.panel; }

    /* Functions for Manual Input Panel */ 
    // Initialize Panel 
    public void initializePanel(){
        /* Panel Initializations */
        panel = new JPanel(new GridBagLayout()); 

        // Set Panel Color
        this.panel.setBackground(BACKGROUND_COLOR);
    }

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
        /* Set Constraints for GridBagLayout for each component */ 
        GridBagConstraints c = new GridBagConstraints();

        // Set insets for each element (Left, Right, Top, Bottom)
        c.insets = new Insets(10,10,10,10);

        // Add Entry Button constraints
        c.gridx = 0; c.gridy = 0; panel.add(this.addentrybutton, c);

        // All Text Field Constraints
        this.enterdatefield.setPreferredSize(DIMENSION_TEXTFIELD);
        this.enterperiodfield.setPreferredSize(DIMENSION_TEXTFIELD);
        this.enterusagefield.setPreferredSize(DIMENSION_TEXTFIELD);
        c.gridx = 4; c.gridy = 1; panel.add(this.enterdatefield, c);
        c.gridx = 4; c.gridy = 2; panel.add(this.enterperiodfield, c);
        c.gridx = 4; c.gridy = 3; panel.add(this.enterusagefield, c);

        // Scroll Pane constraints
        this.scrollpane.setPreferredSize(DIMENSION_SCROLL_PANE);
        c.gridx = 1; c.gridy = 1; panel.add(this.scrollpane, c);

        // Scroll Bar constraints
        this.scrollbar.setPreferredSize(DIMENSION_SCROLL_BAR);
        c.gridx = 3; c.gridy = 1; panel.add(this.scrollbar, c);
    }
}