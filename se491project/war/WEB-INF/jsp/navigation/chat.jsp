<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%
	UserService userService = UserServiceFactory.getUserService();
	String user = userService.getCurrentUser().getUserId();
%>

<link rel=StyleSheet href="stylesheets/opentok.css" type="text/css">
<script src="http://static.opentok.com/v0.91/js/TB.min.js"></script>
<script type="text/javascript" src="javascript/jquery-1.8.2.js"></script> 
<script type="text/javascript" src="javascript/opentok/opentok.js"></script>
<script type="text/javascript" src="javascript/opentok/opentokUtil.js"></script>
</head>
 
<body onload="getSessionInfo('<%=user%>')">
	<div id="conferenceContainer">
		<div id="myPublisherDiv"></div>
		<div id="subscribers"></div>
		
		<div id="speakRequest"></div>
		
		<div id="userDashboard">
			<div id="teacherDashboard" style="display: none;">
				<!-- TODO - create teacher dashboard -->
			</div>
			<div id="studentDashboard" style="display: none;">
				<a href="" onclick="raisehand()">
					<img src="images/opentok/raiseHand.png" alt="raise hand" title="raise hand" />
				</a>
			</div>
		</div>
	</div>
	<div id="myDiv">
		<!-- 
		<button type="button" onclick="endOpenTokSession()">Close session</button>
		-->
	</div>