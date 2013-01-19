package main.java.edu.depaul.se491.participants;

public class Instructor extends Participant {

	public Instructor(String fn, String ln) {
		super(fn, ln);
	}

	@Override
	public String toString() {
		return "Instructor [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
	
	

}
