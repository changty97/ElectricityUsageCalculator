/*README
    Make sure to add this to POM file
*/

// Main package import
package edu.csus.csc131.euc;

// Framework Imports
import javax.swing.JFrame;

public class UIwindow{
    // Instance variables
    JFrame window;

    // Variables for window creation
    String title;
    int height;
    int width;

    // Constructor for a Window
    public UIwindow(String t, int w, int h){
        this.title = t;
        this.width = w;
        this.height = h;
    }

    /* Functions of UIwindow */

    public void initializeGUI(){
        // Create set up the window
        this.window = new JFrame(this.title);

        // Set the close operation
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set Size
        this.window.setSize(this.width, this.height);

        // Show the GUI
        this.window.setVisible(true);
    }


}
