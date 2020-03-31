package edu.csus.csc131.euc.model;

public class Rates
{
    private float ratesVal[];

    //contstructor
    public Rates(){
        ratesVal = new float[24];
    }
    public Rates(float[] values){
        ratesVal = values;
    }

    //setter
    public void setRate(float rate, int index) throws ArrayIndexOutOfBoundsException, NumberFormatException {
        ratesVal[index] = rate;
    }

    //getter
    public float getRate(int index) throws ArrayIndexOutOfBoundsException, NumberFormatException {
        return ratesVal[index];
    }

}
