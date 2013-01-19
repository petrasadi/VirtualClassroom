package edu.depaul.se491.engine;

import java.util.HashSet;
import java.util.Set;

import edu.depaul.se491.participants.Instructor;
import edu.depaul.se491.participants.Student;

public class VirtualClass {

	private Instructor instructor;
	private Set<Student> students = new HashSet<Student>();
	
	private boolean isAssignedToInstructor = false;

	private String name;

	private long startTime;
	private long endTime;

	private int maxStudents = 10;

	public VirtualClass(String name, Instructor i) {
		if (name == null || i == null) {
			throw new RuntimeException(
					"Class name or Instructor name is null. This is not cool");
		}

		this.name = name;
		this.instructor = i;
	}

	/**
	 * If class has some students, it'll be added to the overall instructor
	 * workload
	 */
	public void addToWorkload() {
		if (students.size() > 0) {
			ClassOrganizer.getInstance().addClass(this);
			isAssignedToInstructor = true;
		}
	}
	
	/**
	 * Returns students currently registered for class
	 */
	public Set<Student> getStudents() {
		if (students == null) {
			return new HashSet<Student>();
		}
		return students;
	}

	/**
	 * @return {@code true} if class is now in session (current time in between
	 *         class start and end times)
	 */
	public boolean isClassInSession() {
		long timeNow = System.currentTimeMillis();
		return timeNow > startTime && timeNow < endTime;
	}

	@Override
	public String toString() {
		return "VirtualClass [name=" + name + ", instructor=" + instructor
				+ ", students=" + students + "]";
	}

	/**
	 * Adds student to class
	 */
	public boolean addStudent(Student s) {
		boolean added = true;
		if (students.size() <= maxStudents) {
			students.add(s);
		} else {
			added = false;
		}

		
		return added;
	}

	public Instructor getInstructor() {
		return instructor;
	}
	
	public void remove(Student s) {
		if (students.contains(s)) {
			students.remove(s);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((instructor == null) ? 0 : instructor.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (startTime ^ (startTime >>> 32));
		result = prime * result
				+ ((students == null) ? 0 : students.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VirtualClass other = (VirtualClass) obj;
		if (instructor == null) {
			if (other.instructor != null)
				return false;
		} else if (!instructor.equals(other.instructor))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startTime != other.startTime)
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

}
