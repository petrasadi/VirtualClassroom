package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import edu.depaul.se491.josql.CategoryDAO;
import edu.depaul.se491.josql.CategoryException;
import edu.depaul.se491.josql.ICategoryDAO;
import edu.depaul.se491.model.Category;

import java.util.LinkedList;


class GetAllCategories implements IDaoCommands
{
    public Key execute()
    {
        return null;
    }

    public boolean isExecute()
    {
        return false;
    }

    public LinkedList<Category> getExecute()
    {
        ICategoryDAO categories = new CategoryDAO();
        try {
            LinkedList<Category> ctlist = new LinkedList<Category>();
            Iterable<Entity> cte = categories.getAllCategory();
            for (Entity e : cte) {
                Category ctf = null;
                if (e != null && e.getKey() != null) {
                    ctf = new Category();
                    ctf.setId(e.getKey());
                    ctf.setDescription((String) e.getProperty("description"));
                    ctf.setName((String) e.getProperty("name"));
                    ctlist.add(ctf);
                }
            }
            return ctlist;
        } catch (CategoryException e) {
            e.printStackTrace();
            return null;
        }
    }
}
