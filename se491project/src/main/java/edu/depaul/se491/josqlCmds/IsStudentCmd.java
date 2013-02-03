package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import edu.depaul.se491.josql.*;

import java.util.List;

class IsStudentCmd implements IDaoCommands
{
    String OpenId;
    long OpenTokId;

    public IsStudentCmd(String OpenId, long OpenTokId)
    {
        this.OpenId = OpenId;
        this.OpenTokId = OpenTokId;
    }

    public Key execute()
    {
        return null;
    }

    public Object getExecute()
    {
        return null;
    }

    @SuppressWarnings("unchecked")
    public boolean isExecute()
    {
        IClassesDAO classes = new ClassesDAO();
        IPersonDAO person = new PersonDAO();

        try {
            Entity c = classes.getClassById(OpenTokId);
            List<Key> t = (List<Key>) c.getProperty("students");
            if (t == null) {
                return false;
            }
            Key p = person.getPersonByOpenId(this.OpenId).getId();
            if (t.contains(p)) {
                return true;
            } else {
                return false;
            }
        } catch (PersonException e) {
            return false;
        } catch (ClassesException e) {
            return false;
        }
    }
}
