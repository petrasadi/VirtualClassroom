package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassRatingDAO;
import edu.depaul.se491.josql.ClassRatingException;
import edu.depaul.se491.josql.IClassRating;

public class GetIsSurveyComplete implements IDaoCommands {
	  	Key classesId;
	  	Key personId;
	  	
	    public GetIsSurveyComplete(Key classes, Key person)
	    {
	        this.classesId = classes;
	        this.personId = person;
	    }

	    public Key execute()
	    {
	        return null;
	    }

	    public boolean isExecute()
	    {
	    	IClassRating c = new ClassRatingDAO();
	    	try {
				return c.isSurveyComplete(classesId, personId);
			} catch (ClassRatingException e) {
				e.printStackTrace();
				return false;
			}
	    }

		public Object getExecute()
	    {
			return null;
	    }
}
