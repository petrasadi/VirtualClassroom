package edu.depaul.se491.api.se491proj.model;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;

/**
 * {@literal}
 * class Category is a persistent class
 * 
 * @author
 * Adrian Petras <petrasadi@gmail.com>
 * Andy Soderstrom <asoderst@gmail.com>
 * Casey Benzel <casey.benzel@gmail.com>
 * Elizabeth Stovall <emstovall@gmail.com>
 * James Raitsev <raitsev@gmail.com>
 *
 */
@Entity
@Table(name = "Category")
public class Category {
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;

	@Basic(optional = true)
	@Column(name = "description")
	private String description;

	@Basic(optional = false)
	@Column(name = "name")
	private String name;

	public Category() {
	}

	public Key getId() {
		return this.id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}