package edu.depaul.se491.servlets.login;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class LoginRedirectServlet extends HttpServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LoginRedirectServlet.class.getName());

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String url;
        if (request.getParameter("continue") != null)
        {
            url = request.getParameter("continue");
        }
        else
        {
            url = request.getRequestURI();
        }

        UserService userService = UserServiceFactory.getUserService();

        String openIdUrl = null;
        String openIdUserName = null;
        if (request.getParameter("openid_identifier") != null)
        {
            openIdUrl = request.getParameter("openid_identifier");
        }
        if (request.getParameter("openid_username") != null)
        {
            openIdUserName = request.getParameter("openid_username");
        }

        String openIdRedirectUrl = userService.createLoginURL(url, "OpenID", openIdUrl, null);

        log.info("continue" + url);
        log.info("openIdUserName" + openIdUserName);
        log.info("openIdUrl" + openIdUrl);
        log.info("openIdRedirectUrl" + openIdRedirectUrl);

        response.sendRedirect(openIdRedirectUrl);
    }

}
