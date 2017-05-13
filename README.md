# Android Servlet Container

## Background

Back in 2012 I authored an Android application which core component was an HTTP server that was implemented resorting only to Java sockets. The main reason for the application's success, apart from the provided usability and functionality, was due to its extreme lighweight and performance.

Embedded servlet containers were already available - namely Jetty - but I didn't need (or wanted) a full blown servlet container, especially due to the strict requirements that Android applications must meet in order to provide a good user experience (I still target Android 1.6 users today [if any!]). So I went into a custom implementation of the HTTP protocol subset that was required for the application.

Anyway, I never abandoned the idea of experimenting embedded servlet containers in Android. After a couple of years, here we are.

## Results

 -  **Jetty**: Everything went smoothly. I only had to use an older version because recent versions are coupled to JMX (**javax.management** package) and in Android this is a no-go.

 -  **Winstone**: I found this pretty old embeddable open source servlet container [winstone.sourceforge.net](http://winstone.sourceforge.net). I just had to do some changes to the source and it was ready to go:

   - The developer provided its own hand crafted subset version of the Servlet API (v2.5) along with the container. Since I was already providing the Servlet API with Jetty, I changed Winstone in order to compile against the API I was already providing (by the way, v3.0) and discarded the hand crafted API.

   - The developer also enabled XML validation while loading existing application's deployment descriptor (web.xml), but the  **DocumentBuilderFactory** implementation provided by Android (at least in my device) does not support this feature. Since this was hard-coded in Winstone source, I also hat it changed.

 -  **Tomcat**: Unfortunately Tomcat is coupled to JMX, even in the older versions. Since JMX is not available in Android, I could not run it. TODO: Look at tomcat source and evaluate the effort in order to decouple it from JMX.

 -  **Undertow**: The same as Tomcat.
