package framework.optionPosition;

/**                                                                                                                                                                                           
 * A class for handling matrix exceptions, including row or column indices                                                                                                                    
 * that are out of bounds, attempting to add or multiply matrices of incorrect                                                                                                                
 * dimensions, and other situations.                                                                                                                                                          
 * @author tcolburn                                                                                                                                                                           
 */
public class optionException extends RuntimeException {

    public optionException() {}

    /**                                                                                                                                                                                       
     * Creates a matrix exception object.                                                                                                                                                     
     * @param reason the reason for the exception                                                                                                                                             
     */
    public optionException(String reason) {
        super(reason);
    }

}