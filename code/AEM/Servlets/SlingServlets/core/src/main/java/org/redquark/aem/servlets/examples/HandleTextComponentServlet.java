package org.redquark.aem.servlets.examples;

import java.io.IOException;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
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
 * This servlet is registered via resource type of a component
 * 
 * @author Anirudh Sharma
 */
@Component(
		service = Servlet.class, 
		property = { 
				"sling.servlet.resourceTypes=slingservlets/components/content/text",
				"sling.servlet.extensions=html",
				"sling.servlet.methods=" + HttpConstants.METHOD_GET 
				}
		)
public class HandleTextComponentServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = -4017298222572257376L;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

		try {
			// Getting the resource object
			Resource currentResource = request.getResource();

			// Getting the reference of the corresponding node
			Node currentNode = currentResource.adaptTo(Node.class);

			// Check if the node has property "text"
			if (currentNode.hasProperty("text")) {

				// Getting the value that is stored in "text" property
				String text = currentNode.getProperty("text").getString();

				log.info("Current resource path: {}", currentResource.getPath());

				// Writing the value to the browser
				response.getWriter().println("Text: " + text);
			}

		} catch (RepositoryException | IOException e) {
			log.error(e.getMessage(), e);
		}
	}

}
