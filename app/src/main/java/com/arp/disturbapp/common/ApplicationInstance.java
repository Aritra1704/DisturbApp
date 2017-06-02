package com.arp.disturbapp.common;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import com.arp.disturbapp.receiver.AlarmReceiver;
import com.arp.disturbapp.DisturbService;

/**
 * Created by aritrapal on 02/06/17.
 */

public class ApplicationInstance extends Application {

    private static final String TAG = "ApplicationInstance";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate");
        Intent serviceIntent = new Intent(getApplicationContext(), DisturbService.class);
        startService(serviceIntent);
    }

    public static void setAlarm(Context context) {
        Log.d(TAG, "setAlarm");

        AlarmManager alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intentAlarm = new Intent(context, AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intentAlarm, 0);
        alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 10 * 1000, alarmIntent);
    }
}
