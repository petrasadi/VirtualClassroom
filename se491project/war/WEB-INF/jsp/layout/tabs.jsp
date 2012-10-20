<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<%
	UserService userService = UserServiceFactory.getUserService();
	if (userService.isUserLoggedIn()) {
%>


<div class="grid_4">
<a href="/displayAboutPage.do">About</a>  | 
Teacher  |
Student  |
<a href="/displayUserInformationPage.do">User Information</a>
<a href="<%=userService.createLogoutURL("/")%>">log out</a>
</div>

<%
	} else{
%>

<div class="grid_4">
<a href="/displayAboutPage.do">About</a>  | 
<a href="/displayLoginPage.do">Login</a> <br>
</div>



<%
	} 
%>

