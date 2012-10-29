package edu.depaul.se491.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import edu.depaul.se491.formBeans.CreateClassFormBean;
import edu.depaul.se491.josql.CategoryDAO;
import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class CreateClassFormController {
	
	@RequestMapping(value = "/classCreate", method = RequestMethod.POST)
    public ModelAndView addContact(@ModelAttribute("CreateClassFormBean")
    		CreateClassFormBean formBean, BindingResult result) 
	{
         
		DateFormat dateFmt;
		String classStartStr, classEndStr;
		Date classStartDate = null; 
		Date classEndDate = null;
		
		Classes clazz = new Classes();
		IClassesDAO clazzDAO = new ClassesDAO();
		Key clazzKey;
		UserService userService = UserServiceFactory.getUserService();
		IPersonDAO personDAO = new PersonDAO();
		Person vcUser = null;
		
		try {
			vcUser = personDAO.getPersonByOpenId(userService.getCurrentUser().getUserId());
		} catch (PersonException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		clazz.setTeacher(vcUser.getId());
		clazz.setClassName(formBean.getClassTitle());
		clazz.setDescription(formBean.getClassDescription());
		clazz.setMinStudents(Integer.parseInt(formBean.getMinStudents()));
		clazz.setMaxStudents(Integer.parseInt(formBean.getMaxStudents()));
		
		dateFmt = new SimpleDateFormat("MM/dd/yyyy HH:mm aaa");
		classStartStr = formBean.getClassDate() + " " + formBean.getClassStartTime();
		classEndStr = formBean.getClassDate() + " " + formBean.getClassEndTime();
		try 
		{
			classStartDate = dateFmt.parse(classStartStr);
			classEndDate = dateFmt.parse(classEndStr);
		} catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		clazz.setClassStartTime(classStartDate);
		clazz.setClassEndTime(classEndDate);
		try 
		{
			clazzKey = clazzDAO.saveClasses(clazz);
		} catch (ClassesException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("displayClassCreatedPage");
		    return view;
    }

}
