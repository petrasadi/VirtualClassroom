<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="edu.depaul.se491.model.Person"%>
<%@ page import="edu.depaul.se491.model.Role"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	UserService userService = UserServiceFactory.getUserService();
    Person vcUser = (Person)session.getAttribute("vcUser");
    Role roles = null;
    if(vcUser!= null){
    	roles = vcUser.getRole();
    }
	if (userService.isUserLoggedIn() && roles != null) {
%>

<a href="/displayAboutPage.do">About</a>  |
<%
		if (roles.getTeacherActive()) {
%> 
<a href="/displayTeacherMainPage.do">Teacher</a> |
<%
		}
		if (roles.getStudentActive()) {
%> 
<a href="/displayStudentMainPage.do.do">Student</a>   |
<%

		}
		if (roles.getAdminActive()) {
%> 
<a href="/displayAboutPage.do">Admin</a>    |
<%
		}
%>

<a href="/displayUserInformationPage.do">User Information  |</a>
<a href="<%=userService.createLogoutURL("/")%>">log out</a>
<%
	} else{
%>
<a href="/displayAboutPage.do">About</a>  | 
<a href="/displayLoginPage.do">Login</a> <br>
<%
	} 
%>


 

