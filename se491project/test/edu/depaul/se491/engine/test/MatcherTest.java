

package test.edu.depaul.se491.engine.test;

import edu.depaul.se491.engine.ClassOrganizer;
import edu.depaul.se491.engine.VirtualClass;
import edu.depaul.se491.participants.Instructor;
import edu.depaul.se491.participants.Student;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class MatcherTest {

	private ClassOrganizer organizer = ClassOrganizer.getInstance();

	@Test(expectedExceptions = RuntimeException.class, groups = "basic")
	public void testAddingNewClassWithNull() {
		new VirtualClass("Programming 101", null);
	}
 
	@Test(groups = "basic")
	public void testAddingNewClass() {
		Instructor i1 = new Instructor("John", "Doe");
		VirtualClass class1 = new VirtualClass("Programming 101", i1);
		
		// Create some students and add them to a class (which has instructor)
		Student student1 = new Student("Student", "Mike");
		Student student2 = new Student("Student", "Peter");

		class1.addStudent(student1);
		class1.addStudent(student2); 

		// Nothing will happen until class is added to instructor workload
		assertThat(organizer.getClassesForInstructor(i1).size(), is(0));
		class1.addToWorkload();
		
		// Instructor now has 1 valid class with students in it
		assertThat(organizer.getClassesForInstructor(i1).size(), is(1));

		// Give instructor 1 more class to teach w/o students
		VirtualClass class2 = new VirtualClass("Programming 102", i1);
		class2.addToWorkload();

		// Not added to workload, still has 1
		assertThat(organizer.getClassesForInstructor(i1).size(), is (1));
		
		// Add a student
		class2.addStudent(new Student ("Jane","Roberts"));
		class2.addToWorkload();
		assertThat(organizer.getClassesForInstructor(i1).size(), is (2));		
	}
}


