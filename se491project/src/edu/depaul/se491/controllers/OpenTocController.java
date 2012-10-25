package edu.depaul.se491.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


@Controller
@SessionAttributes
public class OpenTocController {
		
	 @RequestMapping("/displayViewClassPage")
	 public ModelAndView checkRegistration() {
		 
		  UserService userService = UserServiceFactory.getUserService();
		  
		  if(!userService.isUserLoggedIn()){
			  return new ModelAndView("displayLoginPage", "command", new Object());
		  }
		  
		 		 
	      return new ModelAndView("displayViewClassPage", "command", new Object());
	  }
	

}
