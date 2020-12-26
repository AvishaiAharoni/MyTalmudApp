package com.avishai.MyShas;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * An activity for a single Masechet to show
 */
public class ShowMasechet extends AppCompatActivity {
    private ImageView img;
    private ExpandableListView exlv;
    private List<String> listGroup;                         // for the parent list
    private HashMap<String, List<String>> listItems;        // for the child items
    private MainAdapter adapter;
    private Keystore store;                                 // for shared pereferences
    private HashMap<String, Boolean> stateOfPages;          // to save the state before saving
    private int numOfPages;
    private String fileName;
    private int numOfChap;
    private String url;
    private TextView name;
    private int numMasechet;
    private Boolean hasLastPage;
    private ProgressBar progressBar;
    private TextView progressTxt;

    /**
     * Method to inflate the specific menu to this form (for every Masechet)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        switch (this.numOfChap) {
            case 3 :
                inflater.inflate(R.menu.menu_3_chap, menu);
                break;
            case 4 :
                inflater.inflate(R.menu.menu_4_chap, menu);
                break;
            case 5 :
                inflater.inflate(R.menu.menu_5_chap, menu);
                break;
            case 6 :
                inflater.inflate(R.menu.menu_6_chap, menu);
                break;
            case 7 :
                inflater.inflate(R.menu.menu_7_chap, menu);
                break;
            case 8 :
                inflater.inflate(R.menu.menu_8_chap, menu);
                break;
            case 9 :
                inflater.inflate(R.menu.menu_9_chap, menu);
                break;
            case 10 :
                inflater.inflate(R.menu.menu_10_chap, menu);
                break;
            case 11 :
                inflater.inflate(R.menu.menu_11_chap, menu);
                break;
            case 12 :
                inflater.inflate(R.menu.menu_12_chap, menu);
                break;
            case 13 :
                inflater.inflate(R.menu.menu_13_chap, menu);
                break;
            case 14 :
                inflater.inflate(R.menu.menu_14_chap, menu);
                break;
            case 16 :
                inflater.inflate(R.menu.menu_16_chap, menu);
                break;
            case 24 :
                inflater.inflate(R.menu.menu_24_chap, menu);
                break;
            case 0 :
                inflater.inflate(R.menu.menu_meila_chap, menu);
                break;
            // if there isn't a menu to show
            default:
                ProgramMethods.manageHome(this, "שגיאה");
        }
        return true;
    }

    /**
     * Method to to determine what happened at click on item in the menu
     * @param item - the item that been clicked
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                disableButtonns();
                ProgramMethods.manageSave(this, store, stateOfPages);
                break;
            case R.id.home:
                disableButtonns();
                ProgramMethods.manageHome(this, "השינויים לא נשמרו");
                break;
            // for all others options
            default:
                ProgramMethods.manageMenu(item, this, this.adapter, this.listGroup, this.listItems, this.fileName,
                        this.numOfPages, this.numMasechet, this.stateOfPages, this.exlv, this.url, this.name.getText().toString(),
                        this.progressBar, this.progressTxt, this.hasLastPage);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masechet);

        /* The custom Toolbar */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.name = toolbar.findViewById(R.id.headText);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.img = findViewById(R.id.imgView);

