package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.IClassesDAO;

public class GetClassesCmd implements IDaoCommands {
    Key classesId;

    public GetClassesCmd(Key classes)
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

    public Entity getExecute()
    {
        IClassesDAO c = new ClassesDAO();
        try {
            return c.getClassById(classesId);
        } catch (ClassesException e) {
            e.printStackTrace();
            return null;
        }
    }
}
