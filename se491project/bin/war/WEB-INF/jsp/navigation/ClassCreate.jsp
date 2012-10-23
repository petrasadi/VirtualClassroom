<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Class</title>
<link rel="stylesheet" type="text/css" href="/stylesheets/960.css" />
<link rel="stylesheet" type="text/css" href="/stylesheets/BasicStyle.css" />
</head>
<body>
	<div><h1>Create a Class</h1></div><br /><br />
	<form:form action="/classCreate.do" method="post">
       
   		<table>
   			<tr>
   				<td><form:label path="classTitle">Class Title</form:label></td>
   				<td><form:input path="classTitle" /></td>
   			</tr>  
   			<tr>
   				<td><form:label path="minStudents">Minimum Number Of Students</form:label></td>
   				<td><form:input path="minStudents" /></td>
   			</tr>
   			<tr>
   				<td><form:label path="maxStudents">Maximum Number Of Students</form:label></td>
   				<td><form:input path="maxStudents" /></td>
   			</tr>
   			<tr>
   				<td><form:label path="classDate">Class Date</form:label></td>
   				<td><form:input path="classDate" /></td>
   			</tr>
   			<tr>
				<td colspan="2"><input type="submit" value="Create Class" /></td>			
			</tr>
   			
   		</table> 		
	</form:form>

</body>
</html>