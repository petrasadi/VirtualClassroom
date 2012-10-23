package src.edu.depaul.se491.api.se491proj.josql;

/**
 * {@literal}
 * class RoleException
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
public class RoleException extends Exception {
	public RoleException(String errorMessage) {
		super(errorMessage);
	}

	public RoleException(Throwable throwable) {
	    super(throwable);
	}
}
