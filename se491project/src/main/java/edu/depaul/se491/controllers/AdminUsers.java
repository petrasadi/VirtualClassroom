package edu.depaul.se491.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class AdminUsers
{

    @RequestMapping(value = "/displayAdminUsersPage.do", method = RequestMethod.GET)
    public ModelAndView displayStudentSchedule(HttpServletRequest request)
    {
      

        ModelAndView view = new ModelAndView();
        view.setViewName("displayAdminUsers");
        view.addObject("tab", "admin");

        return view;
    }

}
