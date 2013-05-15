package edu.depaul.se491.servlets.login;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class LoginRedirectServlet extends HttpServlet
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserService userService = UserServiceFactory.getUserService();
        String openIdRedirectUrl = userService.createLoginURL ("/checkRegistration.do", null, "https://www.google.com/accounts/o8/id", null);
  
        response.sendRedirect(openIdRedirectUrl);
    }

}
