package edu.depaul.se491.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;

@Entity
@Table(name = "Role")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;

	@Basic(optional = false)
	@Column(name = "admin")
	private boolean admin;
	
	@Basic(optional = false)
	@Column(name = "teacher")
	private boolean teacher;
	
	@Basic(optional = false)
	@Column(name = "student")
	private boolean student;

	//bi-directional one-to-one association to Person
	@Basic(optional = false)
	@Column(name = "person")
	private Key person;

	public Role() {
	}

	public Key getId() {
		return this.id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public boolean getAdminActive() {
		return this.admin;
	}

	public void setAdminActive(boolean admin) {
		this.admin = admin;
	}

	public boolean getTeacherActive() {
		return this.teacher;
	}

	public void setTeacherActive(boolean teacher) {
		this.teacher = teacher;
	}
	
	public boolean getStudentActive() {
		return this.student;
	}

	public void setStudentActive(boolean student) {
		this.student = student;
	}
	
	public Key getPerson() {
		return this.person;
	}
	
	public void setPerson(Key person) {
		this.person = person;
	}
}
