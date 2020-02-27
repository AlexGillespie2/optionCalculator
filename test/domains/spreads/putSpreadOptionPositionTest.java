/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.spreads;

import org.junit.Test;
import static org.junit.Assert.*;
import framework.optionPosition.*;

//testing github

/**
 *
 * @author alexg
 */
public class putSpreadOptionPositionTest {
    
    public putSpreadOptionPositionTest() {
    }

    @Test
    public void testSomeMethod() {
        putSpreadOptionPosition bullPutSpread = new putSpreadOptionPosition(new putOption(false, "TEST", 25, "1/1/2000", 1.0), new putOption(true, "TEST", 20, "1/1/2000", 0.5));
        putSpreadOptionPosition bearPutSpread = new putSpreadOptionPosition(new putOption(true, "TEST", 20, "1/1/2000", 1.0), new putOption(false, "TEST", 25, "1/1/2000", 0.5));
        
    }
    
}
