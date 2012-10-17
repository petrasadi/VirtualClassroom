package edu.depaul.se491.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class TabViewController {

	@RequestMapping("/logout")
	public ModelAndView displayLoginPage() {
		return new ModelAndView("displayAboutPage", "command", new Object());
	}
	
	@RequestMapping("/displayUserInformationPage")
	public ModelAndView displayUserInformationPage() {
		return new ModelAndView("displayUserInformationPage", "command", new Object());
	}
	  @RequestMapping("/displayAboutPage")
	  public ModelAndView displayAboutPage() {
	      return new ModelAndView("displayAboutPage", "command", new Object());
	  }
	  


}
