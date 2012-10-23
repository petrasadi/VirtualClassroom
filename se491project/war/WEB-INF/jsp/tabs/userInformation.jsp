
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<%
	UserService userService = UserServiceFactory.getUserService();
	if (userService.isUserLoggedIn()) {
%>
<br />
Nick Name:<%=userService.getCurrentUser().getNickname()%>
<br />
Email:
<%=userService.getCurrentUser().getEmail()%>
<br />
User ID:
<%=userService.getCurrentUser().getUserId()%>
<br />
Federated Identity:
<%=userService.getCurrentUser().getFederatedIdentity()%>
<br />
Auth Domain:
<%=userService.getCurrentUser().getAuthDomain()%>
<%
	}
%>