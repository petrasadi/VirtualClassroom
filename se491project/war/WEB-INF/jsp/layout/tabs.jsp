
<link rel="stylesheet" type="text/css" href="/stylesheets/2leveltab.css" />
<script type="text/javascript" src="/javascript/2leveltab.js">
</script>
	
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="edu.depaul.se491.model.Person"%>
<%@ page import="edu.depaul.se491.model.Role"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%
// Determin what tab is the selected tab first set all tabs to not selected.
 String teacherSelect = "notselected";
 String studentSelect = "notselected";
 String homeSelect = "notselected";
 String adminSelect = "notselected";
 String accountSelect = "notselected";
 String loginSelect = "notselected";

 String tab = (String)session.getAttribute("tab");
 if(tab == null){
   	tab = "home";
 }else if(tab.equals("home")){
 	homeSelect = "selected";
 }else if(tab.equals("teacher")){
 	teacherSelect = "selected";
 }else if(tab.equals("student")){
 	studentSelect = "selected";
 }else if(tab.equals("admin")){
 	adminSelect = "selected";
 }else if(tab.equals("acount")){
 	accountSelect = "selected";
 }else if(tab.equals("login")){
 	loginSelect = "selected";
 }else{
 	homeSelect = "selected";
 }
 


 UserService userService = UserServiceFactory.getUserService();
 Person vcUser = (Person)session.getAttribute("vcUser");
 Role roles = null;
 if(vcUser!= null){
   	roles = vcUser.getRole();
 }
%>
<ul id="maintab" class="basictab">
    <li  class="<%= homeSelect %>" rel="home"><a href="#">Home</a></li>
	
<%
	if (userService.isUserLoggedIn() && roles != null) {
%>


<%
		if (roles.getTeacherActive()) {
%> 
<li  class="<%= teacherSelect %>" rel="teacher"><a href="#">Teacher</a></li>
<% 
		}
		if (roles.getStudentActive()) {
%> 
<li  class="<%=studentSelect %>"  rel="student"><a href="#">Student</a></li>
<%

		}
		if (roles.getAdminActive()) {
%> 
<li  class="<%=adminSelect %>" rel="admin"><a href="#">Admin</a></li>
<%
		}
%>

<li  class="<%=accountSelect %>" rel="account"><a href="#">Account Information</a></li>
<li  class="notselected" ><a href="<%=userService.createLogoutURL("/")%>">Log Out</a></li>

<%
	} else{
%>
<li  class="<%=loginSelect %>" ><a href="/displayLoginPage.do">Log In</a></li>
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
<a href="href="/displayCreateClassPage.do"">Create Class</a>
<a href="/displayListClassesPage.do">Scheduled Classes</a>
<a href="#">Completed Classes</a>
<a href="href="/displayViewClassPage.do"">View Class</a>
</div>

<% 
		}
		if (roles.getStudentActive()) {
%>
<div id="student" class="submenustyle">
<a href="/displaySearchClassPage.do">Search Classes</a>
<a href="/displayRegisterClassPage.do">Register For Class</a>
<a href="#">Scheduled Classes</a>
<a href="#">Completed Classes</a>
<a href="/displayViewClassPage.do">View Class</a>
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
<a href="/displayUserInformationPage.do">User Account</a>
<a href="#">Edit</a>
</div>


<script type="text/javascript">
//initialize tab menu, by passing in ID of UL
initalizetab("maintab")
</script>


