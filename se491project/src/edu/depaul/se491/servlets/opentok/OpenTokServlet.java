package edu.depaul.se491.servlets.opentok;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import edu.depaul.se491.opentok.OpenTokUtil;

public class OpenTokServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String sessionData = null;

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
		if (request.getParameter("param").equals("forget")){
			//System.out.println("FORGET SESSION request received");
			sessionData = null;
		} else  if (request.getParameter("param").equals("info")){
			//System.out.println("SESSION INFO request received");
			if (sessionData == null) {
				//serialize session info to json
				sessionData = new OpenTokUtil().getSessionInfo();
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(sessionData);
		}
	}
	

}
