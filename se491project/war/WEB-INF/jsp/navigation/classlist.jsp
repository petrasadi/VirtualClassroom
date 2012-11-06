<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Class Teaching</title>
<link rel="stylesheet" type="text/css" href="/stylesheets/960.css" />
<link rel="stylesheet" type="text/css" href="/stylesheets/BasicStyle.css" />
</head>
<body>
You are teaching the following classes:


 <table>
      <c:forEach var="vsclass" items="${vcClasses}">
        <tr>
          <td>${vsclass.classTitle}</td>
          <td>${vsclass.maxStudents}</td>
          <td>${vsclass.minStudents}</td>
        </tr>
      </c:forEach>
    </table>


</body>
</html>