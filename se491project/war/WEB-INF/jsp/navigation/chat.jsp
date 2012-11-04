<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%
	UserService userService = UserServiceFactory.getUserService();
	String user = userService.getCurrentUser().getUserId();
%>
<script src="http://static.opentok.com/v0.91/js/TB.min.js"></script>
<script type="text/javascript" src="javascript/jquery-1.8.2.js"></script> 
<script type="text/javascript" src="javascript/opentok/opentok.js"></script>
</head>
 
<body onload="getSessionInfo('<%=user%>')">
	<div id="conferenceContainer">
		<div id="myPublisherDiv" style="visibility: hidden; height: 0; width: 0;"></div>
		<div id="subscribers"></div>
	</div>
	<div id="myDiv">
		<button type="button" onclick="endOpenTokSession()">Close session</button>
	</div>