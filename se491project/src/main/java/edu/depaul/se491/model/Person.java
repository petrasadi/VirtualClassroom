package edu.depaul.se491.model;

import com.google.appengine.api.datastore.Key;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * {@literal}
 * class Person is a persistent class
 *
 * @author Adrian Petras <petrasadi@gmail.com>
 *         Andy Soderstrom <asoderst@gmail.com>
 *         Casey Benzel <casey.benzel@gmail.com>
 *         Elizabeth Stovall <emstovall@gmail.com>
 *         James Raitsev <raitsev@gmail.com>
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
public class Person implements Serializable
{

    private static final long serialVersionUID = 5922454234631103677L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Key id;

    @Basic(optional = false)
    @Column(name = "open_id")
    private String openid;

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
    @Pattern(regexp = "[0-9]+", message = "{Person.zip.Pattern}")
    private String zip;

    @Column(name = "description")
    private String description;


    @Basic
    @Column(name = "teacher")
    private boolean teacher = false;

    @Basic
    @Column(name = "student")
    private boolean student = false;

    @Basic
    @Column(name = "admin")
    private boolean admin = false;


    //bi-directional many-to-one association to Class
    @Basic(optional = true)
    @OneToMany(mappedBy = "person")
    private List<Key> classes;


    public Person()
    {
    }


    public Person(String firstName, String lastName,
                  String middleName, String address, String address2, String city, String zip, String country,
                  String email, String phone, String phone2, String state)
    {

        super();
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.country = country;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
        this.phone2 = phone2;
        this.state = state;
        this.zip = zip;
    }

    public Key getId()
    {
        return this.id;
    }

    public void setId(Key id)
    {
        this.id = id;
    }

    public void setOpenid(String Openid)
    {
        this.openid = Openid;
    }

    public String getOpenid()
    {
        return this.openid;
    }

    public String getAddress()
    {
        return this.address;
    }


    public boolean isTeacher()
    {
        return teacher;
    }


    public void setTeacher(boolean teacher)
    {
        this.teacher = teacher;
    }


    public boolean isStudent()
    {
        return student;
    }


    public void setStudent(boolean student)
    {
        this.student = student;
    }


    public boolean isAdmin()
    {
        return admin;
    }


    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    }


    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress2()
    {
        return this.address2;
    }

    public void setAddress2(String address2)
    {
        this.address2 = address2;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCountry()
    {
        return this.country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public Date getCreated()
    {
        return this.created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public String getEmail()
    {
        return this.email;
    }

    @Pattern(regexp = "^[\\w-]+(\\.[\\w-]+)*@([a-z0-9-]+(\\.[a-z0-9-]+)*?\\.[a-z]{2,6}|(\\d{1,3}\\.){3}\\d{1,3})(:\\d{4})?$",
            message = "{Person.email.Pattern}")
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getMiddleName()
    {
        return this.middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getPhone()
    {
        return this.phone;
    }

    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$|^(\\d{3})[\\.](\\d{3})[\\.](\\d{4})$",
            message = "{Person.phone.Pattern}")
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone2()
    {
        return this.phone2;
    }

    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$|^(\\d{3})[\\.](\\d{3})[\\.](\\d{4})$",
            message = "{Person.phone.Pattern}")
    public void setPhone2(String phone2)
    {
        this.phone2 = phone2;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public Timestamp getUpdated()
    {
        return this.updated;
    }

    public void setUpdated(Timestamp updated)
    {
        this.updated = updated;
    }

    public String getZip()
    {
        return this.zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }


    public List<Key> getClasses()
    {
        return this.classes;
    }

    public void setClasses(List<Key> classes)
    {
        this.classes = classes;
    }

    public void addClass(Key classes)
    {
        this.classes.add(classes);
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
