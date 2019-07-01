package org.redquark.aem.servlets.slingservlets.types;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 */
@Component(service=Servlet.class,
property={
		Constants.SERVICE_DESCRIPTION + "=Simple Read Only Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.resourceTypes="+ "redquark/servlets/example",
		"sling.servlet.extensions=" + "html"
	})
public class SlingSafeMethodsServletEsample extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 8565932343267006374L;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		log.info("Inside the doGet method of the SlingSafeMethodsServlet type servlet");
		try {
			PrintWriter out = response.getWriter();
			out.println("Read only servlet got executed!!!");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
}
