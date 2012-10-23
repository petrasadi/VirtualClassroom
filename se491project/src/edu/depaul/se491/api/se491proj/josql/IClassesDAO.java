package src.edu.depaul.se491.api.se491proj.josql;

import com.google.api.se491proj.model.Classes;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

/**
 * {@literal}
 * interface for Classes data access object
 * 
 * @author
 * Adrian Petras <petrasadi@gmail.com>
 * Andy Soderstrom <asoderst@gmail.com>
 * Casey Benzel <casey.benzel@gmail.com>
 * Elizabeth Stovall <emstovall@gmail.com>
 * James Raitsev <raitsev@gmail.com>
 *
 */
public interface IClassesDAO {
	/**
	 * @return Iterable<Entity> get all Classes
	 */
	public Iterable<Entity> getAllClasses() throws ClassesException;
	
	/**
	 * @return Iterable<Entity> get all Classes with Category
	 */
	public Iterable<Entity> getAllClassesByCategory(Key Category) throws ClassesException;
	
	/**
	 * @return String opentokid
	 * @throws ClassesException
	 */
	public String getOpenTokId(Key classes) throws ClassesException;
	
	/**
	 * @return String opentoktoken
	 * @throws ClassesException
	 */
	public String getOpenTokToken(Key classes) throws ClassesException;
	
	/**
	 * @param person
	 * @param classes
	 * @return boolean
	 * @throws ClassesException
	 */
	public boolean addStudent(Key person, Key classes) throws ClassesException;
	
	/**
     * Save Class data.  If Class exists then will update.  If Class is blank then it
     * will create a new class
     *
     * @param class - class information to save
     * @return class id
     */
    public Key saveClasses(Classes classes) throws ClassesException;
    
    /**
     * Delete Classes data.  If Classes exists then will delete.  If Classes is blank then it
     * will exit
     *
     * @param Classes - Classes information to delete
     */
    public void deleteClasses(Classes classes) throws ClassesException;
}
