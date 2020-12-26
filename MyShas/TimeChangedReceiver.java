package com.avishai.MyShas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * A receiver to create the notification after the time of the phone was changed
 */
public class TimeChangedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.TIME_SET".equals(intent.getAction())) {

            ProgramMethods.cancelNotification(context, 120);
            ProgramMethods.cancelNotification(context, 121);

            SharedPreferences set = context.getSharedPreferences("setFile", Context.MODE_PRIVATE);

            if (set.getBoolean("showNotif", false)) {
                ProgramMethods.createNotificationAtTime(context, set.getString("time", "21:30").split(":"),
                        String.valueOf(set.getInt("typeNotification", 2)), set.getInt("dayOfWeek", 5),
                        set.getBoolean("runOnce", false));
            }
        }
    }
}
