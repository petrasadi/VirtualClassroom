package edu.depaul.se491.josql;

import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Transaction;

import edu.depaul.se491.model.Classes;

/**
 * {@literal}
 * Class for Classes data access object
 * 
 * @author
 * Adrian Petras <petrasadi@gmail.com>
 * Andy Soderstrom <asoderst@gmail.com>
 * Casey Benzel <casey.benzel@gmail.com>
 * Elizabeth Stovall <emstovall@gmail.com>
 * James Raitsev <raitsev@gmail.com>
 *
 */
public class ClassesDAO implements IClassesDAO {
	/*******************************************************************************
	*
	*   {@literal}
	*    getAllClasses - gets all classes
	*
	*   {@param} void
	*
	*   {@return} Iterable<Entity> - the retreived list
	*
	******************************************************************************/
	public Iterable<Entity> getAllClasses() throws ClassesException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query classesQuery = new Query("Classes");
		
		PreparedQuery pq = datastore.prepare(classesQuery);
        return pq.asIterable();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getTeacherClasses - gets all classes with teacher
	*
	*   {@param} void
	*
	*   {@return} Iterable<Entity> - the retrieved list
	*
	******************************************************************************/
	public Iterable<Entity> getTeacherClasses(Key teacher) throws ClassesException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("teacher", FilterOperator.EQUAL, teacher);
		Query classesByTeacherQuery = new Query("Classes").setFilter(classesFilter);
		
		PreparedQuery pq = datastore.prepare(classesByTeacherQuery);
		return pq.asIterable();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getStudentClasses - gets all classes with student
	*
	*   {@param} void
	*
	*   {@return} Iterable<Entity> - the retrieved list
	*
	******************************************************************************/
	public Iterable<Entity> getStudentClasses(Key student) throws ClassesException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("students", FilterOperator.IN, student);
		Query classesByStudentQuery = new Query("Classes").setFilter(classesFilter);
		
