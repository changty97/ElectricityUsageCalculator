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

    private static final float RATES_DEFAULT_OFFPEAK_SUMMER_DEFAULT = (float)0.1209;
    private static final float RATES_DEFAULT_OFFPEAK_NONSUMMER_DEFAULT = (float)0.1006;
    private static final float RATES_DEFAULT_MIDPEAK_SUMMER_DEFAULT = (float)0.1671;
    private static final float RATES_DEFAULT_PEAK_SUMMER_DEFAULT = (float)0.2941;
    private static final float RATES_DEFAULT_PEAK_NONSUMMER_DEFAULT = (float)0.1388;

    // Instance Variables
    private float [] rates;

    // Default Constructor
    public Rates(boolean isSummer){
        // Always true for now

        rates = setUserRates(isSummer);
    }

    // Setters
    public void setRate(float [] r){ this.rates = r; }
    public void setRateAtIndex(float r, int i){ this.rates[i] = r; }

    // Getters
    public float [] getRates(){ return this.rates; }
    public float getRateAtIndex(int i){ return this.rates[i]; }
    public static float getOffPeakSummer(){ return RATES_DEFAULT_OFFPEAK_SUMMER;}
    public static float getMidPeakSummer(){ return RATES_DEFAULT_MIDPEAK_SUMMER;}
    public static float getPeakSummer(){ return RATES_DEFAULT_PEAK_SUMMER;}
    public static float getPeakNonSummer(){ return RATES_DEFAULT_PEAK_NONSUMMER;}
    public static float getOffPeakNonSummer(){ return RATES_DEFAULT_OFFPEAK_NONSUMMER;}


    //setters for default rates
    public void setOffPeakSummer(float value){
        RATES_DEFAULT_OFFPEAK_SUMMER = value;
    }
    public void setMidPeakSummer(float value){
        RATES_DEFAULT_MIDPEAK_SUMMER = value;
    }
    public void setPeakSummer(float value){
        RATES_DEFAULT_PEAK_SUMMER = value;
    }
    public void setPeakNonSummer(float value){
        RATES_DEFAULT_PEAK_NONSUMMER = value;
    }
    public void setOffPeakNonSummer(float value){
        RATES_DEFAULT_OFFPEAK_NONSUMMER = value;
    }

    private float[] setUserRates(boolean isSummer){
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
    // Method for setting default time values
    public static void setDefaultRates(){

        RATES_DEFAULT_OFFPEAK_SUMMER = RATES_DEFAULT_OFFPEAK_SUMMER_DEFAULT;
        RATES_DEFAULT_MIDPEAK_SUMMER = RATES_DEFAULT_MIDPEAK_SUMMER_DEFAULT;
        RATES_DEFAULT_PEAK_SUMMER = RATES_DEFAULT_PEAK_SUMMER_DEFAULT;

        RATES_DEFAULT_OFFPEAK_NONSUMMER = RATES_DEFAULT_OFFPEAK_NONSUMMER_DEFAULT;
        RATES_DEFAULT_PEAK_NONSUMMER = RATES_DEFAULT_PEAK_NONSUMMER_DEFAULT;

    }


}