package edu.depaul.se491.controllers;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@SessionAttributes
public class OpenTocController
{

    @RequestMapping("/displayTeacherViewClassPage")
    public ModelAndView displayTeacherViewClassPage(HttpServletRequest request)
    {

        UserService userService = UserServiceFactory.getUserService();

        if (!userService.isUserLoggedIn()) {
            return new ModelAndView("displayLoginPage", "command", new Object());
        }

        ModelAndView view = new ModelAndView();
        view.setViewName("displayViewClassPage");
        view.addObject("tab", "teacher");
        view.addObject("command", new Object());
        view.addObject("classid", Long.parseLong(request.getParameter("classid")));

        return view;

    }


    @RequestMapping("/displayStudentViewClassPage")
    public ModelAndView displayStudentViewClassPage(HttpServletRequest request)
    {

        UserService userService = UserServiceFactory.getUserService();

        if (!userService.isUserLoggedIn()) {
            return new ModelAndView("displayLoginPage", "command", new Object());
        }


        return new ModelAndView("displayViewClassPage", "command", new Object()).addObject("tab", "student");
    }


}
