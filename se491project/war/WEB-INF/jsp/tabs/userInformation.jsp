<%@ page import="edu.depaul.se491.model.Person"%>
<%@ page import="edu.depaul.se491.model.Role"%>



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
		     <% 
		     Person vcUser = (Person)session.getAttribute("vcUser");
		     Role role = (Role)vcUser.getRole();
		     
		     if(role.getStudentActive()){  %>
				Yes
			 <% }else{  %>			
				No
			 <% }  %>
	    </td>
	</tr>
	<tr>
		<td>Signed up as a Teacher</td>
		<td> <% 		 	     
		     if(role.getTeacherActive()){  %>
				Yes
			 <% }else{  %>			
				No
			 <% }  %>
		</td>
	</tr>
</Table>



