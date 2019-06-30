package org.redquark.aem.servlets.slingservlets;

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
			Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
			"sling.servlet.methods=" + HttpConstants.METHOD_GET,
			"sling.servlet.resourceTypes="+ "redquark/servlets/example",
			"sling.servlet.selectors="+"img",
			"sling.servlet.selectors="+"tab"
	})
public class SelectorsPropertyExample extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 6043799632124866549L;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		log.info("Executing servlet using selectors");
		try {
			PrintWriter out = response.getWriter();
			out.println("This servlet will be executed via following requests:");
			out.println("http://localhost:4502/content/redquark/example/jcr:content.img.json");
			out.println("http://localhost:4502/contentredquark/example/jcr:content.tab.json");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

}
