package edu.depaul.se491.api.se491proj.josql;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

/**
 * {@literal}
 * Class for Role data access object
 * 
 * @author
 * Adrian Petras <petrasadi@gmail.com>
 * Andy Soderstrom <asoderst@gmail.com>
 * Casey Benzel <casey.benzel@gmail.com>
 * Elizabeth Stovall <emstovall@gmail.com>
 * James Raitsev <raitsev@gmail.com>
 *
 */
public class RoleDAO implements IRoleDAO {
	/*******************************************************************************
	*
	*   {@literal}
	*    getAllAdmins - gets all persons admin keys or none admins
	*
	*   {@param} boolean
	*
	*   {@return} Iterable<Entity> - the retreived list
	*
	******************************************************************************/
	public Iterable<Entity> getAllAdmins(boolean admin) throws RoleException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter adminFilter = new FilterPredicate("admin", FilterOperator.EQUAL, admin);
		Query roleAdminQuery = new Query("Role").setFilter(adminFilter);
       
		PreparedQuery pq = datastore.prepare(roleAdminQuery);
        return pq.asIterable();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getAllStudents - gets all persons students keys or none students
	*
	*   {@param} boolean
	*
	*   {@return} Iterable<Entity> - the retreived list
	*
	******************************************************************************/
	public Iterable<Entity> getAllStudents(boolean student) throws RoleException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter studentFilter = new FilterPredicate("student", FilterOperator.EQUAL, student);
		Query roleStudentQuery = new Query("Role").setFilter(studentFilter);
       
		PreparedQuery pq = datastore.prepare(roleStudentQuery);
		return pq.asIterable();
	}
	
	/*******************************************************************************
	*
	*   {@literal}
	*    getAllStudents - gets all persons students keys or none students
	*
	*   {@param} boolean
	*
	*   {@return} Iterable<Entity> - the retreived list
	*
	******************************************************************************/
	public Iterable<Entity> getAllTeachers(boolean teacher) throws RoleException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Filter teacherFilter = new FilterPredicate("teacher", FilterOperator.EQUAL, teacher);
		Query roleTeacherQuery = new Query("Role").setFilter(teacherFilter);
       
		PreparedQuery pq = datastore.prepare(roleTeacherQuery);
		return pq.asIterable();
	}
}
