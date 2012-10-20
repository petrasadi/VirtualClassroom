<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Virtual Classroom OpenID Login</title>
    <link rel="stylesheet" type="text/css" media="screen" href="/stylesheets/openid.css" />   
</head>
<body>
<form class="openid" method="get" action="/_ah/login_redirect">
  <div><ul class="providers">
  <li class="openid" title="OpenID"><img src="images/openID/openidW.png" alt="icon" />
  <span><strong>http://{your-openid-url}</strong></span></li>
  <li class="direct" title="Google">
		<img src="images/openID/googleW.png" alt="icon" /><span>https://www.google.com/accounts/o8/id</span></li>
  <li class="direct" title="Yahoo">
		<img src="images/openID/yahooW.png" alt="icon" /><span>http://yahoo.com/</span></li>
  <li class="username" title="AOL screen name">
		<img src="images/openID/aolW.png" alt="icon" /><span>http://openid.aol.com/<strong>username</strong></span></li>
  <li class="username" title="MyOpenID user name">
		<img src="images/openID/myopenid.png" alt="icon" /><span>http://<strong>username</strong>.myopenid.com/</span></li>
  <li class="username" title="Flickr user name">
		<img src="images/openID/flickr.png" alt="icon" /><span>http://flickr.com/<strong>username</strong>/</span></li>
  <li class="username" title="Technorati user name">
		<img src="images/openID/technorati.png" alt="icon" /><span>http://technorati.com/people/technorati/<strong>username</strong>/</span></li>
  <li class="username" title="Wordpress blog name">
		<img src="images/openID/wordpress.png" alt="icon" /><span>http://<strong>username</strong>.wordpress.com</span></li>
  <li class="username" title="Blogger blog name">
		<img src="images/openID/blogger.png" alt="icon" /><span>http://<strong>username</strong>.blogspot.com/</span></li>
  <li class="username" title="LiveJournal blog name">
		<img src="images/openID/livejournal.png" alt="icon" /><span>http://<strong>username</strong>.livejournal.com</span></li>
  <li class="username" title="ClaimID user name">
		<img src="images/openID/claimid.png" alt="icon" /><span>http://claimid.com/<strong>username</strong></span></li>
  <li class="username" title="Vidoop user name">
		<img src="images/openID/vidoop.png" alt="icon" /><span>http://<strong>username</strong>.myvidoop.com/</span></li>
  <li class="username" title="Verisign user name">
		<img src="images/openID/verisign.png" alt="icon" /><span>http://<strong>username</strong>.pip.verisignlabs.com/</span></li>
  </ul></div>
  <fieldset>
  <input type="hidden"  name="continue" value="<%=(request.getParameter("continue")==null ? "/" : request.getParameter("continue")) %>" />
  <label for="openid_username">Enter your <span>Provider user name</span></label>
  <div><span></span><input type="text" name="openid_username" /><span></span>
  <input type="submit" value="Login" /></div>
  </fieldset>
  <fieldset>
  <div>
  <label for="openid_identifier">Enter your <a class="openid_logo" href="http://openid.net">OpenID</a></label>
  <input type="text" name="openid_identifier" />
  <input type="submit" value="Login" />
  </div>
  </fieldset>
</form>
<br />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.1/jquery.min.js"></script>
<script type="text/javascript" src="javascript/jquery.openid.js"></script>
<script type="text/javascript">  $(function() { $("form.openid:eq(0)").openid(); });</script>
</body>

</html>
