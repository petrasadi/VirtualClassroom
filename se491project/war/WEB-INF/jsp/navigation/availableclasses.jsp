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
        <th>Class Name</th>
        <th>Category</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Start Time</th>
        <th>End Time</th>
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
           <td>${class.name}</td>
           <td>${class.category}</td>
           <td>${class.classStartDay}</td>
           <td>${class.classEndDay}</td>
           <td>${class.classStartTime}</td>
           <td>${class.classEndTime}</td>
        </tr>
    </c:forEach>

</table></div>
</div>