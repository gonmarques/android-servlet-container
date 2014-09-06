package gmarques.androidservlet.server;

import java.util.HashMap;
import java.util.Map;

import winstone.Launcher;
import android.os.Environment;

public class WinstoneServerRunner implements ServerRunner {

    private Launcher winstone;

    @Override
    public void start() throws Exception {
        Map<String, String> args = new HashMap<String, String>();
        args.put("warfile", Environment.getExternalStorageDirectory().getPath() + "/winstone.war");
        args.put("port", "8080");
        args.put("preferredClassLoader", "exploit");
        Launcher.initLogger(args);
        winstone = new Launcher(args);
    }

    @Override
    public void stop() throws Exception {
        if (winstone != null) {
            winstone.shutdown();
        }
    }

}
