# What is a Sling Servlet?

A Servlet is a class used to extend the capabilities of servers that host applications accessed by means of a request-response 
programming model. 

For such applications, Servlet technology defines HTTP-specific servlet classes. 

All servlets must implement the Servlet interface, which defines life-cycle methods. When implementing a generic service, 
we can use or extend the GenericServlet class provided with Java Servlet API. 
The HttpServlet class provides methods, such as doGet() and doPost(), for handling HTTP-specific services.

Sling servlets are special type of servlets which are registered as OSGi service of type ***javax.servlet.Servlet***.
 There are some properties defined for Sling Servlets which are as follows - 
 
1. **sling.servlet.paths**
This is a list of paths under which the servlet is accessible as a Resource. The value can either be a single 
String, an array of Strings or a Vector of Strings.
A servlet using this property might be ignored unless its path is included in the Execution Paths (`servletresolver.paths`) 
configuration setting of the `SlingServletResolver` service. 
Either this property or the `sling.servlet.resourceTypes` property must be set, or the servlet is ignored. If both are set, 
the servlet is registered using both ways.

2. **sling.servlet.resourceTypes**
The resource type(s) supported by the servlet. The property value must either be a single String, an array of Strings or a 
Vector of Strings. Either this property or the `sling.servlet.paths` property must be set, or the servlet is ignored. 
If both are set, the servlet is registered using both ways.

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

