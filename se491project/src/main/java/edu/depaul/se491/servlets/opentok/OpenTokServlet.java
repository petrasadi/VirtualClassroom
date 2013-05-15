package edu.depaul.se491.servlets.opentok;

import edu.depaul.se491.opentok.SessionManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OpenTokServlet extends HttpServlet
{

	private static final long serialVersionUID = -7826158042929606757L;
	private SessionManager sessionManager = new SessionManager();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException
    {
        handleRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        handleRequest(request, response);
    }


    protected void handleRequest(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException
    {

        //TODO - validation on classId
        long classId = Long.parseLong(request.getParameter("classId"));
        String userOpenId = request.getParameter("user");
        if (classId != 0) {
            String sessionData = sessionManager.getSessionInfo(classId, userOpenId);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(sessionData);
        }
    }
}