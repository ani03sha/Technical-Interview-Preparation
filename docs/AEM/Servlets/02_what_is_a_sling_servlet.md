# What is a Sling Servlet?

A Servlet is a class used to extend the capabilities of servers that host applications accessed by means of a request-response 
programming model. 

For such applications, Servlet technology defines HTTP-specific servlet classes. 

All servlets must implement the Servlet interface, which defines life-cycle methods. When implementing a generic service, 
we can use or extend the GenericServlet class provided with Java Servlet API. 
The HttpServlet class provides methods, such as doGet() and doPost(), for handling HTTP-specific services.

Sling servlets are special type of servlets which are registered as OSGi service of type ***javax.servlet.Servlet***.
 There are some properties defined for Sling Servlets which are as follows - 
 
- **sling.servlet.paths**
This is a list of paths under which the servlet is accessible as a Resource. The value can either be a single 
String, an array of Strings or a Vector of Strings.
A servlet using this property might be ignored unless its path is included in the Execution Paths (`servletresolver.paths`) 
configuration setting of the `SlingServletResolver` service. 
Either this property or the `sling.servlet.resourceTypes` property must be set, or the servlet is ignored. If both are set, 
the servlet is registered using both ways.

```java
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
		log.info("Servlet is being executed via path");
	}
}
```
In the above example, Servlet is only registered by path, so the registration properties `sling.servlet.method`, `sling.servlet.extension` has been ignored.

- **sling.servlet.resourceTypes**
The resource type(s) supported by the servlet. The property value must either be a single String, an array of Strings or a 
Vector of Strings. Either this property or the `sling.servlet.paths` property must be set, or the servlet is ignored. 
If both are set, the servlet is registered using both ways.

```java
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
@Component(service=Servlet.class,
property={
		Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.resourceTypes="+ "redquark/servlets/example",
		"sling.servlet.extensions=" + "html"
	})
public class RegisterByResourceTypeExample extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 8417083368846819273L;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		log.info("Executing servlet registered via resource type");
	}
}
```

3. **sling.servlet.resourceSuperType**
The resource super type, indicating which previously registered servlet could intercept the request if the request matches 
the resource super type better. The property value must be a single String. This property is only considered for the registration with `sling.servlet.resourceTypes`.

4. **sling.servlet.selectors**
The request URL selectors supported by the servlet. The selectors must be configured as they would be specified in the URL 
that is as a list of dot-separated strings such as print.a4. 
In case this is not empty the first selector(s) (i.e. the one(s) on the left) in the request URL must match, 
otherwise the servlet is not executed. 
After that may follow arbitrarily many non-registered selectors. The property value must either be a single String, 
an array of Strings or a Vector of Strings. This property is only considered for the registration with `sling.servlet.resourceTypes`.

```java
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
```

5. **sling.servlet.extensions**
The request URL extensions supported by the servlet for requests. The property value must either be a single String, 
an array of Strings or a Vector of Strings. This property is only considered for the registration with `sling.servlet.resourceTypes`.

6. **sling.servlet.methods**
The request methods supported by the servlet. The property value must either be a single String, an array of Strings or 
a Vector of Strings. This property is only considered for the registration with `sling.servlet.resourceTypes`. 
If this property is missing, the value defaults to GET and HEAD, regardless of which methods are actually implemented/handled 
by the servlet. A value of `*` leads to a servlet being bound to all methods.

7. **sling.servlet.prefix**
The prefix or numeric index to make relative paths absolute. If the value of this property is a number (int), it defines 
the index of the search path entries from the resource resolver to be used as the prefix. The defined search path is 
used as a prefix to mount this servlet. The number can be -1 which always points to the last search entry. 
If the specified value is higher than than the highest index of the search paths, the last entry is used. 
The index starts with 0. If the value of this property is a string and parseable as a number, the value is treated as 
if it would be a number. If the value of this property is a string starting with "/", this value is applied as a prefix,
 regardless of the configured search paths! If the value is anything else, it is ignored. 
 If this property is not specified, it defaults to the default configuration of the sling servlet resolver.
 
8. **sling.core.servletName**
The name with which the servlet should be registered. This registration property is optional. If one is not explicitly set, 
the servlet's name will be determined from either the property `component.name`, `service.pid` or `service.id` (in that order). 
This means that the name is always set (as at least the last property is always ensured by OSGi).


```text
For a Servlet registered as an OSGi service to be used by the Sling Servlet Resolver, either one or both of the 
sling.servlet.paths or the sling.servlet.resourceTypes service reference properties must be set. 
If neither is set, the Servlet service is ignored.
```

```text
If sling.servlet.methods is not specified, the servlet is only registered for handling GET and HEAD requests. 
Make sure to list all methods you want to be handled by this servlet.
```

```text
Each path to be used for registration - either from the sling.servlet.paths property or constructed from the other 
sling.servlet.\* properties - must be absolute. Any relative path is made absolute by prefixing it with a root path. 
This prefix may be set with the sling.servlet.prefix service registration property. 

If this property is not set, the first entry in the ResourceResolver search path for the ResourceResolver.getResource(String) 
method is used as the prefix. If this entry cannot be derived, a simpe slash - / - is used as the prefix.
```


## Servlet resolution order

The following order rules are being followed when trying to resolve a servlet for a given request URL and request method 
and multiple candidates would match. Then the following candidate is being picked (if one rule doesn't lead to one winner, 
the next rule is being evaluated):

- The one with the highest number of matching selectors + extension.
- The one which is registered to a resource type closest to the requested one (when traversing the resource type hierarchy up).
- The one with the highest `service.ranking` property.

In case of an OptingServlet not matching the next candidate is being used.
