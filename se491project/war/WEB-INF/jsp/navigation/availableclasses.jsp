 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="edu.depaul.se491.model.Classes"%>
<link rel="stylesheet" type="text/css" href="/stylesheets/row.css" />



List ofAvailable Classes
<br />
<br />
<br />

<table>
   	  <tr class="rowheader">
          <td>Class Name</td>
          <td>Class Description</td>
          <td>Class Date</td>
          <td>Start Time</td>
          <td>End Time</td>
          <td>Min Students</td>
          <td>Max Students</td>
      </tr>
      <c:forEach var="class" items="${classes}" varStatus="rowCounter">
        <c:choose>
          <c:when test="${rowCounter.count % 2 == 0}">
            <c:set var="rowStyle" scope="page" value="oddrow"/>
          </c:when>
          <c:otherwise>
            <c:set var="rowStyle" scope="page" value="evenrow"/>
          </c:otherwise>
        </c:choose>
        <tr class="${rowStyle}">
          <td>${class.className}</td>
          <td>${class.description}</td>
          <td>${class.displayClassDate}</td>
          <td>${class.displayClassStartTime}</td>
          <td>${class.displayClassEndTime}</td>
          <td>${class.minStudents}</td>
          <td>${class.maxStudents}</td>
        </tr>
      </c:forEach>
      
</table>