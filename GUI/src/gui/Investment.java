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
public class Investment {
    
    //declare array variables
    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double bookValue;
    private String type;
    
    /**
     * Function to set array values to given variables
     * @param symbol
     * @param name
     * @param quantity
     * @param price
     * @param bookValue
     * @param type 
     */
    public Investment(String symbol, String name, int quantity, double price, double bookValue, String type) {
        
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.bookValue = bookValue;
        this.type = type;
    }
    
    /**
     * Function that sets values for the objects in the array
     */
    public Investment() {
        
        this.symbol = "";
        this.name = "";
        this.quantity = 0;
        this.price = 0.00;
        this.bookValue = 0.00;
        this.type = "";
    }
    
    /**
     * Function that checks if objects are the same
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        
        if (!(o instanceof Investment)) {
            
            return false;
        }
        else {
            
            Investment b = (Investment) o;
            
            if (!(this.getSymbol().equals(b.getSymbol()))) {
                
                return false;
            }
            
            if (!(this.getName().equals(b.getName()))) {
                
                return false;
            }
            
            if (!(this.getQuantity() == b.getQuantity())) {
                
                return false;
            }
            
            if (!(this.getPrice() == b.getPrice())) {
                
                return false;
            }
            
            if (!(this.getBookValue() == b.getBookValue())) {
                
                return false;
            }
            
            if (!(this.getType().equals(b.getType()))) {
                
                return false;
            }
            return true;
        }
    }
    
    /**
     * Function that outputs data in the array
     * @return 
     */
    @Override
    public String toString() {
        
        return symbolString() + ", " + nameString() + ", " + quantityInt() + ", " + priceDouble() + bookValueDouble();
    }
    
    //call the array variables in different ways

    /**
     *returns instance of symbol
     * @return
     */
    public String symbolString() {
        
        return this.symbol;
    }
    
    /**
     *returns instance of name
     * @return
     */
    public String nameString() {
        
        return this.name;
    }
    
    /**
     *returns instance of quantity
     * @return
     */
    public int quantityInt() {
        
        return this.quantity;
    }
    
    /**
     *returns instance of price
     * @return
     */
    public double priceDouble() {
        
        return this.price;
    }
    
    /**
     *returns symbol string
     * @return
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     *returns name string
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *gives quantity value
     * @return
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     *gives price value
     * @return
     */
    public double getPrice() {
        return price;
    }
    
    /**
     *returns the instance of book value
     * @return
     */
    public double bookValueDouble() {
        
        return this.bookValue;
    }
    

    /**
     *gives bookValue value
     * @return
     */
    public double getBookValue() {
        return bookValue;
    }
    
    /**
     *returns the instance of type value
     * @return
     */
    public String typeString() {
        
        return this.type;
    }
    

    /**
     *gives type value
     * @return
     */
    public String getType() {
        
        return type;
    }
    
    /**
     *sets book value
     * @param bookValue value to set
     */
    public void setBookValue(double bookValue ) {
        
        this.bookValue = bookValue;
    }
    
    /**
     *sets quantity
     * @param quantity value to set
     */
    public void setQuantity(int quantity ) {
        
        this.quantity = quantity;
    }
    
    /**
     *sets price
     * @param price value to set
     */
    public void setPrice(double price ) {
        
        this.price = price;
    }
}
