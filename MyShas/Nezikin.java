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
public class Nezikin extends AppCompatActivity {
    private ArrayList<Keystore> nezikin;                   // container for all the Masechtot in this Seder

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seder_nezikin);

        this.nezikin = new ArrayList<>();
        this.nezikin.add(new Keystore(this.getApplicationContext(), "babaKamaFile", 119));
        this.nezikin.add(new Keystore(this.getApplicationContext(), "babaMetziaFile", 119));
        this.nezikin.add(new Keystore(this.getApplicationContext(), "babaBatraFile", 176));
        this.nezikin.add(new Keystore(this.getApplicationContext(), "sanhedrinFile", 113));
        this.nezikin.add(new Keystore(this.getApplicationContext(), "makotFile", 24));
        this.nezikin.add(new Keystore(this.getApplicationContext(), "shvuotFile", 49));
        this.nezikin.add(new Keystore(this.getApplicationContext(), "avodaZaraFile", 76));
        this.nezikin.add(new Keystore(this.getApplicationContext(), "horayotFile", 14));

        // the custom Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView name = toolbar.findViewById(R.id.headText);
        name.setText(R.string.sederNezikin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        onResume();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // all the buttons in the UI
        Button babaKamaBtn = findViewById(R.id.button1);
        Button babaMetziaBtn = findViewById(R.id.button2);
        Button babaBatraBtn = findViewById(R.id.button3);
        Button sanhedrinBtn = findViewById(R.id.button4);
        Button makotBtn = findViewById(R.id.button5);
        Button shvuotBtn = findViewById(R.id.button6);
        Button avodaZaraBtn = findViewById(R.id.button7);
        Button horayotBtn = findViewById(R.id.button8);

        ProgramMethods.styleOfButton(babaKamaBtn, ProgramMethods.sumPagesLearned(this.nezikin.get(0)), 118);
        ProgramMethods.styleOfButton(babaMetziaBtn, ProgramMethods.sumPagesLearned(this.nezikin.get(1)), 118);
        ProgramMethods.styleOfButton(babaBatraBtn, ProgramMethods.sumPagesLearned(this.nezikin.get(2)), 175);
        ProgramMethods.styleOfButton(sanhedrinBtn, ProgramMethods.sumPagesLearned(this.nezikin.get(3)), 112);
        ProgramMethods.styleOfButton(makotBtn, ProgramMethods.sumPagesLearned(this.nezikin.get(4)), 23);
        ProgramMethods.styleOfButton(shvuotBtn, ProgramMethods.sumPagesLearned(this.nezikin.get(5)), 48);
        ProgramMethods.styleOfButton(avodaZaraBtn, ProgramMethods.sumPagesLearned(this.nezikin.get(6)), 75);
        ProgramMethods.styleOfButton(horayotBtn, ProgramMethods.sumPagesLearned(this.nezikin.get(7)), 13);
    }

    /**
     * Method to inflate the specific menu to this form
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_nezikin, menu);

        return true;
    }

    /**
     * Method to to determine what happened at click on item in the menu
     * @param item - the item that been clicked
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ProgramMethods.manageSederMenu(item.getItemId(), this, this.nezikin, 682);

        return super.onOptionsItemSelected(item);
    }

    /**
     * To open Masechet Baba Kama (by click the button)
     * @param view - the button that been clicked
     */
    public void openBabaKama(View view) {
        ProgramMethods.openActivity(this, "babaKamaFile", 119,
                        10, 21, true, R.id.goToBabaKama);
    }

    /**
     * To open Masechet Baba Metzia (by click the button)
     * @param view - the button that been clicked
     */
    public void openBabaMetzia(View view) {
        ProgramMethods.openActivity(this, "babaMetziaFile", 119,
                        10, 22, false, R.id.goToBabaMetzia);
    }

    /**
     * To open Masechet Baba Batra (by click the button)
     * @param view - the button that been clicked
     */
    public void openBabaBatra(View view) {
        ProgramMethods.openActivity(this, "babaBatraFile", 176,
                        10, 23, true, R.id.goToBabaBatra);
    }

    /**
     * To open Masechet Sanhedrin (by click the button)
     * @param view - the button that been clicked
     */
    public void openSanhedrin(View view) {
        ProgramMethods.openActivity(this, "sanhedrinFile", 113,
                        11, 24, true, R.id.goToSanhedrin);
    }

    /**
     * To open Masechet Makot (by click the button)
     * @param view - the button that been clicked
     */
    public void openMakot(View view) {
        ProgramMethods.openActivity(this, "makotFile", 24,
                        3, 25, true, R.id.goToMakot);
    }

    /**
     * To open Masechet Shvuot (by click the button)
     * @param view - the button that been clicked
     */
    public void openShvuot(View view) {
        ProgramMethods.openActivity(this, "shvuotFile", 49,
                        8, 26, true, R.id.goToShvuot);
    }

    /**
     * To open Masechet Avoda Zara (by click the button)
     * @param view - the button that been clicked
     */
    public void openAvodaZara(View view) {
        ProgramMethods.openActivity(this, "avodaZaraFile", 76,
                        5, 27, true, R.id.goToAvodaZara);
    }

    /**
     * To open Masechet Horayot (by click the button)
     * @param view - the button that been clicked
     */
    public void openHorayot(View view) {
        ProgramMethods.openActivity(this, "horayotFile", 14,
                        3, 28, false, R.id.goToHorayot);
    }
}