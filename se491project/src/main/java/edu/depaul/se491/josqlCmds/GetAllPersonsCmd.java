package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;
import edu.depaul.se491.model.Person;

import java.util.LinkedList;

class GetAllPersonsCmd implements IDaoCommands
{
    public Key execute()
    {
        return null;
    }

    public boolean isExecute()
    {
        return false;
    }

    public LinkedList<Person> getExecute()
    {
        IPersonDAO persons = new PersonDAO();
        try {
            LinkedList<Person> plist = new LinkedList<Person>();
            Iterable<Entity> pe = persons.getAllPerson();
            for (Entity e : pe) {
                Person pf = null;
                if (e != null && e.getKey() != null) {
                    pf = new Person();
                    pf.setId(e.getKey());
                    pf.setOpenid((String) e.getProperty("openid"));
                    pf.setFirstName((String) e.getProperty("firstname"));
                    pf.setLastName((String) e.getProperty("lastname"));
                    pf.setMiddleName((String) e.getProperty("middlename"));
                    pf.setAddress((String) e.getProperty("address"));
                    pf.setAddress2((String) e.getProperty("address2"));
                    pf.setCity((String) e.getProperty("city"));
                    pf.setState((String) e.getProperty("state"));
                    pf.setZip((String) e.getProperty("zip"));
                    pf.setCountry((String) e.getProperty("country"));
                    pf.setPhone((String) e.getProperty("phone"));
                    pf.setPhone2((String) e.getProperty("phone2"));
                    pf.setEmail((String) e.getProperty("email"));
                    pf.setOpenid((String) e.getProperty("openid"));
                    plist.add(pf);
                }
            }
            return plist;
        } catch (PersonException e) {
            e.printStackTrace();
            return null;
        }
    }
}
