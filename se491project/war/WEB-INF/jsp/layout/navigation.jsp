
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<div class=menu>

<%
	UserService userService = UserServiceFactory.getUserService();
	if (!userService.isUserLoggedIn()) {
%>
<a href="/displayAboutPage.do">About</a> <br />
<a href="/displayLoginPage.do">Login</a> <br />
<%
	} else{
%>

<a href="/displayCreateClassPage.do">Creat Class</a> <br />
<a href="/displayListClassesPage.do">List Classes</a> <br />
<a href="/displaySearchClassPage.do">Class Search</a> <br />
<a href="/displayRegisterClassPage.do">Class Register</a> <br />
<%
	}
%>

</div>