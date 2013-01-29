package edu.depaul.se491.josqlCmds;

import java.util.LinkedList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

class GetStudentsInClassCmd implements IDaoCommands {
	Key classId;

	public GetStudentsInClassCmd(Key classId) {
		this.classId = classId;
	}

	public Key execute() {
		return null;
	}

	public boolean isExecute() {
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Person> getExecute() {
		IClassesDAO classes = new ClassesDAO();
		List<Person> studentlist = new LinkedList<Person>();
		try {
			Entity e = classes.getClassById(classId);

			if (e != null && e.getKey() != null) {
				List<Key> studentKeys = (List<Key>) e.getProperty("students");

				if (studentKeys == null) {
					return studentlist;
				}
	
				for (Key key : studentKeys) {
					Entity pe = DaoCmds.getPersonById(key);
					Person pf = new Person();
					if (pe != null && pe.getKey() != null) {

						pf.setId(pe.getKey());
						pf.setOpenid((String) pe.getProperty("openid"));
						pf.setFirstName((String) pe.getProperty("firstname"));
						pf.setLastName((String) pe.getProperty("lastname"));
						pf.setMiddleName((String) pe.getProperty("middlename"));
						pf.setAddress((String) pe.getProperty("address"));
						pf.setAddress2((String) pe.getProperty("address2"));
						pf.setCity((String) pe.getProperty("city"));
						pf.setState((String) pe.getProperty("state"));
						pf.setZip((String) pe.getProperty("zip"));
						pf.setCountry((String) pe.getProperty("country"));
						pf.setPhone((String) pe.getProperty("phone"));
						pf.setPhone2((String) pe.getProperty("phone2"));
						pf.setEmail((String) pe.getProperty("email"));
						pf.setOpenid((String) pe.getProperty("openid"));
						studentlist.add(pf);
					}

				}

				return studentlist;
			} else {
				return null;
			}
		} catch (ClassesException e) {
			e.printStackTrace();
			return null;
		}
	}
}