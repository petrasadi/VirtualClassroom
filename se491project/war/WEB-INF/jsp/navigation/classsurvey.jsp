<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	UserService userService = UserServiceFactory.getUserService();
%>
<link rel="stylesheet" type="text/css" href="/stylesheets/960.css" />
<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/stylesheets/error.css" />

<style>
.error {
	color: #ff0000;
}
</style>

	<div class="container_9">
	<div class="grid_9"><h3>Please complete the class survey for *TO DO: Course Name*.</h3></div>
	
	<form:form action="/submitClassSurvey.do" method="post"  commandName="classSurveyFormBean" >

        <br />
      
    			 <form:errors path="*" >
        			<div class="error" class="grid_9">Please correct the errors and resubmit the form.</div>
        		</form:errors>
    		
				<div class="grid_3">
					<form:label path="q1" id="question1">Course objectives were clearly defined</form:label>
				</div>
				<div class="grid_6">
					<form:radiobutton path="q1" value="DNME" /> Did NOT meet expectations <br/>
					<form:radiobutton path="q1" value="ME" /> Meet expectations <br/>
					<form:radiobutton path="q1" value="EE" /> Exceeded expectations <br/>
					<form:errors path="q1" cssClass="error" />
				</div>
				<div class="grid_3">
					<form:label path="q2">Information presented can be applied</form:label>
				</div>
				<div class="grid_6">
					<form:radiobutton path="q2" value="DNME" /> Did NOT meet expectations <br/>
					<form:radiobutton path="q2" value="ME" /> Meet expectations <br/>
					<form:radiobutton path="q2" value="EE" /> Exceeded expectations <br/>
					<form:errors path="q2" cssClass="error" />
				</div>

				<div class="grid_3">
					<form:label path="q3">The content met my expectations</form:label>
					</div>
				<div class="grid_6">
					<form:radiobutton path="q3" value="DNME" /> Did NOT meet expectations <br/>
					<form:radiobutton path="q3" value="ME" /> Meet expectations <br/>
					<form:radiobutton path="q3" value="EE" /> Exceeded expectations <br/>
					<form:errors path="q3" cssClass="error" />
				</div>
			
				<div class="grid_3">
					<form:label path="q4">This course was an appropriate length to cover the stated objectives</form:label>
				</div>
				<div class="grid_6">
					<form:radiobutton path="q4" value="DNME" /> Did NOT meet expectations <br/>
					<form:radiobutton path="q4" value="ME" /> Meet expectations <br/>
					<form:radiobutton path="q4" value="EE" /> Exceeded expectations <br/>
					<form:errors path="q4" cssClass="error" />
				</div>
				
				<div class="grid_3">
					<form:label path="q5">The material was logically organized</form:label>
				</div>
				<div class="grid_6">
					<form:radiobutton path="q5" value="DNME" /> Did NOT meet expectations <br/>
					<form:radiobutton path="q5" value="ME" /> Meet expectations <br/>
					<form:radiobutton path="q5" value="EE" /> Exceeded expectations <br/>
					<form:errors path="q5" cssClass="error" />
				</div>
			
				<div class="grid_3">
					<form:label path="q6">The instructor created an engaging learning environment</form:label>
				</div>
				<div class="grid_6">
					<form:radiobutton path="q6" value="DNME" /> Did NOT meet expectations <br/>
					<form:radiobutton path="q6" value="ME" /> Meet expectations <br/>
					<form:radiobutton path="q6" value="EE" /> Exceeded expectations <br/>
					<form:errors path="q6" cssClass="error" />
				</div>
			
				<div class="grid_3">
					<form:label path="q7">The instructor was knowledgeable of the course content</form:label>
				</div>
				<div class="grid_6">
					<form:radiobutton path="q7" value="DNME" /> Did NOT meet expectations <br/>
					<form:radiobutton path="q7" value="ME" /> Meet expectations <br/>
					<form:radiobutton path="q7" value="EE" /> Exceeded expectations <br/>
					<form:errors path="q7" cssClass="error" />
				</div>
			
				<div class="grid_3">
					<form:label path="q8">The instructor presented materials in an organized manner</form:label>
				</div>
				<div class="grid_6">
					<form:radiobutton path="q8" value="DNME" /> Did NOT meet expectations <br/>
					<form:radiobutton path="q8" value="ME" /> Meet expectations <br/>
					<form:radiobutton path="q8" value="EE" /> Exceeded expectations <br/>
					<form:errors path="q8" cssClass="error" />
				</div>
			
				<div class="grid_3">
					<form:label path="q9">The instructor responded to questions thoroughly and carefully</form:label>
				</div>
				<div class="grid_6">
					<form:radiobutton path="q9" value="DNME" /> Did NOT meet expectations <br/>
					<form:radiobutton path="q9" value="ME" /> Meet expectations <br/>
					<form:radiobutton path="q9" value="EE" /> Exceeded expectations <br/>
					<form:errors path="q9" cssClass="error" />
				</div>
			   	<br />
   			    <br />
				<div class="grid_3 prefix_3"><input type="submit" value="Submit" /></div>			
		

     
	</form:form>
	</div>

