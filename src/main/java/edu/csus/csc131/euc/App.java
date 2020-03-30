package edu.csus.csc131.euc;

public class App 
{
    // Static Main window for application 
    static UIwindow mainwindow = new UIwindow("Main Window", 800, 800);

    // Initializing the main GUI for application
    public static void initializeGUI() {

        // Main Window initialization
        mainwindow.initializeWindow();

        // Other intializations for UI elements ... 

    }

    public static void main( String[] args )
    {
        // intialize the GUI 
        initializeGUI(); 
    }
}