<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="edu.depaul.se491.model.Classes"%>
<link rel="stylesheet" type="text/css" href="/stylesheets/row.css" />



List of Class Taken at virtual Classroom 
<br />
<br />
<br />

<div class="container">
	<div class="datagrid">
		<table id="my-table" class="table table-hover">
		<thead><tr><th>Class Name</th><th>Teacher</th><th>Category</th><th>End Date</th><th>Grade</th></tr></thead>
		<tfoot><tr><td colspan="4"></tr></tfoot>
		<tbody>
			<c:forEach var="class" items="${classes}" varStatus="rowCounter">
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
          			<td>${class.teacherName}</td>
          			<td>${class.category}</td>
                    <td>${class.classEndDay}</td>
                    <td>Unavailable</td>
                </tr>
      		</c:forEach>
		</tbody>
		</table>
	</div>
	
</div>

