package edu.csus.csc131.euc.model.data;

public class Day {

  private String date;
  private Usage usage;

  public Day(String date){
    this.date = date;
    this.usage = new Usage();
  }

  //getters

  public String getDate(){
    return date;
  }

  public Usage getUsage(){
    return usage;
  }

  //setters

  public void setDate(String date){
    this.date = date;
  }

  // This function initializes usage specific for the profile
  public void setUsage(float value, int index){
    usage.setUsageAtIndex(value, index);
  }
}