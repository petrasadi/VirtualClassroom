<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="edu.depaul.se491.model.Person" %>
<%
UserService userService = UserServiceFactory.getUserService();
Person vcUser = (Person) session.getAttribute("vcUser");
%>
<div class="top-menu">
	<% if (userService.isUserLoggedIn() && vcUser != null) { %>
	 <a class="btn btn-warning" href="<%=userService.createLogoutURL("/logout.do")%>">logout</a>
	
	<% } else { %>
    <a class="btn btn-success" href="/_ah/login_redirect">login</a>
    <% } %>
</div>