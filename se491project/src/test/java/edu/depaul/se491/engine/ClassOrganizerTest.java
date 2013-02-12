package edu.depaul.se491.engine;

import edu.depaul.se491.participants.Instructor;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: James Raitsev
 * Date: 2/11/13
 */
public class ClassOrganizerTest
{

    @Test
    public void testGetInstance() throws Exception
    {
        ClassOrganizer i1 = ClassOrganizer.getInstance();
        ClassOrganizer i2 = ClassOrganizer.getInstance();

        assertTrue(i1 == i2);
    }

    @Test
    public void testAddClass() throws Exception
    {
        ClassOrganizer classOrganizer = ClassOrganizer.getInstance();

        Instructor ins1 = new Instructor("instructor name1", "instructor last name");
        Instructor ins2 = new Instructor("instructor name2", "instructor last name");

        // 2 classes for inst 1
        classOrganizer.addClass(new VirtualClass("class 1", ins1));
        classOrganizer.addClass(new VirtualClass("class 2", ins1));

        // 1 classes for inst 2
        classOrganizer.addClass(new VirtualClass("class 3", ins2));

        assertTrue(classOrganizer.getClassesForInstructor(ins1).size() == 2);
        assertTrue(classOrganizer.getClassesForInstructor(ins2).size() == 1);

    }
}
