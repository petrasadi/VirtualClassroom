<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/stylesheets/row.css"/>

<div class="container">
    <div class="datagrid">
    <div class="navbar">
    	<p class="brand">List of Classes Taken at Virtual Classroom</p><br/>
<br/>

    	</div>
        <table id="my-table" class="table table-hover">
            <thead>
            <tr>
                <th>Class Name</th>
                <th>Teacher</th>
                <th>Category</th>
                <th>End Date</th>
                <th>Survey</th>
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
                    <c:choose>
                    <c:when test = "${class.survey}">
						<td><a href="/displayClassSurveyPage.do?openId=${class.openId}&classId=${class.id}" class="btn btn-warning disabled" onClick='return false'><i
                            class="icon-remove icon-white"></i> Survey</a></td>
                    </c:when>
                    <c:otherwise>
                    	<td><a href="/displayClassSurveyPage.do?openId=${class.openId}&classId=${class.id}" class="btn btn-warning"><i
                            class="icon-exclamation-sign icon-white"></i> Survey</a></td>
                    </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

