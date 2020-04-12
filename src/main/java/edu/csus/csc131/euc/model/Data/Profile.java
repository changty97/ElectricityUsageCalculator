/* PACKAGE PATH */ 
package edu.csus.csc131.euc.model.data;

// ----------------------------------------- //
// Profile Class: Sets up user profile       //
// ----------------------------------------- //

public class Profile {

    // Instance Variables for Profile 
    private int userid;
    private float totalcost; 
    private Usage usage; 
    private Rates rates; 

    // Constructor for the profile class 
    public Profile(int id){
        this.userid = id;  
        this.rates = new Rates(true);
        this.usage = new Usage(); 
    }

    // Setters 
    public void setProfileID(int id){ this.userid = id; };
    public void setProfileUsage(Usage u){ this.usage = u; };
    public void setProfileRates(Rates r){ this.rates = r;};
    
    // Getters 
    public int getProfileID(){ return this.userid; };
    public Usage getProfileUsage(){ return this.usage; };
    public Rates getProfileRates(){ return this.rates; };
    public float getTotalCost(){ return this.totalcost; }

    /* Functions for Profile Class */

    // This function initializes usage specific for the profile 
    public void setProfileUsage(float d, int h){
        this.usage.setUsageAtIndex(d, h);
    }

    // This function sets up the rates specific for the Profile
    public void setProfileRates(float d, int h){
        this.rates.setRateAtIndex(d, h); 
    }

    // This function returns the calculated results KWH 
    public float calculateKWH(){ 
        this.totalcost = 0;
        for (int i = 0; i < 24; i++){ 
            totalcost += usage.getUsageAtIndex(i) * rates.getRateAtIndex(i); 
        }
        return this.totalcost; 
    }


}