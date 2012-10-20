package com.google.api.se491proj.model;

import javax.persistence.*;


/**
 * The persistent class for the class_history database table.
 * 
 */
@Entity
public class ClassHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String event;

	//bi-directional many-to-one association to Person
	@ManyToOne
	private Person person;

	//bi-directional many-to-one association to Class
	@ManyToOne
	@JoinColumn(name="class_id")
	private Classes clazz;

	public ClassHistory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Classes getClazz() {
		return this.clazz;
	}

	public void setClazz(Classes clazz) {
		this.clazz = clazz;
	}

}