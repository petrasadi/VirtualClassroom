package edu.depaul.se491.controllers;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController
{


    boolean isLoggedIn(HttpServletRequest request)
    {

        UserService userService = UserServiceFactory.getUserService();

        if (!userService.isUserLoggedIn()) {
            return false;
        }
        if (request.getSession().getAttribute("vcUser") == null) {
            return false;
        }

        return true;
    }
}
