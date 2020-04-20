/* PACKAGE PATH */
package edu.csus.csc131.euc.model.data;

/* Libaray Imports */
import java.util.Arrays;

// ----------------------------------------- //
// Rates Class: Contains rates               //
// ----------------------------------------- //

public class Rates {

    // Constants
    private static final int HOURS = 24;
    //removed final property
    private static float RATES_DEFAULT_OFFPEAK_SUMMER = (float)0.1209;
    private static float RATES_DEFAULT_OFFPEAK_NONSUMMER = (float)0.1006;
    private static float RATES_DEFAULT_MIDPEAK_SUMMER = (float)0.1671;
    private static float RATES_DEFAULT_PEAK_SUMMER = (float)0.2941;
    private static float RATES_DEFAULT_PEAK_NONSUMMER = (float)0.1388;

    // Instance Variables
    private float [] rates;
    private String [] startTime;
    private String [] endTime;

    // Default Constructor
    public Rates(boolean isSummer){
        // Always true for now
        isSummer = true;

        rates = setDefaultRates(isSummer);
        startTime = setDefaultTime();
        endTime = setDefaultTime();
    }

    // Setters
    public void setRate(float [] r){ this.rates = r; }
    public void setEndTime(String [] r){ this.endTime = r; }
    public void setStartTime(String [] r){ this.startTime = r; }
    public void setRateAtIndex(float r, int i){ this.rates[i] = r; }
    public void setEndTimeAtIndex(String r, int i){ this.endTime[i] = r; }
    public void setStartTimeAtIndex(String r, int i){ this.startTime[i] = r; }

    // Getters
    public float [] getRates(){ return this.rates; }
    public String [] getEndTime(){ return this.endTime; }
    public String [] getStartTime(){ return this.startTime; }
    public float getRateAtIndex(int i){ return this.rates[i]; }
    public String getEndTimeAtIndex(int i){ return this.endTime[i]; }
    public String getStartTimeAtIndex(int i){ return this.startTime[i]; }
    public static float getOffPeakSummer(){ return RATES_DEFAULT_OFFPEAK_SUMMER;}
    public static float getMidPeakSummer(){ return RATES_DEFAULT_MIDPEAK_SUMMER;}
    public static float getPeakSummer(){ return RATES_DEFAULT_PEAK_SUMMER;}
    public static float getPeakNonSummer(){ return RATES_DEFAULT_PEAK_NONSUMMER;}
    public static float getOffPeakNonSummer(){ return RATES_DEFAULT_OFFPEAK_NONSUMMER;}


    //setters for default rates
    public static void setOffPeakSummer(float value){
        RATES_DEFAULT_OFFPEAK_SUMMER = value;
    }
    public static void setMidPeakSummer(float value){
        RATES_DEFAULT_MIDPEAK_SUMMER = value;
    }
    public static void setPeakSummer(float value){
        RATES_DEFAULT_PEAK_SUMMER = value;
    }
    public static void setPeakNonSummer(float value){
        RATES_DEFAULT_PEAK_NONSUMMER = value;
    }
    public static void setOffPeakNonSummer(float value){
        RATES_DEFAULT_PEAK_NONSUMMER = value;
    }

    // Method for setting default time values
    private float [] setDefaultRates(boolean isSummer){
        float temp[] = new float[HOURS];
        if(isSummer){
            Arrays.fill(temp, 0, 11, RATES_DEFAULT_OFFPEAK_SUMMER);
            Arrays.fill(temp, 12, 16, RATES_DEFAULT_MIDPEAK_SUMMER);
            Arrays.fill(temp, 17, 19, RATES_DEFAULT_PEAK_SUMMER);
            Arrays.fill(temp, 20, 23, RATES_DEFAULT_MIDPEAK_SUMMER);
        }else{
            Arrays.fill(temp, 0, 15, RATES_DEFAULT_OFFPEAK_NONSUMMER);
            Arrays.fill(temp, 16, 19, RATES_DEFAULT_PEAK_NONSUMMER);
            Arrays.fill(temp, 20, 23, RATES_DEFAULT_OFFPEAK_NONSUMMER);
        }

        return temp;
    }

    // Method for setting the default time values
    private String [] setDefaultTime(){
        String temp[] = new String[HOURS];
        Arrays.fill(temp, 0, 23, "");
        return temp;
    }

}