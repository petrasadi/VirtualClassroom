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

import edu.depaul.se491.dao.VCUserDAO;
import edu.depaul.se491.entities.VCClass;
import edu.depaul.se491.entities.VCUser;
import edu.depaul.se491.formBeans.CreateClassFormBean;
import edu.depaul.se491.formBeans.UserRegistrationFormBean;

@Controller
@SessionAttributes
public class TeacherClassController {

	@RequestMapping(value = "/classCreates", method = RequestMethod.POST)
	public ModelAndView createClass(@ModelAttribute("createClassFormBean") CreateClassFormBean createClassFormBean, BindingResult result) {
		
		 UserService userService = UserServiceFactory.getUserService();
		  
		  if(!userService.isUserLoggedIn()){
			  return new ModelAndView("displayLoginPage", "command", new Object());
		  }
		  
		 VCUserDAO vcuserDAO = new VCUserDAO();
         VCUser vcUser = vcuserDAO.getVCUser(userService.getCurrentUser().getUserId());
	  
         if(vcUser == null){
       	  return new ModelAndView("displayUserRegistrationPage", "command", new UserRegistrationFormBean());
         }
         
         vcUser.addClassesTeaching(new VCClass(createClassFormBean.getClassTitle(), createClassFormBean.getMaxStudents(), createClassFormBean.getMinStudents(), null));
        
                
		 return new ModelAndView("displayClassCreatedPage", "command", new CreateClassFormBean());
	}
	
}
