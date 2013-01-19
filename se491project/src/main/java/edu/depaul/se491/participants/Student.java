package edu.depaul.se491.participants;

import edu.depaul.se491.engine.VirtualClass;

public class Student extends Participant {

	public Student(String fn, String ln) {
		super(fn, ln);
	}

	/**
	 * Attempts to enroll student in class. Returns {@code true} if attempt was
	 * successful, else {@code false}
	 */
	public boolean enrollInClass(VirtualClass c) {
		return true;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

	
	
}
