package main.java.edu.depaul.se491.engine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import main.java.edu.depaul.se491.participants.Instructor;

/**
 * Singleton Class organizer. Main responsibility is to match 
 * students and teachers will classes
 */
public class ClassOrganizer {
	
	private static ClassOrganizer m = null;
	private ClassOrganizer() {}
	
	private Map<Instructor, Set<VirtualClass>> workload = new HashMap<Instructor, Set<VirtualClass>>();
		
	public static synchronized ClassOrganizer getInstance() {
		if (m==null) {
			m = new ClassOrganizer();
		}
		return m;
	}

	/**
	 * Adds to instructor workload.
	 */
	public void addClass(VirtualClass c) {
		
		if (c == null) {
			throw new RuntimeException("Can't add null class to organizer");
		}
		
		Instructor i = c.getInstructor();
		Set<VirtualClass> classes = workload.get(i);
		if (classes == null) {
			classes = new HashSet<VirtualClass>();
		} 
		
		classes.add(c); 
		workload.put(i, classes);
		
	}
	
	public Set<VirtualClass> getClassesForInstructor (Instructor i) {
		Set<VirtualClass> classes= workload.get(i);
		if (classes == null ) {
			return new HashSet<VirtualClass>();
		}
		
		return classes;
	}
		
}
