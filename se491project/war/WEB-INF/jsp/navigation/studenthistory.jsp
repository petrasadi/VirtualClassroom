<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/stylesheets/row.css"/>

<div class="container">
    <div class="datagrid">
    <div class="navbar">
    	<p class="brand">List of Class Taken at virtual Classroom</p><br/>
<br/>

    	</div>
        <table id="my-table" class="table table-hover">
            <thead>
            <tr>
                <th>Class Name</th>
                <th>Teacher</th>
                <th>Category</th>
                <th>End Date</th>
                <th>Grade</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <td colspan="4">
            </tr>
            </tfoot>
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
                    <td><a href="/displayTeacherInformation.do?openId=${class.openId}">${class.teacherName}</a></td>
                    <td>${class.category}</td>
                    <td>${class.classEndDay}</td>
                    <td>Unavailable</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

