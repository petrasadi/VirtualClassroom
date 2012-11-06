package edu.depaul.se491.controllers;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Classes;

@Controller
@SessionAttributes
public class ClassRegistrationController {
	@RequestMapping(value = "/displayClassRegistration", method = RequestMethod.GET)
	public ModelAndView displayClassRegistration(HttpServletRequest request) {
		LinkedList<Classes> clist = (LinkedList<Classes>) DaoCmds.getClasses();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("displayClassRegistration");
		view.addObject("tab","student");
		view.addObject("classes",clist);
	    return view;	
	}
}
