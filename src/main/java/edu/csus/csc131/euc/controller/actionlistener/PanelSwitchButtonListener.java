/* PACKAGE PATH */
package edu.csus.csc131.euc.controller.actionlistener;

/* Library Imports */
// AWT Imports 
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Swing Imports 
import javax.swing.JButton;

/* Local Imports */
// Local MVC Imports 
import edu.csus.csc131.euc.view.View;

public class PanelSwitchButtonListener implements ActionListener {

    // Instance Variables
    private View view; 

    // Button Instances 
    private JButton ib;
    private JButton mb;
    private JButton vcb;

    // Current Button 
    private JButton currentbutton; 

    private String panelname; 

    public PanelSwitchButtonListener(View v, JButton cb, String pn){
        this.view = v;
        this.panelname = pn; 
        this.currentbutton = cb;

        // Get References to All MP Buttons
        this.ib = v.getMainPanel().getImportJsonButton();
        this.mb = v.getMainPanel().getManualInputButton();
        this.vcb = v.getMainPanel().getViewCalcButton();
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout panels = (CardLayout) view.getPanels().getLayout();
        
        // Do this if Current Button is NOT Selected 
        if(!currentbutton.isSelected()){
            // Select
            currentbutton.setSelected(true); 

            // Deselect All Other Buttons
            if(currentbutton == ib){
                mb.setSelected(false); 
                vcb.setSelected(false); 
            }else if(currentbutton == mb){
                ib.setSelected(false); 
                vcb.setSelected(false);
            }else if(currentbutton == vcb){
                ib.setSelected(false); 
                mb.setSelected(false);  
            }
            // Display Panel
            panels.show(view.getPanels(), this.panelname ); 
        }
        // If Current Button is Already Selected 
        else if(currentbutton.isSelected()){
            // Deselect
            currentbutton.setSelected(false); 

            // Display Blank Screen 
            panels.show(view.getPanels(), "Blank" );
        }
    }
    
}