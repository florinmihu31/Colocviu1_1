package ro.pub.cs.systems.eim.colocviu1_1;

import android.content.Context;
import android.content.Intent;

import java.util.Date;

public class Colocviu1_1Thread extends Thread {
    private boolean isRunning = true;
    public static final String BROADCAST_KEY = "broadcast";
    private String direction;
    private Context context;

    public Colocviu1_1Thread(Context context, String direction) {
        this.context = context;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (isRunning) {
            Intent intent = new Intent();
            intent.setAction("ro.pub.cs.systems.eim.colocviu1_1.Colocviu1_1Service");
            intent.putExtra(BROADCAST_KEY, new Date(System.currentTimeMillis()) + " " + direction);
            context.sendBroadcast(intent);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
