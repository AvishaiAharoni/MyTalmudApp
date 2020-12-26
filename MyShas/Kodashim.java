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
 * The Activity for Seder Kodashim and all of its Masechtot
 */
public class Kodashim extends AppCompatActivity {
    private ArrayList<Keystore> kodashim;                           // container for all the Masechtot in this Seder

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seder_kodashim);

        this.kodashim = new ArrayList<>();
        this.kodashim.add(new Keystore(this.getApplicationContext(), "zvachimFile", 120));
        this.kodashim.add(new Keystore(this.getApplicationContext(), "menachotFile", 110));
        this.kodashim.add(new Keystore(this.getApplicationContext(), "chulinFile", 142));
        this.kodashim.add(new Keystore(this.getApplicationContext(), "bechorotFile", 61));
        this.kodashim.add(new Keystore(this.getApplicationContext(), "arachinFile", 34));
        this.kodashim.add(new Keystore(this.getApplicationContext(), "tmuraFile", 34));
        this.kodashim.add(new Keystore(this.getApplicationContext(), "kritutFile", 28));
        this.kodashim.add(new Keystore(this.getApplicationContext(), "meilaFile", 37));

        // the custom Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView name = toolbar.findViewById(R.id.headText);
        name.setText(R.string.sederKodashim);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        onResume();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // all the buttons in the UI
        Button zvachimBtn = findViewById(R.id.button1);
        Button menachotBtn = findViewById(R.id.button2);
        Button chulinBtn = findViewById(R.id.button3);
        Button bechorotBtn = findViewById(R.id.button4);
        Button arachinBtn = findViewById(R.id.button5);
        Button tmuraBtn = findViewById(R.id.button6);
        Button kritutBtn = findViewById(R.id.button7);
        Button meilaBtn = findViewById(R.id.button8);

        ProgramMethods.styleOfButton(zvachimBtn, ProgramMethods.sumPagesLearned(this.kodashim.get(0)), 119);
        ProgramMethods.styleOfButton(menachotBtn, ProgramMethods.sumPagesLearned(this.kodashim.get(1)), 109);
        ProgramMethods.styleOfButton(chulinBtn, ProgramMethods.sumPagesLearned(this.kodashim.get(2)), 141);
        ProgramMethods.styleOfButton(bechorotBtn, ProgramMethods.sumPagesLearned(this.kodashim.get(3)), 60);
        ProgramMethods.styleOfButton(arachinBtn, ProgramMethods.sumPagesLearned(this.kodashim.get(4)), 33);
        ProgramMethods.styleOfButton(tmuraBtn, ProgramMethods.sumPagesLearned(this.kodashim.get(5)), 33);
        ProgramMethods.styleOfButton(kritutBtn, ProgramMethods.sumPagesLearned(this.kodashim.get(6)), 27);
        ProgramMethods.styleOfButton(meilaBtn, ProgramMethods.sumPagesLearned(this.kodashim.get(7)), 36);
    }

    /**
     * Method to inflate the specific menu to this form
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_kodashim, menu);

        return true;
    }

    /**
     * Method to to determine what happened at click on item in the menu
     * @param item - the item that been clicked
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ProgramMethods.manageSederMenu(item.getItemId(), this, this.kodashim, 558);

        return super.onOptionsItemSelected(item);
    }

    /**
     * To open Masechet Zvachim (by click the button)
     * @param view - the button that been clicked
     */
    public void openZvachim(View view) {
        ProgramMethods.openActivity(this, "zvachimFile", 120,
                        14, 29, true, R.id.goToZvachim);
    }

    /**
     * To open Masechet Menachot (by click the button)
     * @param view - the button that been clicked
     */
    public void openMenachot(View view) {
        ProgramMethods.openActivity(this, "menachotFile", 110,
                        13, 30, false, R.id.goToMenachot);
    }

    /**
     * To open Masechet Chulin (by click the button)
     * @param view - the button that been clicked
     */
    public void openChulin(View view) {
        ProgramMethods.openActivity(this, "chulinFile", 142,
                        12, 31, false, R.id.goToChulin);
    }

    /**
     * To open Masechet Bechorot (by click the button)
     * @param view - the button that been clicked
     */
    public void openBechorot(View view) {
        ProgramMethods.openActivity(this, "bechorotFile", 61,
                        9, 32, false, R.id.goToBechorot);
    }

    /**
     * To open Masechet Arachin (by click the button)
     * @param view - the button that been clicked
     */
    public void openArachin(View view) {
        ProgramMethods.openActivity(this, "arachinFile", 34,
                        9, 33, false, R.id.goToArachin);
    }

    /**
     * To open Masechet Tmura (by click the button)
     * @param view - the button that been clicked
     */
    public void openTmura(View view) {
        ProgramMethods.openActivity(this, "tmuraFile", 34,
                        7, 34, false, R.id.goToTmura);
    }

    /**
     * To open Masechet Kritut (by click the button)
     * @param view - the button that been clicked
     */
    public void openKritut(View view) {
        ProgramMethods.openActivity(this, "kritutFile", 28,
                        6, 35, true, R.id.goToKritut);
    }

    /**
     * To open Masechet Meila with Tamid, Midot, Kinim (by click the button)
     * @param view - the button that been clicked
     */
    public void openMeila(View view) {
        ProgramMethods.openActivity(this, "meilaFile", 37,
                        0, 36, true, R.id.goToMeila);
    }
}