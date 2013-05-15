package edu.depaul.se491.formBeans;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: James Raitsev
 * Date: 2/11/13
 */
public class CreateClassFormBeanTest
{

    @Test
    public void testConstruction()
    {
        CreateClassFormBean c = new CreateClassFormBean();

        c.setClassEndTime("1 hour");
        assertTrue(c.getClassEndTime().equals("1 hour"));

        c.setClassCategory("class category");
        assertTrue(c.getClassCategory().equals("class category"));

        c.setClassDate("class date");
        assertTrue(c.getClassDate().equals("class date"));

        c.setClassLevel("class level");
        assertTrue(c.getClassLevel().equals("class level"));

        c.setClassStartTime("class start time");
        assertTrue(c.getClassStartTime().equals("class start time"));

        c.setClassTitle("the title");
        assertTrue(c.getClassTitle().equals("the title"));

        c.setMinStudents("23");
        assertTrue(c.getMinStudents().equals("23"));

        c.setMaxStudents("54");
        assertTrue(c.getMaxStudents().equals("54"));

        c.setClassDescription("description of the class");
        assertTrue(c.getClassDescription().equals("description of the class"));


    }


}
