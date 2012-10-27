package edu.depaul.se491.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import edu.depaul.se491.formBeans.CreateClassFormBean;

@Controller
@SessionAttributes
public class NavigationViewController extends AbstractController{

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
   
		ModelAndView mav = new ModelAndView("displayListClassesPage", "command", new Object());
		
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


