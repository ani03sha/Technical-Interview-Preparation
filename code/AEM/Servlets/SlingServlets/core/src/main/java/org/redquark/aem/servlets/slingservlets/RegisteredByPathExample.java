package org.redquark.aem.servlets.slingservlets;

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
@Component(service = Servlet.class, property = {
		Constants.SERVICE_DESCRIPTION + "=Registered By Path Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.paths=" + "/bin/registeredbypathdemo",
		"sling.servlet.extensions=" + "html"
		})
public class RegisteredByPathExample extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = -5869747502146791269L;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		log.info("Servlet is being executed via pathss");
	}
}
