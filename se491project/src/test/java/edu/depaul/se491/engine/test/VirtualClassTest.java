
package edu.depaul.se491.engine.test;


import org.testng.annotations.Test;

import edu.depaul.se491.engine.VirtualClass;
import edu.depaul.se491.participants.Instructor;
import edu.depaul.se491.participants.Student;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class VirtualClassTest {
	
	@Test(groups="basic")
	public void testVirtualClass() {
		VirtualClass vc = new VirtualClass("Writing 101", new Instructor("Wise", "Guy"));
		assertThat(vc.getStudents().size(), is(0));

		Student s1 = new Student("a", "b");
		Student s2 = new Student("c", "d");
		Student s3 = new Student("d", "f");
		
		vc.addStudent(s1);
		vc.addStudent(s2);
		vc.addStudent(s3);
					
		assertThat(vc.getStudents().size(), is(3));
		
		vc.addStudent(s3);
		vc.addStudent(s3);
		vc.addStudent(s3);

		assertThat(vc.getStudents().size(), is(3));

	}

}


