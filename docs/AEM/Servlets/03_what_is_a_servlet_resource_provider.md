# Servlet Resource Provider

A service listener `org.apache.sling.servlets.resolver.internal.SlingServletResolver` listens for the OSGi services implementing 
`javax.servlet.Servlet` interface and registers its reference. 

When a request hits the server, this `SlingServletResolver` kicks in to executes its sling script resolution procedure to 
choose the right servlet to respond to the request.

Each individual servlet will have a dedicated service instance of ServletResourceProvider associated to it, which will 
provide ServletResources in the resource tree, based on the servlet's registration properties. 

The actual resource path of such resources differs for servlets registered by type and those registered by path:


| Servlet registered by         | Full Resource Path |
| ------------------------------|------------------|
| Path                          | (given path).servlet |
| ResourceType                  | for each selector, extension and method combination one resource with path resource type[/[<selector with separator '/'>.][extension][method]].servlet'. |

If multiple servlets are registered for the same metadata the one with the highest service ranking is returned in the virtual resource tree. 

The resources expose the following properties:

| Property Name|Description|
| ------------------------|-------------|
| sling:resourceType |The resource type to which the servlet is registered. Is equal to the absolute resource path.|
| sling:resourceSuperType |The resource super type. Is sling/bundle/resource if not explicitly set.|
| servletName |The name of the servlet.|
| servletClass |The fully-qualified class name of the underlying servlet.|

In addition each such resource can be adapted to a Servlet.
