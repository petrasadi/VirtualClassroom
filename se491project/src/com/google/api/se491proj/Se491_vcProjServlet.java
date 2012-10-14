package com.google.api.se491proj;

import java.io.IOException;

// This is a comment for a test push.
// THis comment can be deleted.


@SuppressWarnings("serial")
public class Se491_vcProjServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
