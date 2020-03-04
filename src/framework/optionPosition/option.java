/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.optionPosition;

/**
 *
 * @author alexg
 */
public interface option {
    
    
    /**
     * Creates a putOption with given characteristics
     * 
     * This is a static method with a default implementation.
     * 
     * @param isLong describes if the option is a long or short position, true means long
     * @param ticker ticker symbol of the underlying stock
     * @param strike is the strike price of the option
     * @param exp is the expiration date of the option
     * @param avgPrice is the average price per share for the single contract
     * @throws optionException is any of the parameters are invalid
     * @return the created put option
     */
    static option createPut(boolean isLong, String ticker, double strike, String exp, double avgPrice) {
        return new putOption(isLong, ticker, strike, exp, avgPrice);
    } 
    
    /**
     * Creates a callOption with given characteristics
     * 
     * This is a static method with a default implementation.
     * 
     * @param isLong describes if the option is a long or short position, true means long
     * @param ticker ticker symbol of the underlying stock
     * @param strike is the strike price of the option
     * @param exp is the expiration date of the option
     * @param avgPrice is the average price per share for the single contract
     * @throws optionException is any of the parameters are invalid
     * @return the created call option
     */
    static option createCall(boolean isLong, String ticker, double strike, String exp, double avgPrice) {
        return new callOption(isLong, ticker, strike, exp, avgPrice);
    }
    
    /*
    *Creates a one line string containing all the data about the option as it would be seen on a brokerage's application
    *@return a string detailing the option
    */
    @Override 
    String toString();
    
    
    
    
    
}
