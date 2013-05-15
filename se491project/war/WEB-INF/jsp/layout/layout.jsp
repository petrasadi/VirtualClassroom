<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="/stylesheets/bootstrap.css"/>
<head>
    <style type="text/css">
        html,
        body {
            margin: 0;
            padding: 0;
            height: 100%;
            background:url(../images/bg-content2.gif);
        }       

        .page_container {
            min-height: 100%;
    		height: auto !important;
    		height: 100%;
    		margin: 0 auto -5px;
        }

        .navigation {
            vertical-align: top;
            width: 10%;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<div class="page_container" border="0" cellpadding="2" cellspacing="2" align="left">
    <div class="header"><tiles:insertAttribute name="header"/></div>
	<div class="sub-header"><tiles:insertAttribute name="sub-header"/></div>
    <div class="tabs"><tiles:insertAttribute name="tabs"/></div>
    <div class="body"><tiles:insertAttribute name="body"/></div>
    <div class="push"></div>
</div>
<div class="footer"><tiles:insertAttribute name="footer"/></div>
</html>
    