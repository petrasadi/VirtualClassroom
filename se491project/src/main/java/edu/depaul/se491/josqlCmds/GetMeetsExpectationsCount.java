package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassRatingDAO;
import edu.depaul.se491.josql.ClassRatingException;
import edu.depaul.se491.josql.IClassRating;

import java.util.List;

public class GetMeetsExpectationsCount implements IDaoCommands {
    Key classesId;

    public GetMeetsExpectationsCount(Key classes)
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

    @SuppressWarnings("unchecked")
	public Integer getExecute()
    {
    	IClassRating c = new ClassRatingDAO();
    	int eeCount = 0;
        try {
           	for(Entity e : c.getClassRatings(classesId).asIterable()) {
           		List<String> crList = (List<String>) e.getProperty("survey");
           		for (String s : crList) {
           			if (s.equals("Meets Expectations")) {
           				eeCount++;
           			}
           		}
           	}
           	return new Integer(eeCount);
            
        } catch (ClassRatingException e) {
            e.printStackTrace();
            return new Integer(0);
        }
    }
}