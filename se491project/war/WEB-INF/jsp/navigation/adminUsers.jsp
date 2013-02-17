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
        <form>
        <table id="my-table" class="table table-hover">
            <thead>
            <tr>
                <th>User</th>
                <th>Email</th>
                <th>Teacher</th>
                <th>Student</th>
                <th>Admin</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <td colspan="2">
            </tr>
            </tfoot>
            <tbody>
            <c:forEach var="user" items="${userList}" varStatus="rowCounter">
        
                <tr >
                    <td>${user.firstName} ${user.lastName}</td>
                    <td>${user.email}</td>
                    <c:choose>
                       <c:when test="${user.teacher}"><td>Yes</td></c:when>
                       <c:otherwise><td>No</td></c:otherwise>                    
                    </c:choose>
                     <c:choose>
                       <c:when test="${user.student}"><td>Yes</td></c:when>
                       <c:otherwise><td>No</td></c:otherwise>                    
                    </c:choose>
                     <c:choose>
                       <c:when test="${user.admin}"><td><input type="checkbox" name="admin" value="admin" checked></td></c:when>
                       <c:otherwise><td><input type="checkbox" name="admin" value="admin"></td></c:otherwise>                    
                    </c:choose>
                    
                </tr>
            </c:forEach>
       
            </tbody>
        </table>
        <input type="submit" value="Save">
        </form>
    </div>

</div>

