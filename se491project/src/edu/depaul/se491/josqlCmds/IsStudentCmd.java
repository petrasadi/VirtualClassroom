package edu.depaul.se491.josqlCmds;

import java.util.List;

import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;

class IsStudentCmd implements IDaoCommands {
	String OpenId;
	long OpenTokId;
	
	public IsStudentCmd(String OpenId, long OpenTokId) {
		this.OpenId = OpenId;
		this.OpenTokId = OpenTokId;
	}
	public void execute() {
		return;
	}
	public Object getExecute() {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isExecute() {
		IClassesDAO classes = new ClassesDAO();
		IPersonDAO person = new PersonDAO();
		
		try {
			List<Key> t = (List<Key>) classes.getClassByOpenId(OpenTokId).getProperty("students");
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
