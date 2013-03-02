<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/stylesheets/row.css"/>
<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>

<div class="container">
    <div class="datagrid">
    <div class="navbar">
    <p class="brand">Student Information</p>
    </div>
    <br/>
    <br/>
    <br/>
    <p class="brand">${studentname}</p>
    <p class="brand">${studentemail}</p>
    <br/>
    <br/>
    <div class="navbar">
    <p class="brand">Scheduled Classes</p>
     </div>

        <table id="my-table" class="table table-hover">
            <thead>
            <tr>
                <th>Class Name</th>
                <th>Category</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Start Time</th>
                <th>End Time</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <td colspan="4">
            </tr>
            </tfoot>
            <tbody>
            <c:forEach var="class" items="${scheduledclasses}" varStatus="rowCounter">
               <tr>
                    <td>${class.name}</td>
                    <td>${class.category}</td>
                    <td>${class.classStartDay}</td>
                    <td>${class.classEndDay}</td>
                    <td>${class.classStartTime}</td>
                    <td>${class.classEndTime}</td>                   
               </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<br/>
<br/>


<div class="container">
    <div class="datagrid">
    <div class="navbar">
    <p class="brand">Class History</p>
    </div>
        <table id="my-table" class="table table-hover">
            <thead>
            <tr>
                <th>Class Name</th>
                <th>Category</th>
                <th>Start Date</th>
                <th>End Date</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <td colspan="4">
            </tr>
            </tfoot>
            <tbody>
            <c:forEach var="class" items="${historyclasses}" varStatus="rowCounter">
                <c:choose>
                    <c:when test="${rowCounter.count % 2 == 0}">
                        <c:set var="rowStyle" scope="page" value=""/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="rowStyle" scope="page" value="alt"/>
                    </c:otherwise>
                </c:choose>
                <tr class="${rowStyle}">
                    <td>${class.name}</td>
                    <td>${class.category}</td>
                    <td>${class.classStartDay}</td>
                    <td>${class.classEndDay}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

