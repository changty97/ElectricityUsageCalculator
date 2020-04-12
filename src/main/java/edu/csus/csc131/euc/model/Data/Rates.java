/* PACKAGE PATH */ 
<<<<<<< HEAD
package edu.csus.csc131.euc.model.data;
=======
package edu.csus.csc131.euc.Model.Data;
>>>>>>> 83032d465435b8a494a067d40aeeac63905c6793

/* Libaray Imports */ 
import java.util.Arrays;

// ----------------------------------------- //
// Rates Class: Contains rates               //
// ----------------------------------------- //

public class Rates {

    // Constants 
    private static final int HOURS = 24; 
    private static final float RATES_DEFAULT_OFFPEAK_SUMMER = (float)0.1209;
    private static final float RATES_DEFAULT_OFFPEAK_NONSUMMER = (float)0.1006;
    private static final float RATES_DEFAULT_MIDPEAK_SUMMER = (float)0.1671;
    private static final float RATES_DEFAULT_PEAK_SUMMER = (float)0.2941;
    private static final float RATES_DEFAULT_PEAK_NONSUMMER = (float)0.1388;

    // Instance Variables 
    private float [] rates;

    // Default Constructor 
    public Rates(boolean isSummer){
        // Always true for now 
        isSummer = true; 

        rates = setDefaultRates(isSummer); 
    }

    // Setters
    public void setRate(float [] r){ this.rates = r; }
    public void setRateAtIndex(float r, int i){ this.rates[i] = r; }

    // Getters
    public float [] getRates(){ return this.rates; }
    public float getRateAtIndex(int i){ return this.rates[i]; }

    // Method for detting default rate values 
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

}