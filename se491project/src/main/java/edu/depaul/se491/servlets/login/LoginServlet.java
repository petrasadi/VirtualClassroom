package edu.depaul.se491.servlets.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/tabs/openidlogin.jsp");
	
		System.out.println("***************** in LoginServlet ");
		if (request.getParameter("continue") != null) {
			request.setAttribute("continue", request.getParameter("continue"));			
		} else {
			request.setAttribute("continue", request.getRequestURI());
		}	
				
		view.forward(request, response);
		
	}
}
