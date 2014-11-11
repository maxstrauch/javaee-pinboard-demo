JavaEE Pinboard Demo
==

This project is a simple demo project to demonstrate the basic workflow of creating JavaEE applications using NetBeans IDE and GlassFish 4. It features a very simple pinboard which contains notes. Although there can be more than one pinboard, e.g. for different topics. See the data model and use case diagram for further information.

You can download the entire repo by just following this link: https://github.com/maxstrauch/javaee-pinboard-demo/archive/master.zip

Installation
===
Very simple: open the project using Netbeans and open the "required" EJB and WAR projects. More information on how to create the database configuration can be found in the file `create-db-tutorial.pdf`.

A login page is already created to ensure that only authenticated users can browse through the application. In order to get this mechanism working, one needs to uncomment the lines 44 to 64 in the `web.xml` file. In the GlassFish administration console (`http://localhost:4848/`) under `Configuration > server-config > Security > Realms > file > Edit users` one can modify the users list. You can also create an other realm and connect it by placing its name in line 46 in the `web.xml`.

Sources of information
===

Sources of information are listed bellow. Please be aware of the fact, that the following literature list is far away from being complete. So you should take a look into the first reference since it is a master piece of information.

 - the **official Oracle JavaEE** tutorial: http://docs.oracle.com/javaee/7/tutorial/doc/home.htm or as PDF http://docs.oracle.com/javaee/7/tutorial/doc/javaeetutorial7.pdf (980 pages)
 - https://glassfish.java.net/docs/4.0/application-development-guide.pdf (252 pages)
 - https://glassfish.java.net/docs/4.0/application-deployment-guide.pdf (216 pages)