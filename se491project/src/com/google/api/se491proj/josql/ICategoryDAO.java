package com.google.api.se491proj.josql;

import com.google.api.se491proj.model.Category;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

/**
 * {@literal}
 * interface for Category data access object
 * 
 * @author
 * Adrian Petras <petrasadi@gmail.com>
 * Andy Soderstrom <asoderst@gmail.com>
 * Casey Benzel <casey.benzel@gmail.com>
 * Elizabeth Stovall <emstovall@gmail.com>
 * James Raitsev <raitsev@gmail.com>
 *
 */
public interface ICategoryDAO {
	/**
	 * @return Iterable<Entity> get all Category
	 */
	public Iterable<Entity> getAllCategory() throws CategoryException;
	
	/**
	 * @return Iterable<Entity> get all category with givn key
	 */
	public Iterable<Entity> getCategoryById(Key Category) throws CategoryException;
	
	/**
     * Save category data.  If category exists then will update.  If category is blank then it
     * will create a new category
     *
     * @param category - category information to save
     * @return category id
     */
    public Key saveCategory(Category category);
    
    /**
     * Delete category data.  If category exists then will delete.  If category is blank then it
     * will exit
     *
     * @param category - category information to delete
     */
    public void deleteCategory(Category category);
}
