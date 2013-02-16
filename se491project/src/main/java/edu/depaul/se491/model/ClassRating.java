package edu.depaul.se491.model;

import java.util.HashMap;
import java.util.Map;

import com.google.appengine.api.datastore.Key;

import javax.persistence.*;


/**
 * The persistent class for the class_rating database table.
 */
@Entity
public class ClassRating
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rating;

    private String review;
    
    @ElementCollection
    private Map<String, String> survey = new HashMap<String, String>();

    //bi-directional many-to-one association to Class
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Key classes;

    //bi-directional many-to-one association to Person
    @ManyToOne
    private Key person;

    public ClassRating()
    {
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setSurvey(HashMap<String, String> s) {
    	survey = s;
    }
    
    public String get(String question) {
    	return survey.get(question);
    }
    
    public void put(String question, String answer) {
    	if(!survey.containsKey(question)) {
    		survey.put(question, answer);
    	}
    }
    
    public Map<String, String> getSurveyResults() {
    	return survey;
    }

    public int getRating()
    {
        return this.rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public String getReview()
    {
        return this.review;
    }

    public void setReview(String review)
    {
        this.review = review;
    }

    public Key getClasses()
    {
        return this.classes;
    }

    public void setClasses(Key classes)
    {
        this.classes = classes;
    }

    public Key getPerson()
    {
        return this.person;
    }

    public void setPerson(Key person)
    {
        this.person = person;
    }

}