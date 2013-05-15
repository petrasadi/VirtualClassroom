<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>

<div class="container">
<div class="navbar">
    <p class="brand">Class Roster</p>
    	</div><br/><br/>
    <div class="datagrid">

        <table id="my-table" class="table table-hover">
            <thead>
            <tr>
                <th>Student</th>
                <th>Email</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <td colspan="2">
            </tr>
            </tfoot>
            <tbody>
            <c:forEach var="student" items="${studentList}" varStatus="rowCounter">
                <tr>
                    <td><a href="/displayStudentInformation.do?openId=${student.openid}">${student.firstName} ${student.lastName}</a></td>
                    <td>${student.email}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

