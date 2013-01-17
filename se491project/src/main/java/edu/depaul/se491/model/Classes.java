package edu.depaul.se491.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.appengine.api.datastore.Key;

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
	private Key id; //also openTokId --> classes.getKey().getId();

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
	
	/*@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	@Column(name = "opentokid")
	private long opentokid;
	
	@Column(name = "opentoktoken")
	private String opentoktoken;*/

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
	
	public void setStudents(List<Key> students) {
		this.students = students;
	}
	public void addStudent(Key student) {
		this.students.add(student);
	}
	
	/*public void setOpenTokId(long opentokid) {
		this.opentokid = opentokid;
	}
	
	public long getOpenTokId() {
		return this.opentokid;
	}
	
	public void setOpenTokToken(String opentoktoken) {
		this.opentoktoken = opentoktoken;
	}
	
	public String getOpenTokToken() {
		return this.opentoktoken;
	}*/

	public Key getCategory() {
		return this.category;
	}

	public void setCategory(Key category) {
		this.category = category;
	}
	
	public String getDisplayClassDate(){
		
		if(classstarttime != null){
			DateFormat dateFmt = new SimpleDateFormat("MM/dd/yyyy");
			return dateFmt.format(classstarttime);
		}else{
			return "unavailable";
		}
	}
	
	public String getDisplayClassStartTime(){		

		if(classstarttime != null){
			DateFormat dateFmt = new SimpleDateFormat("hh:mm aaa");
			return dateFmt.format(classstarttime);
		}else{
			return "unavailable";
		}		
	}
	
	public String getDisplayClassEndTime(){
		
		if(classstarttime != null){
			DateFormat dateFmt = new SimpleDateFormat("hh:mm aaa");
			return dateFmt.format(classendtime);
		}else{
			return "unavailable";
		}		
	}
		
	
	
}