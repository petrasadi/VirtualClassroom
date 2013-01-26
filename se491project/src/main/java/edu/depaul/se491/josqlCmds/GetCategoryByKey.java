package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.CategoryDAO;
import edu.depaul.se491.josql.CategoryException;
import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.ICategoryDAO;
import edu.depaul.se491.josql.IClassesDAO;

class GetCategoryByKey implements IDaoCommands {
	Key id;
	
	public GetCategoryByKey(Key id) {
		System.out.println("initialize getCategoryByKey: " + id.toString());
		this.id = id;
	}
	public Key execute() {
		return null;
	}
	public boolean isExecute() {
		return false;
	}
	public Entity getExecute() {
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