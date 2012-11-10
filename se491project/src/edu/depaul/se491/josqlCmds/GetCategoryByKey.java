package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.CategoryDAO;
import edu.depaul.se491.josql.CategoryException;
import edu.depaul.se491.josql.ICategoryDAO;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.model.Category;

class GetCategoryByKey implements IDaoCommands {
	Key id;
	
	public GetCategoryByKey(Key id) {
		this.id = id;
	}
	public Key execute() {
		return null;
	}
	public boolean isExecute() {
		return false;
	}
	public Category getExecute() {
		IClassesDAO c = new ClassesDAO();
		ICategoryDAO ct = new CategoryDAO();
		try {
			Key ctKey = (Key) c.getClassById(id).getProperty("category");
			return (Category) ct.getCategoryById(ctKey);
		} catch (ClassesException e) {
			e.printStackTrace();
			return null;
		} catch (CategoryException e) {
			e.printStackTrace();
			return null;
		}
	}
}
