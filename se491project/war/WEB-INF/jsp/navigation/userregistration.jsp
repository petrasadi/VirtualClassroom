<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    UserService userService = UserServiceFactory.getUserService();
%>
<link rel="stylesheet" type="text/css" href="/stylesheets/960.css"/>
<link rel="stylesheet" type="text/css" href="/stylesheets/BasicStyle.css"/>
<style>
    .error {
        color: #ff0000;
    }
</style>

<div class="container">
  <div class="datagrid">
    <div class="navbar">
      <div ><p class="brand">You must complete the Virtual Classroom registration</p></div>
      <br/><br/>
    </div>


    <form:form action="/registerUser.do" method="post" commandName="userRegistrationFormBean">
        <br/>
        <form:hidden path="openid" value="<%=userService.getCurrentUser().getUserId()%>"/>

        <form:errors path="*">
           <div  class="row">
  			 <div class="span12"> <div class="error" >Please correct the errors and resubmit the form.</div></div>
           </div>
        </form:errors>
        <br /><br />

        <div  class="row">
           <div class="span4">
              <form:label path="firstName">First Name</form:label>
               <form:errors path="firstName" cssClass="error"/><br />
              <form:input path="firstName"/><br/>             
           </div>
           <div class="span4">
              <form:label path="lastName">Last Name</form:label>
              <form:errors path="lastName" cssClass="error"/><br />
              <form:input path="lastName"/><br/>              
           </div>
           <div class="span4">
             <form:label path="middleName">Middle Name</form:label>
             <form:errors path="middleName" cssClass="error"/><br />
             <form:input path="middleName"/><br/>
           </div>
        </div>
        
        <div  class="row">
          <div class="span4">
            <form:label path="phone">Phone</form:label>
            <form:errors path="phone" cssClass="error"/><br />
            <form:input path="phone"/><br/>            
          </div>
          <div class="span4">
            <form:label path="phone2">Phone 2</form:label>
            <form:errors path="phone2" cssClass="error"/><br />
            <form:input path="phone2"/><br/>            
          </div>
          <div class="span4">
            <form:label path="email">Email</form:label>
            <form:errors path="email" cssClass="error"/><br />
            <form:input path="email"/><br/>
          </div>
        </div>
        <div  class="row">
          <div class="span4">
            <form:label path="address">Address</form:label>
            <form:errors path="address" cssClass="error"/><br />
            <form:input path="address"/><br/>            
          </div>
          <div class="span4">
            <form:label path="address2">Address 2</form:label>
             <form:errors path="address2" cssClass="error"/><br />
            <form:input path="address2"/><br/>           
          </div>
          <div class="span4">
            <form:label path="city">City</form:label>
            <form:errors path="city" cssClass="error"/><br />
            <form:input path="city"/><br/>         
          </div>
        </div>
        
        <div  class="row">        
          <div class="span4">
            <form:label path="state">State</form:label>
             <form:errors path="state" cssClass="error"/><br />
            <form:select path="state">
                <form:option value="NONE" label="--- Select ---"/>
                <form:options items="${stateList}"/>
            </form:select><br/>           
          </div>
          <div class="span4">
            <form:label path="zip">Zip</form:label>
            <form:errors path="zip" cssClass="error"/><br />
            <form:input path="zip"/><br/>            
          </div>
          <div class="span4">
            <form:label path="country">Country</form:label>
            <form:errors path="country" cssClass="error"/><br />
            <form:select path="country">
                <form:option value="NONE" label="--- Select ---"/>
                <form:options items="${countryList}"/>
            </form:select><br/>            
          </div>
        </div>
    
        <div  class="row"> 
          <div class="span4">
            <form:label path="student">Sign up as a Student</form:label>
            <form:errors path="student" cssClass="error"/><br />
            <form:checkbox path="student" value="student"/><br/>            
          </div>

          <div class="span4">
            <form:label path="teacher">Sign up as a Teacher</form:label>
            <form:errors path="teacher" cssClass="error"/><br />
            <form:checkbox path="teacher" value="teacher"/><br />
          </div>
          <div class="span4">
          </div>
        </div>
        <br/>
        <br/>
           
        <div  class="row">
           <div class="span12">
              <input class="btn btn-primary" type="submit" value="Register"/>

           </div>
        </div>

    </form:form>
  </div>
 </div>
