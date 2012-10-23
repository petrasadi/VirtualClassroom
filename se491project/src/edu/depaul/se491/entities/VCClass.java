package edu.depaul.se491.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;


@Entity
@Table(name = "vc_class")
public class VCClass{
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private VCUser vcUser;
	
	@Column(name = "class_title")
	private String classTitle;
	
	@Column(name = "max_students")
	private String maxStudents;
	
	@Column(name = "min_students")
	private String minStudents;
	
	@Column(name = "class_dates")
	private Date classDate;
	
	
	public VCClass(String classTitle, String maxStudents, String minStudents,
			Date classDate) {
		super();
		this.classTitle = classTitle;
		this.maxStudents = maxStudents;
		this.minStudents = minStudents;
		this.classDate = classDate;
	}

	public String getClassTitle() {
		return classTitle;
	}

	public void setClassTitle(String classTitle) {
		this.classTitle = classTitle;
	}

	public String getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(String maxStudents) {
		this.maxStudents = maxStudents;
	}

	public String getMinStudents() {
		return minStudents;
	}

	public void setMinStudents(String minStudents) {
		this.minStudents = minStudents;
	}

	public Date getClassDate() {
		return classDate;
	}

	public void setClassDate(Date classDate) {
		this.classDate = classDate;
	}	

}