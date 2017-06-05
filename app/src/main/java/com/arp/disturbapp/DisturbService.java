package com.arp.disturbapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.arp.disturbapp.common.ApplicationInstance;

public class DisturbService extends Service {

    private String TAG = "DisturbService";

    public DisturbService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "Service started");
        ApplicationInstance.setAlarm(this);

        return START_STICKY;
//        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
