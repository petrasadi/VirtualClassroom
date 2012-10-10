package com.google.api.se491proj.model;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * {@literal}
 * class Class is a persistent class
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
@Table(name = "Class")
@NamedQueries({
	@NamedQuery(name = "Class.findById", query = "SELECT u FROM Class u WHERE u.id = :id")})
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date classEndTime;

	private String className;

	@Temporal(TemporalType.TIMESTAMP)
	private Date classStartTime;

	private String description;

	@Column(name="max_students")
	private int maxStudents;

	@Column(name="min_students")
	private int minStudents;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="teacher_id")
	private Person person;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	//bi-directional many-to-one association to Class
	@ManyToOne
	@JoinColumn(name="prerequisit_id")
	private Class clazz;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="clazz")
	private List<Class> clazzs;

	//bi-directional many-to-one association to ClassHistory
	@OneToMany(mappedBy="clazz")
	private List<ClassHistory> classHistories;

	//bi-directional many-to-one association to ClassRating
	@OneToMany(mappedBy="clazz")
	private List<ClassRating> classRatings;

	//bi-directional many-to-many association to Person
	@ManyToMany(mappedBy="clazzs2")
	private List<Person> persons;

	public Class() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getClassEndTime() {
		return this.classEndTime;
	}

	public void setClassEndTime(Date classEndTime) {
		this.classEndTime = classEndTime;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getClassStartTime() {
		return this.classStartTime;
	}

	public void setClassStartTime(Date classStartTime) {
		this.classStartTime = classStartTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxStudents() {
		return this.maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public int getMinStudents() {
		return this.minStudents;
	}

	public void setMinStudents(int minStudents) {
		this.minStudents = minStudents;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Class getClazz() {
		return this.clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public List<Class> getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(List<Class> clazzs) {
		this.clazzs = clazzs;
	}

	public List<ClassHistory> getClassHistories() {
		return this.classHistories;
	}

	public void setClassHistories(List<ClassHistory> classHistories) {
		this.classHistories = classHistories;
	}

	public List<ClassRating> getClassRatings() {
		return this.classRatings;
	}

	public void setClassRatings(List<ClassRating> classRatings) {
		this.classRatings = classRatings;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}