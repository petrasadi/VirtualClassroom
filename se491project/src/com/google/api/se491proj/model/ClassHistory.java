package com.google.api.se491proj.model;

import javax.persistence.*;

import com.google.api.se491proj.josql.ClassHistoryEnum;
import com.google.appengine.api.datastore.Key;


/**
 * The persistent class for the class_history database table.
 * 
 */
@Entity
@Table(name = "ClassHistory")
public class ClassHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "eventtype")
	private ClassHistoryEnum eventType;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@Column(name = "person")
	private Key person;

	//bi-directional many-to-one association to Class
	@ManyToOne
	@Column(name="class_id")
	private Key classes;

	public ClassHistory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvent() {
		return this.eventType.toString();
	}

	public void setClassHistoryEnum(ClassHistoryEnum eventType) {
		this.eventType = eventType;
	}
	
	public ClassHistoryEnum getClassHistoryEnum() {
		return this.eventType;
	}

	public Key getPerson() {
		return this.person;
	}

	public void setPerson(Key person) {
		this.person = person;
	}

	public Key getClasses() {
		return this.classes;
	}

	public void setClasses(Key classes) {
		this.classes = classes;
	}
}