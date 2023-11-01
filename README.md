# Rental

## Rental Application
### server:wildfly

### servlet api
-handles http request
### main packages of servlet apis
1.javax.servlet-protocol independent servlet
2.javax.servlet.http-http servlet

### ways of implementing servlet
1.-implement servlet class by implementing the interface
2.-extend generic servlet class
-extend http servlet class

### Generic servlet
### Http servlet
  service();s
  
### implementing servelet
2.-extending generic servlet by extending an abstract class
3.extending httpservlet

### servlet lifecycle
1.loading the servlet-point of deployment to the server
2.servlet instance created by the container-called on first access
3.init() method called-called only once
4.service() method called-called on any request
5.destroy() method called-servlet is shutting down or the servlet is shutting the application

### servletRequest-handles request,get parameters
### serveletDispature-enables response,printwriter