package edu.depaul.se491.josql;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import edu.depaul.se491.model.Classes;

import javax.jdo.PersistenceManager;
import java.util.LinkedList;
import java.util.List;

/**
 * {@literal}
 * Class for Classes data access object
 *
 * @author Adrian Petras <petrasadi@gmail.com>
 *         Andy Soderstrom <asoderst@gmail.com>
 *         Casey Benzel <casey.benzel@gmail.com>
 *         Elizabeth Stovall <emstovall@gmail.com>
 *         James Raitsev <raitsev@gmail.com>
 */
public class ClassesDAO implements IClassesDAO
{
    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getAllClasses - gets all classes
     * <p/>
     * {@param} void
     * <p/>
     * {@return} Iterable<Entity> - the retreived list
     * <p/>
     * ****************************************************************************
     */
    public Iterable<Entity> getAllClasses() throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query classesQuery = new Query("Classes");

        PreparedQuery pq = datastore.prepare(classesQuery);
        return pq.asIterable();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getTeacherClasses - gets all classes with teacher
     * <p/>
     * {@param} void
     * <p/>
     * {@return} Iterable<Entity> - the retrieved list
     * <p/>
     * ****************************************************************************
     */
    public Iterable<Entity> getTeacherClasses(Key teacher) throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter classesFilter = new FilterPredicate("teacher", FilterOperator.EQUAL, teacher);
        Query classesByTeacherQuery = new Query("Classes").setFilter(classesFilter);

        PreparedQuery pq = datastore.prepare(classesByTeacherQuery);
        return pq.asIterable();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getStudentClasses - gets all classes with student
     * <p/>
     * {@param} void
     * <p/>
     * {@return} Iterable<Entity> - the retrieved list
     * <p/>
     * ****************************************************************************
     */
    public Iterable<Entity> getStudentClasses(Key student) throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter classesFilter = new FilterPredicate("students", FilterOperator.EQUAL, student);
        Query classesByStudentQuery = new Query("Classes").setFilter(classesFilter);

