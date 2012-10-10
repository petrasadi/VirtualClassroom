package com.google.api.se491proj.model;

import javax.persistence.*;


/**
 * {@literal}
 * class Admin is a persistent class
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
@Table(name = "Admin")
@NamedQueries({
	@NamedQuery(name = "Admin.findByPersonId", query = "SELECT u FROM Admin u WHERE u.personId = :personId")})
public class Admin {

	@Id
	@Column(name = "personId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;

	@Basic(optional = false)
	@Column(name = "active")
	private byte active;

	//bi-directional one-to-one association to Person
	@Basic(optional = false)
	@Column(name = "person")
	@OneToOne
	private Person person;

	public Admin() {
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