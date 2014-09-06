package gmarques.androidservlet.activity;

import gmarques.androidservlet.R;
import gmarques.androidservlet.server.ServerRunner;
import gmarques.androidservlet.server.factory.ServerRunnerFactory;
import gmarques.androidservlet.server.factory.ServerRunnerFactory.ServerType;
import gmarques.androidservlet.server.task.RunServerTask;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {

    private RunServerTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        ServerRunner runner = ServerRunnerFactory.createServer(ServerType.WINSTONE);
        task = new RunServerTask(runner);
        task.execute();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.stop();
    }

}
