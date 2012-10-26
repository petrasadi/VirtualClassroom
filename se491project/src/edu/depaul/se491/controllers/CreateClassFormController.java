package edu.depaul.se491.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.depaul.se491.formBeans.CreateClassFormBean;

@Controller
@SessionAttributes
public class CreateClassFormController {
	
	@RequestMapping(value = "/classCreate", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("CreateClassFormBean")
    		CreateClassFormBean formBean, BindingResult result) {
         
		System.out.println("Class Name:" + formBean.getClassTitle());
		System.out.println("Class Date:" + formBean.getClassDate());
		System.out.println("Min Students:" + formBean.getMinStudents());
		System.out.println("Max Students:" + formBean.getMinStudents());
        
        return "redirect:/classcreated.jsp";
    }

}
