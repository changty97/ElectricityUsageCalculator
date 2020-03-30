/* Refactored by extending */ 

// Main package import
package edu.csus.csc131.euc;

// Framework Imports
import javax.swing.JFrame;

public class UIwindow extends JFrame{
    // Serial Verison ID 
    private static final long serialVersionUID = 1L; 

    // Instance Variables 
    String title; 
    int height; 
    int width;

    // Specific constructor for this window 
    UIwindow(String t, int h, int w){
        this.title = t; 
        this.height = h;
        this.width = w; 
    }

    // Initialize window with necessary parameters 
    public void initializeWindow(){ 
        // Frame Components 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(this.title);
        this.setSize(this.height, this.width);
        this.setVisible(true);
    }
}