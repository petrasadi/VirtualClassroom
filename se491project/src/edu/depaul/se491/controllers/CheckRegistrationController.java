package edu.depaul.se491.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import edu.depaul.se491.formBeans.UserRegistrationFormBean;


@Controller
@SessionAttributes
public class CheckRegistrationController {
		
	 @RequestMapping("/checkRegistration")
	 public ModelAndView checkRegistration() {
		 
		  UserService userService = UserServiceFactory.getUserService();
		  
		  if(!userService.isUserLoggedIn()){
			  return new ModelAndView("displayLoginPage", "command", new Object());
		  }
		  
		  // todo  register a user with andy entity and dao classes
		  /****
		  VCUserDAO vcuserDAO = new VCUserDAO();
          VCUser vcUser = vcuserDAO.getVCUser(userService.getCurrentUser().getUserId());
		  
          if(vcUser == null){
        	  return new ModelAndView("displayUserRegistrationPage", "command", new UserRegistrationFormBean());
          }
		 
		 ****/
	      return new ModelAndView("displayUserLoggedInPage", "command", new Object());
	            
	  }
	 
	 
	 @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	 public ModelAndView registerUser( @ModelAttribute("userRegistrationFormBean") UserRegistrationFormBean userRegistrationFormBean, BindingResult result) {
	
		 // todo  register a user with andy entity and dao classes
		 
		 return new ModelAndView("displayUserLoggedInPage", "command", new UserRegistrationFormBean());
	 }
	 

}
