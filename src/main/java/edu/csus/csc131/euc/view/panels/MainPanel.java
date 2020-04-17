/* PACKAGE PATH */ 
package edu.csus.csc131.euc.view.panels;

/* Library Imports */ 
import javax.swing.*; 
import java.awt.*; 

public class MainPanel extends Panel {
    /* CONSTANTS */ 
    // Size per Element 
    private final Dimension PANEL_SIZE = new Dimension(427, 817); 
    private final Dimension BUTTON_SIZE = new Dimension(427, 60); 
    private final Dimension LOGO_BG_SIZE = new Dimension(427, 175);

    // Padding per Element 
    private final Insets BUTTON_PADDING = new Insets(0, 0, 0, 0); 
    private final Insets TITLE_PADDING = new Insets(90, 15, 160, 15);
    private final Insets LOGO_PADDING = new Insets(142, 0, 0, 0);

    // Padding inside Button 
    private final Insets BUTTON_INNER_PADDING = new Insets(0, 50, 0, 50 ); 


    /* Elements for the Main Frame */
    private JButton importjsonbutton, manualinputbutton, viewcalcbutton;

    /* Labels */ 
    private JLabel titleapp; 

    /* Logo Image */ 
    JLabel logo = new JLabel(new ImageIcon("src\\main\\assets\\mainpanelres\\Logo.png"));

    // Constructor 
    public MainPanel(){ 
        /* Setting attributes for this Panel */ 
        setBackgroundColor(2, 29, 62);
        setPanelSize(PANEL_SIZE); 

        /* Initializers */ 
        initializePanel(); 
        initializeComponents(); 
        intializeConstraints(); 
    }

    // Getters
    public JButton getImportJsonButton(){ return this.importjsonbutton; }
    public JButton getManualInputButton(){ return this.manualinputbutton; }
    public JButton getViewCalcButton(){ return this.viewcalcbutton; }

    /* Functions for Main Panel */ 

    // Intialize All Components 
    public void initializeComponents(){
        /* Instantiate all components of panel here */ 
        // Instantiate Buttons
        this.importjsonbutton = new JButton("Add File", new ImageIcon("src\\main\\assets\\mainpanelres\\ImportJSON Icon.png") ); 
        this.manualinputbutton = new JButton("Enter Usage", new ImageIcon("src\\main\\assets\\mainpanelres\\Manual Input Icon.png") ); 
        this.viewcalcbutton = new JButton("View & Calculate", new ImageIcon("src\\main\\assets\\mainpanelres\\Calculate Icon.png")); 

        // Instantiate Labels
        this.titleapp = new JLabel("Electricity Usage Calculator"); 
        this.titleapp.setFont(new Font("Poppins", Font.PLAIN, 20));
        this.titleapp.setForeground(Color.WHITE); 
    }

    // Initializes Constraints for GridBag Layout 
    public void intializeConstraints(){

        // Import JSON Button constraints 
        setButtonConstraints(this.importjsonbutton, 0, 1, BUTTON_SIZE, BUTTON_PADDING);        

        /* IMPORT JSON BUTTON ATTRIBUTES */ 
        // Set gap between icon and text 
        importjsonbutton.setIconTextGap(45);

        // Set alignment of text 
        importjsonbutton.setHorizontalAlignment(SwingConstants.LEFT);

        // Set padding within the button 
        importjsonbutton.setMargin(BUTTON_INNER_PADDING); 

        // Sets the font and color
        importjsonbutton.setFont(new Font("Poppins", Font.PLAIN, 20));
        importjsonbutton.setForeground(Color.WHITE);

        // Removes Focus Border
        importjsonbutton.setFocusPainted(false); 
        importjsonbutton.setRolloverIcon(new ImageIcon("src\\main\\assets\\mainpanelres\\selection.png") );

        // Set opacity of button 
        importjsonbutton.setOpaque(true);
        importjsonbutton.setContentAreaFilled(false);
        importjsonbutton.setBorderPainted(false);

        // Manual Input Button constraints 
        setButtonConstraints(this.manualinputbutton, 0, 2, BUTTON_SIZE, BUTTON_PADDING);

        /* MANUAL INPUT BUTTON ATTRIBUTES */ 
        // Set gap between icon and text 
        manualinputbutton.setIconTextGap(40);

        // Set padding within the button 
        manualinputbutton.setMargin(BUTTON_INNER_PADDING); 

        // Set alignment of text 
        manualinputbutton.setHorizontalAlignment(SwingConstants.LEFT);

        // Sets the font and color
        manualinputbutton.setFont(new Font("Poppins", Font.PLAIN, 20));
        manualinputbutton.setForeground(Color.WHITE);

        // Removes Focus Border
        manualinputbutton.setFocusPainted(false); 
        manualinputbutton.setRolloverIcon(new ImageIcon("src\\main\\assets\\mainpanelres\\selection.png") );

        // Set opacity of button 
        manualinputbutton.setOpaque(true);
        manualinputbutton.setContentAreaFilled(false);
        manualinputbutton.setBorderPainted(false);

        // View Calculate Button constraints 
        setButtonConstraints(this.viewcalcbutton, 0, 3, BUTTON_SIZE, BUTTON_PADDING);

        /* VIEW CALCULATE BUTTON ATTRIBUTES */ 
        // Set gap between icon and text 
        viewcalcbutton.setIconTextGap(50);

        // Set alignment of text 
        viewcalcbutton.setHorizontalAlignment(SwingConstants.LEFT);

        // Set padding within the button 
        viewcalcbutton.setMargin(BUTTON_INNER_PADDING); 

        // Sets the font and color
        viewcalcbutton.setFont(new Font("Poppins", Font.PLAIN, 20));
        viewcalcbutton.setForeground(Color.WHITE);

        // Removes Focus Border
        viewcalcbutton.setFocusPainted(false); 
        viewcalcbutton.setRolloverIcon(new ImageIcon("src\\main\\assets\\mainpanelres\\selection_calculate.png") );

        // Set opacity of button 
        viewcalcbutton.setOpaque(true);
        viewcalcbutton.setContentAreaFilled(false);
        viewcalcbutton.setBorderPainted(false);

        // titleapp Label constraints 
        setLabelConstraints(titleapp, 0, 0, null, TITLE_PADDING);

        /* TITLE APP LABEL ATTRIBUTES */ 
        // Set Font and Size 
        titleapp.setFont(new Font("Poppins", Font.BOLD, 30));

        // Label for Bottom Of Main Panel 
        setLabelConstraints(logo, 0, 4, LOGO_BG_SIZE, LOGO_PADDING);

        /* LOGO LABEL ATTRIBUTES */ 
        // Set Background color for Logo 
        logo.setBackground(new Color(23, 104, 172));
        logo.setOpaque(true); 

    }


}
