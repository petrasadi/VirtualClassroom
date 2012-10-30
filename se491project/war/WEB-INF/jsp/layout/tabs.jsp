
<link rel="stylesheet" type="text/css" href="/stylesheets/2leveltab.css" />
<script type="text/javascript" src="/javascript/2leveltab.js">
</script>
	
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
<ul id="maintab" class="basictab">
    <li  class="selected" rel="home"><a href="#">Home</a></li>
	
<%
	if (userService.isUserLoggedIn() && roles != null) {
%>


<%
		if (roles.getTeacherActive()) {
%> 
<li  class="notselected" rel="teacher"><a href="#">Teacher</a></li>
<% 
		}
		if (roles.getStudentActive()) {
%> 
<li  class="notselected"  rel="student"><a href="#">Student</a></li>
<%

		}
		if (roles.getAdminActive()) {
%> 
<li  class="notselected" rel="account"><a href="#">Admin</a></li>
<%
		}
%>

<li  class="notselected" rel="account"><a href="#">Account Information</a></li>
<li  class="notselected" ><a href="<%=userService.createLogoutURL("/")%>">Log Out</a></li>

<%
	} else{
%>
<li  class="notselected" ><a href="/displayLoginPage.do">Log In</a></li>
<%
	} 
%>
</ul>

<div id="home" class="submenustyle">
<a href="#">About</a>
</div>

<%
	if (userService.isUserLoggedIn() && roles != null) {
%>


<%
		if (roles.getTeacherActive()) {
%> 

<div id="teacher" class="submenustyle">
<a href="#">Create Class</a>
<a href="#">Scheduled Classes</a>
<a href="#">Completed Classes</a>
<a href="#">View Class</a>
</div>

<% 
		}
		if (roles.getStudentActive()) {
%>
<div id="student" class="submenustyle">
<a href="#">Search Classes</a>
<a href="#">Register For Class</a>
<a href="#">Scheduled Classes</a>
<a href="#">Completed Classes</a>
<a href="#">View Class</a>
</div>

<%

		}
		if (roles.getAdminActive()) {
%> 

<div id="admin" class="submenustyle">
<a href="#">Create Category</a>
<a href="#">List Users</a>
<a href="#">List Classes</a>
</div>

<%
	} 
}		
%>


<div id="account" class="submenustyle">
<a href="#">User Account</a>
<a href="#">Edit</a>
</div>


<script type="text/javascript">
//initialize tab menu, by passing in ID of UL
initalizetab("maintab")
</script>


