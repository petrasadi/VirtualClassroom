package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import edu.depaul.se491.josql.*;

class GetCategoryByKey implements IDaoCommands
{
    Key id;

    public GetCategoryByKey(Key id)
    {
       this.id = id;
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
        ICategoryDAO ct = new CategoryDAO();
        try {
            Entity classes = c.getClassById(id);
            Key ctKey = (Key) classes.getProperty("category");
            Entity e = ct.getCategoryById(ctKey);
            return e;
        } catch (ClassesException e) {
            e.printStackTrace();
            return null;
        } catch (CategoryException e) {
            e.printStackTrace();
            return null;
        }
    }
}
