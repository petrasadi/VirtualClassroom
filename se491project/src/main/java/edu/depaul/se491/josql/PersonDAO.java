package edu.depaul.se491.josql;

import static com.google.appengine.api.datastore.FetchOptions.Builder.withLimit;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Transaction;

import edu.depaul.se491.model.Person;

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
	public Iterable<Entity> getAllPerson() throws PersonException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query person_tableQuery = new Query("Person");
		
		PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asIterable();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getPersonById
	*
	*   {@param} Key
	*
	*   {@return} Entity
	*
	******************************************************************************/
	public Entity getPersonById(Key id) throws PersonException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter idFilter = new FilterPredicate("id", FilterOperator.EQUAL, id);
		Query person_tableQuery = new Query("Person").setFilter(idFilter);
		
		PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asSingleEntity();
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
	public Iterable<Entity> getPersonByLastName(String lastName) throws PersonException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter firstNameFilter = new FilterPredicate("lastname", FilterOperator.EQUAL, lastName);
		Query person_tableQuery = new Query("Person").setFilter(firstNameFilter)
				.addSort("lastname", Query.SortDirection.DESCENDING);
		
		PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asIterable();
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
	public Iterable<Entity> getPersonByFirstName(String firstName) throws PersonException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter firstNameFilter = new FilterPredicate("firstname", FilterOperator.EQUAL, firstName);
		Query person_tableQuery = new Query("Person").setFilter(firstNameFilter)
				.addSort("firstname", Query.SortDirection.DESCENDING);
		
		PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asIterable();
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
	public Iterable<Entity> getPersonByFirstNameAndLastName(String firstName, String lastName) throws PersonException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter firstNameFilter = new FilterPredicate("firstname", FilterOperator.EQUAL, firstName);
		Filter lastNameFilter = new FilterPredicate("lastname", FilterOperator.EQUAL, lastName);
		Filter firstAndLastNameComposite = CompositeFilterOperator.and(firstNameFilter, lastNameFilter);
		Query person_tableQuery = new Query("Person").setFilter(firstAndLastNameComposite)
				.addSort("lastname", Query.SortDirection.DESCENDING);
		
		PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asIterable();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getPersonByOpenId - gets the persons with given openid
	*
	*   {@param} String openid
	*
	*   {@return} Person - the person with the openid account.
	*
	******************************************************************************/
	public Person getPersonByOpenId(String openid) throws PersonException {
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter idFilter = new FilterPredicate("openid", FilterOperator.EQUAL, openid);
		Query person_tableQuery = new Query("Person").setFilter(idFilter);
		PreparedQuery pq = datastore.prepare(person_tableQuery);		
		Entity pEntity = pq.asSingleEntity();

        Person personFound = null;
    	if (pEntity != null && pEntity.getKey() != null){
            personFound = new Person();
            personFound.setId(pEntity.getKey());
            personFound.setOpenid((String)pEntity.getProperty("openid"));
            personFound.setFirstName((String)pEntity.getProperty("firstname"));
            personFound.setLastName((String)pEntity.getProperty("lastname"));
            personFound.setMiddleName((String)pEntity.getProperty("middlename"));
            personFound.setAddress((String)pEntity.getProperty("address"));
            personFound.setAddress2((String)pEntity.getProperty("address2"));
            personFound.setCity((String)pEntity.getProperty("city"));
            personFound.setState((String)pEntity.getProperty("state"));
            personFound.setZip((String)pEntity.getProperty("zip"));
            personFound.setCountry((String)pEntity.getProperty("country"));
            personFound.setPhone((String)pEntity.getProperty("phone"));	
            personFound.setPhone2((String)pEntity.getProperty("phone2"));
            personFound.setEmail((String)pEntity.getProperty("email"));
            personFound.setOpenid((String)pEntity.getProperty("openid"));
            if(pEntity.getProperty("teacher") != null){
            	 personFound.setTeacher((Boolean) pEntity.getProperty("teacher"));
            }else{
            	personFound.setTeacher(false);
            }
            if(pEntity.getProperty("student") != null){
            	personFound.setStudent((Boolean) pEntity.getProperty("student"));
           }else{
           	personFound.setTeacher(false);
           }
            if(pEntity.getProperty("admin") != null){
            	personFound.setAdmin((Boolean) pEntity.getProperty("admin"));
           }else{
        	   personFound.setAdmin(false);
           }
           personFound.setAdmin((Boolean) pEntity.getProperty("admin"));
     	} 

		return personFound;      
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
	public Iterable<Entity> getPersonByEmail(String email) throws PersonException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter emailFilter = new FilterPredicate("email", FilterOperator.EQUAL, email);
		Query person_tableQuery = new Query("Person").setFilter(emailFilter)
				.addSort("email", Query.SortDirection.DESCENDING);
       
		PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asIterable();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    savePerson - saves the person
	*
	*   {@param} Person - the person table
	*
	*   {@return} Long - the person id
	 * @throws EntityNotFoundException 
	*
	******************************************************************************/	
    public Key savePerson(Person person) throws PersonException, EntityNotFoundException {
    	Key keyId = person.getId();
   	
    	if(person.getId() == null){
    		return createPerson(person);
    	}
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter idFilter = new FilterPredicate(Entity.KEY_RESERVED_PROPERTY, FilterOperator.EQUAL, person.getId());
		Query person_tableQuery = new Query("Person").setFilter(idFilter);
		PreparedQuery pq = datastore.prepare(person_tableQuery);		
		Entity pEntity = pq.asSingleEntity();
        PersistenceManager pm = PersistenceManagerService.get().getPersistenceManager();
    	if ((person.getId() != null) && (pEntity != null && pEntity.getKey() != null)){
    		keyId = person.getId();
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
     * @throws EntityNotFoundException 
	*
	******************************************************************************/
    public void updatePerson(Person person) throws EntityNotFoundException {
      	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
      	try {
      		Entity pEntity = datastore.get(person.getId());
      	
		//Filter idFilter = new FilterPredicate("id", FilterOperator.EQUAL, person.getId());
		//Query person_tableQuery = new Query("Person").setFilter(idFilter);
		//PreparedQuery pq = datastore.prepare(person_tableQuery);
		
		//Entity pEntity = pq.asSingleEntity();
		Transaction tx = datastore.beginTransaction();
		pEntity.setProperty("firstname", person.getFirstName());
		pEntity.setProperty("middlename", person.getMiddleName());
		pEntity.setProperty("lastname", person.getLastName());
		pEntity.setProperty("email", person.getEmail());
		pEntity.setProperty("address", person.getAddress());
		pEntity.setProperty("address2", person.getAddress2());
		pEntity.setProperty("city", person.getCity());
		pEntity.setProperty("state", person.getState());
        pEntity.setProperty("zip", person.getZip());
        pEntity.setProperty("country", person.getCountry());
        pEntity.setProperty("phone", person.getPhone());
        pEntity.setProperty("phone2", person.getPhone2());
        pEntity.setProperty("openid", person.getOpenid());
    	
        try {
        	datastore.put(pEntity);
        	tx.commit();
        } finally {
        	if(tx.isActive()) {
        		tx.rollback();
        	}
        }
    } catch (EntityNotFoundException e) {
  		return;
  	}
    }
    
    /*******************************************************************************
   	*
   	*   {@literal}
   	*    addClass - adds class to student classes list
   	*
   	*   {@param} Key person
   	*
   	******************************************************************************/	
    @SuppressWarnings("unchecked")
	public boolean addClass(Key person, Key classes) {
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    	try {
    		Entity p = datastore.get(person);
    		List<Key> clist = (List<Key>) p.getProperty("classes");
    		if((clist != null) && (!clist.contains(classes))) {
    			clist.add(classes);
    			p.setProperty("classes", clist);
    			datastore.put(p);
    			return true;
    		} else {
    			clist = new LinkedList<Key>();
    			clist.add(classes);
    			p.setProperty("classes", clist);
    			datastore.put(p);
    			return true;
    		}
    	} catch (EntityNotFoundException e) {
    		return false;
    	}
    }
    /*******************************************************************************
   	*
   	*   {@literal}
   	*    setPersonAsAdmin - sets Admin status for the person
   	*
   	*   {@param} Key person
   	*
   	******************************************************************************/	  
    public void setPersonAsAdmin(Key person) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter keyFilter = new FilterPredicate("person", FilterOperator.EQUAL, person);
		Query role_tableQuery = new Query("Role").setFilter(keyFilter);
		PreparedQuery pq = datastore.prepare(role_tableQuery);
		
		if(pq.countEntities(withLimit(1)) == 0) {
			Entity adminRole = new Entity("Role");
			
			Transaction tx = datastore.beginTransaction();
			adminRole.setProperty("admin", true);
			adminRole.setProperty("student", false);
			adminRole.setProperty("teacher", false);
			adminRole.setProperty("person", person);
			
			try {
				datastore.put(adminRole);
				tx.commit();
			} finally {
				if(tx.isActive()) {
					tx.rollback();
				}
			}
		} else {
			Entity adminRole = pq.asSingleEntity();
			Boolean isAdmin = (Boolean) adminRole.getProperty("admin");
			adminRole.setProperty("admin", !(isAdmin.booleanValue()));
			
			Transaction tx = datastore.beginTransaction();
			try {
				datastore.put(adminRole);
				tx.commit();
			} finally {
				if(tx.isActive()) {
					tx.rollback();
				}
			}
		}
    }
    
    /*******************************************************************************
   	*
   	*   {@literal}
   	*    setPersonAsStudent - sets Student status for the person
   	*
   	*   {@param} Key person
   	*
   	******************************************************************************/	  
    public void setPersonAsStudent(Key person) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter keyFilter = new FilterPredicate("person", FilterOperator.EQUAL, person);
		Query role_tableQuery = new Query("Role").setFilter(keyFilter);
		PreparedQuery pq = datastore.prepare(role_tableQuery);

		if(pq.countEntities(withLimit(1)) == 0) {

			Entity studentRole = new Entity("Role");
			
			Transaction tx = datastore.beginTransaction();
			studentRole.setProperty("admin", false);
			studentRole.setProperty("student", true);
			studentRole.setProperty("teacher", false);
			studentRole.setProperty("person", person);
			
			try {
				datastore.put(studentRole);
				tx.commit();
			} finally {
				if(tx.isActive()) {
					tx.rollback();
				}
			}
		} else {
			Entity studentRole = pq.asSingleEntity();
			Boolean isStudent = (Boolean) studentRole.getProperty("student");
			studentRole.setProperty("student", !(isStudent.booleanValue()));
			
			Transaction tx = datastore.beginTransaction();
			try {
				datastore.put(studentRole);
				tx.commit();
			} finally {
				if(tx.isActive()) {
					tx.rollback();
				}
			}
		}
    }
    
    /*******************************************************************************
   	*
   	*   {@literal}
   	*    setPersonAsStudent - sets Student status for the person
   	*
   	*   {@param} Key person
   	*
   	******************************************************************************/	  
    public void setPersonAsTeacher(Key person) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter keyFilter = new FilterPredicate("person", FilterOperator.EQUAL, person);
		Query role_tableQuery = new Query("Role").setFilter(keyFilter);
		PreparedQuery pq = datastore.prepare(role_tableQuery);

		if(pq.countEntities(withLimit(1)) == 0) {

			Entity teacherRole = new Entity("Role");
			Transaction tx = datastore.beginTransaction();
			teacherRole.setProperty("admin", false);
			teacherRole.setProperty("student", false);
			teacherRole.setProperty("teacher", true);
			teacherRole.setProperty("person", person);
			
			try {
				datastore.put(teacherRole);
				tx.commit();
			} finally {
				if(tx.isActive()) {
					tx.rollback();
				}
			}
		} else {
			
			Entity teacherRole = pq.asSingleEntity();
			Boolean isTeacher = (Boolean) teacherRole.getProperty("teacher");
			teacherRole.setProperty("teacher", !(isTeacher.booleanValue()));
			
			Transaction tx = datastore.beginTransaction();
			try {
				datastore.put(teacherRole);
				tx.commit();
			} finally {
				if(tx.isActive()) {
					tx.rollback();
				}
			}
		}
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
    private Key createPerson(Person person) {
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    	Entity createPerson = new Entity("Person");

		Transaction tx = datastore.beginTransaction();
		createPerson.setProperty("firstname", person.getFirstName());
		createPerson.setProperty("middlename", person.getMiddleName());
		createPerson.setProperty("lastname", person.getLastName());
		createPerson.setProperty("email", person.getEmail());
		createPerson.setProperty("address", person.getAddress());
		createPerson.setProperty("address2", person.getAddress2());
		createPerson.setProperty("city", person.getCity());
		createPerson.setProperty("state", person.getState());
		createPerson.setProperty("zip", person.getZip());
		createPerson.setProperty("country", person.getCountry());
		createPerson.setProperty("phone", person.getPhone());
		createPerson.setProperty("phone2", person.getPhone2());
		createPerson.setProperty("openid", person.getOpenid());
		createPerson.setProperty("teacher", person.isTeacher());
		createPerson.setProperty("student", person.isStudent());
		createPerson.setProperty("admin", person.isAdmin());

        try {
        	datastore.put(createPerson);
        	tx.commit();
        } finally {
        	if(tx.isActive()) {
        		tx.rollback();
        	}
        }
        
        return createPerson.getKey();
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
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter idFilter = new FilterPredicate("id", FilterOperator.EQUAL, person.getId());
		Query person_tableQuery = new Query("Person").setFilter(idFilter);
		PreparedQuery pq = datastore.prepare(person_tableQuery);
    	
		Transaction tx = datastore.beginTransaction();
		Entity pEntity = pq.asSingleEntity();
		try {
			datastore.delete(pEntity.getKey());
		} finally {
			if(tx.isActive()) {
        		tx.rollback();
        	}
		}
    }
    
    
    
}



