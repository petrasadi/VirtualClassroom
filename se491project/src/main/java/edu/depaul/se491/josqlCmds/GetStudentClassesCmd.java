package edu.depaul.se491.josqlCmds;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import edu.depaul.se491.josql.*;
import edu.depaul.se491.model.Classes;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

class GetStudentClassesCmd implements IDaoCommands
{
    String openId;

    public GetStudentClassesCmd(String openId)
    {
        this.openId = openId;
    }

    public Key execute()
    {
        return null;
    }

    public boolean isExecute()
    {
        return false;
    }

    @SuppressWarnings("unchecked")
    public LinkedList<Classes> getExecute()
    {
        IClassesDAO classes = new ClassesDAO();
        IPersonDAO person = new PersonDAO();
        try {
            Key p = person.getPersonByOpenId(this.openId).getId();
            LinkedList<Classes> clist = new LinkedList<Classes>();
            Iterable<Entity> c = classes.getStudentClasses(p);

            for (Entity e : c) {
                Classes cl = null;
                if (e != null && e.getKey() != null)
                    cl = new Classes();
                cl.setCategory((Key) e.getProperty("category"));
                cl.setId(e.getKey());
                cl.setClassEndTime((Date) e.getProperty("classendtime"));
                cl.setClassStartTime((Date) e.getProperty("classstarttime"));
                cl.setClassName((String) e.getProperty("className"));
                cl.setDescription((String) e.getProperty("description"));
                cl.setMaxStudents(((Long) e.getProperty("maxstudents")).intValue());
                cl.setMinStudents(((Long) e.getProperty("minstudents")).intValue());
                //cl.setOpenTokId(((Long) e.getProperty("opentokid")).longValue());
                cl.setTeacher((Key) e.getProperty("teacher"));
                cl.setStudents((List<Key>) e.getProperty("students"));
                clist.add(cl);
            }
            return clist;
        } catch (ClassesException e) {
            e.printStackTrace();
            return null;
        } catch (PersonException e) {
            e.printStackTrace();
            return null;
        }
    }
}