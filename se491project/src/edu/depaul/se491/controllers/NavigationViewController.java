package edu.depaul.se491.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import edu.depaul.se491.dao.VCUserDAO;
import edu.depaul.se491.entities.VCUser;
import edu.depaul.se491.formBeans.CreateClassFormBean;
import edu.depaul.se491.formBeans.UserRegistrationFormBean;

@Controller
@SessionAttributes
public class NavigationViewController {

	@RequestMapping("/displayLoginPage")
	public ModelAndView displayLoginPage() {
		return new ModelAndView("displayLoginPage", "command", new Object());
	}

	@RequestMapping("/displayCreateClassPage")
	public ModelAndView displayCreateClassPage() {
		return new ModelAndView("displayCreateClassPage", "command",
				new CreateClassFormBean());
	}

	@RequestMapping("/displayListClassesPage")
	public ModelAndView displayListClassesPage() {

		UserService userService = UserServiceFactory.getUserService();

		if (!userService.isUserLoggedIn()) {
			return new ModelAndView("displayLoginPage", "command", new Object());
		}

		VCUserDAO vcuserDAO = new VCUserDAO();
		VCUser vcUser = vcuserDAO.getVCUser(userService.getCurrentUser().getUserId());

		if (vcUser == null) {
			return new ModelAndView("displayUserRegistrationPage", "command", new UserRegistrationFormBean());
		}
   
		ModelAndView mav = new ModelAndView("displayListClassesPage", "command", vcUser);
		mav.addObject("vcUser",vcUser);
		mav.addObject("vcClasses",vcUser.getClassesTeaching());
		mav.addObject("numberofclasses",vcUser.getClassesTeaching().size());
		
		return mav;
	}

	@RequestMapping("/displaySearchClassPage")
	public ModelAndView displaySearchClassPage() {
		return new ModelAndView("displaySearchClassPage", "command",
				new Object());
	}

	@RequestMapping("/displayRegisterClassPage")
	public ModelAndView displayRegisterClassPage() {
		return new ModelAndView("displayRegisterClassPage", "command",
				new Object());
	}

}


