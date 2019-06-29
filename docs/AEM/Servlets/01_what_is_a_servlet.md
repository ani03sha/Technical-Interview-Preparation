# What is a Servlet?

A servlet in its very core is a Java class, which can handle network requests (for e.g. HTTP requests). Servlets are 
usually used to implement web applications. This java class does not have any ***main()*** method, only some callback 
methods.

Servlets run on the java enabled web-server or the application server. They handle requests from the web server, 
process it, produces the response, then send response back to the server. This means servlet lives and dies within a 
web container. Web container is responsible for invoking methods in a servlet. It knows what callback methods a 
servlet has.

```
Servlets run in a servlet container which handles the networking side (e.g. parsing an HTTP request, connection 
handling etc.). One of the best known open source servlet container is Tomcat.
```

## Properties of servlets

- Servlets work on the server side
- Servlets are capable of handling complex requests obtained from the web server.


## Execution of servlet

It involves six basic steps - 
- The client sends HTTP request to the web server.
- The web server receives the request and forwards it to the web container.
- Web container spins a thread for each request.
- The web container passes the request to the corresponding servlet.
- Since servlet cannot understand HTTP, it is a java program, it only understands objects, so web container converts 
the request into valid request object.
- The servlet processes the request and generates the response in the form of output. A servlet has callback methods 
for this processing (for e.g. doGet(), doPost() etc.).
- The servlet sends the response back to the web server.
- The web server sends the response back to the client after converting it into HTTP response and the client browser 
displays it on the screen.


## How does a container know which servlet client is requested for?

- There is a file called ***web.xml*** which is the master file for the web container.
- We have information about servlet in this file - 
```
1. servlets
    a. servlet-name
    b. servlet-class
2. servlet-mappings
    a. servlet-name
    b. url-pattern
```
- Every servlet in the web app should have entry in this file
- So this lookup happens => url-pattern -> servlet-name -> servlet-class


## Advantages

- Servlets provide a way to generate dynamic documents that is both easier and faster to run.
- Provide all the powerful features of Java, such as Exception Handling, Garbage Collection etc.
- Enables easy portability across web servers.
- Can communicate with different servlets and servers.
- Since all web applications are stateless protocol, servlet uses its own API to maintain session.


## Disadvantages

- Designing in servlet is difficult and slows down the application.
- Writing complex business logic makes the application difficult to understand.
- We need a Java Runtime Environment on the server to run Servlets. CGI is a complete language independent protocol, 
so we can write CGIs in whatever languages available (including Java if we want to).


## Servlet APIs

- javax.servlet (Basic)
- javax.servlet.http (Advance)


## Code example

To crate a simple servlet demo, we need to perform following steps - 

1. Create a java dynamic web project using maven with the following ***pom.xml***

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>org.redquark.aem.servlets</groupId>
  <artifactId>SimpleServlet</artifactId>
  <packaging>war</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>SimpleServlet Maven Webapp</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/javax.servlet/jsp-api -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.0</version>
            <scope>provided</scope>
        </dependency>
  </dependencies>
  <build>
    <finalName>SimpleServlet</finalName>
    <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.5.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
  </build>
</project>
``` 

2. Now add the following code in the ***index.html*** file

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Servlet Demo</title>
</head>
<body>
	<a href="welcome">Click to call Servlet</a>
</body>
</html>
```

3. Add the following code in ***SimpleHTTPServlet.java*** file

```java
package org.redquark.aem.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Anirudh Sharma
 *
 */
public class SimpleHTTPServlet extends HttpServlet {

	private static final long serialVersionUID = 4389328665759581789L;
	private String message;

	public void init() throws ServletException {
		message = "Simple HTTP Servlet Demo";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Setting up the content type of web page
		response.setContentType("text/html");
		// Writing the message on the web page
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
		out.println("<p>" + "Hello Friends!" + "</p>");
	}

	public void destroy() {
		/*
		 * Empty. This will be called if we require some operation to happen at the end
		 * of Servlet life cycle
		 */
	}
}
```

4. Finally add the following code in the ***web.xml*** file to define the servlet mappings

```xml
<web-app>
	<display-name>Simple Servlet</display-name>
	<welcome-file-list>
		<welcome-file>index.html</welcome-file>
		<welcome-file>index.htm</welcome-file>
		<welcome-file>index.jsp</welcome-file>
		<welcome-file>default.html</welcome-file>
		<welcome-file>default.htm</welcome-file>
		<welcome-file>default.jsp</welcome-file>
	</welcome-file-list>

	<servlet>
		<servlet-name>SimpleHTTPServlet</servlet-name>
		<servlet-class>org.redquark.aem.servlets.SimpleHTTPServlet</servlet-class>
	</servlet>

	<servlet-mapping>
		<servlet-name>SimpleHTTPServlet</servlet-name>
		<url-pattern>/welcome</url-pattern>
	</servlet-mapping>

</web-app>
```

5. Click on the index.html file -> Run on server (You need to configure Apache Tomcat server to do this)