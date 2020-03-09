/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.optionPosition;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexg
 */
public class putOptionTest {
    private final putOption longPutOption;
    private final putOption shortPutOption;
    
    public putOptionTest() {
        longPutOption = new putOption(true, "TEST", 20.0, "1/1/2000", 1.0);
        shortPutOption = new putOption(false, "TEST", 20.0, "1/1/2000", 1.0);
    }

    @Test
    public void testToString() {
        assertTrue(longPutOption.toString().equals("$TEST $20.0 long put 1/1/2000 expiration"));
        assertTrue(shortPutOption.toString().equals("$TEST $20.0 short put 1/1/2000 expiration"));
    }
    
    @Test
    public void testBreakEven() {
        assertTrue(longPutOption.getBreakEven() == 19.0);
        assertTrue(shortPutOption.getBreakEven() == 19.0);
    }
}
