package edu.depaul.se491.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class AdminCategory
{

    @RequestMapping(value = "/displayAdminCategoriesPage.do", method = RequestMethod.GET)
    public ModelAndView displayStudentSchedule(HttpServletRequest request)
    {
      

        ModelAndView view = new ModelAndView();
        
        view.setViewName("displayAdminCategories");
        view.addObject("tab", "admin");

        return view;
    }

}
