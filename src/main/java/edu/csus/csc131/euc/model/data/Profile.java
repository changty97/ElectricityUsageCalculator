/* PACKAGE PATH */
package edu.csus.csc131.euc.model.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

// ----------------------------------------- //
// Profile Class: Sets up user profile       //
// ----------------------------------------- //

public class Profile {

    // Instance Variables for Profile
    private int userid;
    private float totalcost;
    private ArrayList<Day> days;
    private static Rates summerRates = new Rates(true);
    private static Rates nonSummerRates = new Rates(false);

    //private Rates rates;
    private String unit, siteTimeZoneId;

    // Constructor for the profile class
    public Profile(int id){
        this.userid = id;
        days = new ArrayList<Day>();
    }

    // Setters
    public void setProfileID(int id){ this.userid = id; };
    public void addDay(Day day){ days.add(day);};
    public static void setSummerRates(Rates r){ summerRates = r; };
    public static void setNonSummerRates(Rates r){ nonSummerRates = r; };
    public void setProfileUnit(String s){ this.unit = s; };
    public void setProfileSiteTimeZoneID(String s){ this.siteTimeZoneId = s; };

    // Getters
    public int getProfileID(){ return this.userid; };
    public ArrayList<Day> getDays(){ return days;}
    public Rates getSummerRates(){ return summerRates; };
    public Rates getNonSummerRates(){ return nonSummerRates; };
    public float getTotalCost(){ return this.totalcost; };
    public String setProfileUnit(){ return unit; };
    public String setProfileSiteTimeZoneID(){ return siteTimeZoneId; };

    /* Functions for Profile Class */

    // These functions sets up the rates specific for the Profile
    public void setSummerRates(float value, int index){
        summerRates.setRateAtIndex(value, index);
    }
    public void setNonSummerRates(float value, int index){
        nonSummerRates.setRateAtIndex(value, index);
    }

    // This function returns the calculated results KWH
    public float calculateKWH(){
        this.totalcost = 0;
        Iterator<Day> iter = days.iterator();
        while(iter.hasNext()){
            Day day = iter.next();
            Rates rates;
            if(day.isSummer()){
                rates = summerRates;
            }
            else{
                rates = nonSummerRates;
            }
            for (int j = 0; j < 24; j++){
                totalcost += day.getUsage().getUsageAtIndex(j) * rates.getRateAtIndex(j);
            }
        }
        return this.totalcost;
    }

    public float getTotalUsage(){
        float total = 0;
        Iterator<Day> iter = days.iterator();
        while(iter.hasNext()){
            Day day = iter.next();
            for (int j = 0; j < 24; j++){
                total += day.getUsage().getUsageAtIndex(j);
            }
        }
        return total;
    }

    public float getTotalCostByDay(int dayIndex){
        if(days.size() == 0){
            return 0;
        }
        float sum = 0;
        Rates rates;
        if(days.get(dayIndex).isSummer()){
            rates = summerRates;
        }
        else{
            rates = nonSummerRates;
        }
        for (int i = 0; i < 24; i++){
            sum += days.get(dayIndex).getUsage().getUsageAtIndex(i) * rates.getRateAtIndex(i);
        }
        return sum;
    }

    public float getTotalUsageByDay(int dayIndex){
        if(days.size() == 0){
            return 0;
        }
        float sum = 0;
        for (int i = 0; i < 24; i++){
            sum += days.get(dayIndex).getUsage().getUsageAtIndex(i);
        }
        return sum;
    }

    public void resetToNewRates(){
        summerRates = new Rates(true);
        nonSummerRates = new Rates(false);
    }

    public void resetDefault(){
        Rates.setDefaultRates();
        summerRates = new Rates(true);
        nonSummerRates = new Rates(false);
    }

    public Day getDay(String date){
        ListIterator<Day> i = days.listIterator();
        Day d = new Day(date, true);
        while(i.hasNext()){
            Day comp = i.next();
            if(d.getDate().equals(date)){
                return comp;
            }
        }
        return null;
    }
    public void deleteRecord(String date, int index){
        ListIterator<Day> i = days.listIterator();
        while(i.hasNext()){
            Day d = i.next();
            if(d.getDate().equals(date)){
                d.setUsage(0, index);
            }
        }
    }

}