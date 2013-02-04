<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            // Write on keyup event of keyword input element
            $("#kwd_search").keyup(function () {
                // When value of the input is not blank
                if ($(this).val() != "") {
                    // Show only matching TR, hide rest of them
                    $("#my-table tbody>tr").hide();
                    $("#my-table td:contains-ci('" + $(this).val() + "')").parent("tr").show();
                }
                else {
                    // When there is no input or clean again, show everything back
                    $("#my-table tbody>tr").show();
                }
            });
        });
        // jQuery expression for case-insensitive filter
        $.extend($.expr[":"],
                {
                    "contains-ci": function (elem, i, match, array) {
                        return (elem.textContent || elem.innerText || $(elem).text() || "").toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
                    }
                });
    </script>
<div class="container">
<div class="navbar">
    	<p class="brand">Available Classes</p>
    	</div><br/><br/>
    	<form class="navbar-form pull-left"><input type="text" id="kwd_search" class="span2" placeholder="Search"></form><br/>
    	<div class="datagrid">
<table id="my-table" class="table table-hover">
    <thead><tr class="rowheader">
        <td>Class Name</td>
        <td>Class Description</td>
        <td>Class Date</td>
        <td>Start Time</td>
        <td>End Time</td>
        <td>Min Students</td>
        <td>Max Students</td>
    </tr></thead>
    <c:forEach var="class" items="${classes}" varStatus="rowCounter">
        <c:choose>
            <c:when test="${rowCounter.count % 2 == 0}">
                <c:set var="rowStyle" scope="page" value="oddrow"/>
            </c:when>
            <c:otherwise>
                <c:set var="rowStyle" scope="page" value="evenrow"/>
            </c:otherwise>
        </c:choose>
        <tr class="${rowStyle}">
            <td>${class.className}</td>
            <td>${class.description}</td>
            <td>${class.displayClassDate}</td>
            <td>${class.displayClassStartTime}</td>
            <td>${class.displayClassEndTime}</td>
            <td>${class.minStudents}</td>
            <td>${class.maxStudents}</td>
        </tr>
    </c:forEach>

</table></div>
</div>