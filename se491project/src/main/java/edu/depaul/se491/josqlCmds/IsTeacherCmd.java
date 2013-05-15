package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Key;
import edu.depaul.se491.josql.*;

class IsTeacherCmd implements IDaoCommands
{
    String OpenId;
    long OpenTokId;

    public IsTeacherCmd(String OpenId, long OpenTokId)
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

    public boolean isExecute()
    {
        IClassesDAO classes = new ClassesDAO();
        IPersonDAO person = new PersonDAO();
        try {
            Key t = (Key) classes.getClassById(OpenTokId).getProperty("teacher");
            Key p = person.getPersonByOpenId(this.OpenId).getId();
            if (t.equals(p)) {
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
