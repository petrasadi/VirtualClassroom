package edu.depaul.se491.josqlCmds;

import java.util.LinkedList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.model.Person;

public class IsClassFullCmd implements IDaoCommands {
	Key classId;
	public IsClassFullCmd(Key classes) {
		this.classId = classes;
	}
	public Key execute() {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isExecute() {
		IClassesDAO classes = new ClassesDAO();
		try {
			Entity c = classes.getClassById(classId);
			List<Key> slist = (List<Key>) c.getProperty("students");
			if(slist == null) {
				return false;
			}
			if(((Long) c.getProperty("maxstudents")).intValue() > slist.size()) {
				return false;
			} else {
				return true;
			}
		} catch (ClassesException e) {
			e.printStackTrace();
			return true;
		}
	}
	public LinkedList<Person> getExecute() {
		return null;
	}
}
