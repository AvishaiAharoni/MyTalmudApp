package com.avishai.MyShas;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

/**
 * The Activity for Seder Moed and all of its Masechtot
 */
public class Moed extends AppCompatActivity {
    private ArrayList<Keystore> moed;                   // container for all the Masechtot in this Seder

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seder_moed);

        this.moed = new ArrayList<>();
        this.moed.add(new Keystore(this.getApplicationContext(), "shabatFile", 157));
        this.moed.add(new Keystore(this.getApplicationContext(), "eruvinFile", 105));
        this.moed.add(new Keystore(this.getApplicationContext(), "psachimFile", 121));
        this.moed.add(new Keystore(this.getApplicationContext(), "shkalimFile", 22));
        this.moed.add(new Keystore(this.getApplicationContext(), "yomaFile", 88));
        this.moed.add(new Keystore(this.getApplicationContext(), "sukaFile", 56));
        this.moed.add(new Keystore(this.getApplicationContext(), "beitzaFile", 40));
        this.moed.add(new Keystore(this.getApplicationContext(), "roshHashanaFile", 35));
        this.moed.add(new Keystore(this.getApplicationContext(), "taanitFile", 31));
        this.moed.add(new Keystore(this.getApplicationContext(), "megilaFile", 32));
        this.moed.add(new Keystore(this.getApplicationContext(), "moedKatanFile", 29));
        this.moed.add(new Keystore(this.getApplicationContext(), "hagigaFile", 27));

        // the custom Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView name = toolbar.findViewById(R.id.headText);
        name.setText(R.string.sederMoed);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        onResume();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // all the buttons in the UI
        Button shabatBtn = findViewById(R.id.button1);
        Button eruvinBtn = findViewById(R.id.button2);
        Button psachimBtn = findViewById(R.id.button3);
        Button shkalimBtn = findViewById(R.id.button4);
        Button yomaBtn = findViewById(R.id.button5);
        Button sukaBtn = findViewById(R.id.button6);
        Button beitzaBtn = findViewById(R.id.button7);
        Button roshHashanaBtn = findViewById(R.id.button8);
        Button taanitBtn = findViewById(R.id.button9);
        Button megilaBtn = findViewById(R.id.button10);
        Button moedKatanBtn = findViewById(R.id.button11);
        Button hagigaBtn = findViewById(R.id.button12);

        ProgramMethods.styleOfButton(shabatBtn, ProgramMethods.sumPagesLearned(this.moed.get(0)), 156);
        ProgramMethods.styleOfButton(eruvinBtn, ProgramMethods.sumPagesLearned(this.moed.get(1)), 104);
        ProgramMethods.styleOfButton(psachimBtn, ProgramMethods.sumPagesLearned(this.moed.get(2)), 120);
        ProgramMethods.styleOfButton(shkalimBtn, ProgramMethods.sumPagesLearned(this.moed.get(3)), 21);
        ProgramMethods.styleOfButton(yomaBtn, ProgramMethods.sumPagesLearned(this.moed.get(4)), 87);
        ProgramMethods.styleOfButton(sukaBtn, ProgramMethods.sumPagesLearned(this.moed.get(5)), 55);
        ProgramMethods.styleOfButton(beitzaBtn, ProgramMethods.sumPagesLearned(this.moed.get(6)), 39);
        ProgramMethods.styleOfButton(roshHashanaBtn, ProgramMethods.sumPagesLearned(this.moed.get(7)), 34);
        ProgramMethods.styleOfButton(taanitBtn, ProgramMethods.sumPagesLearned(this.moed.get(8)), 30);
        ProgramMethods.styleOfButton(megilaBtn, ProgramMethods.sumPagesLearned(this.moed.get(9)), 31);
        ProgramMethods.styleOfButton(moedKatanBtn, ProgramMethods.sumPagesLearned(this.moed.get(10)), 28);
        ProgramMethods.styleOfButton(hagigaBtn, ProgramMethods.sumPagesLearned(this.moed.get(11)), 26);
    }

    /**
     * Method to inflate the specific menu to this form
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_moed, menu);

        return true;
    }

    /**
     * Method to to determine what happened at click on item in the menu
     * @param item - the item that been clicked
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ProgramMethods.manageSederMenu(item.getItemId(), this, this.moed, 731);

        return super.onOptionsItemSelected(item);
    }

    /**
     * To open Masechet Shabat (by click the button)
     * @param view - the button that been clicked
     */
    public void openShabat(View view) {
        ProgramMethods.openActivity(this, "shabatFile",157,
                        24, 2, true, R.id.goToShabat);
    }

    /**
     * To open Masechet Eruvin (by click the button)
     * @param view - the button that been clicked
     */
    public void openEruvin(View view) {
        ProgramMethods.openActivity(this, "eruvinFile",105,
                        10, 3, false, R.id.goToEruvin);
    }

    /**
     * To open Masechet Psachim (by click the button)
     * @param view - the button that been clicked
     */
    public void openPsachim(View view) {
        ProgramMethods.openActivity(this, "psachimFile",121,
                        10, 4, true, R.id.goToPsachim);
    }

    /**
     * To open Masechet Shkalim (by click the button)
     * @param view - the button that been clicked
     */
    public void openShkalim(View view) {
        ProgramMethods.openActivity(this, "shkalimFile", 22,
                        8, 5, true, R.id.goToShkalim);
    }

    /**
     * To open Masechet Yoma (by click the button)
     * @param view - the button that been clicked
     */
    public void openYoma(View view) {
        ProgramMethods.openActivity(this, "yomaFile", 88,
                        8, 6, false, R.id.goToYoma);
    }

    /**
     * To open Masechet Suka (by click the button)
     * @param view - the button that been clicked
     */
    public void openSuka(View view) {
        ProgramMethods.openActivity(this, "sukaFile", 56,
                        5, 7, true, R.id.goToSuka);
    }

    /**
     * To open Masechet Beitza (by click the button)
     * @param view - the button that been clicked
     */
    public void openBeitza(View view) {
        ProgramMethods.openActivity(this, "beitzaFile", 40,
                        5, 8, true, R.id.goToBeitza);
    }

    /**
     * To open Masechet Rosh Hashana (by click the button)
     * @param view - the button that been clicked
     */
    public void openRoshHashana(View view) {
        ProgramMethods.openActivity(this, "roshHashanaFile",35,
                        4, 9, false, R.id.goToRoshHashana);
    }

    /**
     * To open Masechet Taanit (by click the button)
     * @param view - the button that been clicked
     */
    public void openTaanit(View view) {
        ProgramMethods.openActivity(this, "taanitFile", 31,
                        4, 10, false, R.id.goToTaanit);
    }

    /**
     * To open Masechet Megila (by click the button)
     * @param view - the button that been clicked
     */
    public void openMegila(View view) {
        ProgramMethods.openActivity(this, "megilaFile", 32,
                        4, 11, false, R.id.goToMegila);
    }

    /**
     * To open Masechet Moed Katan (by click the button)
     * @param view - the button that been clicked
     */
    public void openMoedKatan(View view) {
        ProgramMethods.openActivity(this, "moedKatanFile", 29,
                        3, 12, false, R.id.goToMoedKatan);
    }

    /**
     * To open Masechet Hagiga (by click the button)
     * @param view - the button that been clicked
     */
    public void openHagiga(View view) {
        ProgramMethods.openActivity(this, "hagigaFile", 27,
                         3, 13, false, R.id.goToHagiga);
    }
}
