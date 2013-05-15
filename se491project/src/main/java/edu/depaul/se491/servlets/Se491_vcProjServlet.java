package edu.depaul.se491.servlets;

import edu.depaul.se491.josql.EntityManagerService;
import edu.depaul.se491.model.Category;
import edu.depaul.se491.model.Person;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@SuppressWarnings("serial")
public class Se491_vcProjServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {
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
        person.setOpenid("bljbaljdljlfjslajf");
        person.setStudent(true);
        person.setTeacher(true);


        Category category = new Category();
        category.setName("Computer Information Systems");
        category.setDescription("Python programming");

		/*try {
            //Key p = personDAO.savePerson(person);
		//	personDAO.setPersonAsAdmin(p);
			//personDAO.setPersonAsStudent(p);
			resp.setContentType("text/plain");
			resp.getWriter().println("Hello, world");
			
		}  catch (PersonException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}*/

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        this.doGet(req, resp);
    }
}
