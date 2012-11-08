package edu.depaul.se491.josqlCmds;

import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.model.Classes;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

class GetAllClassesCmd implements IDaoCommands {
	public Key execute() {
		return null;
	}
	
	public boolean isExecute() {
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public LinkedList<Classes> getExecute() {
		IClassesDAO classes = new ClassesDAO();
		try {
			LinkedList<Classes> clist = new LinkedList<Classes>();
			Iterable<Entity> c = classes.getAllClasses();
			for(Entity e : c) {
				Classes cl = null;
				if (e != null && e.getKey() != null)
					cl = new Classes();
					cl.setCategory((Key) e.getProperty("category"));
					cl.setId(e.getKey());
					cl.setClassEndTime((Date) e.getProperty("classendtime"));
					cl.setClassStartTime((Date) e.getProperty("classstarttime"));
					cl.setClassName((String) e.getProperty("className"));
					cl.setDescription((String) e.getProperty("description"));
					cl.setMaxStudents(((Long) e.getProperty("maxstudents")).intValue());
					cl.setMinStudents(((Long) e.getProperty("minstudents")).intValue());
					//cl.setOpenTokId(((Long) e.getProperty("opentokid")).longValue());
					cl.setTeacher((Key) e.getProperty("teacher"));
					cl.setStudents((List<Key>) e.getProperty("students"));
					clist.add(cl);
			}
			return clist;
		} catch (ClassesException e) {
			e.printStackTrace();
			return null;
		}
	}
}
