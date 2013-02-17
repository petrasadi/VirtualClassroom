package edu.depaul.se491.josql;

import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public interface IClassRating {
	/**
	 * 
	 * @param classes
	 * @param person
	 * @return
	 * @throws ClassRatingException
	 */
	public Entity getClassRating(Key classes, Key person) throws ClassRatingException;
	
	
	 /**
     * Save Survey data.  If Survey exists then will update.  If Survey is blank then it
     * will create a new survey
     *
     * @param HashMap<String, String>, Classes classes, Person person
     * @return void
     */
	public Key setSurvey(List<String> s, Key classes, Key person) throws ClassRatingException;
	
	/**
	 * 
	 * @param classes
	 * @param person
	 * @return
	 * @throws ClassRatingExcpetion
	 */
	public boolean isSurveyComplete(Key classes, Key person) throws ClassRatingException;
	
	/**
	 * 
	 * @param classes
	 * @param person
	 * @return
	 * @throws ClassRatingException
	 */
	public List<String> getSurvey(Key classes, Key person) throws ClassRatingException;
}
