package edu.depaul.se491.josqlCmds;

import java.util.LinkedList;

import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.model.Classes;

class AddStudentsCmd implements IDaoCommands {
	Key person;
	Key classes;
	
	public AddStudentsCmd(Key person, Key classes) {
		this.person = person;
		this.classes = classes;
	}
	public Key execute() {
		IClassesDAO c = new ClassesDAO();
		IPersonDAO p = new PersonDAO();
		try {
			if (!DaoCmds.isStudentByKey(person, classes)) {
				if (c.addStudent(person, classes)) {
					p.addClass(person, classes);
					return person;
				}
			}
			return null;
		} catch (ClassesException e) {
			return null;
		}
	}
	
	public boolean isExecute() {
		return false;
	}
	
	public LinkedList<Classes> getExecute() {
		return null;
	}
}
