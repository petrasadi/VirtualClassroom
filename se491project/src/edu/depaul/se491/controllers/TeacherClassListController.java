package edu.depaul.se491.controllers;

import java.util.LinkedList;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class TeacherClassListController {

	@RequestMapping(value = "/displayTeacherListCurrentClasses", method = RequestMethod.GET)
	public ModelAndView displayTeacherListCurrentClasses(HttpServletRequest request) {
		
		Person vcUser = (Person)request.getSession().getAttribute("vcUser");
		Key userKey = vcUser.getId();


		LinkedList<Classes> clist = (LinkedList<Classes>) DaoCmds.getClasses();
		
			
		// get only the teachers classes
		LinkedList<Classes> tlist = new LinkedList<Classes>();
		
		ListIterator<Classes> itr = clist.listIterator();
		
  	     while(itr.hasNext()){
  	    	Classes c = (Classes) itr.next();
  	    	if(userKey.equals(c.getTeacher())){
  	    		tlist.add(c);
  	    	}
		 }

		ModelAndView view = new ModelAndView();
		view.setViewName("displayTeacherListCurrentClasses");
		view.addObject("tab", "teacher");
		view.addObject("classes",tlist);
	    return view;	
	
	}
	
}
