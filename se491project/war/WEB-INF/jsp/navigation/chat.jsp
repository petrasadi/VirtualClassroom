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
<script src='http://static.opentok.com/v1.1/js/TB.min.js'></script>
<script type="text/javascript" src="javascript/jquery-1.8.2.js"></script>
<script type="text/javascript" src="javascript/opentok/opentok.js"></script>
<script type="text/javascript" src="javascript/opentok/opentokUtil.js"></script>
</head>

<!-- FIXME -user id is currently passed in clear text -->
<body onload="getSessionInfo('<%=user%>', '<%=classId%>')">
<div class="container">
<div id="conferenceContainer">
    <div id="myPublisherDiv"></div>
    <div id="subscribers"></div>

    <div id="userDashboard" style="display: none; padding-left: 20px;">
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
               onclick="alert('TODO - open chat window')">
        <input class="dashboardButton" type="image" src="images/glyphicons_063_power.png" title="exit class"
               onclick="alert('TODO - exit chat')">
    </div>

    <div id="speakRequests"></div>

</div>
<div id="myDiv">
    <!-- 
    <button type="button" onclick="endOpenTokSession()">Close session</button>
    -->
</div>
</div>