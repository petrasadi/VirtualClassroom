package com.google.api.se491proj;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.http.*;

import com.google.api.se491proj.josql.EntityManagerService;
import com.google.api.se491proj.josql.IPersonDAO;
import com.google.api.se491proj.josql.PersonDAO;
import com.google.api.se491proj.josql.PersonException;
import com.google.api.se491proj.model.Person;

@SuppressWarnings("serial")
public class Se491_vcProjServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		EntityManager em = EntityManagerService.get().createEntityManager();
		
		Person person = new Person();
		person.setFirstName("Andy");
		person.setLastName("Soderstrom");
		person.setMiddleName("L");
		person.setEmail("asoderst@gmail.com");
		person.setAddress("5506 Cumnor Rd");
		person.setAddress2("");
		person.setCity("Downers Grove");
		person.setState("IL");
		person.setZip("60516");
		person.setCountry("United States");
		person.setPhone("wrewerwr");
		person.setPhone2("jfñ");
		person.setCreated(new Date());
				
		IPersonDAO personDAO = new PersonDAO();
		try {
			//em.persist(person);
			personDAO.savePerson(person);
		}  catch (PersonException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
