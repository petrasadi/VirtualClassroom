package edu.depaul.se491.josql;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import edu.depaul.se491.model.Person;

import javax.jdo.PersistenceManager;
import java.util.LinkedList;
import java.util.List;

import static com.google.appengine.api.datastore.FetchOptions.Builder.withLimit;

/**
 * {@literal}
 * class PersonDAO data access object
 *
 * @author Adrian Petras <petrasadi@gmail.com>
 *         Andy Soderstrom <asoderst@gmail.com>
 *         Casey Benzel <casey.benzel@gmail.com>
 *         Elizabeth Stovall <emstovall@gmail.com>
 *         James Raitsev <raitsev@gmail.com>
 */
public class PersonDAO implements IPersonDAO
{

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getAllPerson - gets all persons
     * <p/>
     * {@param} void
     * <p/>
     * {@return} List<Person> - the retreived list
     * <p/>
     * ****************************************************************************
     */
    public Iterable<Entity> getAllPerson() throws PersonException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query person_tableQuery = new Query("Person");

        PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asIterable();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getPersonById
     * <p/>
     * {@param} Key
     * <p/>
     * {@return} Entity
     * <p/>
     * ****************************************************************************
     */
    public Entity getPersonById(Key id) throws PersonException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter idFilter = new FilterPredicate(Entity.KEY_RESERVED_PROPERTY, FilterOperator.EQUAL, id);
        Query person_tableQuery = new Query("Person").setFilter(idFilter);

        PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asSingleEntity();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getPersonByLastName - gets all persons with given lastname
     * <p/>
     * {@param} String lastName
     * <p/>
     * {@return} List<Person> - the retreived list
     * <p/>
     * ****************************************************************************
     */
    public Iterable<Entity> getPersonByLastName(String lastName) throws PersonException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter firstNameFilter = new FilterPredicate("lastname", FilterOperator.EQUAL, lastName);
        Query person_tableQuery = new Query("Person").setFilter(firstNameFilter)
                .addSort("lastname", Query.SortDirection.DESCENDING);

        PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asIterable();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getPersonByFirstName - gets all persons with given firstname
     * <p/>
     * {@param} String firstName
     * <p/>
     * {@return} List<Person> - the retreived list
     * <p/>
     * ****************************************************************************
     */
    public Iterable<Entity> getPersonByFirstName(String firstName) throws PersonException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter firstNameFilter = new FilterPredicate("firstname", FilterOperator.EQUAL, firstName);
        Query person_tableQuery = new Query("Person").setFilter(firstNameFilter)
                .addSort("firstname", Query.SortDirection.DESCENDING);

        PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asIterable();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getPersonByFirstNameAndLastName - gets all persons with given firstname
     * and lastname
     * <p/>
     * {@param} String firstName, String lastName
     * <p/>
     * {@return} List<Person> - the retreived list
     * <p/>
     * ****************************************************************************
     */
    public Iterable<Entity> getPersonByFirstNameAndLastName(String firstName, String lastName) throws PersonException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter firstNameFilter = new FilterPredicate("firstname", FilterOperator.EQUAL, firstName);
        Filter lastNameFilter = new FilterPredicate("lastname", FilterOperator.EQUAL, lastName);
        Filter firstAndLastNameComposite = CompositeFilterOperator.and(firstNameFilter, lastNameFilter);
        Query person_tableQuery = new Query("Person").setFilter(firstAndLastNameComposite)
                .addSort("lastname", Query.SortDirection.DESCENDING);

        PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asIterable();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getPersonByOpenId - gets the persons with given openid
     * <p/>
     * {@param} String openid
     * <p/>
     * {@return} Person - the person with the openid account.
     * <p/>
     * ****************************************************************************
     */
    public Person getPersonByOpenId(String openid) throws PersonException
    {

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter idFilter = new FilterPredicate("openid", FilterOperator.EQUAL, openid);
        Query person_tableQuery = new Query("Person").setFilter(idFilter);
        PreparedQuery pq = datastore.prepare(person_tableQuery);
        Entity pEntity = pq.asSingleEntity();

        Person personFound = null;
        if (pEntity != null && pEntity.getKey() != null) {
            personFound = new Person();
            personFound.setId(pEntity.getKey());
            personFound.setOpenid((String) pEntity.getProperty("openid"));
            personFound.setFirstName((String) pEntity.getProperty("firstname"));
            personFound.setLastName((String) pEntity.getProperty("lastname"));
            personFound.setMiddleName((String) pEntity.getProperty("middlename"));
            personFound.setAddress((String) pEntity.getProperty("address"));
            personFound.setAddress2((String) pEntity.getProperty("address2"));
            personFound.setCity((String) pEntity.getProperty("city"));
            personFound.setState((String) pEntity.getProperty("state"));
            personFound.setZip((String) pEntity.getProperty("zip"));
            personFound.setCountry((String) pEntity.getProperty("country"));
            personFound.setPhone((String) pEntity.getProperty("phone"));
            personFound.setPhone2((String) pEntity.getProperty("phone2"));
            personFound.setEmail((String) pEntity.getProperty("email"));
            personFound.setOpenid((String) pEntity.getProperty("openid"));
            if (pEntity.getProperty("teacher") != null) {
            	 personFound.setTeacher((Boolean) pEntity.getProperty("teacher"));
            } else {
            	 personFound.setTeacher(false);
            }
            if (pEntity.getProperty("student") != null) {
                personFound.setStudent((Boolean) pEntity.getProperty("student"));
            } else {
                personFound.setTeacher(false);
            }
            if (pEntity.getProperty("admin") != null) {
                personFound.setAdmin((Boolean) pEntity.getProperty("admin"));
            } else {
                personFound.setAdmin(false);
            }
            personFound.setAdmin((Boolean) pEntity.getProperty("admin"));
        }

        return personFound;
    }


    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * getPersonByEmail - gets all persons with given email
     * <p/>
     * {@param} String email
     * <p/>
     * {@return} List<Person> - the retreived list
     * <p/>
     * ****************************************************************************
     */
    public Iterable<Entity> getPersonByEmail(String email) throws PersonException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter emailFilter = new FilterPredicate("email", FilterOperator.EQUAL, email);
        Query person_tableQuery = new Query("Person").setFilter(emailFilter)
                .addSort("email", Query.SortDirection.DESCENDING);

