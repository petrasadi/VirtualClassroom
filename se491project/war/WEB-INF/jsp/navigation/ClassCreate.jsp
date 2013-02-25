<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="/stylesheets/error.css"/>
<link rel="stylesheet" type="text/css" href="/stylesheets/datepicker.css"/>
<script type="text/javascript" src="/javascript/datepicker.js"></script>


<div class="container">
  <div class="datagrid">
    <div class="navbar">
      <div ><p class="brand">Create a Class</p></div>
      <br/><br/>
    </div>
    
    <form:form action="/classCreate.do" method="post" commandName="createClassFormBean">
        <form:errors path="*">
           <div  class="row">
  			 <div class="span12"> <div class="error" >Please correct the errors and resubmit the form.</div></div>
           </div>
        </form:errors>
        <br />
        <br />
        <div  class="row">     
          <div class="span4">
            <form:label path="classTitle">Class Title</form:label>
            <form:errors path="classTitle" cssClass="error"/><br/>  
            <form:input path="classTitle"/><br/>            
          </div>
          <div class="span4">
            <form:label path="classDescription">Class Description</form:label>
             <form:errors path="classDescription" cssClass="error"/><br/>  
            <form:textarea path="classDescription"/><br/>           
          </div>
          <div class="span4">
            <form:label path="classCategory">Class Category</form:label>
            <form:errors path="classCategory" cssClass="error"/><br />
            <form:select path="classCategory" >
              <form:option value="NONE" label="--- Select ---"/>
              <form:options items="${categoryList}" itemValue="id.id" itemLabel="name" />
            </form:select><br/>            
          </div>
         </div>
         
          <div  class="row">
           <div class="span4">
             <form:label path="classDate">Class Date</form:label>
             <form:errors path="classDate" cssClass="error"/><br />           
             <form:input readonly="true" path="classDate"/><a href="javascript:displayDatePicker('classDate')">
             <i class="icon-calendar"></i></a><br/>             
           </div>
           <div class="span4">
             <form:label path="classStartTime">Class Start Time</form:label>
             <form:errors path="classStartTime" cssClass="error"/><br />
             <form:select path="classStartTime">
               <form:option value="NONE" label="--- Select ---"/>
               <form:options items="${timeList}"/>
             </form:select><br/>             
           </div>
           <div class="span4">
             <form:label path="classEndTime">Class End Time</form:label>
              <form:errors path="classEndTime" cssClass="error"/><br />
               <form:select path="classEndTime">
               <form:option value="NONE" label="--- Select ---"/>
               <form:options items="${timeList}"/>
              </form:select><br/>             
            </div>
         </div>
         
         <div class="row">
           <div class="span4">
             <form:label path="classLevel">Class Level</form:label>
             <form:radiobutton path="classLevel" value="beginner"/> &nbsp &nbsp Beginner <br />
             <form:radiobutton path="classLevel" value="intermediate"/> &nbsp &nbsp Intermediate  <br />
             <form:radiobutton path="classLevel" value="advanced"/> &nbsp &nbsp Advanced 
           </div>
           <div class="span4">
             <form:label path="minStudents">Minimum Class Size:</form:label>
             <form:errors path="minStudents" cssClass="error"/><br/>
             <form:input path="minStudents" maxlength="3" size="3"/><br/>
             
           </div>
           <div class="span4">
             <form:label path="maxStudents">Maximum Class Size:</form:label>
             <form:errors path="maxStudents" cssClass="error"/><br/>
             <form:input path="maxStudents" maxlength="3" size="3"/><br/>             
           </div>
         </div>
         
        <br />
        <br />
        <br />
         
         <div  class="row">
           <div class="span9">
              <input class="btn btn-primary" type="submit" value="Create Class"/>
           </div>
         </div>
    </form:form>
</div>
</div>
