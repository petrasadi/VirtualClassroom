package edu.depaul.se491.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



@Controller
@SessionAttributes
public class NavigationViewController
{
  
	  @RequestMapping("/displayLoginPage")
	  public ModelAndView displayLoginPage() {
	       return new ModelAndView("displayLoginPage", "command", new Object());
	  }
	  
	  @RequestMapping("/displayCreateClassPage")
	  public ModelAndView displayCreateClassPage() {
	       return new ModelAndView("displayCreateClassPage", "command", new Object());
	  }
	  
	  @RequestMapping("/displayListClassesPage")
	  public ModelAndView displayListClassesPage() {
	       return new ModelAndView("displayListClassesPage", "command", new Object());
	  }
	  
	  @RequestMapping("/displaySearchClassPage")
	  public ModelAndView displaySearchClassPage() {
	       return new ModelAndView("displaySearchClassPage", "command", new Object());
	  }
	  
	  @RequestMapping("/displayRegisterClassPage")
	  public ModelAndView displayRegisterClassPage() {
	       return new ModelAndView("displayRegisterClassPage", "command", new Object());
	  }
	  

	}
	 


