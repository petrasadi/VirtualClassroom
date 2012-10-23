package edu.depaul.se491.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;


@Entity
@Table(name = "vc_user")
@NamedQueries({ @NamedQuery(name = "findUserbyOpenId", query = "select u from VCUser u where openId = :openId")
})
public class VCUser{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	@Column(name = "first_name")
	private String fname;
	
	@Column(name = "last_name")
	private String lname;
	private String email;
	private String openId;
	
	private boolean teacher;
	private boolean admin;
	private boolean student;

	@OneToMany(mappedBy = "vcUser", cascade = CascadeType.ALL)
	private List <VCClass> classesTeaching;
	
	public VCUser(String fname, String lname, String email, String openId,
			boolean teacher, boolean student, boolean admin) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.openId = openId;
		this.teacher = teacher;
		this.admin = admin;
		this.student = student;
		
		classesTeaching =  new  ArrayList<VCClass>();
	}
	
	public VCUser(){
		
	}

	public Key getKey() {
		return key;
	}



	public void setKey(Key key) {
		this.key = key;
	}



	public boolean isStudent() {
		return student;
	}



	public void setStudent(boolean student) {
		this.student = student;
	}



	public List<VCClass> getClassesTeaching() {
		return classesTeaching;
	}



	public void setClassesTeaching(List<VCClass> classesTeaching) {
		this.classesTeaching = classesTeaching;
	}
	
	public void addClassesTeaching(VCClass vcClass) {
		this.classesTeaching.add(vcClass);
	}



	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public boolean isTeacher() {
		return teacher;
	}
	public void setTeacher(boolean teacher) {
		this.teacher = teacher;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	

}