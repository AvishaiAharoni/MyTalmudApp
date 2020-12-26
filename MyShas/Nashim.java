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
public class Nashim extends AppCompatActivity {
    private ArrayList<Keystore> nashim;                   // container for all the Masechtot in this Seder

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seder_nashim);

        this.nashim = new ArrayList<>();
        this.nashim.add(new Keystore(this.getApplicationContext(), "yevamotFile", 122));
        this.nashim.add(new Keystore(this.getApplicationContext(), "ktubotFile", 112));
        this.nashim.add(new Keystore(this.getApplicationContext(), "nedarimFile", 91));
        this.nashim.add(new Keystore(this.getApplicationContext(), "nazirFile", 66));
        this.nashim.add(new Keystore(this.getApplicationContext(), "sotaFile", 49));
        this.nashim.add(new Keystore(this.getApplicationContext(), "gitinFile", 90));
        this.nashim.add(new Keystore(this.getApplicationContext(), "kidushinFile", 82));

        // the custom Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView name = toolbar.findViewById(R.id.headText);
        name.setText(R.string.sederNashim);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        onResume();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // all the buttons in the UI
        Button yevamotBtn = findViewById(R.id.button1);
        Button ktubotBtn = findViewById(R.id.button2);
        Button nedarimBtn = findViewById(R.id.button3);
        Button nazirBtn = findViewById(R.id.button4);
        Button sotaBtn = findViewById(R.id.button5);
        Button gitinBtn = findViewById(R.id.button6);
        Button kidushinBtn = findViewById(R.id.button7);

        ProgramMethods.styleOfButton(yevamotBtn, ProgramMethods.sumPagesLearned(this.nashim.get(0)), 121);
        ProgramMethods.styleOfButton(ktubotBtn, ProgramMethods.sumPagesLearned(this.nashim.get(1)), 111);
        ProgramMethods.styleOfButton(nedarimBtn, ProgramMethods.sumPagesLearned(this.nashim.get(2)), 90);
        ProgramMethods.styleOfButton(nazirBtn, ProgramMethods.sumPagesLearned(this.nashim.get(3)), 65);
        ProgramMethods.styleOfButton(sotaBtn, ProgramMethods.sumPagesLearned(this.nashim.get(4)), 48);
        ProgramMethods.styleOfButton(gitinBtn, ProgramMethods.sumPagesLearned(this.nashim.get(5)), 89);
        ProgramMethods.styleOfButton(kidushinBtn, ProgramMethods.sumPagesLearned(this.nashim.get(6)), 81);

    }

    /**
     * Method to inflate the specific menu to this form
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_nashim, menu);

        return true;
    }

    /**
     * Method to to determine what happened at click on item in the menu
     * @param item - the item that been clicked
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        ProgramMethods.manageSederMenu(item.getItemId(), this, this.nashim, 605);

        return super.onOptionsItemSelected(item);
    }

    /**
     * To open Masechet Yevamot (by click the button)
     * @param view - the button that been clicked
     */
    public void openYevamot(View view) {
        ProgramMethods.openActivity(this,"yevamotFile", 122,
                        16, 14, true, R.id.goToYevamot);
    }

    /**
     * To open Masechet Ktubot (by click the button)
     * @param view - the button that been clicked
     */
    public void openKtubot(View view) {
        ProgramMethods.openActivity(this,"ktubotFile", 112,
                        13, 15, true, R.id.goToKtubot);
    }

    /**
     * To open Masechet Nedarim (by click the button)
     * @param view - the button that been clicked
     */
    public void openNedarim(View view) {
        ProgramMethods.openActivity(this,"nedarimFile", 91,
                        11, 16, true, R.id.goToNedarim);
    }

    /**
     * To open Masechet Nazir (by click the button)
     * @param view - the button that been clicked
     */
    public void openNazir(View view) {
        ProgramMethods.openActivity(this,"nazirFile", 65,
                        9, 17, true, R.id.goToNazir);
    }

    /**
     * To open Masechet Sota (by click the button)
     * @param view - the button that been clicked
     */
    public void openSota(View view) {
        ProgramMethods.openActivity(this,"sotaFile", 48,
                        9, 18, true, R.id.goToSota);
    }

    /**
     * To open Masechet Gitin (by click the button)
     * @param view - the button that been clicked
     */
    public void openGitin(View view) {
        ProgramMethods.openActivity(this,"gitinFile", 89,
                        9, 19, true, R.id.goToGitin);
    }

    /**
     * To open Masechet Kidushin (by click the button)
     * @param view - the button that been clicked
     */
    public void openKidushin(View view) {
        ProgramMethods.openActivity(this,"kidushinFile", 81,
                        4, 20, true, R.id.goToKidushin);
    }
}
