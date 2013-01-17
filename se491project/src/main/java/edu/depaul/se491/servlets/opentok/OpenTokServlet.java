package main.java.edu.depaul.se491.servlets.opentok;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import main.java.edu.depaul.se491.opentok.SessionManager;

public class OpenTokServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionManager sessionManager = new SessionManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		doStuff(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		doStuff(request, response);
	}


	protected void doStuff(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {

		//TODO - validation on classId
		long classId = Long.parseLong(request.getParameter("classId"));
		String userOpenId = request.getParameter("user");
		if (classId != 0){
			String sessionData = sessionManager.getSessionInfo(classId, userOpenId);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(sessionData);
		}
	}
}