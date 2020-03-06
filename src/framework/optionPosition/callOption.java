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
public class callOption implements option {
    
    private boolean isLong;
    private String ticker;
    private double strike;
    private String expiration;
    private double averagePrice;
    private double breakEven;
    
    /**
     * Creates a callOption with given characteristics
     * 
     * 
     * @param cIsLong describes if the option is a long or short position, true means long
     * @param cTicker ticker symbol of the underlying stock
     * @param cStrike is the strike price of the option
     * @param cExpiration is the expiration date of the option
     * @param cAveragePrice is the average price per share for the single contract
     * @throws optionException is any of the parameters are invalid
     */
    public callOption(boolean cIsLong, String cTicker, double cStrike, String cExpiration, double cAveragePrice) {
        try {
            isLong = cIsLong;
            ticker = cTicker;
            strike = cStrike;
            expiration = cExpiration;
            averagePrice = cAveragePrice;
            breakEven = strike + averagePrice;
        } catch(Exception e) {
            throw new optionException(e.toString());
        }
        
    }
    
    @Override
    public String toString() {
        String longOrShort = isLong ? " long "  : " short ";
        return ("$" + ticker + " $" + strike + longOrShort + "call " + expiration + " expiration");
    }
    
    public void setIsLong(boolean isLongInput) {
        isLong = isLongInput;
    }
    
    public boolean getIsLong() {
        return isLong;
    }
    
    public void setExpiration(String expInput) {
        expiration = expInput;
    }
    
    public String getExpiration() {
        return expiration;   
    }
    
    public void setStrike(double inputStrike) {
        strike = inputStrike;
    }
    
    public double getStrike() {
        return strike;
    }
    
    public void setTicker(String inputTicker) {
        ticker = inputTicker;
    }
    
    public String getTicker() {
        return ticker;
    }
    
    public void setAveragePrice(double inputAveragePrice) {
        averagePrice = inputAveragePrice;
        breakEven = strike + averagePrice;
    }
    
    public double getAveragePrice() {
        return averagePrice;
    }
    
    public double getBreakEven() {
        return breakEven;
    }
}
