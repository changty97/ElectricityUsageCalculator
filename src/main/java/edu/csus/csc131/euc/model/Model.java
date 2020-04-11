/* PACKAGE PATH */
package edu.csus.csc131.euc.Model;

/* Local Imports */
import edu.csus.csc131.euc.Model.Data.*;

public class Model {
    // Instance Variables handling all the models
    Profile profile;
    Usage usage;
    Rates rates;

    // Construtor for all Models
    public Model(int id){
        this.profile = new Profile(id);
        this.usage = new Usage();
        // Always true for summer for now
        this.rates = new Rates(true);
    }

    // Setters
    public void setModelProfile(Profile p){ this.profile = p; }
    public void setModelUsage(Usage u){ this.usage = u; }
    public void setModelRates(Rates r){ this.rates = r; }

    // Getters
    public Profile getModelProfile(){ return this.profile; }
    public Usage getModelUsage(){ return this.usage; }
    public Rates getModelRates(){ return this.rates; }

}