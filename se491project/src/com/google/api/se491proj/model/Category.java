package com.google.api.se491proj.model;

import javax.persistence.*;

import java.util.List;


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
@NamedQueries({
	@NamedQuery(name = "Category.findById", query = "SELECT u FROM Category u WHERE u.id = :id"),
	@NamedQuery(name = "Category.findByName", query = "SELECT u FROM Category u WHERE u.name = :name")})
public class Category {
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic(optional = true)
	@Column(name = "description")
	private String description;

	@Basic(optional = false)
	@Column(name = "name")
	private String name;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="category")
	private List<Class> clazzs;

	public Category() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public List<Class> getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(List<Class> clazzs) {
		this.clazzs = clazzs;
	}

}