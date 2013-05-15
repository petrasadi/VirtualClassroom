<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/stylesheets/row.css"/>
<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1', {packages: ['corechart']});
    </script>
    <script type="text/javascript">
      function drawVisualization() {
        // Create and populate the data table.
        var options = {
  width: 600,
  height: 400,
  colors: ['#51a351', '#B2C7D6', '#f89406', '#f3b49f', '#f6c7b6'],
  backgroundColor: 'transparent',
  is3D: true
};
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Total Survey Result Counts'],
          ['Exceeds Expectations', ${ee}],
          ['Meets Expectations', ${me}],
          ['Does NOT Meet Expectations', ${dnm}],
        ]);
       
        // Create and draw the visualization.
        new google.visualization.PieChart(document.getElementById('visualization')).
          draw(data, options);
      }

      google.setOnLoadCallback(drawVisualization);
    </script>
<div class="container">
    <div class="datagrid">
    <div class="row">
    <div class="span6">
    <div class="navbar">
    <p class="brand">Teacher Information</p>
    </div>
    <br/>
    <br/>
    <br/>
    <p class="brand">${teachername}</p>
    <p class="brand">${teacheremail}</p>
    <br/>
    <br/>
    </div>
    <div class="span6">
    <div class="navbar">
    	<p class="brand">Survey Result for Teacher: ${teachername}</p>
    	</div>
    <div id="visualization" style="width: 600px; height: 400px;"></div></div>
    </div>
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
                <th>Register</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <td colspan="4">
            </tr>
            </tfoot>
            <tbody>
            <c:forEach var="class" items="${scheduledclasses}" varStatus="rowCounter">
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
                    <td>${class.classStartTime}</td>
                    <td>${class.classEndTime}</td>
                    <c:set var="registration" scope="page" value="${class.registration}"/>
                    <% String registration = pageContext.getAttribute("registration").toString();
                        if (registration.equals("Register")) { %>
                    <td><a href="/registerStudentForClass.do?classId=${class.id}" class="btn btn-warning"><i
                            class="icon-ok icon-white"></i> ${class.registration}</a></td>
                    <% } else if (registration.equals("Join")) { %>
                    <td><a href="/joinClass.do?classId=${class.id}" class="btn btn-success"><i
                            class="icon-play icon-white"></i> ${class.registration}</a></td>
                    <% } else if (registration.equals("Not Time To Join")) { %>
                    <td>Registered</td>
                    <% } %>
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

