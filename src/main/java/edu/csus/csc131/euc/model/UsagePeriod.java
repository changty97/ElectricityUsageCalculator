package edu.csus.csc131.euc.model;

public class UsagePeriod{

  //default number of timeslots
  public static final int SIZE = 24;

  private float usage[];

  //constructor
  public UsagePeriod(){
    usage = new float[SIZE];
  }

  //setter
  public void setUsage(float value, int index) throws ArrayIndexOutOfBoundsException, NumberFormatException{
    usage[index] = value;
  }

  //getter
  public float getUsage(int index) throws ArrayIndexOutOfBoundsException, NumberFormatException{
    return usage[index];
  }
}