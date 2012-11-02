package edu.depaul.se491.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class TabViewController {

	@RequestMapping("/logout")
	public ModelAndView displayLogoutPage(HttpServletRequest request) {
		return new ModelAndView("displayAboutPage", "command", new Object()).addObject("tab", "home");
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
	
	@RequestMapping("/displayErrorJavaExceptionPage")
	public ModelAndView displayErrorJavaExceptionPage(HttpServletRequest request) {
		return new ModelAndView("displayErrorJavaExceptionPage", "command", new Object()).addObject("tab", "home");
	}
	
	@RequestMapping("/displayError404Page")
	public ModelAndView displayError404Page(HttpServletRequest request) {
		return new ModelAndView("displayError404Page", "command", new Object()).addObject("tab", "home");
	}

}

