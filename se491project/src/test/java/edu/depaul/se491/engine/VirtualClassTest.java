package edu.depaul.se491.engine;

import edu.depaul.se491.participants.Instructor;
import edu.depaul.se491.participants.Student;
import org.junit.Test;

import static org.junit.Assert.*;

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
        VirtualClass vc = new VirtualClass("class name", new Instructor("fn", "ln"));
        System.out.println(vc.toString());
        assertTrue(vc.toString().equals("VirtualClass [name=class name, instructor=Instructor [firstName=fn, lastName=ln], students=[]]"));

    }

    @Test
    public void testCreation()
    {
        try {
            new VirtualClass(null, null);
            fail();
        } catch (Exception e) {
        }

        try {
            new VirtualClass("", null);
            fail();
        } catch (Exception e) {
        }

        try {
            new VirtualClass("     ", null);
            fail();
        } catch (Exception e) {
        }

        try {
            new VirtualClass("Name", null);
            fail();
        } catch (Exception e) {
        }

        try {
            new VirtualClass("     ", new Instructor("", ""));
            fail();
        } catch (Exception e) {
        }

    }

    @Test
    public void testAddStudent() throws Exception
    {
        VirtualClass vc = new VirtualClass("name", new Instructor("fn", "ln"));

        Student a = new Student("a", "b");
        vc.addStudent(a);
        assertTrue(vc.getStudents().size() == 1);

        vc.addStudent(a);
        assertTrue(vc.getStudents().size() == 1);

        Student b = new Student("a", "b");
        vc.addStudent(b);
        assertTrue(vc.getStudents().size() == 1);
    }

    @Test
    public void testGetInstructor() throws Exception
    {

    }

    @Test
    public void testRemove() throws Exception
    {
        VirtualClass vc1 = new VirtualClass("name", new Instructor("fn", "ln"));
        vc1.addStudent(new Student("student", "joe"));

        vc1.remove(new Student("student", "joe"));
        assertTrue(vc1.getStudents().isEmpty());
    }

    @Test
    public void testHashCode() throws Exception
    {
        VirtualClass vc1 = new VirtualClass("name", new Instructor("fn", "ln"));
        VirtualClass vc2 = new VirtualClass("name", new Instructor("fn", "ln"));

        assertTrue(vc1.hashCode() == vc2.hashCode());
    }

    @Test
    public void testEquals() throws Exception
    {
        VirtualClass vc1 = new VirtualClass("name", new Instructor("fn", "ln"));
        VirtualClass vc2 = new VirtualClass("name", new Instructor("fn", "ln"));

        assertTrue(vc1.equals(vc2));
    }
}
