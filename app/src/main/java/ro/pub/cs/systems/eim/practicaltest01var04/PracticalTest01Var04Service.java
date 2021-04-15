package ro.pub.cs.systems.eim.practicaltest01var04;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var04Service extends Service {

    ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int userName = intent.getIntExtra(Constants.USER_NAME, -1);
        int groupName = intent.getIntExtra(Constants.GROUP_NAME, -1);
        processingThread = new ProcessingThread(this, userName, groupName);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }
}
