<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="edu.depaul.se491.model.Classes"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register for Class</title>
<link rel="stylesheet" type="text/css" href="/stylesheets/960.css" />
<link rel="stylesheet" type="text/css" href="/stylesheets/BasicStyle.css" />
<style>
.datagrid table { border-collapse: collapse; text-align: left; width: 100%; }
.datagrid {font: normal 12px/150% Arial, Helvetica, sans-serif; background: #fff; overflow: hidden; border: 0px rgba(0, 102, 153, 0.3) solid; -webkit-border-radius: 3px; -moz-border-radius: 3px; border-radius: 3px; background-clip: padding-box;}
.datagrid table td, .datagrid table th { padding: 3px 10px; }
.datagrid table thead th {background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #006699), color-stop(1, #00557F) );background:-moz-linear-gradient( center top, #006699 5%, #00557F 100% );filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#006699', endColorstr='#00557F');background-color:#006699; color:#FFFFFF; font-size: 12px; font-weight: bold; border-left: 0px solid #0070A8; } 
.datagrid table thead th:first-child { border: none; }.datagrid table tbody td { color: #00557F; font-size: 12px;font-weight: normal; }
.datagrid table tbody .alt td { background: #E1EEf4; color: #00557F; }.datagrid table tbody td:first-child { border-left: none; }.datagrid table tbody tr:last-child td { border-bottom: none; }
.datagrid table tfoot td div { border-top: 1px solid #006699;background: #E1EEf4;} .datagrid table tfoot td { padding: 0; font-size: 12px } .datagrid table tfoot td div{ padding: 2px; }

.datagrid table tfoot td ul { margin: 0; padding:0; list-style: none; text-align: right; }
.datagrid table tfoot  li { display: inline; }
.datagrid table tfoot li a { text-decoration: none; display: inline-block;  padding: 2px 8px; margin: 1px;color: #FFFFFF;border: 1px solid #006699;-webkit-border-radius: 3px; -moz-border-radius: 3px; border-radius: 3px; background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #006699), color-stop(1, #00557F) );background:-moz-linear-gradient( center top, #006699 5%, #00557F 100% );filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#006699', endColorstr='#00557F');background-color:#006699; }

.datagrid table tfoot ul.active, .datagrid table tfoot ul a:hover { text-decoration: none;border-color: #00557F; color: #FFFFFF; background: none; background-color:#006699;}
.classname {
	-moz-box-shadow:inset 0px 1px 0px 0px #ffffff;
	-webkit-box-shadow:inset 0px 1px 0px 0px #ffffff;
	box-shadow:inset 0px 1px 0px 0px #ffffff;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ededed), color-stop(1, #dfdfdf) );
	background:-moz-linear-gradient( center top, #ededed 5%, #dfdfdf 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#dfdfdf');
	background-color:#ededed;
	-moz-border-radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	border:1px solid #dcdcdc;
	display:inline-block;
	color:#777777;
	font-family:arial;
	font-size:15px;
	font-weight:bold;
	padding:6px ;
	text-decoration:none;
	text-shadow:1px 1px 0px #ffffff;
}.classname:hover {
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #dfdfdf), color-stop(1, #ededed) );
	background:-moz-linear-gradient( center top, #dfdfdf 5%, #ededed 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dfdfdf', endColorstr='#ededed');
	background-color:#dfdfdf;
}.classname:active {
	position:relative;
	top:1px;
}
</style>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
	// Write on keyup event of keyword input element
	$("#kwd_search").keyup(function(){
		// When value of the input is not blank
		if( $(this).val() != "")
		{
			// Show only matching TR, hide rest of them
			$("#my-table tbody>tr").hide();
			$("#my-table td:contains-ci('" + $(this).val() + "')").parent("tr").show();
		}
		else
		{
			// When there is no input or clean again, show everything back
			$("#my-table tbody>tr").show();
		}
	});
});
// jQuery expression for case-insensitive filter
$.extend($.expr[":"], 
{
    "contains-ci": function(elem, i, match, array) 
	{
		return (elem.textContent || elem.innerText || $(elem).text() || "").toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	}
});
</script>
</head>
<body>
<div class="container_9">
	<label for="kwd_search">Search:</label> <input type="text" id="kwd_search" value=""/>
	<div class="datagrid">
		<table id="my-table">
		<thead><tr><th>Class Name</th><th>Category</th><th>Start Date</th><th>End Date</th><th>Registration</th></tr></thead>
			<tfoot><tr><td colspan="4"></tr></tfoot>
			<tbody>
			<c:forEach var="class" items="${classes}" varStatus="rowCounter">
        <c:choose>
          <c:when test="${rowCounter.count % 2 == 0}">
            <c:set var="rowStyle" scope="page" value=""/>
          </c:when>
          <c:otherwise>
            <c:set var="rowStyle" scope="page" value="alt"/>
          </c:otherwise>
        </c:choose>
        <tr class="${rowStyle}">
          <td>${class.className}</td>
          <td>${class.description}</td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
      </c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>