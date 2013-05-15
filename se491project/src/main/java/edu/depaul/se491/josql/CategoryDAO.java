package edu.depaul.se491.josql;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import edu.depaul.se491.model.Category;

import javax.jdo.PersistenceManager;

public class CategoryDAO implements ICategoryDAO
{
    public Iterable<Entity> getAllCategory() throws CategoryException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query categoryQuery = new Query("Category");

        PreparedQuery pq = datastore.prepare(categoryQuery);
        return pq.asIterable();
    }

    public Entity getCategoryById(Key category) throws CategoryException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        try {
            return datastore.get(category);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Key saveCategory(Category category) throws CategoryException
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter categoryIdFilter = new FilterPredicate("id", FilterOperator.EQUAL, category.getId());
        Query categoryByIdQuery = new Query("Category").setFilter(categoryIdFilter);
        PreparedQuery pq = datastore.prepare(categoryByIdQuery);
        Entity pEntity = pq.asSingleEntity();

        PersistenceManager pm = PersistenceManagerService.get().getPersistenceManager();
        if ((category.getId() != null) && (pEntity.getKey() != null)) {
            Key keyId = category.getId();
            Category categoryFound = pm.getObjectById(Category.class, keyId);
            if (categoryFound != null) {
                updateCategory(categoryFound);
            }
            return categoryFound.getId();
        } else {
            return createCategory(category);
        }
    }

    public void updateCategory(Category category)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter categoryIdFilter = new FilterPredicate("id", FilterOperator.EQUAL, category.getId());
        Query categoryByIdQuery = new Query("Category").setFilter(categoryIdFilter);
        PreparedQuery pq = datastore.prepare(categoryByIdQuery);

        Entity pEntity = pq.asSingleEntity();
        Transaction tx = datastore.beginTransaction();
        pEntity.setProperty("name", category.getName());
        pEntity.setProperty("decription", category.getDescription());

        try {
            datastore.put(pEntity);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public Key createCategory(Category category)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Entity pEntity = new Entity("Category");

        Transaction tx = datastore.beginTransaction();
        pEntity.setProperty("name", category.getName());
        pEntity.setProperty("decription", category.getDescription());

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

    public void deleteCategory(Category category)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Filter categoryIdFilter = new FilterPredicate("id", FilterOperator.EQUAL, category.getId());
        Query categoryByIdQuery = new Query("Category").setFilter(categoryIdFilter);
        PreparedQuery pq = datastore.prepare(categoryByIdQuery);

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
