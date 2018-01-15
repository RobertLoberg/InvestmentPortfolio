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
public class InvalidInvestmentInputException extends Exception 
{
    /**
     * Constructor for exception
     */
    public InvalidInvestmentInputException() {
        
        super("Invalid input.");
    }
    
    /**
     * Constructor for exception
     * @param message - Calls output message
     */
    public InvalidInvestmentInputException(String message) {
    
        super(message);
    }
}