        PreparedQuery pq = datastore.prepare(classesByStudentQuery);
        return pq.asIterable();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getOpenTokId - gets open tok id
     * <p/>
     * {@param} Key classes
     * <p/>
     * {@return} String opentokid
     * <p/>
     * ****************************************************************************
     */
    public long getOpenTokId(Key classes) throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter classesFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes);
        Query classesByIdQuery = new Query("Classes").setFilter(classesFilter);

        PreparedQuery pq = datastore.prepare(classesByIdQuery);
        Entity classesEntity = pq.asSingleEntity();

        return classesEntity.getKey().getId();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getClassById - gets enity by id
     * <p/>
     * {@param} Key classes
     * <p/>
     * {@return} Entity
     *
     * @throws ****************************************************************************
     *
     */
    public Entity getClassById(Key classes) throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        try {
            return datastore.get(classes);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getClassById - gets enity by id
     * <p/>
     * {@param} long classes
     * <p/>
     * {@return} Entity
     * <p/>
     * ****************************************************************************
     */
    public Entity getClassById(long classes) throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key n = KeyFactory.createKey("Classes", classes);
        try {
            return datastore.get(n);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getClassByOpenId - gets enity by opentokid
     * <p/>
     * {@param} long openTokId
     * <p/>
     * {@return} Entity
     * <p/>
     * ****************************************************************************
     */
    public Entity getClassByOpenId(long OpenTokId) throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter classesFilter = new FilterPredicate("opentokid", FilterOperator.EQUAL, OpenTokId);
        Query classesByOpenTokIdQuery = new Query("Classes").setFilter(classesFilter);

        PreparedQuery pq = datastore.prepare(classesByOpenTokIdQuery);
        return pq.asSingleEntity();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getOpenTokToken - gets open tok token
     * <p/>
     * {@param} Key classes
     * <p/>
     * {@return} String opentoktoken
     * <p/>
     * ****************************************************************************
     */
    public long getOpenTokToken(Key classes) throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter classesFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes);
        Query classesByIdQuery = new Query("Classes").setFilter(classesFilter);

        PreparedQuery pq = datastore.prepare(classesByIdQuery);
        Entity classesEntity = pq.asSingleEntity();

        return ((Long) classesEntity.getProperty("opentoktoken")).longValue();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getAllClassesByCategory - gets all classes with category
     * <p/>
     * {@param} Key category
     * <p/>
     * {@return} Iterable<Entity> - the retreived list
     * <p/>
     * ****************************************************************************
     */
    public Iterable<Entity> getAllClassesByCategory(Key category) throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter classesQuery = new FilterPredicate("category", FilterOperator.EQUAL, category);
        Query classesByCategoryQuery = new Query("Classes").setFilter(classesQuery);

        PreparedQuery pq = datastore.prepare(classesByCategoryQuery);
        return pq.asIterable();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * addStudent - add student
     * <p/>
     * {@param} Key person, Key classes
     * <p/>
     * {@return} boolean
     * <p/>
     * ****************************************************************************
     */
    @SuppressWarnings("unchecked")
    public boolean addStudent(Key person, Key classes) throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        try {
            Entity c = datastore.get(classes);
            List<Key> slist = (List<Key>) c.getProperty("students");
            if ((slist != null) && (!slist.contains(person))) {
                slist.add(person);
                c.setProperty("students", slist);
                datastore.put(c);
                return true;
            } else if (slist == null) {
                slist = new LinkedList<Key>();
                slist.add(person);
                c.setProperty("students", slist);
                datastore.put(c);
                return true;
            } else {
                return false;
            }
        } catch (EntityNotFoundException e) {
            return false;
        }
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * saveClasses - saves the class
     * <p/>
     * {@param} Classes - the class
     * <p/>
     * {@return} Long - the classes id
     * <p/>
     * ****************************************************************************
     */
    public Key saveClasses(Classes classes) throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter idFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes.getId());
        Query classesQuery = new Query("Classes").setFilter(idFilter);
        PreparedQuery pq = datastore.prepare(classesQuery);
        Entity pEntity = pq.asSingleEntity();

        PersistenceManager pm = PersistenceManagerService.get().getPersistenceManager();
        if ((classes.getId() != null) && (pEntity.getKey() != null)) {
            Key keyId = classes.getId();
            Classes classesFound = pm.getObjectById(Classes.class, keyId);
            if (classesFound != null) {
                updateClasses(classesFound);
            }
            return classesFound.getId();
        } else {
            return createClasses(classes);
        }
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * updatePerson - updates the person
     * <p/>
     * {@param} Person - the person table
     * <p/>
     * {@return} void
     * <p/>
     * ****************************************************************************
     */
    public void updateClasses(Classes classes)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter idFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes.getId());
        Query person_tableQuery = new Query("Classes").setFilter(idFilter);
        PreparedQuery pq = datastore.prepare(person_tableQuery);

        Entity pEntity = pq.asSingleEntity();
        Transaction tx = datastore.beginTransaction();
        pEntity.setProperty("className", classes.getClassName());
        pEntity.setProperty("description", classes.getDescription());
        pEntity.setProperty("classendtime", classes.getClassEndTime());
        pEntity.setProperty("classstarttime", classes.getClassStartTime());
        pEntity.setProperty("maxstudents", classes.getMaxStudents());
        pEntity.setProperty("minstudents", classes.getMinStudents());
        pEntity.setProperty("teacher", classes.getTeacher());
        pEntity.setProperty("students", classes.getStudents());
        pEntity.setProperty("category", classes.getCategory());
        //pEntity.setProperty("opentokid", classes.getOpenTokId());

        try {
            datastore.put(pEntity);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * updatePerson - updates the person
     * <p/>
     * {@param} Person - the person table
     * <p/>
     * {@return} void
     * <p/>
     * ****************************************************************************
     */
    public Key createClasses(Classes classes)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Entity pEntity = new Entity("Classes");

        Transaction tx = datastore.beginTransaction();
        pEntity.setProperty("className", classes.getClassName());
        pEntity.setProperty("description", classes.getDescription());
        pEntity.setProperty("classendtime", classes.getClassEndTime());
        pEntity.setProperty("classstarttime", classes.getClassStartTime());
        pEntity.setProperty("maxstudents", classes.getMaxStudents());
        pEntity.setProperty("minstudents", classes.getMinStudents());
        pEntity.setProperty("teacher", classes.getTeacher());
        pEntity.setProperty("students", classes.getStudents());
        pEntity.setProperty("category", classes.getCategory());
        //pEntity.setProperty("opentokid", classes.getOpenTokId());

        try {
            datastore.put(pEntity);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
        return pEntity.getKey();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * deleteClasses - deletes the class
     * <p/>
     * {@param} Classes - classes
     * <p/>
     * {@return} void
     * <p/>
     * ****************************************************************************
     */
    public void deleteClasses(Classes classes) throws ClassesException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter idFilter = new FilterPredicate("id", FilterOperator.EQUAL, classes.getId());
        Query classesQuery = new Query("Classes").setFilter(idFilter);
        PreparedQuery pq = datastore.prepare(classesQuery);

        Transaction tx = datastore.beginTransaction();
        Entity pEntity = pq.asSingleEntity();
        try {
            datastore.delete(pEntity.getKey());
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }


}
