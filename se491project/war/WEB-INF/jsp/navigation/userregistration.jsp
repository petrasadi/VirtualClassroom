<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	UserService userService = UserServiceFactory.getUserService();
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Page</title>
</head>
<body>
	You must complete the Virtual Classroom registration. <br /><br />
	<form:form action="/registerUser.do" method="post">
        <form:hidden path="openID"  value="<%=userService.getCurrentUser().getUserId()%>" />
    	<table>
			<tr>
				<td><form:label path="fname">First Name</form:label></td>
				<td><form:input path="fname" /></td>
			</tr>
			<tr>
				<td><form:label path="lname">Last Name</form:label></td>
				<td><form:input path="lname" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="student">Sign up as a student</form:label></td>
				<td><form:checkbox path="student" value="student" /></td>
			</tr>
			<tr>
				<td><form:label path="teacher">Sign up as a teacher</form:label></td>
				<td><form:checkbox path="teacher" value="teacher" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register" /></td>			
			</tr>

		</table>

	</form:form>

</body>
</html>