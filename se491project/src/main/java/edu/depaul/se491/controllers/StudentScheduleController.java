package main.java.edu.depaul.se491.controllers;

import java.util.LinkedList;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.Key;

import main.java.edu.depaul.se491.josqlCmds.DaoCmds;
import main.java.edu.depaul.se491.model.Classes;
import main.java.edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class StudentScheduleController {

	@RequestMapping(value = "/displayStudentSchedule", method = RequestMethod.GET)
	public ModelAndView displayStudentSchedule(HttpServletRequest request) {
		
		Person vcUser = (Person)request.getSession().getAttribute("vcUser");
		String openId= vcUser.getOpenid();
		
		LinkedList<Classes> clist = (LinkedList<Classes>) DaoCmds.getStudentClasses(openId);
		
			

		ModelAndView view = new ModelAndView();
		view.setViewName("displayStudentSchedule");
		view.addObject("tab", "student");
		view.addObject("classes",clist);
	    return view;	
	
	}
	
}
