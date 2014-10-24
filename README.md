JavaEE Pinboard Demo
==

This project is a simple demo project to demonstrate the basic workflow of creating JavaEE applications using NetBeans IDE and GlassFish 4. It features a very simple pinboard which contains notes. Although there can be more than one pinboard, e.g. for different topics.

Installation
===
Quite simple: open the project using Netbeans and open the "required" EJB and WAR projects. Next create a new Derby database. Then you need to create a connection pool and a JDBC resource in the administration console (http://localhost:4848/). Finally create a "Persistence Unit" (persistence.xml) in the project. Now you are ready to go.

Sources of information
===

Sources of information are listed bellow. Please be aware of the fact, that the following literature list is far away from being complete. So you should take a look into the first reference since it is a master piece of information.

 - the **official Oracle JavaEE** tutorial: http://docs.oracle.com/javaee/7/tutorial/doc/home.htm or as PDF http://docs.oracle.com/javaee/7/tutorial/doc/javaeetutorial7.pdf (980 pages)
 - https://glassfish.java.net/docs/4.0/application-development-guide.pdf (252 pages)
 - https://glassfish.java.net/docs/4.0/application-deployment-guide.pdf (216 pages)