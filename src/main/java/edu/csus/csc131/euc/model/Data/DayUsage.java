package edu.csus.csc131.euc.Model.Data;

import edu.csus.csc131.euc.Model.*;

public class DayUsage {

  //declare field variables
  private String date;
  private Usage usage;


  public DayUsage(){
    this.date = " ";
    this.usage = new Usage();
  }

  public DayUsage(String date, Usage usage){
    this.date = date;
    this.usage = usage;
  }

  //getters
  public String getDate(){ return date;}
  public Usage getUsage(){ return usage;}

  //setters
  public void setDate(String date){ this.date = date;}
  public void setUsage(Usage usage) {this.usage = usage;}
}