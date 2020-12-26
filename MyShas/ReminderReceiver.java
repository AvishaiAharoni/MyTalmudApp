package com.avishai.MyShas;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

/**
 * A receiver to create the notification for reminder
 */
public class ReminderReceiver extends BroadcastReceiver {

    /**
     * A public empty constructor
     */
    public ReminderReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {
        // to determine the next time of the reminder notification
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 30);

        // to dismiss the notification
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(120);

        ProgramMethods.createNotificationChannel(context);

        Intent notifIntent = new Intent(context, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent. getBroadcast(context, 121, notifIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
            } else {
                alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
            }

        }

        // to set the notification again (if needed)
        SharedPreferences set = context.getSharedPreferences("setFile", Context.MODE_PRIVATE);
        String typeNotif = String.valueOf(set.getInt("typeNotification", 2));

        if (set.getBoolean("runOnce", false) || (!typeNotif.equals("2"))) {
            ProgramMethods.createNotificationAtTime(context, set.getString("time", "21:30").split(":"),
                    typeNotif, set.getInt("dayOfWeek", 5),true);
        }
    }
}