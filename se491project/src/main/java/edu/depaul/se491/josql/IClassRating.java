package edu.depaul.se491.josql;

import java.util.HashMap;
import java.util.Map;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

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
	 * Set answer for a question.
	 * 
	 * @param question
	 * @param answer
	 * @param classes
	 * @param person
	 * @return
	 * @throws ClassRatingException
	 */
	public String setAnswer(String question, String answer, Key classRating) throws ClassRatingException;
	
	/**
	 * Provides answer given a question. Question is key of Map.
	 * 
	 * @param question
	 * @param classes
	 * @param person
	 * @return
	 * @throws ClassRatingException
	 */
	public String getAnswer(String question, Key classRating) throws ClassRatingException;
	
	 /**
     * Save Survey data.  If Survey exists then will update.  If Survey is blank then it
     * will create a new survey
     *
     * @param HashMap<String, String>, Classes classes, Person person
     * @return void
     */
	public void setSurvey(HashMap<String, String> s, Key classes, Key person) throws ClassRatingException;
	
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
	public Map<String, String> getSurvey(Key classes, Key person) throws ClassRatingException;
}
