package com.google.api.se491proj.model;

import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;

	private byte active;

	//bi-directional one-to-one association to Person
	@OneToOne
	private Person person;

	public Student() {
	}

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}