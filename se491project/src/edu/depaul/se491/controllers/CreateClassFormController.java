package edu.depaul.se491.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
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
import edu.depaul.se491.josql.ICategoryDAO;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.josql.IPersonDAO;
import edu.depaul.se491.josql.PersonDAO;
import edu.depaul.se491.josql.PersonException;
import edu.depaul.se491.model.Category;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class CreateClassFormController {
	
/*	@Autowired
    private Validator validator;
    
    public void setValidator(Validator validator) {
        this.validator = validator;
    }*/
	
	@RequestMapping(value = "/classCreate", method = RequestMethod.POST)
    public ModelAndView classCreate(@Valid CreateClassFormBean createClassFormBean, BindingResult result, HttpServletRequest request) 
	{
		ModelAndView view = new ModelAndView();
		//validator.validate(createClassFormBean, result);
        if (result.hasErrors()) 
        { 
        	System.out.println("Found Form Errors");
        	view.setViewName("displayCreateClassPage");
        	view.addObject("createClassFormBean", createClassFormBean);
    		view.addObject("tab", "teacher");
        	return view;
        } 
		
		DateFormat dateFmt;
		String classStartStr, classEndStr;
		Date classStartDate = null; 
		Date classEndDate = null;
		
		Classes clazz = new Classes();
		IClassesDAO clazzDAO = new ClassesDAO();
		Key clazzKey;
		ICategoryDAO catDAO = new CategoryDAO();
		Category category = new Category();
		Key catKey;
		
		UserService userService = UserServiceFactory.getUserService();
		IPersonDAO personDAO = new PersonDAO();
		Person vcUser = null;
		
		try {
			vcUser = personDAO.getPersonByOpenId(userService.getCurrentUser().getUserId());
		} catch (PersonException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*category.setName(formBean.getClassCategory());
		category.setDescription("to be written");
		System.out.println("setCategoryName");
		System.out.println("CategoryID: " + category.getId().toString());
		catDAO.saveCategory(category);
		catKey = catDAO.saveCategory(category);
		System.out.println("saved Category");*/
		
		clazz.setTeacher(vcUser.getId());
		clazz.setClassName(createClassFormBean.getClassTitle());
		clazz.setDescription(createClassFormBean.getClassDescription());
/*		System.out.println("setting class Category");
		clazz.setCategory(catKey);
		System.out.println("class Category set");*/
		clazz.setMinStudents(Integer.parseInt(createClassFormBean.getMinStudents()));
		clazz.setMaxStudents(Integer.parseInt(createClassFormBean.getMaxStudents()));
		
		dateFmt = new SimpleDateFormat("MM/dd/yyyy HH:mm aaa");
		classStartStr = createClassFormBean.getClassDate() + " " + createClassFormBean.getClassStartTime();
		classEndStr = createClassFormBean.getClassDate() + " " + createClassFormBean.getClassEndTime();
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
		
		view = new ModelAndView();
		view.setViewName("displayClassCreatedPage");
		view.addObject("tab", "teacher");
		return view;
    }

}
