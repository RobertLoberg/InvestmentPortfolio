/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author lober
 */
public class MutualFund extends Investment {
           
    /**
     *set array variables
    */
    public MutualFund() {
        
        super("","",0,0.00,0.00,"");
    }

    /**
     *set array variables to given values
     * @param symbol
     * @param name
     * @param quantity
     * @param price
     * @param bookValue
     */
    public MutualFund(String symbol, String name, int quantity, double price, double bookValue, String type) {
        
        super(symbol,name,quantity,price, bookValue,type);
        
    }
    
    /**
     * Function that checks if objects are equal
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        
        if (o == this) {
            
            return true;
        }
        if (! (this.getClass().equals(o.getClass()))) {
            
            return false;
        }
 
        return super.equals(o);
    }
    
    //to sting function for output

    /**
     *sets values into a sting to be printed
     * @return
     */
    @Override
    public String toString() {
        
        return super.toString();
    }
}