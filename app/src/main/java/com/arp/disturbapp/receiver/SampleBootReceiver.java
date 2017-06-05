package com.arp.disturbapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.arp.disturbapp.DisturbActivity;
import com.arp.disturbapp.common.ApplicationInstance;

public class SampleBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            ApplicationInstance.setAlarm(context);
        }

        Intent intents = new Intent(context,DisturbActivity.class);
        intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intents);
    }
}
