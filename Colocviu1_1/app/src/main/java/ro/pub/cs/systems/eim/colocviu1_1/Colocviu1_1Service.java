package ro.pub.cs.systems.eim.colocviu1_1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Colocviu1_1Service extends Service {
    private Colocviu1_1Thread thread = null;

    public Colocviu1_1Service() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String direction = intent.getStringExtra(Colocviul1_1MainActivity.DIRECTION_KEY);

        thread = new Colocviu1_1Thread(this, direction);
        thread.start();

        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        thread.stopThread();
    }
}