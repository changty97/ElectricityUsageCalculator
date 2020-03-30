package edu.csus.csc131.euc.model;

// ----------------------------------------- //
// The Profile Class takes in the JSON file. //
// ----------------------------------------- //
public class Profile {

    private int userID;
    private UsagePeriod usage;
    private Rates rates;

     //constructor initializes the User ID and throws an error if the ID does not exist
    public Profile(int id) throws Exception{
      try {
        this.userID = id;
      }
      catch(Exception e) {
        throw new Exception("Error Could not Set User ID...", e);
      }
    }

    //setter
    public void setID(int id) {
      this.userID = id;
    }

    //getter
    public int getID() {
      return this.userID;
    }
    public UsagePeriod getUsage(){
      return usage;
    }
    public Rates getRates(){
      return rates;
    }

    //This function returns the calculated results of KWH
    public float calculate() {
      float sum = 0;
      for (int i = 0; i < 24; i++){
        sum += usage.getUsage(i) * rates.getRate(i);
      }
      return sum;
    }

    //This is for later - T14
    // public float traversalUsagePeriod(float usageArray[]) {
    //   for(int i = 0; i < usageArray.length; i++) {
    //     usageArray[i];
    //   }
    // }
  }