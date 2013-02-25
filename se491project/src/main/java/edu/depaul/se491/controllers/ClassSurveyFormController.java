package edu.depaul.se491.controllers;


import java.util.LinkedList;
import java.util.List;

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

@Controller
@SessionAttributes
public class ClassSurveyFormController {

	@RequestMapping(value = "/submitClassSurvey", method = RequestMethod.POST)
	public ModelAndView submitClassSurvey(
			@Valid ClassSurveyFormBean classSurveyFormBean,
			BindingResult result, @ModelAttribute("classId") long id, HttpServletRequest request) {
		
		
		Person vcUser = (Person) request.getSession().getAttribute("vcUser");
	    if (vcUser == null) {
	      return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "login");
	    }
		
		List<String> survey = new LinkedList<String>();
		survey.add(request.getParameter("optionsRadios1"));
		survey.add(request.getParameter("optionsRadios2"));
		survey.add(request.getParameter("optionsRadios3"));
		survey.add(request.getParameter("optionsRadios4"));
		survey.add(request.getParameter("optionsRadios5"));
		survey.add(request.getParameter("optionsRadios6"));
		survey.add(request.getParameter("optionsRadios7"));
		survey.add(request.getParameter("optionsRadios8"));
		survey.add(request.getParameter("optionsRadios9"));
		
		//populate from bean with values from form
		ModelAndView view = new ModelAndView();
	
		
		Key n = KeyFactory.createKey("Classes", id);
		
		if(DaoCmds.addSurvey(n, vcUser.getId(), survey) != null) {
			view = new ModelAndView();
			view.setViewName("displaySurveyCompletedPage");
			view.addObject("tab", "student");
			return view;
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
			 return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "home");
		}

		ClassSurveyFormBean classSurveyFormBean = new ClassSurveyFormBean();
		
        String openId = vcUser.getOpenid();
        
        Key n = KeyFactory.createKey("Classes", id);
        Entity cl = DaoCmds.getClass(n);
        
		view.setViewName("displayClassSurveyPage");
		view.addObject("tab", "student");
		view.addObject("classSurveyFormBean", classSurveyFormBean);
		view.addObject("name", cl.getProperty("className"));
		view.addObject("classId", id);
		view.addObject("questions", classSurveyFormBean.getQuestions());
		view.addObject("answers", classSurveyFormBean.getAnswers());
		return view;
	}

	@RequestMapping("/displaySurveyResults")
	public ModelAndView displayClassSurveyResults(@ModelAttribute("classId") long id, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		Person vcUser = (Person) request.getSession().getAttribute("vcUser");
		if(vcUser == null){
			 return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "login");
		}
		
		String openId = vcUser.getOpenid();
        
        Key n = KeyFactory.createKey("Classes", id);
        Entity cl = DaoCmds.getClass(n);
        int ee = DaoCmds.getEEClass(n);
        int me = DaoCmds.getMEClass(n);
        int dnm = DaoCmds.getDNMClass(n);
        
        view.setViewName("displaySurveyResultsPage");
        view.addObject("tab", "teacher");
        view.addObject("name", cl.getProperty("className"));
        view.addObject("ee", ee);
        view.addObject("me", me);
        view.addObject("dnm", dnm);
        return view;
        
	}
}
