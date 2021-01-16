/*
 *  Name:        Brian Klein
 *  Date:        9/5/18
 *  Program:     FractionInterface.java
 *  Description: 
 */

public interface FractionInterface {
    
    public int getNumerator();
    
    public int getDenominator();
    
    public double getFractionAsDecimal();
    
    public String getFractionAsString();
    
    public String addFraction(Fraction other);
    
}
