package com.google.api.se491proj.model;

import javax.persistence.Basic;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * {@literal}
 * class Person is a persistent class
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
@Table(name = "Person")
@NamedQueries({
	@NamedQuery(name = "Person.findById", query = "SELECT u FROM Person u WHERE u.id = :id"),
	@NamedQuery(name = "Person.findByLastName", query = "SELECT u FROM Person u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Person.findByFirstName", query = "SELECT u FROM Person u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Person.findByFirstNameAndLastName", 
	query = "SELECT u FROM Person u WHERE u.firstname = :firstname AND u.lastname = :lastname"),
	@NamedQuery(name = "Person.findByEmail", query = "SELECT u FROM Person u WHERE u.email = :email")})
public class Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Column(name = "address")
	private String address;

	@Basic(optional = true)
	@Column(name = "address2")
	private String address2;

	@Basic(optional = false)
	@Column(name = "city")
	private String city;

	@Basic(optional = false)
	@Column(name = "country")
	private String country;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Basic(optional = false)
	@Column(name = "email")
	@Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-z0-9-]+(\\.[a-z0-9-]+)*?\\.[a-z]{2,6}|(\\d{1,3}\\.){3}\\d{1,3})(:\\d{4})?$", 
		message = "{Person.email.Pattern}")
	private String email;

	@Basic(optional = false)
	@Column(name = "firstname")
	private String firstName;

	@Basic(optional = false)
	@Column(name = "lastname")
	private String lastName;
	
	@Basic(optional = true)
	@Column(name = "middlename")
	private String middleName;

	@Basic(optional = true)
	@Column(name = "phone")
	@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$|^(\\d{3})[\\.](\\d{3})[\\.](\\d{4})$",
			message = "{Person.phone.Pattern}")
	private String phone;

	@Basic(optional = true)
	@Column(name = "phone2")
	@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$|^(\\d{3})[\\.](\\d{3})[\\.](\\d{4})$",
			message = "{Person.phone.Pattern}")
	private String phone2;

	@Basic(optional = false)
	@Column(name = "state")
	private String state;

	private Timestamp updated;
	
	@Basic(optional = false)
	@Column(name = "zip")
    @Pattern(regexp ="[0-9]+", message = "{Person.zip.Pattern}")
	private String zip;

	//bi-directional one-to-one association to Admin
	@Basic(optional = true)
	@OneToOne(mappedBy="person")
	private Admin admin;

	//bi-directional many-to-one association to Class
	@Basic(optional = true)
	@OneToMany(mappedBy="person")
	private List<Class> clazzs1;

	//bi-directional many-to-one association to ClassHistory
	@Basic(optional = true)
	@OneToMany(mappedBy="person")
	private List<ClassHistory> classHistories;

	//bi-directional many-to-one association to ClassRating
	@OneToMany(mappedBy="person")
	private List<ClassRating> classRatings;

	//bi-directional many-to-many association to Class
	@Basic(optional = true)
	@ManyToMany
	@JoinTable(
		name="roster"
		, joinColumns={
			@JoinColumn(name="person_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="class_id")
			}
		)
	private List<Class> clazzs2;

	//bi-directional one-to-one association to Student
	@Basic(optional = true)
	@OneToOne(mappedBy="person")
	private Student student;

	//bi-directional one-to-one association to Teacher
	@Basic(optional = true)
	@OneToOne(mappedBy="person")
	private Teacher teacher;

	public Person() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmail() {
		return this.email;
	}
	
	@Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-z0-9-]+(\\.[a-z0-9-]+)*?\\.[a-z]{2,6}|(\\d{1,3}\\.){3}\\d{1,3})(:\\d{4})?$", 
			message = "{Person.email.Pattern}")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$|^(\\d{3})[\\.](\\d{3})[\\.](\\d{4})$",
			message = "{Person.phone.Pattern}")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone2() {
		return this.phone2;
	}

	@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$|^(\\d{3})[\\.](\\d{3})[\\.](\\d{4})$",
			message = "{Person.phone.Pattern}")
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Class> getClazzs1() {
		return this.clazzs1;
	}

	public void setClazzs1(List<Class> clazzs1) {
		this.clazzs1 = clazzs1;
	}

	public List<ClassHistory> getClassHistories() {
		return this.classHistories;
	}

	public void setClassHistories(List<ClassHistory> classHistories) {
		this.classHistories = classHistories;
	}

	public List<ClassRating> getClassRatings() {
		return this.classRatings;
	}

	public void setClassRatings(List<ClassRating> classRatings) {
		this.classRatings = classRatings;
	}

	public List<Class> getClazzs2() {
		return this.clazzs2;
	}

	public void setClazzs2(List<Class> clazzs2) {
		this.clazzs2 = clazzs2;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}