package org.redquark.aem.servlets.examples;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 */
@Component(service = Servlet.class, property = { "sling.servlet.resourceTypes=slingservlets/components/content/text",
		"sling.servlet.extensions=html", "sling.servlet.methods=" + HttpConstants.METHOD_GET })
public class HandleTextComponentServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = -4017298222572257376L;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {

		// Getting the resource object
		Resource currentResource = request.getResource();

		log.info("Current resource path: {}", currentResource.getPath());

		response.getWriter().println("Current resource path: " + currentResource.getPath());
	}

}
