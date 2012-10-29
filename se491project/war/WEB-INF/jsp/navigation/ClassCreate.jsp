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
<link rel="stylesheet" type="text/css" href="/stylesheets/zurbFoundationCustom.css" />
</head>
<body>
	<div class="container_9">
	<div class="grid_9"><h1>Create a Class</h1></div>
	<form:form action="/classCreate.do" method="post">
      <ul class=table> 
   		
   			<li>
   				<div class="grid_3">
   					<form:label path="classTitle">Class Title</form:label>
   					<form:input path="classTitle" />
   				</div>
   				
   				<div class="grid_3">
   					<form:label path="classDescription">Class Description</form:label>
   					<form:input path="classDescription" />
   				</div>
   				
   			</li>  
   			
   			<li>
   				<div class="grid_3">
   					<form:label path="classCategory">Class Category</form:label>
   					<form:input path="classCategory" />
   				</div>
   				<div class="grid_3">
   						<form:label path="classLevel">Class Level</form:label>
   					<ul>
   						<li>
   							<form:label path="classLevel">Beginner</form:label>
   							<form:radiobutton path="classLevel" value="beginner"/>
   						</li>
   						<li>
   							<form:label path="classLevel">Intermediate</form:label>
   							<form:radiobutton path="classLevel" value="intermediate"/>
   						</li>
   						<li>
   							<form:label path="classLevel">Advanced</form:label>
   							<form:radiobutton path="classLevel" value="advanced"/>
   						</li>
   					</ul>
   				</div>
   			</li>
   			
   			<li>
   				<div class="grid_3">
   					<form:label path="minStudents">Minimum Class Size:</form:label>
   					<form:input path="minStudents" />
   				</div>
   				<div class="grid_3">
   					<form:label path="maxStudents">Maximum Class Size:</form:label>
   					<form:input path="maxStudents" />
   				</div>
   			</li>
   			<li>
   				<div class="grid_3">
   					<form:label path="classDate">Class Date</form:label>
   					<form:input path="classDate" />
   				</div>
   				<div class="grid_3">
   					<form:label path="classStartTime">Class Start Time</form:label>
   					<form:input path="classStartTime" />
   				</div>
   				<div class="grid_3">
   					<form:label path="classEndTime">Class End Time</form:label>
   					<form:input path="classEndTime" />
   				</div>
   			</li>
   			<li>
				<div class="grid_3 prefix_3"><input type="submit" value="Create Class" /></div>			
			</li>
   			
   		 
   		</ul>		
	</form:form>
	</div>
</body>
</html>