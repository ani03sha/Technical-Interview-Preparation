package org.redquark.aem.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Anirudh Sharma
 *
 */
public class SimpleHTTPServlet extends HttpServlet {

	private static final long serialVersionUID = 4389328665759581789L;
	private String message;

	public void init() throws ServletException {
		message = "Simple HTTP Servlet Demo";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Setting up the content type of web page
		response.setContentType("text/html");
		// Writing the message on the web page
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
		out.println("<p>" + "Hello Friends!" + "</p>");
	}

	public void destroy() {
		/*
		 * Empty. This will be called if we require some operation to happen at the end
		 * of Servlet life cycle
		 */
	}
}
