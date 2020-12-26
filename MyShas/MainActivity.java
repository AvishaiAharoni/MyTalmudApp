package com.avishai.MyShas;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * The first Activity to show (when the app is loading)
 */
public class MainActivity extends AppCompatActivity {
    private SharedPreferences dafYomiFile;
    private SharedPreferences set;

    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
//        mContentView.setOnClickListener(new View.OnClickListener() {
  //          @Override
    //        public void onClick(View view) {
      //          toggle();
        //    }
        //});

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);

        this.set = getApplicationContext().getSharedPreferences("setFile", Context.MODE_PRIVATE);
        this.dafYomiFile = getApplicationContext().getSharedPreferences("dafYomi", Context.MODE_PRIVATE);

        // if this is the first time - init the setting file anf the dafYomi file
        if (!this.dafYomiFile.contains("1")) {
            initSettinsgsFile();

            insertPages(1, 63, "1-brachotFile-ברכות דף-");

            insertPages(64, 219, "2-shabatFile-שבת דף-");
            insertPages(220, 323, "3-eruvinFile-עירובין דף-");
            insertPages(324, 443, "4-psachimFile-פסחים דף-");
            insertPages(444, 464, "5-shkalimFile-שקלים דף-");
            insertPages(465, 551, "6-yomaFile-יומא דף-");
            insertPages(552, 606, "7-sukaFile-סוכה דף-");
            insertPages(607, 645, "8-beitzaFile-ביצה דף-");
            insertPages(646, 679, "9-roshHashanaFile-ראש השנה דף-");
            insertPages(680, 709, "10-taanitFile-תענית דף-");
            insertPages(710, 740, "11-megilaFile-מגילה דף-");
            insertPages(741, 768, "12-moedKatanFile-מועד קטן דף-");
            insertPages(769, 794, "13-hagigaFile-חגיגה דף-");

            insertPages(795, 915, "14-yevamotFile-יבמות דף-");
            insertPages(916, 1026, "15-ktubotFile-כתובות דף-");
            insertPages(1027, 1116, "16-nedarimFile-נדרים דף-");
            insertPages(1117, 1181, "17-nazirFile-נזיר דף-");
            insertPages(1182, 1229, "18-sotaFile-סוטה דף-");
            insertPages(1230, 1318, "19-gitinFile-גיטין דף-");
            insertPages(1319, 1399, "20-kidushinFile-קידושין דף-");

            insertPages(1400, 1517, "21-babaKamaFile-בבא קמא דף-");
            insertPages(1518, 1635, "22-babaMetziaFile-בבא מציעא דף-");
            insertPages(1636, 1810, "23-babaBatraFile-בבא בתרא דף-");
            insertPages(1811, 1922, "24-sanhedrinFile-סנהדרין דף-");
            insertPages(1923, 1945, "25-makotFile-מכות דף-");
            insertPages(1946, 1993, "26-shvuotFile-שבועות דף-");
            insertPages(1994, 2068, "27-avodaZaraFile-עבודה זרה דף-");
            insertPages(2069, 2081, "28-horayotFile-הוריות דף-");

            insertPages(2082, 2200, "29-zvachimFile-זבחים דף-");
            insertPages(2201, 2309, "30-menachotFile-מנחות דף-");
            insertPages(2310, 2450, "31-chulinFile-חולין דף-");
            insertPages(2451, 2510, "32-bechorotFile-בכורות דף-");
            insertPages(2511, 2543, "33-arachinFile-ערכין דף-");
            insertPages(2544, 2576, "34-tmuraFile-תמורה דף-");
            insertPages(2577, 2603, "35-kritutFile-כריתות דף-");
            insertPages(2604, 2623, "36-meilaFile-מעילה דף-");
            insertPages(2624, 2626, "36-meilaFile-קינים דף-", 21);
            insertPages(2627, 2635, "36-meilaFile-תמיד דף-", 25);
            insertPages(2636, 2639, "36-meilaFile-מידות דף-", 34);

            insertPages(2640, 2711, "37-nidaFile-נידה דף-");
        }

        // the update to determine whether to fire the once alarm
        if (!this.set.contains("format")) {
            this.set.edit().putBoolean("runOnce", false).apply();
            this.set.edit().putString("format", "pdf").apply();
        }
    }

    /**
     * Method to init the settings file with default values
     */
    private void initSettinsgsFile() {
        Editor editor = this.set.edit();

        editor.putBoolean("showNotif", false);
        editor.putString("message", "לא לשכוח ללמוד דף יומי");
        editor.putInt("typeNotification", 2);
        editor.putInt("dayOfWeek", 5);
        editor.putString("time", "21:30");
        editor.putInt("lastPlace", -99);
        editor.putBoolean("runOnce", false);
        editor.putString("format", "pdf");

        editor.apply();
    }

    /**
     * Method to insert the paget to the dafYomu file
     * @param start - the number of the start page of the Masechet in the Shas
     * @param end - the number of the end page of the Masechet in the Shas
     * @param txtToInsert - given text to insert for this Masechet
     */
    private void insertPages(int start, int end, String txtToInsert) {
        insertPages(start, end, txtToInsert, 2);
    }

    /**
     * Method to insert the paget to the dafYomu file
     * @param start - the number of the start page of the Masechet in the Shas
     * @param end - the number of the end page of the Masechet in the Shas
     * @param txtToInsert - given text to insert for this Masechet
     * @param startPage - the page to start in the Masechet (not 2 in Tamid, Midot, Kinim)
     */
    private void insertPages(int start, int end, String txtToInsert, int startPage) {
        Editor editor = this.dafYomiFile.edit();

        for (int i = start; i <= end; ++i) {
            editor.putString(String.valueOf(i), txtToInsert + startPage);
            ++startPage;
        }

        editor.apply();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);

        OpenSeder(this);
    }
    /**
     * Method to open the next Activity (Seder)
     * @param ac - the Activity that called the method
     */
    private void OpenSeder(final Activity ac) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    Intent seder = new Intent(ac, Seder.class);

                    seder.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    seder.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ac.startActivity(seder);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

//    private void toggle() {
//        if (mVisible) {
//            hide();
//        } else {
//            show();
//        }
//    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}
