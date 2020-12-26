package com.avishai.MyShas;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.ALARM_SERVICE;

/**
 * A class with methods of the application
 */
class ProgramMethods {

    /**
     * Help method to manage the selected items from the menu
     * @param item - the id of the selected item
     * @param ac - the Activity that called the method
     * @param files - a container of the files from the Activity that called the method
     * @param numOfPages - the number of the pages of all the given files
     */
    static void manageSederMenu(int item, Activity ac, ArrayList<Keystore> files, int numOfPages) {
        switch (item) {
            case R.id.goToBrachot:
                ProgramMethods.openActivity(ac, "brachotFile", 64, 9,
                                1, false, R.id.goToBrachot);
                break;
            case R.id.goToShabat:
                ProgramMethods.openActivity(ac, "shabatFile", 157, 24,
                                2, true, R.id.goToShabat);
                break;
            case R.id.goToEruvin:
                ProgramMethods.openActivity(ac, "eruvinFile", 105, 10,
                                3, false, R.id.goToEruvin);
                break;
            case R.id.goToPsachim:
                ProgramMethods.openActivity(ac, "psachimFile", 121, 10,
                                4, true, R.id.goToPsachim);
                break;
            case R.id.goToShkalim:
                ProgramMethods.openActivity(ac, "shkalimFile", 22, 8,
                                5, true, R.id.goToShkalim);
                break;
            case R.id.goToYoma:
                ProgramMethods.openActivity(ac, "yomaFile", 88, 8,
                                6, false, R.id.goToYoma);
                break;
            case R.id.goToSuka:
                ProgramMethods.openActivity(ac, "sukaFile", 56, 5,
                                7, true, R.id.goToSuka);
                break;
            case R.id.goToBeitza:
                ProgramMethods.openActivity(ac, "beitzaFile", 40, 5,
                                8, true, R.id.goToBeitza);
                break;
            case R.id.goToRoshHashana:
                ProgramMethods.openActivity(ac, "roshHashanaFile", 35, 4,
                                9, false, R.id.goToRoshHashana);
                break;
            case R.id.goToTaanit:
                ProgramMethods.openActivity(ac, "taanitFile", 31, 4,
                                10, false, R.id.goToTaanit);
                break;
            case R.id.goToMegila:
                ProgramMethods.openActivity(ac, "megilaFile", 32, 4,
                                11, false, R.id.goToMegila);
                break;
            case R.id.goToMoedKatan:
                ProgramMethods.openActivity(ac, "moedKatanFile", 29, 3,
                                12, false, R.id.goToMoedKatan);
                break;
            case R.id.goToHagiga:
                ProgramMethods.openActivity(ac, "hagigaFile", 27, 3,
                                13, false, R.id.goToHagiga);
                break;
            case R.id.goToYevamot:
                ProgramMethods.openActivity(ac, "yevamotFile", 122, 16,
                                14, true, R.id.goToYevamot);
                break;
            case R.id.goToKtubot:
                ProgramMethods.openActivity(ac, "ktubotFile", 112, 13,
                                15, true, R.id.goToKtubot);
                break;
            case R.id.goToNedarim:
                ProgramMethods.openActivity(ac, "nedarimFile", 91, 11,
                                16, true, R.id.goToNedarim);
                break;
            case R.id.goToNazir:
                ProgramMethods.openActivity(ac, "nazirFile", 65, 9,
                                17, true, R.id.goToNazir);
                break;
            case R.id.goToSota:
                ProgramMethods.openActivity(ac, "sotaFile", 48, 9,
                                18, true, R.id.goToSota);
                break;
            case R.id.goToGitin:
                ProgramMethods.openActivity(ac, "gitinFile", 89, 9,
                                19, true, R.id.goToGitin);
                break;
            case R.id.goToKidushin:
                ProgramMethods.openActivity(ac, "kidushinFile", 81, 4,
                                20, true, R.id.goToKidushin);
                break;
            case R.id.goToBabaKama:
                ProgramMethods.openActivity(ac, "babaKamaFile", 119, 10,
                                21, true, R.id.goToBabaKama);
                break;
            case R.id.goToBabaMetzia:
                ProgramMethods.openActivity(ac, "babaMetziaFile", 119, 10,
                                22, false, R.id.goToBabaMetzia);
                break;
            case R.id.goToBabaBatra:
                ProgramMethods.openActivity(ac, "babaBatraFile", 176, 10,
                                23, true, R.id.goToBabaBatra);
                break;
            case R.id.goToSanhedrin:
                ProgramMethods.openActivity(ac, "sanhedrinFile", 113, 11,
                                24, true, R.id.goToSanhedrin);
                break;
            case R.id.goToMakot:
                ProgramMethods.openActivity(ac, "makotFile", 24, 3,
                                25, true, R.id.goToMakot);
                break;
            case R.id.goToShvuot:
                ProgramMethods.openActivity(ac, "shvuotFile", 49, 8,
                                26, true, R.id.goToShvuot);
                break;
            case R.id.goToAvodaZara:
                ProgramMethods.openActivity(ac, "avodaZaraFile", 76, 5,
                                27, true, R.id.goToAvodaZara);
                break;
            case R.id.goToHorayot:
                ProgramMethods.openActivity(ac, "horayotFile", 14, 3,
                                28, false, R.id.goToHorayot);
                break;
            case R.id.goToZvachim:
                ProgramMethods.openActivity(ac, "zvachimFile", 120, 14,
                                29, true, R.id.goToZvachim);
                break;
            case R.id.goToMenachot:
                ProgramMethods.openActivity(ac, "menachotFile", 110, 13,
                                30, false, R.id.goToMenachot);
                break;
            case R.id.goToChulin:
                ProgramMethods.openActivity(ac, "chulinFile", 142, 12,
                                31, false, R.id.goToChulin);
                break;
            case R.id.goToBechorot:
                ProgramMethods.openActivity(ac, "bechorotFile", 61, 9,
                                32, false, R.id.goToBechorot);
                break;
            case R.id.goToArachin:
                ProgramMethods.openActivity(ac, "arachinFile", 34, 9,
                                33, false, R.id.goToArachin);
                break;
            case R.id.goToTmura:
                ProgramMethods.openActivity(ac, "tmuraFile", 34, 7,
                                34, false, R.id.goToTmura);
                break;
            case R.id.goToKritut:
                ProgramMethods.openActivity(ac, "kritutFile", 28, 6,
                                35, true, R.id.goToKritut);
                break;
            case R.id.goToMeila :
                ProgramMethods.openActivity(ac, "meilaFile", 37, 0,
                                36, true, R.id.goToMeila);
                break;
            case R.id.goToNida:
                ProgramMethods.openActivity(ac, "nidaFile", 73, 10,
                                37, false, R.id.goToNida);
                break;
            case R.id.howMuchAll:
                int res = ProgramMethods.sumPagesLearned(files, 0, files.size() - 1, false);

                String pagesLeft = "נשאר ללמוד עוד " + res + " מתוך " + numOfPages + " דפים";
                Toast.makeText(ac, pagesLeft, Toast.LENGTH_LONG).show();
                break;
            case R.id.home:
                ProgramMethods.manageHome(ac, "השינויים לא נשמרו");
        }
    }

