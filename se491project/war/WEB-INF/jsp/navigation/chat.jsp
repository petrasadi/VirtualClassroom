<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%
    UserService userService = UserServiceFactory.getUserService();

    String user = userService.getCurrentUser().getUserId();
    long classId = 0;
    if (request.getAttribute("classid") != null) {
        classId = ((Long) request.getAttribute("classid")).longValue();
    } else {
        classId = ((Long) session.getAttribute("classId")).longValue();
    }
%>

<link rel=StyleSheet href="stylesheets/opentok.css" type="text/css">
<link rel=StyleSheet href="stylesheets/chat.css" type="text/css">

<script src='http://static.opentok.com/v1.1/js/TB.min.js'></script>
<script type="text/javascript" src="javascript/jquery-1.8.2.js"></script>

<script type="text/javascript" src="javascript/opentok/opentok.js"></script>
<script type="text/javascript" src="javascript/opentok/opentokUtil.js"></script>

<script type="text/javascript" src="/_ah/channel/jsapi"></script>
<script type="text/javascript" src="javascript/chat/chat.js"></script>
<script type="text/javascript" src="javascript/chat/chatSocketListeners.js"></script>

</head>

<!-- FIXME -user id is currently passed in clear text -->
<body onload="getSessionInfo('<%=user%>', '<%=classId%>')">
<div class="container">

	<button class="btn" type="button" onclick="initChat('<%=user%>', '<%=classId%>')">Open chat</button>
		
	<div id="conferenceContainer">
	    <div id="myPublisherDiv"></div>
	    <div id="subscribers">
	    	<div id="teacherVideo"></div>
	    	<div class="hor" id="studentsVideo"></div>
	    </div>
	
	    <div id="userDashboard" style="display: none;">
	        <div id="teacherDashboard">
	            <!-- TODO - handle regain control -->
	            <input class="dashboardButton" type="image" src="images/glyphicons_221_unshare.png" title="regain control"
	                   onclick="unsubscribeAll()">
	        </div>
	        <div id="studentDashboard">
	            <input class="dashboardButton" type="image" src="images/opentok/speaker.png" title="request mic"
	                   onclick="raisehand()">
	        </div>
	
	        <input class="dashboardButton" type="image" src="images/glyphicons_245_chat.png" title="open chat window"
	               onclick="initChat('<%=user%>', '<%=classId%>')">
	        <input class="dashboardButton" type="image" src="images/glyphicons_063_power.png" title="exit class"
	               onclick="endOpenTokSession()">
	    </div>
	
	    <div id="speakRequests"></div>
	</div>
	
	
	
	<!-- //TODO - create this upon chat init -->

	<div id="chat" style="display: none;">
		<div id="messageDisplay">
			<ul id="messageList"></ul>
		</div>
		<div id="messageInputDiv">
			<input id="messageInput" type="text" name="messageInput" value="Write a comment..." />
		</div>
	</div>
	
</div>