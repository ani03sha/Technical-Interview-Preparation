# Types of Sling servlets

There are two classes in Sling API which can be inherited to define our custom functionality. These two classes are - 

- SlingSafeMethodsServlet `org.apache.sling.api.servlets.SlingSafeMethodsServlet`
- SlingAllMethodsServlet `org.apache.sling.api.servlets.SlingAllMethodsServlet`

Let us discuss these one by one - 

## SlingSafeMethodsServlet

This is a helper base class for **read-only** Servlets used in Sling. This base class is actually just a better implementation 
of the Servlet API's `HttpServlet` class which accounts for extensibility. 

So extensions of this class have great control over what methods to overwrite.

If any of the default HTTP methods is to be implemented just override the respective doXXX (doGet(), doHead() etc.) method.

This base class is intended for applications where data is only read. As such, this servlet by itself does not support the 
POST, PUT and DELETE methods. Extensions of this class should either override any of the doXXX methods of this class or 
add support for other read-only methods only.

```java
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
```


## SlingAllMethodsServlet

This is a helper base class for data modifying Servlets used in Sling. This class extends the `SlingSafeMethodsServlet`
 by support for the POST, PUT and DELETE methods. Thus, if we want to modify some data then we should use this base 
 class.
 
```java
package org.redquark.aem.servlets.slingservlets.types;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anirudh Sharma
 */
@Component(service=Servlet.class,
property={
		Constants.SERVICE_DESCRIPTION + "=Simple Read + Write Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST,
		"sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.resourceTypes="+ "redquark/servlets/example",
		"sling.servlet.extensions=" + "html"
	})
public class SlingAllMethodsServletExample extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 7242189079618404960L;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		log.info("Inside the doGet method of the SlingAllMethodsServlet type servlet");
		try {
			PrintWriter out = response.getWriter();
			out.println("Read + Write servlet got executed!!!");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		log.info("Inside the doPost method of the SlingAllMethodsServlet type servlet");
		try {
			PrintWriter out = response.getWriter();
			out.println("Read + Write servlet got executed!!!");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
}
```
