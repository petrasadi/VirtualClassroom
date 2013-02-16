package edu.depaul.se491.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: James Raitsev
 * Date: 2/16/13
 */
public class ClassesTest
{
    @Test
    public void testSettersAndGetters() throws Exception
    {
        Classes c = new Classes();
        c.setClassName("class name");
        assertTrue(c.getClassName().equals("class name"));

        c.setDescription("description with many words");
        assertTrue(c.getDescription().equals("description with many words"));

        c.setMaxStudents(12);
        assertTrue(c.getMaxStudents() == 12);

        c.setMinStudents(5);
        assertTrue(c.getMinStudents() == 5);

    }
    

}
