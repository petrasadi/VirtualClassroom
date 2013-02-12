package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Key;
import edu.depaul.se491.josql.CategoryDAO;
import edu.depaul.se491.josql.CategoryException;
import edu.depaul.se491.josql.ICategoryDAO;
import edu.depaul.se491.model.Category;

import java.util.LinkedList;

class CreateCategoryCmd implements IDaoCommands
{
    String name;
    String description;

    public CreateCategoryCmd(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public Key execute()
    {
        ICategoryDAO category = new CategoryDAO();
        try {
            Category c = new Category();
            c.setName(this.name);
            c.setDescription(this.description);
            return category.saveCategory(c);
        } catch (CategoryException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isExecute()
    {
        return false;
    }

    public LinkedList<Category> getExecute()
    {
        return null;
    }
}
