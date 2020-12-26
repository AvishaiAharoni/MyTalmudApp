package com.avishai.MyShas;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class CheckReceiver  extends BroadcastReceiver {

    /**
     * A public empty constructor
     */
    public CheckReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {
        /* to dismiss the notification */
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();

        Calendar startDate = Calendar.getInstance();
        startDate.set(2020, Calendar.JANUARY, 5, 0, 0);
        Date start = startDate.getTime();
        Date today = new Date();
        long daysElapsed = ((today.getTime() - start.getTime()) / (24 * 60 * 60 * 1000) + 1) % 2711;

        SharedPreferences dafYomi = context.getSharedPreferences("dafYomi", Context.MODE_PRIVATE);
        String[] nameOfCurrMashechet = dafYomi.getString(String.valueOf(daysElapsed), "").split("-");

        SharedPreferences SP = context.getSharedPreferences(nameOfCurrMashechet[1], Context.MODE_PRIVATE);

        /* to check the page */
        SharedPreferences.Editor editor = SP.edit();
        editor.putBoolean(String.valueOf(nameOfCurrMashechet[3]), true);

        Toast.makeText(context, "הדף סומן כנלמד בהצלחה!", Toast.LENGTH_LONG).show();

        editor.apply();
    }
}
