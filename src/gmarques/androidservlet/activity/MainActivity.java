package gmarques.androidservlet.activity;

import gmarques.androidservlet.R;
import gmarques.androidservlet.server.ServerRunner;
import gmarques.androidservlet.server.factory.ServerRunnerFactory;
import gmarques.androidservlet.server.factory.ServerRunnerFactory.ServerType;
import gmarques.androidservlet.server.task.RunServerTask;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private RunServerTask task;
    private ServerType runningServer;
    private Button btnJetty;
    private Button btnWinstone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnJetty = (Button) findViewById(R.id.btnjetty);
        btnWinstone = (Button) findViewById(R.id.btnwinstone);
        initializeButtons();
        updateStatus();
    }

    private void initializeButtons() {
        initializeButton(btnJetty, ServerType.JETTY);
        initializeButton(btnWinstone, ServerType.WINSTONE);
    }

    private void initializeButton(Button button, final ServerType serverType) {
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (runningServer != null) {
                    if (runningServer != serverType) {
                        Toast.makeText(getApplicationContext(), runningServer.getDescription() + " is already running", Toast.LENGTH_SHORT).show();
                    } else {
                        stopServer();
                    }
                } else {
                    startServer(serverType);
                    Toast.makeText(getApplicationContext(), serverType.getDescription() + " server is now running", Toast.LENGTH_SHORT).show();
                    runningServer = serverType;
                }
                updateStatus();
            }
        });
    }

    private void updateStatus() {
        btnJetty.setText(runningServer == ServerType.JETTY ? "Stop Jetty" : "Launch Jetty");
        btnWinstone.setText(runningServer == ServerType.WINSTONE ? "Stop Winstone" : "Launch Winstone");
    }

    private void startServer(ServerType serverType) {
        ServerRunner runner = ServerRunnerFactory.createServer(serverType);
        task = new RunServerTask(runner);
        task.execute();
    }

    private void stopServer() {
        task.stop();
        Toast.makeText(getApplicationContext(), runningServer.getDescription() + " server stopped", Toast.LENGTH_SHORT).show();
        runningServer = null;
    }

}
