package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import edu.depaul.se491.josql.*;
import edu.depaul.se491.model.Category;

class GetCategoryByOpenTokId implements IDaoCommands
{
    long openTokId;

    public GetCategoryByOpenTokId(long openTokId)
    {
        this.openTokId = openTokId;
    }

    public Key execute()
    {
        return null;
    }

    public boolean isExecute()
    {
        return false;
    }

    public Category getExecute()
    {
        IClassesDAO c = new ClassesDAO();
        ICategoryDAO ct = new CategoryDAO();
        try {
            Entity classes = c.getClassById(openTokId);
            Key ctKey = (Key) classes.getProperty("category");
            Entity e = ct.getCategoryById(ctKey);
            Category cat = new Category();

            cat.setName((String) e.getProperty("name"));
            cat.setDescription((String) e.getProperty("description"));
            cat.setId((Key) e.getProperty("id"));

            return cat;
        } catch (ClassesException e) {
            e.printStackTrace();
            return null;
        } catch (CategoryException e) {
            e.printStackTrace();
            return null;
        }
    }
}
