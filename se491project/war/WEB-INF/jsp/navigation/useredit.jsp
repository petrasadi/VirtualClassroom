<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    UserService userService = UserServiceFactory.getUserService();
%>
<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>

<style>
    .error {
        color: #ff0000;
    }
</style>

<div class="container">
  <div class="datagrid">
    <div class="navbar">
      <div ><p class="brand">You can update your Virtual Classroom User Information.</p></div>
      <br/><br/>
    </div>
  

    <form:form action="/editUser.do" method="post" commandName="userRegistrationFormBean">

        <br/>

        <form:errors path="*">
           <div  class="row">
  			 <div class="span12"> <div class="error" class="grid_9">Please correct the errors and resubmit the form.</div></div>
           </div>
        </form:errors>

        <div  class="row">
           <div class="span4">
              <form:label path="firstName">First Name</form:label>
              <form:input path="firstName"/><br/>
              <form:errors path="firstName" cssClass="error"/>
           </div>
           <div class="span4">
              <form:label path="lastName">Last Name</form:label>
              <form:input path="lastName"/><br/>
              <form:errors path="lastName" cssClass="error"/>
           </div>
           <div class="span4">
             <form:label path="middleName">Middle Name</form:label>
             <form:input path="middleName"/><br/>
             <form:errors path="middleName" cssClass="error"/>
           </div>
        </div>
        
        <div  class="row">
          <div class="span4">
            <form:label path="phone">Phone</form:label>
            <form:input path="phone"/><br/>
            <form:errors path="phone" cssClass="error"/>
          </div>
          <div class="span4">
            <form:label path="phone2">Phone 2</form:label>
            <form:input path="phone2"/><br/>
            <form:errors path="phone2" cssClass="error"/>
          </div>
          <div class="span4">
            <form:label path="email">Email</form:label>
            <form:input path="email"/><br/>
            <form:errors path="email" cssClass="error"/>
          </div>
        </div>


        <div  class="row">
          <div class="span4">
            <form:label path="address">Address</form:label>
            <form:input path="address"/><br/>
            <form:errors path="address" cssClass="error"/>
          </div>
          <div class="span4">
            <form:label path="address2">Address 2</form:label>
            <form:input path="address2"/><br/>
            <form:errors path="address2" cssClass="error"/>
          </div>
          <div class="span4">
            <form:label path="city">City</form:label>
            <form:input path="city"/><br/>
            <form:errors path="city" cssClass="error"/>
          </div>
        </div>
        
        <div  class="row">        
          <div class="span4">
            <form:label path="state">State</form:label>
            <form:select path="state">
                <form:option value="NONE" label="--- Select ---"/>
                <form:options items="${stateList}"/>
            </form:select><br/>
            <form:errors path="state" cssClass="error"/>
          </div>
          <div class="span4">
            <form:label path="zip">Zip</form:label>
            <form:input path="zip"/><br/>
            <form:errors path="zip" cssClass="error"/>
          </div>
          <div class="span4">
            <form:label path="country">Country</form:label>
            <form:select path="country">
                <form:option value="NONE" label="--- Select ---"/>
                <form:options items="${countryList}"/>
            </form:select><br/>
            <form:errors path="country" cssClass="error"/>
          </div>
        </div>
    
        <div  class="row"> 
          <div class="span4">
            <form:label path="student">Sign up as a Student</form:label>
            <form:checkbox path="student" value="student"/><br/>
            <form:errors path="student" cssClass="error"/>
          </div>

          <div class="span4">
            <form:label path="teacher">Sign up as a Teacher</form:label>
            <form:checkbox path="teacher" value="teacher"/><br/>
            <form:errors path="teacher" cssClass="error"/>
          </div>
          <div class="span4">
          </div>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        
        <div  class="row">
           <div class="span12">
              <input type="submit" value="Update"/>
           </div>
        </div>

    </form:form>
  </div>
 </div>

