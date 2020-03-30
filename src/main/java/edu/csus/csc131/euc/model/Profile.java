package edu.csus.csc131.euc.model;

// ----------------------------------------- //
// The Profile Class takes in the JSON file. //
// ----------------------------------------- //
public class Profile {

    private int userID;
    
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
    public void setProfile(int id) {
      this.userID = id;
    }
  
    //getter
    public int getProfile() {
      return this.userID;
    }

    //This function returns the calculated results of KWH
    public float calculated() {
      return 1.11; //dummy float
    }

    //This is for later - T14
    // public float traversalUsagePeriod(float usageArray[]) {
    //   for(int i = 0; i < usageArray.length; i++) {
    //     usageArray[i];
    //   }
    // }
  }