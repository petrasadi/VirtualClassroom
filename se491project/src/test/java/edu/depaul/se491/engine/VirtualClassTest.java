package edu.depaul.se491.engine;

import edu.depaul.se491.participants.Instructor;
import edu.depaul.se491.participants.Student;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * User: James Raitsev
 * Date: 2/4/13
 */
public class VirtualClassTest
{
    @Test
    public void testAddToWorkload() throws Exception
    {

    }

    @Test
    public void testGetStudents() throws Exception
    {

    }

    @Test
    public void testIsClassInSession() throws Exception
    {
        VirtualClass vc = new VirtualClass("name", new Instructor("fn", "ln"));
        assertFalse(vc.isClassInSession());


    }

    @Test
    public void testToString() throws Exception
    {

    }

    @Test
    public void testAddStudent() throws Exception
    {
        VirtualClass vc = new VirtualClass("name", new Instructor("fn", "ln"));
        vc.addStudent(new Student("a", "b"));
        assertTrue(vc.getStudents().size() == 1);
    }

    @Test
    public void testGetInstructor() throws Exception
    {

    }

    @Test
    public void testRemove() throws Exception
    {

    }

    @Test
    public void testHashCode() throws Exception
    {

    }

    @Test
    public void testEquals() throws Exception
    {

    }
}
