<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
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
  title: 'Survey Result for class: ${name}',
  colors: ['#51a351', '#B2C7D6', '#f89406', '#f3b49f', '#f6c7b6'],
  backgroundColor: 'transparent',
  is3D: true
};
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Total Survey Result Counts'],
          ['Exceeds Expectations', ${ee}],
          ['Meets Expectations', ${me}],
          ['Does NOT Meets Expectations', ${dnm}]
        ]);
       
        // Create and draw the visualization.
        new google.visualization.PieChart(document.getElementById('visualization')).
          draw(data, options);
      }

      google.setOnLoadCallback(drawVisualization);
    </script>
  </head>
    <div id="visualization" style="width: 600px; height: 400px;"/>
​