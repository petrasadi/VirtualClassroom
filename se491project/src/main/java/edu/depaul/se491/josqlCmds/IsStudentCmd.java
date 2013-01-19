package main.java.edu.depaul.se491.josqlCmds;

import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import main.java.edu.depaul.se491.josql.ClassesDAO;
import main.java.edu.depaul.se491.josql.ClassesException;
import main.java.edu.depaul.se491.josql.IClassesDAO;
import main.java.edu.depaul.se491.josql.IPersonDAO;
import main.java.edu.depaul.se491.josql.PersonDAO;
import main.java.edu.depaul.se491.josql.PersonException;

class IsStudentCmd implements IDaoCommands {
	String OpenId;
	long OpenTokId;
	
	public IsStudentCmd(String OpenId, long OpenTokId) {
		this.OpenId = OpenId;
		this.OpenTokId = OpenTokId;
	}
	public Key execute() {
		return null;
	}
	public Object getExecute() {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isExecute() {
		IClassesDAO classes = new ClassesDAO();
		IPersonDAO person = new PersonDAO();
		
		try {
			Entity c = classes.getClassById(OpenTokId);
			List<Key> t = (List<Key>) c.getProperty("students");
			if(t == null) {
				return false;
			}
			Key p = person.getPersonByOpenId(this.OpenId).getId();
			if (t.contains(p)) {
				return true;
			} else {
				return false;
			}
 		} catch (PersonException e) {
			return false;
		} catch (ClassesException e) {
			return false;
		}
	}
}
