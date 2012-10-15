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
		person.setFirstName(req.getParameter("firstname"));
		person.setLastName(req.getParameter("lastname"));
		person.setMiddleName(req.getParameter("middlename"));
		person.setEmail(req.getParameter("email"));
		person.setAddress(req.getParameter("address"));
		person.setAddress2(req.getParameter("address2"));
		person.setCity(req.getParameter("city"));
		person.setState(req.getParameter("state"));
		person.setZip(req.getParameter("zip"));
		person.setCountry(req.getParameter("country"));
		person.setPhone(req.getParameter("phone"));
		person.setPhone2(req.getParameter("phone2"));
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
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		this.doGet(req, resp);
	}
}
