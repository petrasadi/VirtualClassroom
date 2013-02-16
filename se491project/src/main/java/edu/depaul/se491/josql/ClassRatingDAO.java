package edu.depaul.se491.josql;

import java.util.HashMap;
import java.util.Map;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

public class ClassRatingDAO implements IClassRating {
	@Override
	public Entity getClassRating(Key classes, Key person) throws ClassRatingException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("classes", FilterOperator.EQUAL, classes);
        Filter personFilter = new FilterPredicate("person", FilterOperator.EQUAL, person);
        Filter classesAndPersonComposite = CompositeFilterOperator.and(classesFilter, personFilter);
        Query classRating_tableQuery = new Query("ClassRating").setFilter(classesAndPersonComposite)
                .addSort("classes", Query.SortDirection.DESCENDING);
        
        PreparedQuery cr = datastore.prepare(classRating_tableQuery);
        return cr.asSingleEntity();
	}
	
	@Override
	public String setAnswer(String question, String answer, Key classRating) throws ClassRatingException {
		return null;
	}
	@Override
	public String getAnswer(String question, Key classRating) throws ClassRatingException {
		return null;
    }
	@Override
	public void setSurvey(HashMap<String, String> s, Key classes, Key person) throws ClassRatingException {
		if(!isSurveyComplete(classes, person)) {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	        Entity createClassRating = new Entity("ClassRating");
	        
	        Transaction tx = datastore.beginTransaction();
	        createClassRating.setProperty("classes", classes);
	        createClassRating.setProperty("person", person);
	        createClassRating.setProperty("survey", s);
	        
	        try {
	            datastore.put(createClassRating);
	            tx.commit();
	        } finally {
	            if (tx.isActive()) {
	                tx.rollback();
	            }
	        }
		} else {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			Filter classesFilter = new FilterPredicate("classes", FilterOperator.EQUAL, classes);
	        Filter personFilter = new FilterPredicate("person", FilterOperator.EQUAL, person);
	        Filter classesAndPersonComposite = CompositeFilterOperator.and(classesFilter, personFilter);
	        Query classRating_tableQuery = new Query("ClassRating").setFilter(classesAndPersonComposite)
	                .addSort("classes", Query.SortDirection.DESCENDING);

	        PreparedQuery cr = datastore.prepare(classRating_tableQuery);
	        Entity crEntity = cr.asSingleEntity();
	        crEntity.setProperty("survey", s);
	        datastore.put(crEntity);
		}
	}
	
	@Override
	public boolean isSurveyComplete(Key classes, Key person) throws ClassRatingException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("classes", FilterOperator.EQUAL, classes);
        Filter personFilter = new FilterPredicate("person", FilterOperator.EQUAL, person);
        Filter classesAndPersonComposite = CompositeFilterOperator.and(classesFilter, personFilter);
        Query classRating_tableQuery = new Query("ClassRating").setFilter(classesAndPersonComposite)
                .addSort("classes", Query.SortDirection.DESCENDING);
        
        PreparedQuery cr = datastore.prepare(classRating_tableQuery);
        if(cr.asSingleEntity() != null) {
        	return true;
        } else {
        	return false;
        }
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, String> getSurvey(Key classes, Key person) throws ClassRatingException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter classesFilter = new FilterPredicate("classes", FilterOperator.EQUAL, classes);
        Filter personFilter = new FilterPredicate("person", FilterOperator.EQUAL, person);
        Filter classesAndPersonComposite = CompositeFilterOperator.and(classesFilter, personFilter);
        Query classRating_tableQuery = new Query("ClassRating").setFilter(classesAndPersonComposite)
                .addSort("classes", Query.SortDirection.DESCENDING);
        
        PreparedQuery cr = datastore.prepare(classRating_tableQuery);
        return (Map<String, String>) cr.asSingleEntity().getProperty("survey");
	}
}