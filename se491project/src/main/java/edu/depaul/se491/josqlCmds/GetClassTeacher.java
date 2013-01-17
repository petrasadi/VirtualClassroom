package main.java.edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import main.java.edu.depaul.se491.josql.ClassesDAO;
import main.java.edu.depaul.se491.josql.ClassesException;
import main.java.edu.depaul.se491.josql.IClassesDAO;
import main.java.edu.depaul.se491.josql.IPersonDAO;
import main.java.edu.depaul.se491.josql.PersonDAO;
import main.java.edu.depaul.se491.josql.PersonException;
import main.java.edu.depaul.se491.model.Person;

class GetClassTeacher implements IDaoCommands {
	Key classId;
	public GetClassTeacher(Key classes) {
		this.classId = classes;
	}
	public Key execute() {
		return null;
	}
	
	public boolean isExecute() {
		return false;
	}
	public Person getExecute() {
		IPersonDAO persons = new PersonDAO();
		try {
			IClassesDAO classes = new ClassesDAO();
			Entity c = classes.getClassById(classId);
			Key t = (Key) c.getProperty("teacher");
			Entity e = persons.getPersonById(t);
		
			Person pf = null;
			if (e != null && e.getKey() != null){
				pf = new Person();
				pf.setId(e.getKey());
		        pf.setOpenid((String) e.getProperty("openid"));
		        pf.setFirstName((String) e.getProperty("firstName"));
		        pf.setLastName((String) e.getProperty("lastName"));
		        pf.setMiddleName((String) e.getProperty("middleName"));
		        pf.setAddress((String) e.getProperty("address"));
		        pf.setAddress2((String) e.getProperty("address2"));
		        pf.setCity((String) e.getProperty("city"));
		        pf.setState((String) e.getProperty("state"));
		        pf.setZip((String) e.getProperty("zip"));
		        pf.setCountry((String) e.getProperty("country"));
		        pf.setPhone((String) e.getProperty("phone"));	
		        pf.setPhone2((String) e.getProperty("phone2"));
		        pf.setEmail((String) e.getProperty("email"));
		        pf.setOpenid((String) e.getProperty("openid"));
			}
			return pf;
		} catch (PersonException e) {
			e.printStackTrace();
			return null;
		} catch (ClassesException e) {
			e.printStackTrace();
			return null;
		}
	}
}

