package com.google.api.se491proj.josql;

import com.google.api.se491proj.model.Person;
import com.google.appengine.api.datastore.Key;

import java.util.List;

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
	 * @return List<Person> get all Persons
	 */
	public List<Person> getAllPerson() throws PersonException;
	
	/**
	 * @return List<Person> get all person by LastName
	 */
	public List<Person> getPersonByLastName(String lastName) throws PersonException;
	
	/**
	 * @return List<Person> get all person by firstName
	 */
	public List<Person> getPersonByFirstName(String firstName) throws PersonException;
	
	/**
	 * @return List<Person> get all person by firstName and lastName
	 */
	public List<Person> getPersonByFirstNameAndLastName(String firstName, String lastName) throws PersonException;
	
	/**
	 * @return List<Person> get all person by email
	 */
	public List<Person> getPersonByEmail(String email) throws PersonException;
	
	/**
     * Save person data.  If person exists then will update.  If person is blank then it
     * will create a new person
     *
     * @param person - person information to save
     * @return person id
     */
    public Long savePerson(Person person) throws PersonException;
    
    /**
     * Delete person data.  If person exists then will delete.  If person is blank then it
     * will exit
     *
     * @param person - person information to delete
     */
    public void deletePerson(Person person) throws PersonException;

}