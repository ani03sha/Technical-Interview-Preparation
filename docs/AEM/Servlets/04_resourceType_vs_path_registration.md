# Servlet Registration via ResourceType or Path

There are two ways by which a sling servlet can be registered -
1. Servlet registration via `resourceType`.
2. Servlet registration via `paths`.


## Registration via resource type

A servlet can be registered via resourceType using the following property -
```text
"sling.servlet.resourceTypes="+ "redquark/servlets/example"
```

Here, whenever the request executes anything with the specified `resourceType`, the servlet registered with it will 
be executed. This property can accept a String, an array of Strings or a vector of Strings.


## Registration via path

A servlet can be registered via resourceType using the following property -
```text
"sling.servlet.paths=" + "/bin/registeredbypathdemo"
```

Whenever we hit the request containing specified path - this servlet will be executed. The value can either be a single 
String, an array of Strings or a Vector of Strings.

Whenever a servlet is registered with both path and resourceType, the preference is given to the path.


## Caveats when binding servlets with paths

Binding servlets by paths have several disadvantages when compared to binding by resourceTypes

- Path bound servlets cannot be access controlled using the default JCR repository ACLs
- Since these are bound by paths, there is no suffix handling.
- If a path bound servlet is not active, e.g. if the bundle is missing or not started, a POST request might result in
 unexpected results, usually creating a node at /bin/xyz which subsequently overlays the servlets path binding.
- The mapping is not transparent to the developer who is just looking at the repository.

When we register a servlet using path, we must be specific what all paths are allowed as if we define something 
randomly, our servlet might not work.

Only a limited set of paths are allowed and rest are blocked. Though we can add more paths in the OSGi configuration 
`Apache Sling Servlet / Script Resolver and Error Handler`.

![Apache Sling Servlet / Script Resolver and Error Handler](https://i2.wp.com/www.aemcq5tutorials.com/wp-content/uploads/2017/03/Apache-sling-servlet-resolver-error-handler.jpg)

Allowing more paths to execute makes our application vulnerable and this is the reason we should not open more door 
for servlets unless and until it is required.