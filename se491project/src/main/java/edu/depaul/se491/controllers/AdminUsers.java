package edu.depaul.se491.controllers;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class AdminUsers
{

    @RequestMapping(value = "/displayAdminUsersPage.do", method = RequestMethod.GET)
    public ModelAndView displayStudentSchedule(HttpServletRequest request)
    {
      
        Person vcUser = (Person) request.getSession().getAttribute("vcUser");
  
        LinkedList<Person> userlist = (LinkedList<Person>) DaoCmds.getPersons();
        
        

        ModelAndView view = new ModelAndView();
        view.setViewName("displayAdminUsers");
        view.addObject("tab", "admin");
        view.addObject("userList", userlist);

        return view;
    }

}
