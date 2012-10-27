<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	UserService userService = UserServiceFactory.getUserService();
%>
<style>
.error {
	color: #ff0000;
}

</style>

	You must complete the Virtual Classroom registration. <br /><br />
	<form:form action="/registerUser.do" method="post"  commandName="userRegistrationFormBean">
        <form:errors path="*" >
        	<div class="error" >Please correct the registration errors and resubmit the form.</div>
        </form:errors>
        <br />
        <form:hidden path="openid"  value="<%=userService.getCurrentUser().getUserId()%>" />
        
    	<table>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="middleName">Middle Name</form:label></td>
				<td><form:input path="middleName" /></td>
				<td><form:errors path="middleName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" cssClass="error" /></td>
			</tr>
				<tr>
				<td><form:label path="phone2">Phone 2</form:label></td>
				<td><form:input path="phone2" /></td>
				<td><form:errors path="phone2" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="address2">Address 2</form:label></td>
				<td><form:input path="address2" /></td>
				<td><form:errors path="address2" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
				<td><form:input path="city" /></td>
				<td><form:errors path="city" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="state">State</form:label></td>
				<td> 
					<form:select path="state">
   						<form:option value="NONE" label="--- Select ---"/>
  						<form:options items="${stateList}" />
					</form:select>
                </td>
				<td><form:errors path="state" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="zip">Zip</form:label></td>
				<td><form:input path="zip" /></td>
				<td><form:errors path="zip" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="country">Country</form:label></td>
				<td> 
					<form:select path="country">
   						<form:option value="NONE" label="--- Select ---"/>
  						<form:options items="${countryList}" />
					</form:select>
                </td>
				<td><form:errors path="country" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="student">Sign up as a Student</form:label></td>
				<td><form:checkbox path="student" value="student" /></td>
				<td><form:errors path="student" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="teacher">Sign up as a Teacher</form:label></td>
				<td><form:checkbox path="teacher" value="teacher" /></td>
				<td><form:errors path="teacher" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register" /></td>			
			</tr>

		</table>

	</form:form>

