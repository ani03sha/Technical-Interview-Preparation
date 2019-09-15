package org.redquark.aem.servlets.examples;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

/**
 * This servlet is called on the load of each page
 * 
 * @author Anirudh Sharma
 */
@Component(service = Servlet.class, property = { "sling.servlet.resourceTypes=cq/Page", "sling.servlet.extensions=html",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET })
public class AllPageServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = -4646301080512673638L;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

		try {

			// Get ResourceResolver from the SlingHttpServletRequest object
			ResourceResolver resourceResolver = request.getResourceResolver();

			// Adapting ResourceResolver to the PageManager class
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

			// Get the reference of current page (cq:Page)
			Page currentPage = pageManager.getContainingPage(request.getResource().getPath());

			log.info("Page title: {}", currentPage.getTitle());

			response.getWriter().println("Current page path: " + currentPage.getPath());

		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

	}

}