    /**
     * Help method to manage the selected items from the menu from the Masechet Activity
     * @param item - the id of the selected item
     * @param ac - the Activity that called the method
     * @param adapter - the bridge between the exlv and the UI
     * @param listGroup - the container of the chapters in the Masechet
     * @param listItems - the container of the pages in the Masechet
     * @param fileName - the name of the Masechet's file
     * @param numOfPages - the number of the pages in the given Masechet
     * @param numMasechet - the number of the Masechet
     * @param stateOfPages - the state of the pages before saving
     * @param exlv - thecontainer of all the Masechet
     * @param webSite - the link of the Masechet
     * @param masechet - the name of the Masechet
     * @param progressBar the UI progressbar
     * @param progressTxt - the text of the percent of the learned pages
     * @param hasLastPage - to determine if the Masechet has last page
     */
    static void manageMenu(@NonNull MenuItem item, Activity ac, MainAdapter adapter, List<String> listGroup,
                           HashMap<String, List<String>> listItems, String fileName, final int numOfPages, int numMasechet,
                           final HashMap<String, Boolean> stateOfPages, ExpandableListView exlv, String webSite,
                           String masechet, final ProgressBar progressBar, TextView progressTxt, Boolean hasLastPage) {
        Keystore store = new Keystore(ac.getApplicationContext(), fileName, numOfPages);

        switch (item.getItemId()) {
            case R.id.checkAll :
                if (DataMethods.checkAllPages(2, numOfPages, stateOfPages)) {
                    Toast.makeText(ac, "המסכת סומנה כנלמדה", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(ac, "בוטל הסימון מהמסכת", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.Chap1 :
                ProgramMethods.manageCheckChap(ac, 0, adapter, stateOfPages);
                break;
            case R.id.Chap2 :
                ProgramMethods.manageCheckChap(ac, 1, adapter, stateOfPages);
                break;
            case R.id.Chap3 :
                ProgramMethods.manageCheckChap(ac, 2, adapter, stateOfPages);
                break;
            case R.id.Chap4 :
                ProgramMethods.manageCheckChap(ac, 3, adapter, stateOfPages);
                break;
            case R.id.Chap5 :
                ProgramMethods.manageCheckChap(ac, 4, adapter, stateOfPages);
                break;
            case R.id.Chap6 :
                ProgramMethods.manageCheckChap(ac, 5, adapter, stateOfPages);
                break;
            case R.id.Chap7 :
                ProgramMethods.manageCheckChap(ac, 6, adapter, stateOfPages);
                break;
            case R.id.Chap8 :
                ProgramMethods.manageCheckChap(ac, 7, adapter, stateOfPages);
                break;
            case R.id.Chap9 :
                ProgramMethods.manageCheckChap(ac, 8, adapter, stateOfPages);
                break;
            case R.id.Chap10 :
                ProgramMethods.manageCheckChap(ac, 9, adapter, stateOfPages);
                break;
            case R.id.Chap11 :
                ProgramMethods.manageCheckChap(ac, 10, adapter, stateOfPages);
                break;
            case R.id.Chap12 :
                ProgramMethods.manageCheckChap(ac, 11, adapter, stateOfPages);
                break;
            case R.id.Chap13 :
                ProgramMethods.manageCheckChap(ac, 12, adapter, stateOfPages);
                break;
            case R.id.Chap14 :
                ProgramMethods.manageCheckChap(ac, 13, adapter, stateOfPages);
                break;
            case R.id.Chap15 :
                ProgramMethods.manageCheckChap(ac, 14, adapter, stateOfPages);
                break;
            case R.id.Chap16 :
                ProgramMethods.manageCheckChap(ac, 15, adapter, stateOfPages);
                break;
            case R.id.Chap17 :
                ProgramMethods.manageCheckChap(ac, 16, adapter, stateOfPages);
                break;
            case R.id.Chap18 :
                ProgramMethods.manageCheckChap(ac, 17, adapter, stateOfPages);
                break;
            case R.id.Chap19 :
                ProgramMethods.manageCheckChap(ac, 18, adapter, stateOfPages);
                break;
            case R.id.Chap20 :
                ProgramMethods.manageCheckChap(ac, 19, adapter, stateOfPages);
                break;
            case R.id.Chap21 :
                ProgramMethods.manageCheckChap(ac, 20, adapter, stateOfPages);
                break;
            case R.id.Chap22 :
                ProgramMethods.manageCheckChap(ac, 21, adapter, stateOfPages);
                break;
            case R.id.Chap23 :
                ProgramMethods.manageCheckChap(ac, 22, adapter, stateOfPages);
                break;
            case R.id.Chap24 :
                ProgramMethods.manageCheckChap(ac, 23, adapter, stateOfPages);
                break;
            case R.id.linkToLearn :
                ProgramMethods.openLink(ac, webSite);
                break;
            case R.id.howMuch :
                String pagesLeft = "נשאר ללמוד עוד " + DataMethods.sumPagesLearn(stateOfPages, false) + " מתוך " + (numOfPages - 1) + " דפים";
                Toast.makeText(ac, pagesLeft, Toast.LENGTH_LONG).show();
                break;
            case R.id.learned :
                ProgramMethods.openShowSpecipic(ac, numOfPages, stateOfPages, listItems, masechet, true);
                break;
            case R.id.notLearned :
                ProgramMethods.openShowSpecipic(ac, numOfPages, stateOfPages, listItems, masechet, false);
                break;
        }

        // to rearrange the ExpandableListView
        adapter = new MainAdapter(ac, listGroup, listItems, store, numOfPages, stateOfPages, false, numMasechet,
                                    progressBar, progressTxt, hasLastPage);
        exlv.setAdapter(adapter);

        ProgramMethods.determineProgress(progressBar, stateOfPages, numOfPages, progressTxt);
    }

    /**
     * Help method to manage the "home" button
     * @param ac - the Activity that called the method
     * @param text - the message to show
     */
    static void manageHome(final Activity ac, String text) {
        Toast.makeText(ac.getApplicationContext(), text, Toast.LENGTH_SHORT).show();

        // to wait a sec before return to home page
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

    /**
     * Help method to manage the "save" button
     * @param ac - the Activity that called the method
     * @param store - the file to save the state of the pages in
     * @param stateOfPages - the state of the pages before saving
     */
    static void manageSave(final Activity ac, Keystore store, HashMap<String, Boolean> stateOfPages) {
        ProgramMethods.saveStateToStore(store, stateOfPages);

        Toast.makeText(ac.getApplicationContext(), "השינויים נשמרו בהצלחה", Toast.LENGTH_SHORT).show();

        // to wait a sec before return to home page
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ac.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Help method to save the state of the pages to the file for future use
     * @param store - the file to save the state of the pages in
     * @param stateOfPages - the state of the pages before saving
     */
    private static void saveStateToStore(Keystore store, HashMap<String, Boolean> stateOfPages) {
        for (Map.Entry element : stateOfPages.entrySet()) {
            store.putBool((String) element.getKey(), (Boolean) element.getValue());
        }
    }

    /**
     * Method to open the Activity of the Masechet, with the specific parameters of the requested Masechet
     * @param ac - the Activity that called the method
     * @param fileName - the name of the Masechet's file
     * @param numOfPages - the number of the pages in the given Masechet
     * @param numOfChap - the number of the chapters in the given Masechet
     * @param numMasechet - the number of the Masechet
     * @param hasLastPage - to know if the Masechet has last page
     * @param item - the type of the Masechet (to save it for future entrance)
     */
    static void openActivity(Activity ac, String fileName, int numOfPages, int numOfChap, int numMasechet,
                                    Boolean hasLastPage, int item) {
        /* save the type of the Masechet for future entrance */
        Editor editor = ac.getSharedPreferences("setFile", Context.MODE_PRIVATE).edit();
        editor.putInt("lastPlace", item);
        editor.apply();

        Intent intent = new Intent(ac, ShowMasechet.class);

        intent.putExtra("name", fileName);
        intent.putExtra("pages", numOfPages);
        intent.putExtra("chap", numOfChap);
        intent.putExtra("hasLastPage", hasLastPage);
        intent.putExtra("numMasechet", numMasechet);

        ac.startActivity(intent);
    }

    /**
     * Method to open aSeder Activity
     * @param from - the Activity that called the method
     * @param to - the Activity to open
     */
    static void openSeder(Activity from, Class to) {
        Intent intent = new Intent(from.getApplicationContext(), to);

        from.startActivity(intent);
    }

    /**
     * Method to open the ShowMasechet Activity
     * @param from - the Activity that called the method
     * @param numOfPages - the number of the pages in the given Masechet
     * @param stateOfPages - the state of the pages before saving
     * @param listItems - the container of the pages in the Masechet
     * @param masechet - the name of the Masechet
     * @param showLearned - to determine whether to show learned pages or not
     */
    private static void openShowSpecipic(Activity from, int numOfPages, HashMap<String, Boolean> stateOfPages,
                                 HashMap<String, List<String>> listItems, String masechet, Boolean showLearned) {

        Keystore temp = new Keystore(from.getApplicationContext(), "tempFile", numOfPages);
        ProgramMethods.saveStateToStore(temp, stateOfPages);

        Intent intent = new Intent(from.getApplicationContext(), ShowSpecipic.class);
        intent.putExtra("state", listItems);
        intent.putExtra("numOfPages", numOfPages);
        intent.putExtra("learned", showLearned);
        intent.putExtra("masechet", masechet);
        from.startActivity(intent);
    }

    /**
     * Method to open a link from the web
     * @param ac - the Activity that called the method
     * @param webSite - the link to open
     */
    static void openLink(Activity ac, String webSite) {
        SharedPreferences set = ac.getApplicationContext().getSharedPreferences("setFile", Context.MODE_PRIVATE);

        String link = webSite + set.getString("format", "pdf");
        Intent intent = new Intent();

        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(link));
        ac.startActivity(intent);
    }

    /**
     * Method to determine style of given button
     * @param button - the button to determine the style
     * @param learned - how much pages learned
     * @param total - the total of the pages
     */
    static void styleOfButton(Button button, int learned, int total) {
        if (learned < (total / 2)) {
            button.setBackgroundResource(R.drawable.button_start);
        }
        // half of learn
        else if (learned < total) {
            button.setBackgroundResource(R.drawable.button_middle);
        }
        //learn all
        else {
            button.setBackgroundResource(R.drawable.button_learned);
        }
    }

    /**
     * Method to sum all learned / not learne pages in a range
     * @param file - the file to sum the pages in
     * @param start - the start page of the range to sum
     * @param end - the end page of the range to sum (include)
     * @param learned - to determine which kind of pages to sum
     * @return the sum of the requested pages in the range
     */
    static int sumPagesLearned(ArrayList<Keystore> file, int start, int end, Boolean learned) {
        int res = 0;
        for (int i = start; i <= end; ++i) {
            res += file.get(i).getNumOfGivenPages(learned);
        }

        return res;
    }

    /**
     * Method to sum all learned pages in a file
     * @param file - the file to sum the pages in
     * @return the sum of the learned pages in the file
     */
    static int sumPagesLearned(Keystore file) {
        return file.getNumOfGivenPages(true);
    }

    /**
     * Method to determine the progress of the progressbar by the percent learned paged
     * @param progressBar the UI progressbar
     * @param stateOfPages - the state of the pages before saving
     * @param numOfPages - the number of the pages in the given Masechet
     * @param progressTxt - the text of the percent of the learned pages
     */
    static void determineProgress(ProgressBar progressBar, HashMap<String, Boolean> stateOfPages, int numOfPages, TextView progressTxt) {
        int percent = ProgramMethods.percentOfLearn(stateOfPages, numOfPages - 1);

        progressBar.setProgress(percent);

        String txt = progressBar.getProgress() + "%";
        progressTxt.setText(txt);
    }

    /**
     * The "about" dialog
     * @param context - the context of the Activity that called the method
     */
    static void about(Context context) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("אודות");
        String text = "התלמוד שלי  -  אבישי אהרוני  -  1.70" +
                "\n" + "\n" +
                "לתגובות והערות:" +
                "\n" +
                "my.talmud.app@gmail.com";
        alertDialog.setMessage(text);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "אישור", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        alertDialog.show();
    }

    /**
     * Help method to calculate the percent of learned pages in Masechet
     * @param stateOfPages - the state of the pages before saving
     * @param numOfPages - the number of the pages in the given Masechet
     * @return the percent of the learned pages
     */
    private static int percentOfLearn(HashMap<String, Boolean> stateOfPages, int numOfPages) {
        int numLearned = DataMethods.sumPagesLearn(stateOfPages, true);

        double percent = numLearned / (double)(numOfPages) * 100;

        return (int)percent;
    }

    /**
     * Help method to check / uncheck all pages in a given chapter
     * @param ac - the Activity that called the method
     * @param groupPosition - the number of the chapter to check / uncheck
     * @param adapter - the bridge between the exlv and the UI
     * @param stateOfPages - the state of the pages before saving
     */
    private static void manageCheckChap(Activity ac, int groupPosition, MainAdapter adapter, HashMap<String, Boolean> stateOfPages) {
        // for check all the pages
        if (DataMethods.checkAllPages(adapter.getNumOfFirstChild(groupPosition), adapter.getNumOfLastChild(groupPosition), stateOfPages)) {
            Toast.makeText(ac, "הפרק סומן כנלמד", Toast.LENGTH_LONG).show();
        }
        // uncheck
        else {
            Toast.makeText(ac, "בוטל הסימון מהפרק", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Method to cancel a notification
     * @param context - the context of the Activity that called the method
     * @param code - the code if the notification to cancel
     */
    static void cancelNotification(Context context, int code) {
        Intent intent = new Intent(context, NotificationReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,code, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    /**
     * @param context - the context of the Activity that called the method
     * @param time - the time to fire the alarm (in String format)
     * @param typeNotification - the type of the notification (weekly - 0, daily - 1, once - 2)
     * @param dayOfWeek - the day of the week (if needed) to fire the notification
     * @param runOnce - to determine whether the once notification should run or not
     */
    static void createNotificationAtTime(Context context, String[] time, String typeNotification, int dayOfWeek, Boolean runOnce) {
        ProgramMethods.createNotificationChannel(context);

        Intent intent = new Intent(context, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 120, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        Calendar cal = Calendar.getInstance();

        // to determine the time of the notification
        cal.setFirstDayOfWeek(Calendar.SUNDAY);
        if (!typeNotification.equals("1")) {
            cal.set(Calendar.DAY_OF_WEEK, dayOfWeek + 1);
        }
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time[0]));
        cal.set(Calendar.MINUTE, Integer.parseInt(time[1]));
        cal.set(Calendar.SECOND, 0);

        // to check if the time pass
        if (cal.before(Calendar.getInstance())) {
            if (typeNotification.equals("1")) {                     // daily
                cal.add(Calendar.DATE, 1);
            }
            else {
                cal.add(Calendar.DATE, 7);
            }
        }

        // to set the notification
        if (alarmManager != null) {

            if (typeNotification.equals("2")) {                     // once
                if (runOnce) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
                    } else {
                        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
                    }
                }
            } else if (typeNotification.equals("1")) {                // daily
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);
            } else {                                                  // weekly
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY * 7, pendingIntent);
            }

        }
    }

    /**
     * to create a notification channel (if needed)
     * @param context - the context of the Activity that called the method
     */
    static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("Avishai_01", "My Notifications",
                    NotificationManager.IMPORTANCE_DEFAULT);

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }
}