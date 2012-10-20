package com.google.api.se491proj.josql;

import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.api.se491proj.model.Classes;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

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
	
	@SuppressWarnings("unchecked")
	public boolean addStudent(Key person, Key classes) throws ClassesException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes);
		Query classesQuery = new Query("Classes").setFilter(classesFilter);
		
		PreparedQuery pq = datastore.prepare(classesQuery);
		Entity classEntity = pq.asSingleEntity();
		
		List<Key> students = (List<Key>) classEntity.getProperty("students");
		int maxStudents = ((Integer) classEntity.getProperty("maxstudents")).intValue();
		if(maxStudents > students.size()) {
			if(!students.contains(person)) {
				students.add(person);
				Transaction tx = datastore.beginTransaction();
				classEntity.setProperty("students", students);
				
				try {
		        	datastore.put(classEntity);
		        	tx.commit();
		        } finally {
		        	if(tx.isActive()) {
		        		tx.rollback();
		        	}
		        }
				return true;
			}
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
		pEntity.setProperty("opentokid", classes.getOpenTokId());
                
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
		pEntity.setProperty("opentokid", classes.getOpenTokId());
                
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
