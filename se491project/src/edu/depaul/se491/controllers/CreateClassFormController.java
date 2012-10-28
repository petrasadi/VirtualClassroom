package edu.depaul.se491.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.depaul.se491.formBeans.CreateClassFormBean;
import edu.depaul.se491.model.Classes;

@Controller
@SessionAttributes
public class CreateClassFormController {
	
	@RequestMapping(value = "/classCreate", method = RequestMethod.POST)
    public ModelAndView addContact(@ModelAttribute("CreateClassFormBean")
    		CreateClassFormBean formBean, BindingResult result) 
	{
         
		System.out.println("Class Name:" + formBean.getClassTitle());
		System.out.println("Class Date:" + formBean.getClassDate());
		System.out.println("Min Students:" + formBean.getMinStudents());
		System.out.println("Max Students:" + formBean.getMaxStudents());
		
		DateFormat dateFmt;
		String classStartStr, classEndStr;
		Date classStartDate, classEndDate;
		Classes clazz = new Classes();
		clazz.setClassName(formBean.getClassTitle());
		clazz.setDescription(formBean.getClassDescription());
		//clazz.setCategory(formBean.getClassCategory());
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
        
		ModelAndView view = new ModelAndView();
		view.setViewName("displayClassCreatedPage");
		    return view;
    }

}