		PreparedQuery pq = datastore.prepare(classesByStudentQuery);
		return pq.asIterable();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getOpenTokId - gets open tok id
	*
	*   {@param} Key classes
	*
	*   {@return} String opentokid
	*
	******************************************************************************/
	public long getOpenTokId(Key classes) throws ClassesException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes);
		Query classesByIdQuery = new Query("Classes").setFilter(classesFilter);
		
		PreparedQuery pq = datastore.prepare(classesByIdQuery);
		Entity classesEntity = pq.asSingleEntity();
		
		return classesEntity.getKey().getId();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getClassById - gets enity by id
	*
	*   {@param} Key classes
	*
	*   {@return} Entity
	*
	******************************************************************************/
	public Entity getClassById(Key classes) throws ClassesException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes);
		Query classesByIdQuery = new Query("Classes").setFilter(classesFilter);
		
		PreparedQuery pq = datastore.prepare(classesByIdQuery);
		return pq.asSingleEntity();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getClassById - gets enity by id
	*
	*   {@param} long classes
	*
	*   {@return} Entity
	*
	******************************************************************************/
	public Entity getClassById(long classes) throws ClassesException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes);
		Query classesByIdQuery = new Query("Classes").setFilter(classesFilter);
		
		PreparedQuery pq = datastore.prepare(classesByIdQuery);
		return pq.asSingleEntity();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getClassByOpenId - gets enity by opentokid
	*
	*   {@param} long openTokId
	*
	*   {@return} Entity
	*
	******************************************************************************/
	public Entity getClassByOpenId(long OpenTokId) throws ClassesException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("opentokid", FilterOperator.EQUAL, OpenTokId);
		Query classesByOpenTokIdQuery = new Query("Classes").setFilter(classesFilter);
		
		PreparedQuery pq = datastore.prepare(classesByOpenTokIdQuery);
		return pq.asSingleEntity();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getOpenTokToken - gets open tok token
	*
	*   {@param} Key classes
	*
	*   {@return} String opentoktoken
	*
	******************************************************************************/
	public long getOpenTokToken(Key classes) throws ClassesException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes);
		Query classesByIdQuery = new Query("Classes").setFilter(classesFilter);
		
		PreparedQuery pq = datastore.prepare(classesByIdQuery);
		Entity classesEntity = pq.asSingleEntity();
		
		return ((Long) classesEntity.getProperty("opentoktoken")).longValue();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getAllClassesByCategory - gets all classes with category
	*
	*   {@param} Key category
	*
	*   {@return} Iterable<Entity> - the retreived list
	*
	******************************************************************************/
	public Iterable<Entity> getAllClassesByCategory(Key category) throws ClassesException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesQuery = new FilterPredicate("category", FilterOperator.EQUAL, category);
		Query classesByCategoryQuery = new Query("Classes").setFilter(classesQuery);
		
		PreparedQuery pq = datastore.prepare(classesByCategoryQuery);
        return pq.asIterable();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    addStudent - add student
	*
	*   {@param} Key person, Key classes
	*
	*   {@return} boolean
	*
	******************************************************************************/
	@SuppressWarnings("unchecked")
	public boolean addStudent(Key person, Key classes) throws ClassesException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes);
		Query classesQuery = new Query("Classes").setFilter(classesFilter);
		
		PreparedQuery pq = datastore.prepare(classesQuery);
		Entity classEntity = pq.asSingleEntity();
		
		List<Key> students = (List<Key>) classEntity.getProperty("students");
		Key teacher = (Key) classEntity.getProperty("teacher");
		int maxStudents = ((Integer) classEntity.getProperty("maxstudents")).intValue();
			if((!students.contains(person)) && (maxStudents > students.size()) && (person != teacher)) {
				students.add(person);
				Filter personFilter = new FilterPredicate("id", FilterOperator.EQUAL, person);
				Query personQuery = new Query("Person").setFilter(personFilter);
				PreparedQuery personq = datastore.prepare(personQuery);
				Entity personEntity = personq.asSingleEntity();
				
				Transaction tx = datastore.beginTransaction();
				classEntity.setProperty("students", students);
				List<Key> classList = (List<Key>) personEntity.getProperty("classes");
				classList.add(classes);
				personEntity.setProperty("classes", classList);
				
				try {
					datastore.put(personEntity);
		        	datastore.put(classEntity);
		        	tx.commit();
		        } finally {
		        	if(tx.isActive()) {
		        		tx.rollback();
		        		return false;
		        	}
		        }
				return true;
			}
		return false;
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    saveClasses - saves the class
	*
	*   {@param} Classes - the class
	*
	*   {@return} Long - the classes id
	*
	******************************************************************************/
    public Key saveClasses(Classes classes) throws ClassesException {
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter idFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes.getId());
		Query classesQuery = new Query("Classes").setFilter(idFilter);
		PreparedQuery pq = datastore.prepare(classesQuery);		
		Entity pEntity = pq.asSingleEntity();
		
        PersistenceManager pm = PersistenceManagerService.get().getPersistenceManager();
    	if ((classes.getId() != null) && (pEntity.getKey() != null)){
    		Key keyId = classes.getId();
    		Classes classesFound = pm.getObjectById(Classes.class, keyId);										
    		if (classesFound != null) {
    			updateClasses(classesFound);
    		}
    		return classesFound.getId();
    	} else {
    		return createClasses(classes);
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
    public void updateClasses(Classes classes) {
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter idFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes.getId());
		Query person_tableQuery = new Query("Classes").setFilter(idFilter);
		PreparedQuery pq = datastore.prepare(person_tableQuery);
		
		Entity pEntity = pq.asSingleEntity();
		Transaction tx = datastore.beginTransaction();
		pEntity.setProperty("className", classes.getClassName());
		pEntity.setProperty("description", classes.getDescription());
		pEntity.setProperty("classendtime", classes.getClassEndTime());
		pEntity.setProperty("classstarttime", classes.getClassStartTime());
		pEntity.setProperty("maxstudents", classes.getMaxStudents());
		pEntity.setProperty("minstudents", classes.getMinStudents());
		pEntity.setProperty("teacher", classes.getTeacher());
		pEntity.setProperty("students", classes.getStudents());
		pEntity.setProperty("category", classes.getCategory());
		//pEntity.setProperty("opentokid", classes.getOpenTokId());
                
        try {
        	datastore.put(pEntity);
        	tx.commit();
        } finally {
        	if(tx.isActive()) {
        		tx.rollback();
        	}
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
    public Key createClasses(Classes classes) {
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    	Entity pEntity = new Entity("Classes");
		
		Transaction tx = datastore.beginTransaction();
		pEntity.setProperty("className", classes.getClassName());
		pEntity.setProperty("description", classes.getDescription());
		pEntity.setProperty("classendtime", classes.getClassEndTime());
		pEntity.setProperty("classstarttime", classes.getClassStartTime());
		pEntity.setProperty("maxstudents", classes.getMaxStudents());
		pEntity.setProperty("minstudents", classes.getMinStudents());
		pEntity.setProperty("teacher", classes.getTeacher());
		pEntity.setProperty("students", classes.getStudents());
		pEntity.setProperty("category", classes.getCategory());
		//pEntity.setProperty("opentokid", classes.getOpenTokId());
                
        try {
        	datastore.put(pEntity);
        	tx.commit();
        } finally {
        	if(tx.isActive()) {
        		tx.rollback();
        	}
        }
        return pEntity.getKey();
    }
    
    /*******************************************************************************
	*
	*   {@literal}
	*    deleteClasses - deletes the class
	*
	*   {@param} Classes - classes
	*
	*   {@return} void
	*
	******************************************************************************/	
    public void deleteClasses(Classes classes) throws ClassesException {
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter idFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes.getId());
		Query classesQuery = new Query("Classes").setFilter(idFilter);
		PreparedQuery pq = datastore.prepare(classesQuery);
    	
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
