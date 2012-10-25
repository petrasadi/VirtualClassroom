package edu.depaul.se491.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josql.ClassHistoryEnum;


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