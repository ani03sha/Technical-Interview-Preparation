# Default Servlet

A default servlet is selected if no servlet or script for the current resource type can be found. This servlet is 
registered with a special resource type `sling/servlet/default`

The default servlet is resolved exactly the same way as for any resource type. That is, also for the default Servlet 
selection, the request selectors and extension or method are considered. 

Also, the servlet may be a servlet registered as an OSGi service or it may be a script stored in the repository or 
provided by any bundle.

Finally, if not even a registered default Servlet may be resolved for the request, because none has been registered, 
the `servlets/resolver` bundle provides a fall back the `DefaultServlet` with the following functionality:

- If an `NonExistingResource` was created for the request, the `DefaultServlet` sends a 404 (Not Found)
- Otherwise the `DefaultServlet` sends a 500 (Internal Server Error), because normally at least a `NonExistingResource` 
should be created.


# OptingServlet interface

This interface is used if we want to further refine the servlet request resolution process. This interface has only 
one method `accepts` which returns a boolean. If this method returns true then only the servlet will be selected for 
the processing.

While an opting servlet seems to be a nice way of picking the right servlet to process the request, the use of an opting
 servlet is not recommended: the main reason is that it complicates the request processing, makes it less transparent what 
 is going on during a request and prevents optimizations like caching the script resolution in an optimal manner. 
 The other static options are usually sufficient for all use cases.