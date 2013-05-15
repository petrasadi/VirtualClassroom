package edu.depaul.se491.josqlCmds;

import java.util.LinkedList;
import java.util.List;

import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassRatingDAO;
import edu.depaul.se491.josql.ClassRatingException;
import edu.depaul.se491.josql.IClassRating;
import edu.depaul.se491.model.Classes;

class AddSurveyResults implements IDaoCommands {
	Key classes;
	Key person;
	List<String> survey;
	
	public AddSurveyResults(Key c, Key p, List<String> s) {
		classes = c;
		person = p;
		survey = s;
	}
	
	public Key execute() {
		IClassRating cr = new ClassRatingDAO();
		
		try {
			return cr.setSurvey(survey, classes, person);
		} catch (ClassRatingException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean isExecute()
    {
        return false;
    }

    public LinkedList<Classes> getExecute()
    {
        return null;
    }
}
