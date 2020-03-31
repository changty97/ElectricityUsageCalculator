// Main package import
package edu.csus.csc131.euc;

//Framework imports
import javax.swing.JButton;

public class UIButton extends UIwindow{

    private static final long serialVersionUID = 4L;
    // Instance variable
    JButton button;

    //variables for buttons




    //constructor
    public UIButton(String t, int w, int h) {
        super(t, w, h);
    }

    public void initializeButton(){

        //create button
        this.button = new JButton(this.title);

        //set size
        button.setSize(this.width, this.height);



    }



}