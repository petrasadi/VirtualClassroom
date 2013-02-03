<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">
        html,
        body {
            margin: 0;
            padding: 0;
            height: 100%;
        }

        #page_container {
            min-height: 100%;
            position: relative;
        }


        #tabs {
            padding-top: 50px;

        }

        #body {
            padding: 10px;
            padding-bottom: 20px; /* Height of the footer */
        }

        #footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 20px; /* Height of the footer */
            background: #6cf;
        }

        .navigation {
            vertical-align: top;
            width: 10%;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<div id="page_container" border="0" cellpadding="2" cellspacing="2" align="left">
    <div class="header"><tiles:insertAttribute name="header"/></div>
	<div class="sub-header">
		<tiles:insertAttribute name="sub-header"/>
	</div>
    <div class="tabs">
    			
				<tiles:insertAttribute name="tabs"/></div>
    <div id="body"><tiles:insertAttribute name="body"/></div>
    <div id="footer"><tiles:insertAttribute name="footer"/></div>
</div>
</html>
    