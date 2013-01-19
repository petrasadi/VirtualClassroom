package edu.depaul.se491.josql;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.model.Classes;

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
	 * @param teacher
	 * @return Iterable<Entity>
	 * @throws ClassesException
	 */
	public Iterable<Entity> getTeacherClasses(Key teacher) throws ClassesException;
	
	/**
	 * @param student
	 * @return Iterable<Entity>
	 * @throws ClassesException
	 */
	public Iterable<Entity> getStudentClasses(Key student) throws ClassesException;
	
	/**
	 * @return Iterable<Entity> get all Classes with Category
	 */
	public Iterable<Entity> getAllClassesByCategory(Key Category) throws ClassesException;
	
	/**
	 * @return String opentokid
	 * @throws ClassesException
	 */
	public long getOpenTokId(Key classes) throws ClassesException;
	
	/**
	 * @param classes
	 * @return Entity
	 * @throws ClassesException
	 */
	public Entity getClassById(Key classes) throws ClassesException;
	
	/**
	 * @param OpenTokId
	 * @return
	 * @throws ClassesException
	 */
	public Entity getClassById(long OpenTokId) throws ClassesException;
	
	/**
	 * @return String opentokid
	 * @throws ClassesException
	 */
	public Entity getClassByOpenId(long OpenTokId) throws ClassesException;
	
	/**
	 * @return long opentoktoken
	 * @throws ClassesException
	 */
	public long getOpenTokToken(Key classes) throws ClassesException;
	
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
