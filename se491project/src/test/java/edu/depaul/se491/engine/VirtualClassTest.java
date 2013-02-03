package edu.depaul.se491.engine;

import edu.depaul.se491.participants.Instructor;
import org.junit.Test;

import static org.testng.AssertJUnit.assertFalse;

/**
 * User: James Raitsev
 * Date: 2/3/13
 */
public class VirtualClassTest
{

    @Test
    public void testIsClassInSession()
    {
        VirtualClass vc = new VirtualClass("name", new Instructor("fn", "ln"));
        assertFalse(vc.isClassInSession());


    }


}
