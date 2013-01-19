package main.java.edu.depaul.se491.josql;

/**
 * {@literal}
 * class ClassException
 * 
 * @author
 * Adrian Petras <petrasadi@gmail.com>
 * Andy Soderstrom <asoderst@gmail.com>
 * Casey Benzel <casey.benzel@gmail.com>
 * Elizabeth Stovall <emstovall@gmail.com>
 * James Raitsev <raitsev@gmail.com>
 *
 */
@SuppressWarnings("serial")
public class ClassesException extends Exception {
	public ClassesException(String errorMessage) {
		super(errorMessage);
	}

	public ClassesException(Throwable throwable) {
	    super(throwable);
	}
}
