<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>

<div class="container">
<div class="navbar">
    <p class="brand">Current User List</p>
    	</div><br/><br/>
    <div class="datagrid">

        <table id="my-table" class="table table-hover">
            <thead>
            <tr>
                <th>User</th>
                <th>Email</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <td colspan="2">
            </tr>
            </tfoot>
            <tbody>
            <c:forEach var="user" items="${userList}" varStatus="rowCounter">
                <c:choose>
                    <c:when test="${rowCounter.count % 2 == 0}">
                        <c:set var="rowStyle" scope="page" value=""/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="rowStyle" scope="page" value="alt"/>
                    </c:otherwise>
                </c:choose>
                <tr class="${rowStyle}">
                    <td>${user.firstName} ${user.lastName}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

