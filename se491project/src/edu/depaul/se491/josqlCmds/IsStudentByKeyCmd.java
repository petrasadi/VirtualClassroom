package edu.depaul.se491.josqlCmds;

import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;

class IsStudentByKeyCmd implements IDaoCommands {
	Key person;
	Key classes;
	
	public IsStudentByKeyCmd(Key person, Key classes) {
		this.person = person;
		this.classes = classes;
	}
	public Key execute() {
		return null;
	}
	public Object getExecute() {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isExecute() {
		IClassesDAO c = new ClassesDAO();
		//IPersonDAO p = new PersonDAO();
		
		try {
			Entity ec = c.getClassById(classes);
			List<Key> slist = (List<Key>) ec.getProperty("students");
			if(slist == null) {
				return false;
			}
			//Entity ep = p.getPersonById(person);
			if (slist.contains(person)) {
				return true;
			} else {
				return false;
			}
 		}  catch (ClassesException e) {
			return false;
		}
	}
}
