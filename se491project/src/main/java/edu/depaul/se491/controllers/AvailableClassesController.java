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
public class AvailableClassesController {

	@RequestMapping(value = "/displayAvailableClasses", method = RequestMethod.GET)
	public ModelAndView displayAvailableClasses(HttpServletRequest request) {
	
		LinkedList<Classes> clist = (LinkedList<Classes>) DaoCmds.getClasses();
	
		ModelAndView view = new ModelAndView();
		view.setViewName("displayAvailableClasses");
		view.addObject("tab", "home");
		view.addObject("classes",clist);
	    return view;	
	
	}
	
}