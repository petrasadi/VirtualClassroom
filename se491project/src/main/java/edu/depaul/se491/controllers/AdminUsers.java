package edu.depaul.se491.controllers;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.EntityNotFoundException;

import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;
import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class AdminUsers
{

    @RequestMapping(value = "/displayAdminUsersPage.do", method = RequestMethod.GET)
    public ModelAndView displayUsers(HttpServletRequest request)
    {
      
        Person vcUser = (Person) request.getSession().getAttribute("vcUser");
  
        LinkedList<Person> userlist = (LinkedList<Person>) DaoCmds.getPersons();
        
        

        ModelAndView view = new ModelAndView();
        view.setViewName("displayAdminUsers");
        view.addObject("tab", "admin");
        view.addObject("userList", userlist);

        return view;
    }
    
    
    
    @RequestMapping(value = "/updateAdminUsersPage.do", method = RequestMethod.POST)
    public ModelAndView updateUsers(HttpServletRequest request,  @RequestParam(value = "admin", required=false) String admin)
    {
      
       Person vcUser = (Person) request.getSession().getAttribute("vcUser");
       LinkedList<Person> userlist = (LinkedList<Person>) DaoCmds.getPersons();
       IPersonDAO personDAO = new PersonDAO();
       
       if(admin == null){
    	   admin="";
       }
        
       for(Person user : userlist){
    	   if(admin == null){
    		   System.out.println("admin is null");
    		   
    	   }
    	   
    	   if(user == null){
    		   System.out.println("user is null");
    		   
    	   }
    	   
    	   System.out.println(admin);
    	   System.out.println(user.getFirstName());
    	   System.out.println("****" + user.getOpenid());
    	   
    	   if(admin.contains(user.getOpenid())){
    		   user.setAdmin(true);
    		   
    	   }else{
    		   user.setAdmin(false); 
    	   }
    	   try {
    		  personDAO.savePerson(user);
    	   } catch (PersonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    	   } catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    	   }
       }
        
       userlist = (LinkedList<Person>) DaoCmds.getPersons();
        
        ModelAndView view = new ModelAndView();
        view.setViewName("displayAdminUsers");
        view.addObject("tab", "admin");
        view.addObject("admin", admin);
        view.addObject("userList", userlist);

        return view;
    }


}
