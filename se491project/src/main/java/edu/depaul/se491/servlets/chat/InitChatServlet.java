package edu.depaul.se491.servlets.chat;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.depaul.se491.chat.ChatManager;

/*
 * chat implemented using the Channel API
 */
public class InitChatServlet extends HttpServlet {

	private static final long serialVersionUID = 1420462622633565245L;
	private ChatManager chatManager = new ChatManager();

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
		
		//FIXME - what if parseLong fails
        String userOpenId = request.getParameter("user");
        long classId = Long.parseLong(request.getParameter("classId"));
        
        //FIXME - why is classId=0?
		if (userOpenId!= null && classId!=0){
            String chatToken = chatManager.getTokenAsJson(userOpenId, classId);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(chatToken);
		}
	}
}
