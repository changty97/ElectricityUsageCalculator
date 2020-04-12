/* PACKAGE PATH */
package edu.csus.csc131.euc.controller;

import java.awt.CardLayout;
/* Library Imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/* import java.nio.file.Files;
import java.util.Date;
import java.util.Iterator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;*/
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/* Local Imports */
import edu.csus.csc131.euc.view.View;
import edu.csus.csc131.euc.model.Model;
import edu.csus.csc131.euc.libraries.simple.JSONArray;
import edu.csus.csc131.euc.libraries.simple.JSONObject;
import edu.csus.csc131.euc.libraries.simple.parser.JSONParser;
import edu.csus.csc131.euc.libraries.simple.parser.ParseException;



class actionListener implements ActionListener { 

    private String title;
    private View view;

    public actionListener(String title, View v) {
        this.title = title;
        this.view = v;
    }

    //Setters
    public void setTitle(String title) {this.title = title; }
    public void setView(View v) { this.view = v; }

    // //Getters
    public String getTitle() {return this.title; }
    public View getView() { return this.view; }

    public void actionPerformed(ActionEvent e) {
        CardLayout panels = (CardLayout) view.getPanels().getLayout();
        panels.show(view.getPanels(), this.title); 
    }
}