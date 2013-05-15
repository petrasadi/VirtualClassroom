package edu.depaul.se491.servlets.chat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.depaul.se491.chat.ChatManager;

public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1420462622633565245L;
	ChatManager chatManager = new ChatManager();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		handleRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		handleRequest(request, response);
	}

	protected void handleRequest(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		//TODO - validation for the params
        String userId = request.getParameter("user");
        long classId = Long.parseLong(request.getParameter("classId"));
        String message = request.getParameter("message");
        
        if (userId!= null && classId!=0 && message != null){
    		chatManager.updateClients(classId, userId, message);
        }
		
	}
}