        PreparedQuery pq = datastore.prepare(person_tableQuery);
        return pq.asIterable();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * savePerson - saves the person
     * <p/>
     * {@param} Person - the person table
     * <p/>
     * {@return} Long - the person id
     *
     * @throws EntityNotFoundException ****************************************************************************
     */
    public Key savePerson(Person person) throws PersonException, EntityNotFoundException
    {
        Key keyId = person.getId();
        if (person.getId() == null) {
            return createPerson(person);
        }
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter idFilter = new FilterPredicate(Entity.KEY_RESERVED_PROPERTY, FilterOperator.EQUAL, person.getId());
        Query person_tableQuery = new Query("Person").setFilter(idFilter);
        PreparedQuery pq = datastore.prepare(person_tableQuery);
        Entity pEntity = pq.asSingleEntity();
        PersistenceManager pm = PersistenceManagerService.get().getPersistenceManager();
        if ((person.getId() != null) && (pEntity != null && pEntity.getKey() != null)) {
            keyId = person.getId();
            Person personFound = pm.getObjectById(Person.class, keyId);
            if (personFound != null) {
              updatePerson(person);
            }
            return personFound.getId();
        } else {
            return createPerson(person);
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
     *
     * @throws EntityNotFoundException ****************************************************************************
     */
    public void updatePerson(Person person) throws EntityNotFoundException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        try {
            Entity pEntity = datastore.get(person.getId());

            //Filter idFilter = new FilterPredicate("id", FilterOperator.EQUAL, person.getId());
            //Query person_tableQuery = new Query("Person").setFilter(idFilter);
            //PreparedQuery pq = datastore.prepare(person_tableQuery);

            //Entity pEntity = pq.asSingleEntity();
            Transaction tx = datastore.beginTransaction();
            pEntity.setProperty("firstname", person.getFirstName());
            pEntity.setProperty("middlename", person.getMiddleName());
            pEntity.setProperty("lastname", person.getLastName());
            pEntity.setProperty("email", person.getEmail());
            pEntity.setProperty("address", person.getAddress());
            pEntity.setProperty("address2", person.getAddress2());
            pEntity.setProperty("city", person.getCity());
            pEntity.setProperty("state", person.getState());
            pEntity.setProperty("zip", person.getZip());
            pEntity.setProperty("country", person.getCountry());
            pEntity.setProperty("phone", person.getPhone());
            pEntity.setProperty("phone2", person.getPhone2());
            pEntity.setProperty("openid", person.getOpenid());
            pEntity.setProperty("teacher", person.isTeacher());
            pEntity.setProperty("student", person.isStudent());
            pEntity.setProperty("admin", person.isAdmin());

            try {
                datastore.put(pEntity);
                tx.commit();
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
            }
        } catch (EntityNotFoundException e) {
            return;
        }
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * addClass - adds class to student classes list
     * <p/>
     * {@param} Key person
     * <p/>
     * ****************************************************************************
     */
    @SuppressWarnings("unchecked")
    public boolean addClass(Key person, Key classes)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        try {
            Entity p = datastore.get(person);
            List<Key> clist = (List<Key>) p.getProperty("classes");
            if ((clist != null) && (!clist.contains(classes))) {
                clist.add(classes);
                p.setProperty("classes", clist);
                datastore.put(p);
                return true;
            } else {
                clist = new LinkedList<Key>();
                clist.add(classes);
                p.setProperty("classes", clist);
                datastore.put(p);
                return true;
            }
        } catch (EntityNotFoundException e) {
            return false;
        }
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * setPersonAsAdmin - sets Admin status for the person
     * <p/>
     * {@param} Key person
     * <p/>
     * ****************************************************************************
     */
    public void setPersonAsAdmin(Key person)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter keyFilter = new FilterPredicate("person", FilterOperator.EQUAL, person);
        Query role_tableQuery = new Query("Role").setFilter(keyFilter);
        PreparedQuery pq = datastore.prepare(role_tableQuery);

        if (pq.countEntities(withLimit(1)) == 0) {
            Entity adminRole = new Entity("Role");

            Transaction tx = datastore.beginTransaction();
            adminRole.setProperty("admin", true);
            adminRole.setProperty("student", false);
            adminRole.setProperty("teacher", false);
            adminRole.setProperty("person", person);

            try {
                datastore.put(adminRole);
                tx.commit();
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
            }
        } else {
            Entity adminRole = pq.asSingleEntity();
            Boolean isAdmin = (Boolean) adminRole.getProperty("admin");
            adminRole.setProperty("admin", !(isAdmin.booleanValue()));

            Transaction tx = datastore.beginTransaction();
            try {
                datastore.put(adminRole);
                tx.commit();
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
            }
        }
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * setPersonAsStudent - sets Student status for the person
     * <p/>
     * {@param} Key person
     * <p/>
     * ****************************************************************************
     */
    public void setPersonAsStudent(Key person)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter keyFilter = new FilterPredicate("person", FilterOperator.EQUAL, person);
        Query role_tableQuery = new Query("Role").setFilter(keyFilter);
        PreparedQuery pq = datastore.prepare(role_tableQuery);

        if (pq.countEntities(withLimit(1)) == 0) {

            Entity studentRole = new Entity("Role");

            Transaction tx = datastore.beginTransaction();
            studentRole.setProperty("admin", false);
            studentRole.setProperty("student", true);
            studentRole.setProperty("teacher", false);
            studentRole.setProperty("person", person);

            try {
                datastore.put(studentRole);
                tx.commit();
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
            }
        } else {
            Entity studentRole = pq.asSingleEntity();
            Boolean isStudent = (Boolean) studentRole.getProperty("student");
            studentRole.setProperty("student", !(isStudent.booleanValue()));

            Transaction tx = datastore.beginTransaction();
            try {
                datastore.put(studentRole);
                tx.commit();
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
            }
        }
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * setPersonAsStudent - sets Student status for the person
     * <p/>
     * {@param} Key person
     * <p/>
     * ****************************************************************************
     */
    public void setPersonAsTeacher(Key person)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter keyFilter = new FilterPredicate("person", FilterOperator.EQUAL, person);
        Query role_tableQuery = new Query("Role").setFilter(keyFilter);
        PreparedQuery pq = datastore.prepare(role_tableQuery);

        if (pq.countEntities(withLimit(1)) == 0) {

            Entity teacherRole = new Entity("Role");
            Transaction tx = datastore.beginTransaction();
            teacherRole.setProperty("admin", false);
            teacherRole.setProperty("student", false);
            teacherRole.setProperty("teacher", true);
            teacherRole.setProperty("person", person);

            try {
                datastore.put(teacherRole);
                tx.commit();
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
            }
        } else {

            Entity teacherRole = pq.asSingleEntity();
            Boolean isTeacher = (Boolean) teacherRole.getProperty("teacher");
            teacherRole.setProperty("teacher", !(isTeacher.booleanValue()));

            Transaction tx = datastore.beginTransaction();
            try {
                datastore.put(teacherRole);
                tx.commit();
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
            }
        }
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * createPerson - creates the person
     * <p/>
     * {@param} Person - the person table
     * <p/>
     * {@return} int - the person id
     * <p/>
     * ****************************************************************************
     */
    private Key createPerson(Person person)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Entity createPerson = new Entity("Person");

        Transaction tx = datastore.beginTransaction();
        createPerson.setProperty("firstname", person.getFirstName());
        createPerson.setProperty("middlename", person.getMiddleName());
        createPerson.setProperty("lastname", person.getLastName());
        createPerson.setProperty("email", person.getEmail());
        createPerson.setProperty("address", person.getAddress());
        createPerson.setProperty("address2", person.getAddress2());
        createPerson.setProperty("city", person.getCity());
        createPerson.setProperty("state", person.getState());
        createPerson.setProperty("zip", person.getZip());
        createPerson.setProperty("country", person.getCountry());
        createPerson.setProperty("phone", person.getPhone());
        createPerson.setProperty("phone2", person.getPhone2());
        createPerson.setProperty("openid", person.getOpenid());
        createPerson.setProperty("teacher", person.isTeacher());
        createPerson.setProperty("student", person.isStudent());
        createPerson.setProperty("admin", person.isAdmin());

        try {
            datastore.put(createPerson);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }

        return createPerson.getKey();
    }

    /**
     * ****************************************************************************
     * <p/>
     * {@literal}
     * deleteCustomer - deletes the customer
     * <p/>
     * {@param} ICustomerTable - the customer table interface
     * <p/>
     * {@return} void
     * <p/>
     * ****************************************************************************
     */

    public void deletePerson(Person person) throws PersonException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter idFilter = new FilterPredicate("id", FilterOperator.EQUAL, person.getId());
        Query person_tableQuery = new Query("Person").setFilter(idFilter);
        PreparedQuery pq = datastore.prepare(person_tableQuery);

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



