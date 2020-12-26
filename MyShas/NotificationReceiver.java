package com.avishai.MyShas;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

/**
 * A receiver to create the notification
 */
public class NotificationReceiver extends BroadcastReceiver {

    /**
     * A public empty constructor
     */
    public NotificationReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences set = context.getSharedPreferences("setFile", Context.MODE_PRIVATE);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "Avishai_01";

        Intent toOpen = new Intent(context, MainActivity.class);
        toOpen.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pending = PendingIntent.getActivity(context, 120, toOpen, PendingIntent.FLAG_UPDATE_CURRENT);

        // for remind me later (30m)
        Intent remindIntent = new Intent(context, ReminderReceiver.class);
        PendingIntent remindPending = PendingIntent.getBroadcast(context, 121, remindIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.drawable.reminder, "הזכר לי בעוד 30 דקות", remindPending).build();

        // for check current page as learned
        Intent checkIntent = new Intent(context, CheckReceiver.class);
        PendingIntent checkPending = PendingIntent.getBroadcast(context, 122, checkIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action checkAction =
                new NotificationCompat.Action.Builder(R.drawable.reminder, "סימון הדף של היום כנלמד", checkPending).build();


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID);
        notificationBuilder
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ic_notif)
                .setContentIntent(pending)
                .setColor(ContextCompat.getColor(context, R.color.notificationText))
                .setContentTitle("השס שלי - My Shas")
                .setContentText(set.getString("message", "לא לשכוח ללמוד דף יומי"))
                .addAction(checkAction)
                .addAction(action)
                .setContentInfo("Info")
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        // to cancel the once notification
        set.edit().putBoolean("runOnce", false).apply();

        notificationManager.notify(120, notificationBuilder.build());
    }
}