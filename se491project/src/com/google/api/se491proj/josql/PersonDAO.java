package com.google.api.se491proj.josql;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.api.se491proj.model.Person;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * {@literal}
 * class PersonDAO data access object
 * 
 * @author
 * Adrian Petras <petrasadi@gmail.com>
 * Andy Soderstrom <asoderst@gmail.com>
 * Casey Benzel <casey.benzel@gmail.com>
 * Elizabeth Stovall <emstovall@gmail.com>
 * James Raitsev <raitsev@gmail.com>
 *
 */
public class PersonDAO implements IPersonDAO {
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getAllPerson - gets all persons
	*
	*   {@param} void
	*
	*   {@return} List<Person> - the retreived list
	*
	******************************************************************************/
	@SuppressWarnings("unchecked")
	public List<Person> getAllPerson() throws PersonException {
        EntityManager em = EntityManagerService.get().createEntityManager();
        Query person_tableQuery = em.createQuery("SELECT u FROM Person u");
        return person_tableQuery.getResultList();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getPersonByLastName - gets all persons with given lastname
	*
	*   {@param} String lastName
	*
	*   {@return} List<Person> - the retreived list
	*
	******************************************************************************/
	@SuppressWarnings("unchecked")
	public List<Person> getPersonByLastName(String lastName) throws PersonException {
        EntityManager em = EntityManagerService.get().createEntityManager();
        Query person_tableQuery = em.createNamedQuery("Person.findByLastName", Person.class);
        person_tableQuery.setParameter("lastname", lastName);
        return person_tableQuery.getResultList();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getPersonByFirstName - gets all persons with given firstname
	*
	*   {@param} String firstName
	*
	*   {@return} List<Person> - the retreived list
	*
	******************************************************************************/
	@SuppressWarnings("unchecked")
	public List<Person> getPersonByFirstName(String firstName) throws PersonException {
        EntityManager em = EntityManagerService.get().createEntityManager();
        Query person_tableQuery = em.createNamedQuery("Person.findByFirstName", Person.class);
        person_tableQuery.setParameter("firstname", firstName);
        return person_tableQuery.getResultList();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getPersonByFirstNameAndLastName - gets all persons with given firstname
	*    and lastname
	*
	*   {@param} String firstName, String lastName
	*
	*   {@return} List<Person> - the retreived list
	*
	******************************************************************************/
	@SuppressWarnings("unchecked")
	public List<Person> getPersonByFirstNameAndLastName(String firstName, String lastName) throws PersonException {
        EntityManager em = EntityManagerService.get().createEntityManager();
        Query person_tableQuery = em.createNamedQuery("Person.findByFirstNameAndLastName", Person.class);
        person_tableQuery.setParameter("firstname", firstName);
        person_tableQuery.setParameter("lastname", lastName);
        return person_tableQuery.getResultList();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getPersonByEmail - gets all persons with given email
	*
	*   {@param} String email
	*
	*   {@return} List<Person> - the retreived list
	*
	******************************************************************************/
	@SuppressWarnings("unchecked")
	public List<Person> getPersonByEmail(String email) throws PersonException {
        EntityManager em = EntityManagerService.get().createEntityManager();
        Query person_tableQuery = em.createNamedQuery("Person.findByEmail", Person.class);
        person_tableQuery.setParameter("email", email);
        return person_tableQuery.getResultList();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    savePerson - saves the person
	*
	*   {@param} Person - the person table
	*
	*   {@return} Long - the person id
	*
	******************************************************************************/	
    public Long savePerson(Person person) throws PersonException {
        PersistenceManager pm = PersistenceManagerService.get().getPersistenceManager();
    	if (person.getId() != null) {
    		Key keyId = KeyFactory.createKey(Person.class.getSimpleName(), person.getId());
    		Person personFound = pm.getObjectById(Person.class, keyId);
    		if (personFound != null) {
    			updatePerson(personFound);
    		}
    		return personFound.getId();
    	} else {
    		return createPerson(person);
    	}
    }
    
    /*******************************************************************************
	*
	*   {@literal}
	*    updatePerson - updates the person
	*
	*   {@param} Person - the person table
	*
	*   {@return} void
	*
	******************************************************************************/
    public void updatePerson(Person person) {
    	EntityManager em = EntityManagerService.get().createEntityManager();
    	String queryStr = "select from " + Person.class.getName() + 
                " u where u.id = :id";
        Query personIdQuery = em.createQuery(queryStr);
        personIdQuery.setParameter("id", person.getId());
        Person updatedPerson = (Person) personIdQuery.getSingleResult();
        
        updatedPerson.setFirstName(person.getFirstName());
        updatedPerson.setMiddleName(person.getMiddleName());
        updatedPerson.setLastName("changed");
        updatedPerson.setEmail(person.getEmail());
        updatedPerson.setAddress(person.getAddress());
        updatedPerson.setAddress2(person.getAddress2());
        updatedPerson.setCity(person.getCity());
        updatedPerson.setState(person.getState());
        updatedPerson.setZip(person.getZip());
        updatedPerson.setCountry(person.getCountry());
        updatedPerson.setPhone(person.getPhone());
        updatedPerson.setPhone2(person.getPhone2());
        
        em.getTransaction().begin();
        em.persist(updatedPerson);
        em.getTransaction().commit();
    }
    
    /*******************************************************************************
	*
	*   {@literal}
	*    createPerson - creates the person
	*
	*   {@param} Person - the person table
	*
	*   {@return} int - the person id
	*
	******************************************************************************/	  
    private Long createPerson(Person person) {
        EntityManager em = EntityManagerService.get().createEntityManager();
        Person createPerson = new Person();
       
        createPerson.setFirstName(person.getFirstName());
        createPerson.setMiddleName(person.getMiddleName());
        createPerson.setLastName(person.getLastName());
        createPerson.setEmail(person.getEmail());
        createPerson.setAddress(person.getAddress());
        createPerson.setAddress2(person.getAddress2());
        createPerson.setCity(person.getCity());
        createPerson.setState(person.getState());
        createPerson.setZip(person.getZip());
        createPerson.setCountry(person.getCountry());
        createPerson.setPhone(person.getPhone());
        createPerson.setPhone2(person.getPhone2());
        createPerson.setCreated(person.getCreated());
        
        em.getTransaction().begin();
        em.persist(createPerson);
        em.getTransaction().commit();
        return createPerson.getId();
    }
    
    /*******************************************************************************
	*
	*   {@literal}
	*    deleteCustomer - deletes the customer
	*
	*   {@param} ICustomerTable - the customer table interface
	*
	*   {@return} void
	*
	******************************************************************************/	
        
    public void deletePerson(Person person) throws PersonException {
        EntityManager em = EntityManagerService.get().createEntityManager();
        String queryStr = "select from " + Person.class.getName() + 
                " u where u.id = :id";
        Query personIdQuery = em.createQuery(queryStr);
        personIdQuery.setParameter("id", person.getId());
        Person deletePerson = (Person) personIdQuery.getSingleResult();

        em.getTransaction().begin();
        em.remove(deletePerson);
        em.getTransaction().commit();
    }
}
