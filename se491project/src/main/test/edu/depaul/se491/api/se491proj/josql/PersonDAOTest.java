package edu.depaul.se491.api.se491proj.josql;

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;
import edu.depaul.se491.model.Person;

public class PersonDAOTest {
	@Test
	public void testGetAllPerson() {
		System.out.println("Started testing GetCustomers");
		IPersonDAO personDAO = new PersonDAO();

		List<Person> personTableList = null;
		/*
		 * try { // personTableList = personDAO.getAllPerson(); } catch
		 * (PersonException e) { e.printStackTrace();
		 * fail("GetCustomer exception"); } assert(personTableList != null);
		 */

		Iterator<Person> iPerson = personTableList.iterator();
		while (iPerson.hasNext()) {
			Person person = iPerson.next();
			System.out
					.println("ID,FirstName,MiddleName,LastName,EmailAddress= ("
							+ person.getId() + "," + person.getFirstName()
							+ "," + person.getMiddleName()
							+ person.getLastName() + "," + person.getEmail()
							+ ")");
		}

		assert (iPerson != null);
		System.out.println("Finished testing GetCustomers");
	}
}
