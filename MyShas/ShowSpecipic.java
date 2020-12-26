package com.avishai.MyShas;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * An Activity to show (for given Masechet) the pages that been learned / not learned
 */
public class ShowSpecipic extends AppCompatActivity {
    private Keystore temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_specipic);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView name = findViewById(R.id.headText);
        ListView listView = findViewById(R.id.listView);

        // to get all the properties of the Masechet to show
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            HashMap<String, List<String>> listItems = (HashMap<String, List<String>>) extras.get("state");
            Boolean showLearned = extras.getBoolean("learned");
            int numOfPages = extras.getInt("numOfPages");
            this.temp = new Keystore(getApplicationContext(), "tempFile", numOfPages);
            String masechet = extras.getString("masechet");

            // determine which pages to show
            if (showLearned) {
                name.setText(masechet + " - דפים שנלמדו");
            } else {
                name.setText(masechet + " - דפים שלא נלמדו");
            }

            //to show only the requested pages
            ArrayList<String> arrayList = new ArrayList<>();

            for (List<String> pages : listItems.values()) {
                for (String currPage : pages) {
                    if ((this.temp.getBool((currPage.split("-")[1]))).equals(showLearned)) {
                        arrayList.add(currPage.split("-")[0]);
                    }
                }
            }

            //to show the pages in the Hebrew order
            replacePages(arrayList, "דף טו", "דף יה");
            replacePages(arrayList, "דף טז", "דף יו");
            replacePages(arrayList, "דף קטו", "דף קיה");
            replacePages(arrayList, "דף קטז", "דף קיו");
            Collections.sort(arrayList);
            replacePages(arrayList, "דף יה", "דף טו");
            replacePages(arrayList, "דף יו", "דף טז");
            replacePages(arrayList, "דף קיה", "דף קטו");
            replacePages(arrayList, "דף קיו", "דף קטז");

            // to set the bridge between the arraylist and the UI
            ArrayAdapter adapter = new ArrayAdapter(this, R.layout.show_specipic_list, R.id.textView, arrayList);
            listView.setAdapter(adapter);
        }
    }

    protected void onDestroy() {
        super.onDestroy();

        // remove the file for the next time (with another file)
        this.temp.remove();
    }

    /**
     * Help method to arrange the pages in the of the Hebrew order
     * @param arrayList - all the pages
     * @param oldStr - the page to replace
     * @param newStr - the new page to insert
     */
    private void replacePages(ArrayList<String> arrayList, String oldStr, String newStr) {
        int idx = arrayList.indexOf(oldStr);

        if (idx != -1) {
            arrayList.remove(oldStr);
            arrayList.add(idx, newStr);
        }
    }
}