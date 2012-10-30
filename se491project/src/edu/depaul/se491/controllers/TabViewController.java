package edu.depaul.se491.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class TabViewController {

	@RequestMapping("/logout")
	public ModelAndView displayLogoutPage(HttpServletRequest request) {
		return new ModelAndView("displayAboutPage", "command", new Object()).addObject("tab", "home");
	}
	
	@RequestMapping("/displayUserInformationPage")
	public ModelAndView displayUserInformationPage(HttpServletRequest request) {
		return new ModelAndView("displayUserInformationPage", "command", new Object()).addObject("tab", "userinformation");
	}
	
	@RequestMapping("/displayAboutPage")
	public ModelAndView displayAboutPage(HttpServletRequest request) {
	    return new ModelAndView("displayAboutPage", "command", new Object()).addObject("tab", "home");
	}
	
	@RequestMapping("/displayTeacherMainPage")
	public ModelAndView displayTeacherMainPage(HttpServletRequest request) {
	    return new ModelAndView("displayTeacherMainPage", "command", new Object()).addObject("tab", "teacher");
	}
	
	@RequestMapping("/displayStudentMainPage")
	public ModelAndView displayStudentMainPage(HttpServletRequest request) {
	    return new ModelAndView("displayStudentMainPage", "command", new Object()).addObject("tab", "student");
	}
	  
	@RequestMapping("/displayLoginPage")
	public ModelAndView displayLoginPage(HttpServletRequest request) {
		return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "login");
	}


}

