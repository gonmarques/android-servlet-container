package gmarques.androidservlet.server;

import gmarques.androidservlet.servlet.TestJettyServlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyServerRunner implements ServerRunner {

    private Server server;

    @Override
    public void start() throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server = new Server(8080);
        server.setHandler(context);
        context.addServlet(new ServletHolder(new TestJettyServlet()), "/test");
        server.start();
        server.join();
    }

    @Override
    public void stop() throws Exception {
        if (server != null) {
            server.stop();
        }
    }

}
