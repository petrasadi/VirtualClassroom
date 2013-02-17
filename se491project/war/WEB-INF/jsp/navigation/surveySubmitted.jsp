<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Survey Complete</title>
    <link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>
</head>
<body>
<div class="container">
    <div class="alert">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>Submitted!</strong> Survey completed successfully.
    </div>
    <script src="/javascript/bootstrap.min.js"></script>
	<script src="/javascript/bootstrap.js"></script>
	<script>
		$('.close').on('click', function() {
			$('.alert').alert('close');
		});
	</script>
</body>
</html>