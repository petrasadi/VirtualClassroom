<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="edu.depaul.se491.model.Person"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<Table>
	<tr>
		<td align="center" colspan="2" >User Information</td>
	</tr>
	<tr>
		<td>First Name</td>
		<td>${sessionScope.vcUser.firstName}</td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td>${sessionScope.vcUser.lastName}</td>
	</tr>
	<tr>
		<td>Middle Name</td>
		<td>${sessionScope.vcUser.middleName}</td>
	</tr>
	<tr>
		<td>Phone</td>
		<td>${sessionScope.vcUser.phone}</td>
	</tr>
	<tr>
		<td>Phone 2</td>
		<td>${sessionScope.vcUser.phone2}</td>
	</tr>
	<tr>
		<td>Email</td>
		<td>${sessionScope.vcUser.email}</td>
	</tr>
	<tr>
		<td>Address</td>
		<td>${sessionScope.vcUser.address}</td>
	</tr>
	<tr>
		<td>Address 2</td>
		<td>${sessionScope.vcUser.address2}</td>
	</tr>
	<tr>
		<td>City</td>
		<td>${sessionScope.vcUser.city}</td>
	</tr>
	<tr>
		<td>State</td>
		<td>${sessionScope.vcUser.state}</td>
	</tr>
	<tr>
		<td>Zip</td>
		<td>${sessionScope.vcUser.zip}</td>
	</tr>
	<tr>
		<td>Country</td>
		<td>${sessionScope.vcUser.country}</td>
	</tr>
	<tr>
		<td>Signed up as a Student</td>
		<td>
		   <c:choose>
               <c:when test="${sessionScope.vcUser.student}">Yes </c:when>
        	   <c:otherwise>No  </c:otherwise>    
            </c:choose>		   
	    </td>
	</tr>
	<tr>
		<td>Signed up as a Teacher</td>
		<td> 
			 <c:choose>
               <c:when test="${sessionScope.vcUser.teacher}">Yes </c:when>
        	   <c:otherwise>No  </c:otherwise>    
            </c:choose>	
	
		</td>
	</tr>
</Table>



