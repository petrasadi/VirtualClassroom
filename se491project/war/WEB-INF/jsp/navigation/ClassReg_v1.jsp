<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="edu.depaul.se491.formBeans.ClassRegistrationListBean"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register for Class</title>

<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
	// Write on keyup event of keyword input element
	$("#kwd_search").keyup(function(){
		// When value of the input is not blank
		if( $(this).val() != "")
		{
			// Show only matching TR, hide rest of them
			$("#my-table tbody>tr").hide();
			$("#my-table td:contains-ci('" + $(this).val() + "')").parent("tr").show();
		}
		else
		{
			// When there is no input or clean again, show everything back
			$("#my-table tbody>tr").show();
		}
	});
});
// jQuery expression for case-insensitive filter
$.extend($.expr[":"], 
{
    "contains-ci": function(elem, i, match, array) 
	{
		return (elem.textContent || elem.innerText || $(elem).text() || "").toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	}
});
</script>
</head>
<body>
<div class="container">
	<form class="navbar-form pull-left"><input type="text" id="kwd_search" class="span2" placeholder="Search"></form>
	<div class="datagrid">
		<table id="my-table" class="table table-hover">
		<thead><tr><th>Class Name</th><th>Teacher</th><th>Category</th><th>Start Date</th><th>End Date</th><th>Registration</th></tr></thead>
			<tfoot><tr><td colspan="4"></tr></tfoot>
			<tbody>
			<c:forEach var="classes" items="${classes}" varStatus="rowCounter">
        <c:choose>
          <c:when test="${rowCounter.count % 2 == 0}">
            <c:set var="rowStyle" scope="page" value=""/>
          </c:when>
          <c:otherwise>
            <c:set var="rowStyle" scope="page" value="alt"/>
          </c:otherwise>
        </c:choose>
        <tr class="${rowStyle}">
          <td>${classes.name}</td>
          <td><a href="/displayTeacherInformation.do?openId=${classes.openId}">${classes.teacherName}</a></td>
          <td>${classes.category}</td>
          <td>${classes.startDate}</td>
          <td>${classes.endDate}</td>
          <c:set var="registration" scope="page" value="${classes.registration}"/>
          <% String registration = pageContext.getAttribute("registration").toString();
          if(registration.equals("Register")) { %>
          <td><a href="/registerStudentForClass.do?classId=${classes.id}" class="btn btn-warning"><i class="icon-ok icon-white"></i> ${classes.registration}</a></td>
          <% } else if (registration.equals("Join")) { %>
          <td><a href="/joinClass.do?classId=${classes.id}" class="btn btn-success"><i class="icon-play icon-white"></i> ${classes.registration}</a></td>
          <% } %>
        </tr>
      </c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>