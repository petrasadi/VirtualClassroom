package edu.depaul.se491.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.Key;

import edu.depaul.se491.formBeans.ClassSurveyFormBean;
import edu.depaul.se491.formBeans.CreateClassFormBean;
import edu.depaul.se491.josql.ClassesDAO;
import edu.depaul.se491.josql.ClassesException;
import edu.depaul.se491.josql.IClassesDAO;
import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Classes;
import edu.depaul.se491.model.Person;

@Controller
@SessionAttributes
public class ClassSurveyFormController {

	@RequestMapping(value = "/submitClassSurvey", method = RequestMethod.POST)
	public ModelAndView submitClassSurvey(
			@Valid ClassSurveyFormBean classSurveyFormBean,
			BindingResult result, HttpServletRequest request) {

		//populate from bean with values from form
		System.out.println("process form data");
		ModelAndView view = new ModelAndView();
		// validator.validate(createClassFormBean, result);
		if (result.hasErrors()) {
			view.setViewName("displayClassSurveyPage");
			view.addObject("classSurveyFormBean", classSurveyFormBean);
			view.addObject("tab", "student");
			return view;
		}

	
		Person vcUser = (Person) request.getSession().getAttribute("vcUser");
		if(vcUser == null){
			 return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "login");
		}


		view = new ModelAndView();
		view.setViewName("displayClassCreatedPage");
		view.addObject("tab", "student");
		return view;
	}

	@RequestMapping("/displayClassSurveyPage")
	public ModelAndView displayClassSurveyPage(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		Person vcUser = (Person)request.getSession().getAttribute("vcUser");
		if(vcUser == null){
			 return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "login");
		}

		ClassSurveyFormBean classSurveyFormBean = new ClassSurveyFormBean();
		
		//classSurveyFormBean.setQ1("beginner");
		//classSurveyFormBean.setQ2("5:00 PM");
		//classSurveyFormBean.setQ3("9:30 PM");
		
		System.out.println("display form");

		view.setViewName("displayClassSurveyPage");
		view.addObject("tab", "student");
		view.addObject("classSurveyFormBean", classSurveyFormBean);
		return view;
	}


}
