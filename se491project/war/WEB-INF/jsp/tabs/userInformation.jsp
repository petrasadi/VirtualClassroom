<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>
 
 
<div class="container">
  <div class="datagrid">
    <div class="navbar">
      <div ><p class="brand">User Information</p></div>
      <br/><br/>
    </div>
  
  <div  class="row">
  	<div class="span2"><strong>First Name</strong></div>
  	<div class="span10">${sessionScope.vcUser.firstName}</div>  
  </div>
  
  <div  class="row">
  	<div class="span2"><strong>Last Name</strong></div>
  	<div class="span10">${sessionScope.vcUser.lastName}</div>  
  </div>
  
  <div  class="row">
  	<div class="span2"><strong>Middle Name</strong></div>
  	<div class="span10">${sessionScope.vcUser.middleName}</div>  
  </div>
  
  <div  class="row">
  	<div class="span2"><strong>Phone</strong></div>
  	<div class="span10">${sessionScope.vcUser.phone}</div>  
  </div>
  
    <div  class="row">
  	<div class="span2"><strong>Phone 2</strong></div>
  	<div class="span10">${sessionScope.vcUser.phone2}</div>  
  </div>
  
    <div  class="row">
  	<div class="span2"><strong>Email</strong></div>
  	<div class="span10">${sessionScope.vcUser.email}</div>  
  </div>
  
    <div  class="row">
  	<div class="span2"><strong>Address</strong></div>
  	<div class="span10">${sessionScope.vcUser.address}</div>  
  </div>
  
       <div  class="row">
  	<div class="span2"><strong>Address 2</strong></div>
  	<div class="span10">${sessionScope.vcUser.address2}</div>  
  </div>
  
    <div  class="row">
  	<div class="span2"><strong>City</strong></div>
  	<div class="span10">${sessionScope.vcUser.city}</div>  
  </div>
  
    <div  class="row">
  	<div class="span2"><strong>State</strong></div>
  	<div class="span10">${sessionScope.vcUser.firstName}</div>  
  </div>
  
    <div  class="row">
  	<div class="span2"><strong>Zip</strong></div>
  	<div class="span10">${sessionScope.vcUser.zip}</div>  
  </div>
  
    <div  class="row">
  	<div class="span2"><strong>Country</strong></div>
  	<div class="span10">${sessionScope.vcUser.country}</div>  
  </div>
  <br />
  <br />
    <div  class="row">
  	<div class="span2"><strong>Student</strong></div>
  	<div class="span10">
       <c:choose>
         <c:when test="${sessionScope.vcUser.student}">Yes </c:when>
         <c:otherwise>No </c:otherwise>
         </c:choose>
    </div>  
  </div>
  
    <div  class="row">
  	<div class="span2"><strong>Teacher</strong></div>
  	<div class="span10">
        <c:choose>
          <c:when test="${sessionScope.vcUser.teacher}">Yes </c:when>
          <c:otherwise>No </c:otherwise>
        </c:choose> 
    </div>  
  </div> 
  </div>
</div>
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />
 <br />



