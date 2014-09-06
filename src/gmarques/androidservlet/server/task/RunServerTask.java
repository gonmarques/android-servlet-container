package gmarques.androidservlet.server.task;

import gmarques.androidservlet.server.ServerRunner;
import android.os.AsyncTask;

public class RunServerTask extends AsyncTask<Void, Integer, Void> {

    private final ServerRunner runner;

    public RunServerTask(ServerRunner runner) {
        this.runner = runner;
    }

    @Override
    protected Void doInBackground(Void... args) {
        try {
            runner.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void stop() {
        try {
            runner.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}