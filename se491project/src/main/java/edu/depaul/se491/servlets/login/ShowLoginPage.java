package edu.depaul.se491.servlets.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowLoginPage extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/tabs/openidlogin.jsp");
        request.setAttribute("continue", "");
        view.forward(request, response);
    }

}
