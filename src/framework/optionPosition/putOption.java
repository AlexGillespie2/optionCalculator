/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.optionPosition;


/**
 *
 * Class that implements the option interface
 * 
 * 
 * 
 * @author alexg
 */
public class putOption implements option {
    
    private boolean isLong;
    private String ticker;
    private double strike;
    private String expiration;
    private double averagePrice;
    private double breakEven;
    
    /**
     * Creates a putOption with given characteristics
     * 
     * 
     * @param pIsLong describes if the option is a long or short position, true means long
     * @param pTicker ticker symbol of the underlying stock
     * @param pStrike is the strike price of the option
     * @param pExpiration is the expiration date of the option
     * @param pAveragePrice is the average price per share for the single contract
     * @throws optionException is any of the parameters are invalid
     */
    public putOption(boolean pIsLong, String pTicker, double pStrike, String pExpiration, double pAveragePrice) {
        try {
            isLong = pIsLong;
            ticker = pTicker;
            strike = pStrike;
            expiration = pExpiration;
            averagePrice = pAveragePrice;
            breakEven = strike - averagePrice;
        } catch(Exception e) {
            throw new optionException(e.toString());
        }
        
    }
    
    @Override
    public String toString() {
        return (ticker + " $" + strike + " call " + expiration);
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
        breakEven = strike - averagePrice;
    }
    
    public double getAveragePrice() {
        return averagePrice;
    }
    
    public double getBreakEven() {
        return breakEven;
    }
    
}
