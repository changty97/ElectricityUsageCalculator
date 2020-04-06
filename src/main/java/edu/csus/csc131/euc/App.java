/* PACKAGE PATH */
package edu.csus.csc131.euc;
import java.util.Arrays;
import javax.swing.JFrame;

/* Local Imports */
import edu.csus.csc131.euc.View.*;
import edu.csus.csc131.euc.Model.*; 
import edu.csus.csc131.euc.Controller.*; 

public class App {

    public static void main(String [] args){

        Model m = new Model(1);
        View v = new View();
        Controller c = new Controller(m , v); 
        c.createAndShowGUI();

    }

}