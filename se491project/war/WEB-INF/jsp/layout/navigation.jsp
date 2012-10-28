
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

<div class=menu>
<br />
<br />
<br />
<br />
<br />
<% 
		if(tab.equals("teacher")){		  
%>
			<a href="/displayCreateClassPage.do">Create a Class</a> <br />
			<a href="/displayListClassesPage.do">List Classes In Progress</a> <br />
			List Finished Classes <br />
			<a href="/displayViewClassPage.do">View Class</a> <br />
<%
	  	}
	  	if(tab.equals("student")){		  
%>
			<a href="/displaySearchClassPage.do">Class Search</a> <br />
			<a href="/displayRegisterClassPage.do">Class Register</a> <br />
			Class Schedule <br />
			Class History <br />
			<a href="/displayViewClassPage.do">View Class</a> <br />
<%
	  	}
	  	if(tab.equals("home")){		  
%>



<%
	  	}
	 	if(tab.equals("userinformation")){		  
%>
		Edit Information

<%
	  }
 
	}
%>


</div>