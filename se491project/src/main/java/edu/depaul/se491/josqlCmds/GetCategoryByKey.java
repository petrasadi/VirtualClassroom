package main.java.edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import main.java.edu.depaul.se491.josql.CategoryDAO;
import main.java.edu.depaul.se491.josql.CategoryException;
import main.java.edu.depaul.se491.josql.ICategoryDAO;
import main.java.edu.depaul.se491.josql.IClassesDAO;
import main.java.edu.depaul.se491.josql.ClassesDAO;
import main.java.edu.depaul.se491.josql.ClassesException;
import main.java.edu.depaul.se491.model.Category;

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
