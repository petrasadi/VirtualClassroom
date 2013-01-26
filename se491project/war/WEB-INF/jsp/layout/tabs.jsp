
<link rel="stylesheet" type="text/css" href="/stylesheets/2leveltab.css" />
<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css" />
<script type="text/javascript" src="/javascript/2leveltab.js"></script>
	
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="edu.depaul.se491.model.Person"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%
// Determin what tab is the selected tab first set all tabs to not selected.
 String teacherSelect = "notselected";
 String studentSelect = "notselected";
 String homeSelect = "notselected";
 String adminSelect = "notselected";
 String accountSelect = "notselected";
 String loginSelect = "notselected";

 String tab = (String)request.getAttribute("tab");
 if(tab == null){
   	tab = "home";
 }else if(tab.equals("home")){
 	homeSelect = "active";
 }else if(tab.equals("teacher")){
 	teacherSelect = "active";//"selected";
 }else if(tab.equals("student")){
 	studentSelect = "active";//"selected";
 }else if(tab.equals("admin")){
 	adminSelect = "active";//"selected";
 }else if(tab.equals("userinformation")){
 	accountSelect = "active";//"selected";
 }else if(tab.equals("login")){
 	loginSelect = "active";//"selected";
 }else{
 	homeSelect = "active";//"selected";
 }
 


 UserService userService = UserServiceFactory.getUserService();
 Person vcUser = (Person)session.getAttribute("vcUser");

%>
<div class="navbar">
<div class="navbar-inner">
<ul id="maintab" class="nav">
    <li  class="<%= homeSelect %>" rel="home"><a href="#"><i class="icon-home"></i> Home</a></li>
	
<%
	if (userService.isUserLoggedIn() && vcUser != null) {
%>


<%
		if (vcUser.isTeacher()) {
%> 
<li  class="<%= teacherSelect %>" rel="teacher"><a href="#">Teacher</a></li>
<% 
		}
		if (vcUser.isStudent()) {
%> 
<li  class="<%=studentSelect %>"  rel="student"><a href="#">Student</a></li>
<%

		}
		if (vcUser.isAdmin()) {
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
</div>
</div>

<ul id="home" class="btn-group" style="display: block;">
<button class="btn" onclick="window.location.href='/displayAboutPage.do'">About</button>
<button class="btn" onclick="window.location.href='/displayAvailableClasses.do'">Available Classes</button>
<button class="btn" onclick="window.location.href='/displayUserInstructions.do'">Instructions</button>
</ul>

<%
	if (userService.isUserLoggedIn() && vcUser != null) {
%>


<%
		if (vcUser.isTeacher()){
%> 

<ul id="teacher" class="btn-group" style="display: none;">
<button class="btn" onclick="window.location.href='/displayCreateClassPage.do'">Create Class</button>
<button class="btn" onclick="window.location.href='/displayTeacherListCurrentClasses.do'">Scheduled Classes</button>
<button class="btn" onclick="window.location.href='#'">Completed Classes</button>
</ul>

<% 
		}
		if (vcUser.isStudent()) {
%>
<ul id="student" class="btn-group" style="display: none;">
<button class="btn" onclick="window.location.href='/displayClassRegistration.do'">Register For Class</button>
<button class="btn" onclick="window.location.href='/displayClassSchedule.do'">Class Schedule</button>
<button class="btn" onclick="window.location.href='/displayClassHistory.do'">Class History</button>
</ul>

<%

		}
		if (vcUser.isAdmin()) {
%> 

<ul id="admin" class="btn-group" style="display: none;">
<button class="btn" onclick="window.location.href='#'">Create Category</button>
<button class="btn" onclick="window.location.href='#'">List Users</button>
<button class="btn" onclick="window.location.href='#'">List Classes</button>
</ul>

<%
	} 
}		
%>


<ul id="account" class="btn-group" style="display: none;">
<button class="btn" onclick="window.location.href='/displayUserInformationPage.do'">User Account</button>
<button class="btn" onclick="window.location.href='/editUserInformationPage.do'">Edit</button>
</ul>


<script type="text/javascript">
//initialize tab menu, by passing in ID of UL
initalizetab("maintab")
</script>


