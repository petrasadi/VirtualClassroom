package edu.depaul.se491.controllers;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class NavigationViewController extends AbstractController
{


    @RequestMapping("/displayListClassesPage")
    public ModelAndView displayListClassesPage()
    {

        UserService userService = UserServiceFactory.getUserService();

        if (!userService.isUserLoggedIn()) {
            return new ModelAndView("displayLoginPage", "command", new Object()).addObject("tab", "home");
        }

        ModelAndView mav = new ModelAndView("displayListClassesPage", "command", new Object()).addObject("tab", "teacher");
       

        return mav;
    }

    @RequestMapping("/displaySearchClassPage")
    public ModelAndView displaySearchClassPage()
    {
        return new ModelAndView("displaySearchClassPage", "command",
                new Object()).addObject("tab", "student");
    }

    @RequestMapping("/displayRegisterClassPage")
    public ModelAndView displayRegisterClassPage()
    {
        return new ModelAndView("displayRegisterClassPage", "command",
                new Object()).addObject("tab", "student");
    }
}


