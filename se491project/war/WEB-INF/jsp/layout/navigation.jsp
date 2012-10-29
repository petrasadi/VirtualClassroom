
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
    String tab = (String)session.getAttribute("tab");
  	if (userService.isUserLoggedIn() && roles != null && tab != null) {
%>
<link rel="stylesheet" type="text/css" href="/stylesheets/960.css" />
<link rel="stylesheet" type="text/css" href="/stylesheets/BasicStyle.css" />
<link rel="stylesheet" type="text/css" href="/stylesheets/zurbFoundationCustom.css" />

<div class=menu>
<br />
<br />
<br />
<br />
<br />
<% 
		if(tab.equals("teacher")){		  
%>			
			<ul class="tabs-content">
			<li id="vertTabsExTab" class="active" style="display: block;">
				<dl class="vertical tabs">
					<dd><a href="/displayCreateClassPage.do">Create a Class</a></dd>
					<dd><a href="/displayListClassesPage.do">List Classes In Progress</a></dd>
					<dd>List Finished Classes</dd>
					<dd><a href="/displayViewClassPage.do">View Class</a></dd>
				</dl>
			</li>
			</ul>
<%
	  	}
	  	if(tab.equals("student")){		  
%>
			<ul class="tabs-content">
			<li id="vertTabsExTab" class="active" style="display: block;">
				<dl class="vertical tabs">
					<dd><a href="/displaySearchClassPage.do">Class Search</a></dd> 
					<dd><a href="/displayRegisterClassPage.do">Class Register</a></dd> 
					<dd>Class Schedule</dd> 
					<dd>Class History </dd>
					<dd><a href="/displayViewClassPage.do">View Class</a></dd>
			</dl>
			</li>
			</ul>
<%
	  	}
	  	if(tab.equals("home")){		  
%>



<%
	  	}
	 	if(tab.equals("userinformation")){		  
%>
		<ul class="tabs-content">
			<li id="vertTabsExTab" class="active" style="display: block;">
				<dl class="vertical tabs">
				<dd>Edit Information</dd>
				</dl>
			</li>
		</ul>

<%
	  }
 
	}
%>


</div>