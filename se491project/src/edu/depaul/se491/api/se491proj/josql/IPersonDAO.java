package edu.depaul.se491.api.se491proj.josql;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.api.se491proj.model.Person;

/**
 * {@literal}
 * interface for Person data access object
 * 
 * @author
 * Adrian Petras <petrasadi@gmail.com>
 * Andy Soderstrom <asoderst@gmail.com>
 * Casey Benzel <casey.benzel@gmail.com>
 * Elizabeth Stovall <emstovall@gmail.com>
 * James Raitsev <raitsev@gmail.com>
 *
 */
public interface IPersonDAO {
	/**
	 * @return Iterable<Entity> get all Persons
	 */
	public Iterable<Entity> getAllPerson() throws PersonException;
	
	/**
	 * @return Iterable<Entity> get all person by LastName
	 */
	public Iterable<Entity> getPersonByLastName(String lastName) throws PersonException;
	
	/**
	 * @return Iterable<Entity> get all person by firstName
	 */
	public Iterable<Entity> getPersonByFirstName(String firstName) throws PersonException;
	
	/**
	 * @return Iterable<Entity> get all person by firstName and lastName
	 */
	public Iterable<Entity> getPersonByFirstNameAndLastName(String firstName, String lastName) throws PersonException;
	
	/**
	 * @return List<Person> get all person by email
	 */
	public Iterable<Entity> getPersonByEmail(String email) throws PersonException;
	
	/**
	 * @param Key set person as admin
	 */
	public void setPersonAsAdmin(Key person);
	
	/**
	 * @param Key set person as student
	 */
	public void setPersonAsStudent(Key person);
	
	/**
	 * @param Key set person as teacher
	 */
	public void setPersonAsTeacher(Key person);
	
	/**
     * Save person data.  If person exists then will update.  If person is blank then it
     * will create a new person
     *
     * @param person - person information to save
     * @return person id
     */
    public Key savePerson(Person person) throws PersonException;
    
    /**
     * Delete person data.  If person exists then will delete.  If person is blank then it
     * will exit
     *
     * @param person - person information to delete
     */
    public void deletePerson(Person person) throws PersonException;

}