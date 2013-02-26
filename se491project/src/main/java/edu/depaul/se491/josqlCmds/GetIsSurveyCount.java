package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassRatingDAO;
import edu.depaul.se491.josql.ClassRatingException;
import edu.depaul.se491.josql.IClassRating;

public class GetIsSurveyCount implements IDaoCommands {
  	Key classesId;
  	
    public GetIsSurveyCount(Key classes)
    {
        this.classesId = classes;
    }

    public Key execute()
    {
        return null;
    }

    public boolean isExecute()
    {
    	return false;
    }

	public Object getExecute()
    {
		IClassRating c = new ClassRatingDAO();
    	try {
			return new Integer(c.getClassRatings(classesId).countEntities(FetchOptions.Builder.withLimit(10)));
		} catch (ClassRatingException e) {
			e.printStackTrace();
			return new Integer(0);
		}
    }
}
