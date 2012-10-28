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
		request.getSession().setAttribute("tab", "about");
		return new ModelAndView("displayAboutPage", "command", new Object());
	}
	
	@RequestMapping("/displayUserInformationPage")
	public ModelAndView displayUserInformationPage(HttpServletRequest request) {
		request.getSession().setAttribute("tab", "userinformation");
		return new ModelAndView("displayUserInformationPage", "command", new Object());
	}
	
	@RequestMapping("/displayAboutPage")
	public ModelAndView displayAboutPage(HttpServletRequest request) {
		request.getSession().setAttribute("tab", "about");
	    return new ModelAndView("displayAboutPage", "command", new Object()).addObject("tab", "about");
	}
	
	@RequestMapping("/displayTeacherMainPage")
	public ModelAndView displayTeacherMainPage(HttpServletRequest request) {
		request.getSession().setAttribute("tab", "teacher");
	    return new ModelAndView("displayTeacherMainPage", "command", new Object()).addObject("tab", "teacher");
	}
	
	@RequestMapping("/displayStudentMainPage")
	public ModelAndView displayStudentMainPage(HttpServletRequest request) {
		request.getSession().setAttribute("tab", "student");
	    return new ModelAndView("displayStudentMainPage", "command", new Object());
	}
	  
	@RequestMapping("/displayLoginPage")
	public ModelAndView displayLoginPage(HttpServletRequest request) {
		request.getSession().setAttribute("tab", "about");
		return new ModelAndView("displayLoginPage", "command", new Object());
	}


}

