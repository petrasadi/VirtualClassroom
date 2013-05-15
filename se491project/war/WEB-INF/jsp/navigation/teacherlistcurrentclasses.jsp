<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/stylesheets/row.css"/>

<div class="container">
	<div class="navbar">
    	<p class="brand">List of Scheduled Classes to Teach</p><br/>
<br/>
    	</div>
    <div class="datagrid">
        <table id="my-table" class="table table-hover">
            <thead>
            <tr>
                <th>Class Name</th>
                <th>Category</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Registered Students</th>
                <th>Start Class</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <td colspan="4">
            </tr>
            </tfoot>
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
                    <td><a href="/displayStudentInClass.do?classId=${class.id}">${class.numberOfRegisteredStudents}
                        Students</a>
                    </td>
                    <c:set var="registration" scope="page" value="${class.registration}"/>
                    <% String registration = pageContext.getAttribute("registration").toString();
                    if (registration.equals("Join")) { %>
                    <td><a href="/joinClass.do?classId=${class.id}" class="btn btn-success"><i
                            class="icon-play icon-white"></i>Start Class</a></td>
                    <% } else if (registration.equals("Not Time To Join")) { %>
                    <td></td>
                    <% } %>     
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
