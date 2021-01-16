/*
 *  Name:        Brian Klein
 *  Date:        9/5/18
 *  Program:     Fraction.java
 *  Description: 
 */

public class Fraction implements FractionInterface{
    
    private int numerator, denominator;

    public Fraction() {
    
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public int getNumerator() {    
        return this.numerator;
    }
    
    public int getDenominator() {
        return this.denominator;
    }
    
    public double getFractionAsDecimal() {
        double decimal;
        decimal = (double)numerator / denominator;
        return decimal;
    }
    
    public String getFractionAsString() {
        
        String fractionAsString = numerator + "/" + denominator;
        
        return fractionAsString;
    }
    
    public int getGCD(int m, int n) {
        
        int temp, r, result = 1;
        
        m = Math.abs( m );
        n = Math.abs( n );
        
        if(m == n) {
            return m;
        } 
        if (m < n) {
            temp = m;
            m = n;
            n= temp;
        }
        
        while(true) {
            r = m % n;
            
            if( r != 0) {
                m = n;
                n=r;
            } else {
                return n;
            }
        }//end while
        
    }//end getGCD method
    
    public String addFraction( Fraction other) {
        
        int n1, n2, d1, d2, resultN, resultD, gcd;
        Fraction result;
        
        n1 = this.numerator;
        d1 = this.denominator;
        n2 = other.numerator;
        d2 = other.denominator;
        
        resultN = n1 * d2 + n2 * d1;
        resultD = d1 * d2;
        
        gcd = getGCD(resultN, resultD);
        
        result = new Fraction( resultN/gcd, resultD/gcd);
        
        return result.getFractionAsString();
        
    }
    
}