        /* the specific properties of the Masechet */
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.fileName = extras.getString("name");
            this.numOfPages = extras.getInt("pages");
            this.numOfChap = extras.getInt("chap");
            this.hasLastPage = extras.getBoolean("hasLastPage");
            this.numMasechet = extras.getInt("numMasechet");
            this.url = "https://www.hebrewbooks.org/shas.aspx?mesechta=" + this.numMasechet + "&daf=2&format=pdf";
        }

        /* to create a dynamic shortcut to the last Masechet that entered */
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {
            ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

            Intent intent = new Intent(this, ShowMasechet.class);

            intent.putExtra("name", this.fileName);
            intent.putExtra("pages", this.numOfPages);
            intent.putExtra("chap", this.numOfChap);
            intent.putExtra("hasLastPage", this.hasLastPage);
            intent.putExtra("numMasechet", this.numMasechet);
            intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");

            ShortcutInfo shortcutInfo = new ShortcutInfo.Builder(this, "shID1")
                    .setShortLabel("מיקום אחרון")
                    .setIcon(Icon.createWithResource(this, R.drawable.d_shortcut))
                    .setIntent(intent)
                    .build();

            shortcutManager.setDynamicShortcuts(Collections.singletonList(shortcutInfo));
        }

        /* Gets the key file */
        this.store = new Keystore(getApplicationContext(), this.fileName, this.numOfPages);

        this.exlv = findViewById(R.id.expandableListView);
        this.listGroup = new ArrayList<>();
        this.listItems = new HashMap<>();
        this.stateOfPages = new HashMap<>();
        this.progressBar = findViewById(R.id.progressBar);
        this.progressTxt = findViewById(R.id.progressTxt);

        /* to set the bridge between the exlv and the UI */
        this.adapter = new MainAdapter(this, this.listGroup, this.listItems, this.store, this.numOfPages,
                            this.stateOfPages, true, this.numMasechet, this.progressBar, this.progressTxt, this.hasLastPage);
        this.exlv.setAdapter(this.adapter);

        determinMasechet();

        /* to set the progress of the progressbar */
        ProgramMethods.determineProgress(this.progressBar, this.stateOfPages, this.numOfPages, this.progressTxt);
    }

    /**
     * To save the progress for the future entrance
     * @param view - the button that been clicked
     */
    public void Save(View view) {
        disableButtonns();
        ProgramMethods.manageSave(this, this.store, this.stateOfPages);
    }

    /**
     * To return to the homepage without saving
     * @param view - the button that been clicked
     */
    public void Home(View view) {
        disableButtonns();
        ProgramMethods.manageHome(this, "השינויים לא נשמרו");
    }

    /**
     * Help method to disable the "save" and "home" button after a click on one of them
     */
    private void disableButtonns() {
        ImageButton home = findViewById(R.id.homeWithoutSave);
        home.setEnabled(false);
        ImageButton save = findViewById((R.id.saveChanges));
        save.setEnabled((false));
    }

    /**
     *  Help Method to determine which Masechet to show (by the name of the file)
     */
    private void determinMasechet() {
        switch (this.fileName) {
            case "brachotFile" :
                DataMethods.initListDataBrachot(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.brachot);
                this.img.setImageResource(R.drawable.brachot);
                break;
            case "shabatFile" :
                DataMethods.initListDataShabat(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.shabat);
                this.img.setImageResource(R.drawable.shabat);
                break;
            case "eruvinFile" :
                DataMethods.initListDataEruvin(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.eruvin);
                this.img.setImageResource(R.drawable.eruvin);
                break;
            case "psachimFile" :
                DataMethods.initListDataPsachim(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.psachim);
                this.img.setImageResource(R.drawable.psachim);
                break;
            case "shkalimFile" :
                DataMethods.initListDataShkalim(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.shkalim);
                this.img.setImageResource(R.drawable.shkalim);
                break;
            case "yomaFile" :
                DataMethods.initListDataYoma(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.yoma);
                this.img.setImageResource(R.drawable.yoma);
                break;
            case "sukaFile" :
                DataMethods.initListDataSuka(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.suka);
                this.img.setImageResource(R.drawable.suka);
                break;
            case "beitzaFile" :
                DataMethods.initListDataBeitza(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.beitza);
                this.img.setImageResource(R.drawable.beitza);
                break;
            case "roshHashanaFile" :
                DataMethods.initListDataRoshHashana(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.roshHashana);
                this.img.setImageResource(R.drawable.rosh_hashana);
                break;
            case "taanitFile" :
                DataMethods.initListDataTaanit(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.taanit);
                this.img.setImageResource(R.drawable.taanit);
                break;
            case "megilaFile" :
                DataMethods.initListDataMegila(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.megila);
                this.img.setImageResource(R.drawable.megila);
                break;
            case "moedKatanFile" :
                DataMethods.initListDataMoedKatan(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.moedKatan);
                this.img.setImageResource(R.drawable.moed_katan);
                break;
            case "hagigaFile" :
                DataMethods.initListDataHagiga(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.hagiga);
                this.img.setImageResource(R.drawable.hagiga);
                break;
            case "yevamotFile" :
                DataMethods.initListDataYevamot(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.yevamot);
                this.img.setImageResource(R.drawable.yevamot);
                break;
            case "ktubotFile" :
                DataMethods.initListDataKtubot(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.ktubot);
                this.img.setImageResource(R.drawable.ktubot);
                break;
            case "nedarimFile" :
                DataMethods.initListDataNedarim(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.nedarim);
                this.img.setImageResource(R.drawable.nedarim);
                break;
            case "nazirFile" :
                DataMethods.initListDataNazir(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.nazir);
                this.img.setImageResource(R.drawable.nazir);
                break;
            case "sotaFile" :
                DataMethods.initListDataSota(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.sota);
                this.img.setImageResource(R.drawable.sota);
                break;
            case "gitinFile" :
                DataMethods.initListDataGitin(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.gitin);
                this.img.setImageResource(R.drawable.gitin);
                break;
            case "kidushinFile" :
                DataMethods.initListDataKidushin(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.kidushin);
                this.img.setImageResource(R.drawable.kidushin);
                break;
            case "babaKamaFile" :
                DataMethods.initListDataBabaKama(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.babaKama);
                this.img.setImageResource(R.drawable.baba_kama);
                break;
            case "babaMetziaFile" :
                DataMethods.initListDataBabaMetzia(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.babaMetzia);
                this.img.setImageResource(R.drawable.baba_metzia);
                break;
            case "babaBatraFile" :
                DataMethods.initListDataBabaBatra(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.babaBatra);
                this.img.setImageResource(R.drawable.baba_batra);
                break;
            case "sanhedrinFile" :
                DataMethods.initListDataSanhedrin(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.sanhedrin);
                this.img.setImageResource(R.drawable.sanhedrin);
                break;
            case "makotFile" :
                DataMethods.initListDataMakot(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.makot);
                this.img.setImageResource(R.drawable.makot);
                break;
            case "shvuotFile" :
                DataMethods.initListDataShvuot(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.shvuot);
                this.img.setImageResource(R.drawable.shvuot);
                break;
            case "avodaZaraFile" :
                DataMethods.initListDataAvodaZara(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.avodaZara);
                this.img.setImageResource(R.drawable.avoda_zara);
                break;
            case "horayotFile" :
                DataMethods.initListDataHorayot(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.horayot);
                this.img.setImageResource(R.drawable.horayot);
                break;
            case "zvachimFile" :
                DataMethods.initListDataZvachim(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.zvachim);
                this.img.setImageResource(R.drawable.zvachim);
                break;
            case "menachotFile" :
                DataMethods.initListDataMenachot(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.menachot);
                this.img.setImageResource(R.drawable.menachot);
                break;
            case "chulinFile" :
                DataMethods.initListDataChulin(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.chulin);
                this.img.setImageResource(R.drawable.chulin);
                break;
            case "bechorotFile" :
                DataMethods.initListDataBechorot(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.bechorot);
                this.img.setImageResource(R.drawable.bechorot);
                break;
            case "arachinFile" :
                DataMethods.initListDataArachin(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.arachin);
                this.img.setImageResource(R.drawable.arachin);
                break;
            case "tmuraFile" :
                DataMethods.initListDataTmura(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.tmura);
                this.img.setImageResource(R.drawable.tmura);
                break;
            case "kritutFile" :
                DataMethods.initListDataKritut(this, this.listGroup, this.adapter, this.listItems);
                this.img.setImageResource(R.drawable.kritut);
                this.name.setText(R.string.kritut);
                break;
            case "meilaFile" :
                DataMethods.initListDataMeila(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.meila);
                this.img.setImageResource(R.drawable.meila);
                break;
            case "nidaFile" :
                DataMethods.initListDataNida(this, this.listGroup, this.adapter, this.listItems);
                this.name.setText(R.string.nida);
                this.img.setImageResource(R.drawable.nida);
                break;
            // if the name is not fit to any file
            default:
                ProgramMethods.manageHome(this, "שגיאה");
        }
    }
}