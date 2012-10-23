package src.edu.depaul.se491.api.se491proj.josql;

/**
 * {@literal}
 * interface for Role data access object
 * 
 * @author
 * Adrian Petras <petrasadi@gmail.com>
 * Andy Soderstrom <asoderst@gmail.com>
 * Casey Benzel <casey.benzel@gmail.com>
 * Elizabeth Stovall <emstovall@gmail.com>
 * James Raitsev <raitsev@gmail.com>
 *
 */
import com.google.appengine.api.datastore.Entity;

public interface IRoleDAO {
	/**
	 * @return Iterable<Entity> get all Admins
	 */
	public Iterable<Entity> getAllAdmins(boolean admin) throws RoleException;
	
	/**
	 * @return Iterable<Entity> get all Students
	 */
	public Iterable<Entity> getAllStudents(boolean admin) throws RoleException;
	
	/**
	 * @return Iterable<Entity> get all Teachers
	 */
	public Iterable<Entity> getAllTeachers(boolean admin) throws RoleException;
}
