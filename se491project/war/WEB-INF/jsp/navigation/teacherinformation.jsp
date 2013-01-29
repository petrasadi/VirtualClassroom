<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="edu.depaul.se491.model.Classes"%>
<link rel="stylesheet" type="text/css" href="/stylesheets/row.css" />



Teacher Information
<br />
<br />
<br />
${teachername}
<br />
${teacheremail}

<br />
<br />
upcomming classes

<div class="container">
	<div class="datagrid">
		<table id="my-table" class="table table-hover">
		<thead><tr><th>Class Name</th><th>Category</th><th>Start Date</th><th>End Date</th><th>Start Time</th><th>End Time</th><th>Register</th></tr></thead>
		<tfoot><tr><td colspan="4"></tr></tfoot>
		<tbody>
			<c:forEach var="class" items="${scheduledclasses}" varStatus="rowCounter">
        		<c:choose>
          			<c:when test="${rowCounter.count % 2 == 0}">
            			<c:set var="rowStyle" scope="page" value=""/>
          			</c:when>
          			<c:otherwise>
            			<c:set var="rowStyle" scope="page" value="alt"/>
          			</c:otherwise>
        		</c:choose>
        		<tr class="${rowStyle}">
          			<td>${class.name}</td>
          			<td>${class.category}</td>
                    <td>${class.classStartDay}</td>
                    <td>${class.classEndDay}</td>
                    <td>${class.classStartTime}</td>
                    <td>${class.classEndTime}</td>
                 	<c:set var="registration" scope="page" value="${class.registration}"/>
          			<% String registration = pageContext.getAttribute("registration").toString();
          			if(registration.equals("Register")) { %>
          				<td><a href="/registerStudentForClass.do?classId=${class.id}" class="btn btn-warning"><i class="icon-ok icon-white"></i> ${class.registration}</a></td>
          			<% } else if (registration.equals("Join")) { %>
          				<td><a href="/joinClass.do?classId=${class.id}" class="btn btn-success"><i class="icon-play icon-white"></i> ${class.registration}</a></td>
          			<% } %>
        		</tr>
      		</c:forEach>
		</tbody>
		</table>
	</div>
</div>


<br />
<br />
Class History

<div class="container">
	<div class="datagrid">
		<table id="my-table" class="table table-hover">
		<thead><tr><th>Class Name</th><th>Category</th><th>Start Date</th><th>End Date</th></tr></thead>
		<tfoot><tr><td colspan="4"></tr></tfoot>
		<tbody>
			<c:forEach var="class" items="${historyclasses}" varStatus="rowCounter">
        		<c:choose>
          			<c:when test="${rowCounter.count % 2 == 0}">
            			<c:set var="rowStyle" scope="page" value=""/>
          			</c:when>
          			<c:otherwise>
            			<c:set var="rowStyle" scope="page" value="alt"/>
          			</c:otherwise>
        		</c:choose>
        		<tr class="${rowStyle}">
          			<td>${class.name}</td>
          			<td>${class.category}</td>
                    <td>${class.classStartDay}</td>
                    <td>${class.classEndDay}</td>
                </tr>
      		</c:forEach>
		</tbody>
		</table>
	</div>
</div>

