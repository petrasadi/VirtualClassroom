<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="/stylesheets/error.css"/>
<link rel="stylesheet" type="text/css" href="/stylesheets/datepicker.css"/>
<script type="text/javascript" src="/javascript/datepicker.js"></script>


<div class="container">
<div class="navbar">
    	<p class="brand">Create a Class</p>
    	</div>
   <br/>


    <form:form action="/classCreate.do" method="post" commandName="createClassFormBean">
        <br/>
        <ul class=table>
            <li>
                <form:errors path="*">
                    <div class="error" class="grid_9">Please correct the form errors and resubmit the form.</div>
                </form:errors>
            </li>

            <li>
                <div class="grid_3">
                    <form:label path="classTitle">Class Title</form:label>
                    <form:input path="classTitle"/><br/>
                    <form:errors path="classTitle" cssClass="error"/>
                </div>

                <div class="grid_3">
                    <form:label path="classDescription">Class Description</form:label>
                    <form:textarea path="classDescription"/><br/>
                    <form:errors path="classDescription" cssClass="error"/>
                </div>

            </li>

            <li>
                <div class="grid_3">
                    <form:label path="classCategory">Class Category</form:label>
                     <form:select path="classCategory" >
                        <form:option value="NONE" label="--- Select ---"/>
                        <form:options items="${categoryList}" itemValue="id.id" itemLabel="name" />
                      </form:select><br/>
                    <form:errors path="classCategory" cssClass="error"/>
                </div>
                <div class="grid_3">
                    <form:label path="classLevel">Class Level</form:label>
                    <ul>
                        <li>
                            <form:label path="classLevel">Beginner</form:label>
                            <form:radiobutton path="classLevel" value="beginner"/>
                        </li>
                        <li>
                            <form:label path="classLevel">Intermediate</form:label>
                            <form:radiobutton path="classLevel" value="intermediate"/>
                        </li>
                        <li>
                            <form:label path="classLevel">Advanced</form:label>
                            <form:radiobutton path="classLevel" value="advanced"/>
                        </li>
                    </ul>
                </div>
            </li>

            <li>
                <div class="grid_3">
                    <form:label path="minStudents">Minimum Class Size:</form:label>
                    <form:input path="minStudents" maxlength="3" size="3"/><br/>
                    <form:errors path="minStudents" cssClass="error"/>
                </div>
                <div class="grid_3">
                    <form:label path="maxStudents">Maximum Class Size:</form:label>
                    <form:input path="maxStudents" maxlength="3" size="3"/><br/>
                    <form:errors path="maxStudents" cssClass="error"/>
                </div>
            </li>
            <li>
                <div class="grid_3">
                    <form:label path="classDate">Class Date</form:label>
                    <form:input readonly="true" path="classDate"/><a href="javascript:displayDatePicker('classDate')">
                    <i class="icon-calendar"></i></a><br/>
                    <form:errors path="classDate" cssClass="error"/>
                </div>
                <div class="grid_3">
                    <form:label path="classStartTime">Class Start Time</form:label>
                    <form:select path="classStartTime">
                        <form:option value="NONE" label="--- Select ---"/>
                        <form:options items="${timeList}"/>
                    </form:select><br/>
                    <form:errors path="classStartTime" cssClass="error"/>
                </div>
                <div class="grid_3">
                    <form:label path="classEndTime">Class End Time</form:label>
                    <form:select path="classEndTime">
                        <form:option value="NONE" label="--- Select ---"/>
                        <form:options items="${timeList}"/>
                    </form:select><br/>
                    <form:errors path="classEndTime" cssClass="error"/>
                </div>
            </li>
            <li>
                <input class="btn btn-primary" type="submit" value="Create Class"/>
            </li>

        </ul>
    </form:form>
</div>
