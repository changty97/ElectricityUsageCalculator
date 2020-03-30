package edu.csus.csc131.euc;

/**
 * Hello world!
 *
 */

public class Rates 
{
    private float ratesVal;

    //contstructor
    public Rates(float rate){
        this.ratesVal = rate;
    }

    //setter
    public void setRates(float rate) throws NumberFormatException {
        this.ratesVal = rate;
    }

    //getter
    public float getRates(float rate) throws NumberFormatException {
        return this.ratesVal;
    }

}
