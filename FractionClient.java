/*
 *  Name:        Brian Klein
 *  Date:        9/5/18
 *  Program:     FractionClient.java
 *  Description: 
 */

import java.util.*;

public class FractionClient {
    
    public static void main(String[] args) {
        
        String name = "";
        
        try {
            
            boolean flag = true;
            String command;
            Scanner console = new Scanner(System.in);
        
            System.out.println("Hello, and welcome to the FractionClient program.\n"
                + "First of all: What is your name?");
        
            name = console.next();
        
            System.out.println("Hi there " + name + "! I'm Client Program. To create \n"
                    + "a fraction I'll need you to enter a number to use as a \n"
                    + "numerator. Which number would you like to use?");
        
            int numerator = console.nextInt();
        
            System.out.println("Excellent choice " + name + "! Now, you'll also need\n"
                + "to select a denominator. Which number would you like to use?");
        
            int denominator = console.nextInt();
            
            while(denominator == 0) {
                System.out.println("Remember that denominators cannot be zero. Please\n"
                        + "try again.");
                System.out.println("Which number would you like to use?");
        
            denominator = console.nextInt();
            }
            Fraction fraction = new Fraction(numerator, denominator);
        
            System.out.println("That's perfect. Your fraction is: " 
                + fraction.getFractionAsString() + "\nNow that you are ready, I will bring you to the \n"
                + "main menu. Have fun!\n");
        
            while( flag) {
            
                displayMenu();
            
                command = console.next();
            
                switch( command ){
                    case "1":
                        System.out.println("The fraction is " + fraction.getFractionAsString());
                    
                        break;
                    
                    case "2":
                        System.out.println("The numerator is " + fraction.getNumerator());
                    
                        break;
                    case "3":
                        System.out.println("The denominator is " + fraction.getDenominator());
                    
                        break;
                    case "4":
                        System.out.println("The decimal equivalent is " + fraction.getFractionAsDecimal());
                    
                        break;
                    case "5":
                        System.out.println("OK " + name + ". For this function we \n"
                            + "will have you select another numerator and \n"
                            + "denominator for the fraction you would like to \n"
                            + "add to " + fraction.getFractionAsString() 
                            + ". What is the numerator?");
                    
                        int num2 = console.nextInt();
                    
                        System.out.println("Alright, and the denominator?");
                    
                        int denom2 = console.nextInt();
                        
                        while( denom2 == 0){
                            System.out.println("Remember that denominators cannot be zero. Please\n"
                                    + "try again.");
                            System.out.println("Which number would you like to use?");
                            
                            denom2 = console.nextInt();
                        }
                        
                        Fraction other = new Fraction(num2, denom2);
                    
                        System.out.println("When you add " + fraction.getFractionAsString()
                            + " to " + other.getFractionAsString() + " you get: " 
                            + fraction.addFraction(other));
                    
                    
                        break;
                    case "0":
                        flag = false;
                    
                        System.out.println("Thank you, "+ name + ", for using this "
                                          + "program. \nHave a wonderful day!");
                    
                    break;
                    
                    default: System.out.println("Invalid command, please try again.");
                
                }//end switch
                
            }//end while
        } catch (Exception e){
            
            System.out.println( name + ", you must have hit the wrong button, "
                    + "because that is not a number we can use. "
                    + "\nYou will have to try again.");
            
        }
        
    }//end main
    
    private static void displayMenu() {
        
        System.out.print("\n\n"
            + "1 -- Report fraction\n"
            + "2 -- Report numerator\n"
            + "3 -- Report denominator\n"
            + "4 -- Report decimal equivalent\n"
            + "5 -- Add two fractions together\n"
            + "0 -- Exit\n\n"
            + "Enter Command:");
        
    }//end displayMenu
    
}//end class