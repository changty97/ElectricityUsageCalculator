/* PACKAGE PATH */
package edu.csus.csc131.euc.model.data;

import java.util.ArrayList;
import java.util.Iterator;

// ----------------------------------------- //
// Profile Class: Sets up user profile       //
// ----------------------------------------- //

public class Profile {

    // Instance Variables for Profile
    private int userid;
    private float totalcost;
    private ArrayList<Day> days;
    private Rates rates;
    private String unit, siteTimeZoneId;

    // Constructor for the profile class
    public Profile(int id){
        this.userid = id;
        this.rates = new Rates(true);
        days = new ArrayList<Day>();
    }

    // Setters
    public void setProfileID(int id){ this.userid = id; };
    public void addDay(Day day){ days.add(day);};
    public void setProfileRates(Rates r){ this.rates = r; };
    public void setProfileUnit(String s){ this.unit = s; };
    public void setProfileSiteTimeZoneID(String s){ this.siteTimeZoneId = s; };

    // Getters
    public int getProfileID(){ return this.userid; };
    public ArrayList<Day> getDays(){ return days;}
    public Rates getProfileRates(){ return this.rates; };
    public float getTotalCost(){ return this.totalcost; };
    public String setProfileUnit(){ return unit; };
    public String setProfileSiteTimeZoneID(){ return siteTimeZoneId; };

    /* Functions for Profile Class */

    // This function sets up the rates specific for the Profile
    public void setProfileRates(float d, int h){
        this.rates.setRateAtIndex(d, h);
    }

    // This function returns the calculated results KWH
    public float calculateKWH(){
        this.totalcost = 0;
        Iterator<Day> iter = days.iterator();
        while(iter.hasNext()){
            Day day = iter.next();
            for (int j = 0; j < 24; j++){
                totalcost += day.getUsage().getUsageAtIndex(j) * rates.getRateAtIndex(j);
            }
        }
        return this.totalcost;
    }


}