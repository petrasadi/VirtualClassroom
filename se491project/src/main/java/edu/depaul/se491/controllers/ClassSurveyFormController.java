package edu.depaul.se491.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import edu.depaul.se491.formBeans.ClassSurveyFormBean;
import edu.depaul.se491.josqlCmds.DaoCmds;
import edu.depaul.se491.model.Person;
import edu.depaul.se491.survey.ClassEvaluationSurvey;

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
	public ModelAndView displayClassSurveyPage(@ModelAttribute("classId") long id, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		Person vcUser = (Person)request.getSession().getAttribute("vcUser");
		if(vcUser == null){
			 return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "login");
		}

		ClassSurveyFormBean classSurveyFormBean = new ClassSurveyFormBean();
		
        String openId = vcUser.getOpenid();
        
        Key n = KeyFactory.createKey("Classes", id);
        Entity cl = DaoCmds.getClass(n);
        
		view.setViewName("displayClassSurveyPage");
		view.addObject("tab", "student");
		view.addObject("classSurveyFormBean", classSurveyFormBean);
		view.addObject("name", cl.getProperty("className"));
		view.addObject("questions", classSurveyFormBean.getQuestions());
		view.addObject("answers", classSurveyFormBean.getAnswers());
		return view;
	}


}
