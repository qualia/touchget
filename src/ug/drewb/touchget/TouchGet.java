package ug.drewb.touchget;

import android.app.Activity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TouchGet extends Activity implements Runnable {

    static String[] COMMAND = new String[] {"su", "-c", "getevent"};

    Thread thread;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public void onStart() {
        super.onStart();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Process getevent = Runtime.getRuntime().exec(COMMAND);
            BufferedReader reader = new BufferedReader(new InputStreamReader(getevent.getInputStream()));

            android.util.Log.d("TouchGet", "init.");

            while (true) {
                final String line = reader.readLine();
                if (line == null) break;

                android.util.Log.d("TouchGet", line);
            }
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        thread.interrupt();
    }

}
