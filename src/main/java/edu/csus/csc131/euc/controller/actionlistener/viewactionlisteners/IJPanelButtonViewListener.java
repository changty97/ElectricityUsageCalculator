/* PACKAGE PATH */
package edu.csus.csc131.euc.controller.actionlistener.viewactionlisteners; 

/* Library Imports */
// AWT Imports 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// IO Imports 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// Swing Imports 
import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/* Local Imports */
// Local MVC Imports 
import edu.csus.csc131.euc.view.View;

public class IJPanelButtonViewListener implements ActionListener{
    // Instance variable of the view 
    private View view; 

    // For Browse button Purposes 
    private File file; 
    
    public IJPanelButtonViewListener(View v){ this.view = v; }

    @Override
    public void actionPerformed(ActionEvent e) {
        // If Selected 
        if(!((AbstractButton)e.getSource()).isSelected())
        {
            // Set it to true 
            ((AbstractButton)e.getSource()).setSelected(true); 
        }

        // If the button being selected is the browse button then find file and display it 
        if( ((AbstractButton)e.getSource()) == view.getImportPanel().getBrowseButton() ){
            JFileChooser chooser = new JFileChooser();

            chooser.setAcceptAllFileFilterUsed(false);
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Locat JSON to import");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setMultiSelectionEnabled(false);
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON File", "json"));

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
                System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
                System.out.println("getSelectedFile(): "+ chooser.getSelectedFile());
                System.out.println("getAbsolutePath(): "+ file.getAbsolutePath());

                // Set new import field text
                view.getImportPanel().getImportField().setText("" + chooser.getSelectedFile());
            } else {
                System.out.println("No Selection ");
                file = null;
            }
        }
    }
}