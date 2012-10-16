<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Virtual Classroom</title>
<link rel="stylesheet" type="text/css" href="/stylesheets/960.css" />
<link rel="stylesheet" type="text/css"
	href="/stylesheets/BasicStyle.css" />
</head>
<body>

	<div class="container_9">

		<!-- This should go into the header file once we flesh out the more sophisticated UI-->
		<%
			UserService userService = UserServiceFactory.getUserService();
			if (userService.isUserLoggedIn()) {
		%>
		<ul class=menu>
			<li><a href="/ClassCreate.html">Create Class</a></li>
			<li><a href="/ClassSearch.html">Class Search</a></li>
		</ul>
		<%
			}
		%>

		<h1>Welcome to Virtual Classroom</h1>
		<p>Introduction/welcome statement that still needs to be written.
		</p>
		<%
			if (!userService.isUserLoggedIn()) {
		%>
		<div class="grid_4">
			<a href="/showLogin">Login</a>
		</div>
		<%
			} else {
		%>
	
		<ul>
			<li>
				<div class="grid_4">
					<a href="/UserReg.html">Create Account</a>
				</div>
				<div class="grid_4">
					<a href="<%=userService.createLogoutURL("/")%>">log out</a>
				</div>
			</li>

			<li>
				<div class="grid_4">
					<a href="/ClassSearch.html">Class Search</a>
				</div>
				<div class="grid_4">
					<a href="/ClassCreate.html">Create Class</a>
				</div>
			</li>
		</ul>
	</div>
	<%
		}
	%>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<%
		if (userService.isUserLoggedIn()) {
	%>
	<br /> Nick Name:<%=userService.getCurrentUser().getNickname()%>
	<br /> Email:	<%=userService.getCurrentUser().getEmail()%>
	<br /> User ID:	<%=userService.getCurrentUser().getUserId()%>
	<br /> Federated Identity: <%=userService.getCurrentUser().getFederatedIdentity()%>
	<br /> Auth Domain:	<%=userService.getCurrentUser().getAuthDomain()%>
	<%
		}
	%>
</body>
</html>

