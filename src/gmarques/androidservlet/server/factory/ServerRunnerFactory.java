package gmarques.androidservlet.server.factory;

import gmarques.androidservlet.server.JettyServerRunner;
import gmarques.androidservlet.server.ServerRunner;
import gmarques.androidservlet.server.WinstoneServerRunner;

public class ServerRunnerFactory {

    private ServerRunnerFactory() {
    }

    public static ServerRunner createServer(ServerType serverType) {
        switch (serverType) {
        case JETTY:
            return new JettyServerRunner();
        case WINSTONE:
            return new WinstoneServerRunner();
        default:
            throw new RuntimeException("Unexpected server type");
        }
    }

    public enum ServerType {
        JETTY, WINSTONE;
    }

}
