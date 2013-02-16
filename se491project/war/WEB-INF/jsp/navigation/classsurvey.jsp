<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<div class="container">
	<form class="form-horizontal" action="AddCompanyServlet" method="post" commandName="createClassFormBean">
		<fieldset>
		<div class="span9">
		<legend>Survey for class: ${name}</legend>
	<c:forEach var="question" items="${questions}" varStatus="questionCounter">
		<div class="control-group">
    		<label class="control-label" name="question${questionCounter.count}" for="question${questionCounter.count}" path="question${questionCounter.count}">${question}</label>
    			<div class="controls">
    				<c:forEach var="answer" items="${answers}" varStatus="answerCounter">
      				<label class="radio inline">
      					<input type="radio" name="optionsRadios${questionCounter.count}" id="answer${answerCounter.count}" value="option1" checked>
      					${answer}
      				</label>
      				</c:forEach>
    			</div>
  		</div>
	</c:forEach>
	<div class="control-group">
  				<div class="controls">
					<input class="btn btn-primary" type="submit" value="Submit"/>
				</div>
  			</div>
	</div>
	</fieldset>
	</form>	
  	</div>

