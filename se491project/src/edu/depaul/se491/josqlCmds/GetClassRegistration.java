package edu.depaul.se491.josqlCmds;

import java.util.LinkedList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;
import edu.depaul.se491.model.Person;

class GetClassRegistration {
	Key classId;
	public GetClassRegistration(Key classes) {
		this.classId = classes;
	}
	public void execute() {
		return;
	}
	
	public boolean isExecute() {
		return false;
	}
	@SuppressWarnings("unchecked")
	public LinkedList<Person> getExecute() {
		IPersonDAO persons = new PersonDAO();
		try {
			IClassesDAO classes = new ClassesDAO();
			Entity c = classes.getClassById(classId);
			List<Key> slist = (List<Key>) c.getProperty("students");
			LinkedList<Person> plist = new LinkedList<Person>();
			for(Key p : slist) {	
				Entity e = persons.getPersonById(p);
		
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
		        	plist.add(pf);
				}
			}
			return plist;
		} catch (PersonException e) {
			e.printStackTrace();
			return null;
		} catch (ClassesException e) {
			e.printStackTrace();
			return null;
		}
	}
}
