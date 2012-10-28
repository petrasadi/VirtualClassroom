package edu.depaul.se491.model;

import javax.persistence.*;

import com.google.appengine.api.datastore.Key;

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
@Table(name = "Classes")
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "classendtime")
	private Date classendtime;

	@Column(name = "classname")
	private String classname;

	@Column(name = "classstarttime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date classstarttime;

	@Column(name = "description")
	private String description;

	@Column(name="maxstudents")
	private int maxstudents;

	@Column(name="minstudents")
	private int minstudents;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@Column(name = "teacher")
	private Key teacher;
	
	@OneToMany
	@Column(name = "students")
	private List<Key> students;
	
	@Column(name = "opentokid")
	private String opentokid;
	
	@Column(name = "opentoktoken")
	private String opentoktoken;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@Column(name = "category")
	private Key category;

	public Classes() {
	}

	public Key getId() {
		return this.id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public Date getClassEndTime() {
		return this.classendtime;
	}

	public void setClassEndTime(Date classEndTime) {
		this.classendtime = classEndTime;
	}

	public String getClassName() {
		return this.classname;
	}

	public void setClassName(String className) {
		this.classname = className;
	}

	public Date getClassStartTime() {
		return this.classstarttime;
	}

	public void setClassStartTime(Date classStartTime) {
		this.classstarttime = classStartTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxStudents() {
		return this.maxstudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxstudents = maxStudents;
	}

	public int getMinStudents() {
		return this.minstudents;
	}

	public void setMinStudents(int minStudents) {
		this.minstudents = minStudents;
	}

	public Key getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Key teacher) {
		this.teacher = teacher;
	}
	
	public List<Key> getStudents() {
		return this.students;
	}
	
	public void addStudent(Key student) {
		this.students.add(student);
	}
	
	public void setOpenTokId(String opentokid) {
		this.opentokid = opentokid;
	}
	
	public String getOpenTokId() {
		return this.opentokid;
	}
	
	public void setOpenTokToken(String opentoktoken) {
		this.opentoktoken = opentoktoken;
	}
	
	public String getOpenTokToken() {
		return this.opentoktoken;
	}

	public Key getCategory() {
		return this.category;
	}

	public void setCategory(Key category) {
		this.category = category;
	}
}