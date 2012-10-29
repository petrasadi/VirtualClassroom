<link rel="stylesheet" type="text/css" href="/stylesheets/tabs.css" />
<link rel="stylesheet" type="text/css" href="/stylesheets/BasicStyle.css" />
<link rel="stylesheet" type="text/css" href="/stylesheets/zurbFoundationCustom.css" />
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="edu.depaul.se491.model.Person"%>
<%@ page import="edu.depaul.se491.model.Role"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<%
    String tab = (String)session.getAttribute("tab");
    if(tab == null){
    	tab = "home";
    }
	UserService userService = UserServiceFactory.getUserService();
    Person vcUser = (Person)session.getAttribute("vcUser");
    Role roles = null;
    if(vcUser!= null){
    	roles = vcUser.getRole();
    }
%>
<div id="navcontainer">
		<ul id="navlist">
		<li><a <% if(tab.equals("home")) { %> id="current" <%}%> href="/displayAboutPage.do">Home</a></li>
<%
	if (userService.isUserLoggedIn() && roles != null) {
%>




<%
		if (roles.getTeacherActive()) {
%> 
<li><a <% if(tab.equals("teacher")) { %> id="current" <%}%>href="/displayTeacherMainPage.do">Teacher</a></li>
<% 
		}
		if (roles.getStudentActive()) {
%> 
<li><a <% if(tab.equals("student")) { %> id="current" <%}%> href="/displayStudentMainPage.do">Student</a></li>
<%

		}
		if (roles.getAdminActive()) {
%> 
<li><a <% if(tab.equals("admin")) { %> id="current" <%}%> href="/displayAboutPage.do">Admin</a></li>
<%
		}
%>

<li><a <% if(tab.equals("userinformation")) { %> id="current" <%}%> href="/displayUserInformationPage.do">Account Information</a></li>
<li><a  href="<%=userService.createLogoutURL("/")%>">Logout</a></li>
<%
	} else{
%>
<li><a <% if(tab.equals("login")) { %> id="current" <%}%> href="/displayLoginPage.do">Login</a></li>
<%
	} 
%>



	
		
			
	
		
			
			

		</ul>
	</div>