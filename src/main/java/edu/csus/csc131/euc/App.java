/* PACKAGE PATH */
package edu.csus.csc131.euc;

/* Local Imports */
import edu.csus.csc131.euc.View.View;
import edu.csus.csc131.euc.Model.Model; 
import edu.csus.csc131.euc.Controller.Controller; 

public class App {

    public static void main(String [] args){

        Model m = new Model(1);
        View v = new View();
        Controller c = new Controller(m , v); 
        c.createAndShowGUI();

    }

}