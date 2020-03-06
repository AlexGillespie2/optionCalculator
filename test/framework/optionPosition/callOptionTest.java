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
public class callOptionTest {
    private final callOption longCallOption;
    private final callOption shortCallOption;
    
    public callOptionTest() {
        longCallOption = new callOption(true, "TEST", 20.0, "1/1/2000", 1.0);
        shortCallOption = new callOption(false, "TEST", 20.0, "1/1/2000", 1.0);
    }

    @Test
    public void testToString() {
        assertTrue(longCallOption.toString().equals("$TEST $20.0 long call 1/1/2000 expiration"));
        assertTrue(shortCallOption.toString().equals("$TEST $20.0 short call 1/1/2000 expiration"));
    }
    
}
