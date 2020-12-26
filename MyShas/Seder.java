package com.avishai.MyShas;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Seder extends AppCompatActivity {
    private String[] dafYomiURL = {"https://www.hebrewbooks.org/shas.aspx?mesechta=", "&daf=", "&format="};
    private String link;
    private ArrayList<Keystore> all;                                             // container for all the Masechtot in this Seder
    private String[] nameOfCurrMashechet;
    private ImageButton checkImgbtn;
    private ImageButton uncheckImgbtn;
    private SparseArray<String> pages;                                          // to convert between numbers anf chars
    private long daysElapsed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seder);

        this.all = new ArrayList<>();

        initAllFiles();

        /* the custom Toolbar */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView name = toolbar.findViewById(R.id.headText);
        name.setText(R.string.app_name);

        onResume();
    }

    /**
     * A method to init all the files of the Masechtot
     */
    private void initAllFiles() {
        this.all.add(new Keystore(this.getApplicationContext(), "brachotFile", 64));

        this.all.add(new Keystore(this.getApplicationContext(), "shabatFile", 157));
        this.all.add(new Keystore(this.getApplicationContext(), "eruvinFile", 105));
        this.all.add(new Keystore(this.getApplicationContext(), "psachimFile", 121));
        this.all.add(new Keystore(this.getApplicationContext(), "shkalimFile", 22));
        this.all.add(new Keystore(this.getApplicationContext(), "yomaFile", 88));
        this.all.add(new Keystore(this.getApplicationContext(), "sukaFile", 56));
        this.all.add(new Keystore(this.getApplicationContext(), "beitzaFile", 40));
        this.all.add(new Keystore(this.getApplicationContext(), "roshHashanaFile", 35));
        this.all.add(new Keystore(this.getApplicationContext(), "taanitFile", 31));
        this.all.add(new Keystore(this.getApplicationContext(), "megilaFile", 32));
        this.all.add(new Keystore(this.getApplicationContext(), "moedKatanFile", 29));
        this.all.add(new Keystore(this.getApplicationContext(), "hagigaFile", 27));

        this.all.add(new Keystore(this.getApplicationContext(), "yevamotFile", 122));
        this.all.add(new Keystore(this.getApplicationContext(), "ktubotFile", 112));
        this.all.add(new Keystore(this.getApplicationContext(), "nedarimFile", 91));
        this.all.add(new Keystore(this.getApplicationContext(), "nazirFile", 66));
        this.all.add(new Keystore(this.getApplicationContext(), "sotaFile", 49));
        this.all.add(new Keystore(this.getApplicationContext(), "gitinFile", 90));
        this.all.add(new Keystore(this.getApplicationContext(), "kidushinFile", 82));

        this.all.add(new Keystore(this.getApplicationContext(), "babaKamaFile", 119));
        this.all.add(new Keystore(this.getApplicationContext(), "babaMetziaFile", 119));
        this.all.add(new Keystore(this.getApplicationContext(), "babaBatraFile", 176));
        this.all.add(new Keystore(this.getApplicationContext(), "sanhedrinFile", 113));
        this.all.add(new Keystore(this.getApplicationContext(), "makotFile", 24));
        this.all.add(new Keystore(this.getApplicationContext(), "shvuotFile", 49));
        this.all.add(new Keystore(this.getApplicationContext(), "avodaZaraFile", 76));
        this.all.add(new Keystore(this.getApplicationContext(), "horayotFile", 14));

        this.all.add(new Keystore(this.getApplicationContext(), "zvachimFile", 120));
        this.all.add(new Keystore(this.getApplicationContext(), "menachotFile", 110));
        this.all.add(new Keystore(this.getApplicationContext(), "chulinFile", 142));
        this.all.add(new Keystore(this.getApplicationContext(), "bechorotFile", 61));
        this.all.add(new Keystore(this.getApplicationContext(), "arachinFile", 34));
        this.all.add(new Keystore(this.getApplicationContext(), "tmuraFile", 34));
        this.all.add(new Keystore(this.getApplicationContext(), "kritutFile", 28));
        this.all.add(new Keystore(this.getApplicationContext(), "meilaFile", 37));

        this.all.add(new Keystore(this.getApplicationContext(), "nidaFile", 73));
    }

    /**
     * A method to delete all the files of the Masechtot
     */
    private void deleteFiles() {
        for (Keystore SP : this.all) {
            SP.remove();
        }
    }

    /**
     * Method to inflate the specific menu to this form
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_more_options, menu);

        return true;
    }

    /**
     * Method to to determine what happened at click on item in the menu
     * @param item - the item that been clicked
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.markCurr :
                mark();
                break;
            case R.id.settings :
                ProgramMethods.openSeder(this, SettingsActivity.class);
                break;
            case R.id.howMachDays :
                String txt = "מתחילת מחזור הלימוד הנוכחי עברו " + this.daysElapsed + " ימים";
                Toast.makeText(getApplicationContext(), txt, Toast.LENGTH_LONG).show();
                break;
            case R.id.last :
                SharedPreferences set = getApplicationContext().getSharedPreferences("setFile", Context.MODE_PRIVATE);
                ProgramMethods.manageSederMenu(set.getInt("lastPlace", -1), this, this.all, 2711);
                break;
            case R.id.clearAll :
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("איפוס הכל");
                String text = "האם אתה בטוח שברצונך לבטל את כל הסימונים מכל הדפים?" +
                        "\n" + "(פעולה זו היא בלתי הפיכה!)";
                alertDialog.setMessage(text);
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "אישור", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        for (Keystore file : all) {
                            file.clear();
                        }

                        all.clear();
                        initAllFiles();
                        detrmineStyleButtons();
                        checkImgbtn.setVisibility(View.VISIBLE);
                        uncheckImgbtn.setVisibility(View.GONE);

                        Toast.makeText(getApplicationContext(), "בוטלו כל הסימונים", Toast.LENGTH_LONG).show();
                    }
                });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "ביטול", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
                break;
            case R.id.exit :
                finish();
                break;
            case R.id.about :
                ProgramMethods.about(this);
                break;
            // all the other options
            default:
                ProgramMethods.manageSederMenu(item.getItemId(), this, this.all, 2711);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * To open Masechet Brachot (by click the button)
     * @param view - the button that been clicked
     */
    public void openZraim(View view) {
        ProgramMethods.openActivity(this, "brachotFile", 64,
                        9, 1, false, R.id.goToBrachot);
    }

    /**
     * To open Seder Moed (by click the button)
     * @param view - the button that been clicked
     */
    public void openMoed(View view) {
        ProgramMethods.openSeder(this, Moed.class);
    }

    /**
     * To open Seder Nashim (by click the button)
     * @param view - the button that been clicked
     */
    public void openNashim(View view) {
        ProgramMethods.openSeder(this, Nashim.class);
    }

    /**
     * To open Seder Nezikin (by click the button)
     * @param view - the button that been clicked
     */
    public void openNezikin(View view) {
        ProgramMethods.openSeder(this, Nezikin.class);
    }

    /**
     * To open Seder Kodashim (by click the button)
     * @param view - the button that been clicked
     */
    public void openkodashim(View view) {
        ProgramMethods.openSeder(this, Kodashim.class);
    }

    /**
     * To open Masechet Nida (by click the button)
     * @param view - the button that been clicked
     */
    public void openTaharot(View view) {
        ProgramMethods.openActivity(this, "nidaFile", 73,
                        10, 37, false, R.id.goToNida);
    }

    /**
     * To check / uncheck the current page of the day (by click the button)
     * @param view - the button that been clicked
     */
    public void saveCurr(View view) {
        mark();
    }

    /**
     * Help method to check / uncheck the current page of the day
     */
    private void mark() {
        SharedPreferences SP = getApplicationContext()
                .getSharedPreferences(this.nameOfCurrMashechet[1], Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = SP.edit();
        // to check the page
        if (SP.getBoolean(this.nameOfCurrMashechet[3], false)) {
            editor.putBoolean(String.valueOf(this.nameOfCurrMashechet[3]), false);
            this.checkImgbtn.setVisibility(View.VISIBLE);
            this.uncheckImgbtn.setVisibility(View.GONE);
            Toast.makeText(this, "בוטל הסימון מהדף", Toast.LENGTH_LONG).show();
        }
        else {          // uncheck the page
            editor.putBoolean(String.valueOf(this.nameOfCurrMashechet[3]), true);
            this.checkImgbtn.setVisibility(View.GONE);
            this.uncheckImgbtn.setVisibility(View.VISIBLE);
            Toast.makeText(this, "הדף סומן כנלמד בהצלחה!", Toast.LENGTH_LONG).show();
        }
        editor.apply();
    }

    /**
     * To open the link of the current page (by click the button)
     * @param view - the button that been clicked
     */
    public void openLink(View view) {
        ProgramMethods.openLink(this, this.link);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // To save the start day of the learning the Shas
        Calendar startDate = Calendar.getInstance();
        startDate.set(2020, Calendar.JANUARY, 5, 0, 0);

        TextView pageDate = findViewById(R.id.currPageText);

        // calculate the def from the beginning
        Date start = startDate.getTime();
        Date today = new Date();
        this.daysElapsed = ((today.getTime() - start.getTime()) / (24 * 60 * 60 * 1000) + 1) % 2711;

        SharedPreferences dafYomi = getApplicationContext().getSharedPreferences("dafYomi", Context.MODE_PRIVATE);
        this.nameOfCurrMashechet = dafYomi.getString(String.valueOf(this.daysElapsed), "").split("-");
        this.pages = new SparseArray<>();
        initSparseArray();

        // to show the current page
        int currPage = Integer.parseInt(this.nameOfCurrMashechet[3]);
        this.link = this.dafYomiURL[0] + this.nameOfCurrMashechet[0] + this.dafYomiURL[1] + currPage + this.dafYomiURL[2];
        String txt = "הדף היומי הוא:\n" + this.nameOfCurrMashechet[2] + " " + pages.get(currPage);
        pageDate.setText(txt);

        // the check / uncheck buttons
        this.checkImgbtn = findViewById(R.id.checkCurr);
        this.uncheckImgbtn = findViewById(R.id.unCheckCurr);
        SharedPreferences SP = getApplicationContext().getSharedPreferences(this.nameOfCurrMashechet[1], Context.MODE_PRIVATE);
        if (SP.getBoolean(this.nameOfCurrMashechet[3], false)) {
            this.checkImgbtn.setVisibility(View.GONE);
            this.uncheckImgbtn.setVisibility(View.VISIBLE);
        }
        else {
            this.checkImgbtn.setVisibility(View.VISIBLE);
            this.uncheckImgbtn.setVisibility(View.GONE);
        }

        detrmineStyleButtons();
    }


    /**
     * Method to determine the stle of each button in the UI
     */
    private void detrmineStyleButtons() {
        Button zraimBtn = findViewById(R.id.button1);
        Button moedBtn = findViewById(R.id.button2);
        Button nashimBtn = findViewById(R.id.button3);
        Button nezikinBtn = findViewById(R.id.button4);
        Button kodashimBtn = findViewById(R.id.button5);
        Button taharotBtn = findViewById(R.id.button6);

        ProgramMethods.styleOfButton(zraimBtn, ProgramMethods.sumPagesLearned(this.all.get(0))  , 63);
        ProgramMethods.styleOfButton(moedBtn, ProgramMethods.sumPagesLearned(this.all, 1, 13, true), 731);
        ProgramMethods.styleOfButton(nashimBtn, ProgramMethods.sumPagesLearned(this.all, 13,20, true), 605);
        ProgramMethods.styleOfButton(nezikinBtn, ProgramMethods.sumPagesLearned(this.all, 20,28, true), 682);
        ProgramMethods.styleOfButton(kodashimBtn,ProgramMethods.sumPagesLearned(this.all, 28,36, true) , 558);
        ProgramMethods.styleOfButton(taharotBtn, ProgramMethods.sumPagesLearned(this.all.get(36)),72);
    }

    /**
     * Help method to init the SparseArray with the numbers and the chars
     */
    private void initSparseArray() {
        this.pages.append(2, "ב");
        this.pages.append(3, "ג");
        this.pages.append(4, "ד");
        this.pages.append(5, "ה");
        this.pages.append(6, "ו");
        this.pages.append(7, "ז");
        this.pages.append(8, "ח");
        this.pages.append(9, "ט");
        this.pages.append(10, "י");
        this.pages.append(11, "יא");
        this.pages.append(12, "יב");
        this.pages.append(13, "יג");
        this.pages.append(14, "יד");
        this.pages.append(15, "טו");
        this.pages.append(16, "טז");
        this.pages.append(17, "יז");
        this.pages.append(18, "יח");
        this.pages.append(19, "יט");
        this.pages.append(20, "כ");
        this.pages.append(21, "כא");
        this.pages.append(22, "כב");
        this.pages.append(23, "כג");
        this.pages.append(24, "כד");
        this.pages.append(25, "כה");
        this.pages.append(26, "כו");
        this.pages.append(27, "כז");
        this.pages.append(28, "כח");
        this.pages.append(29, "כט");
        this.pages.append(30, "ל");
        this.pages.append(31, "לא");
        this.pages.append(32, "לב");
        this.pages.append(33, "לג");
        this.pages.append(34, "לד");
        this.pages.append(35, "לה");
        this.pages.append(36, "לו");
        this.pages.append(37, "לז");
        this.pages.append(38, "לח");
        this.pages.append(39, "לט");
        this.pages.append(40, "מ");
        this.pages.append(41, "מא");
        this.pages.append(42, "מב");
        this.pages.append(43, "מג");
        this.pages.append(44, "מד");
        this.pages.append(45, "מה");
        this.pages.append(46, "מו");
        this.pages.append(47, "מז");
        this.pages.append(48, "מח");
        this.pages.append(49, "מט");
        this.pages.append(50, "נ");
        this.pages.append(51, "נא");
        this.pages.append(52, "נב");
        this.pages.append(53, "נג");
        this.pages.append(54, "נד");
        this.pages.append(55, "נה");
        this.pages.append(56, "נו");
        this.pages.append(57, "נז");
        this.pages.append(58, "נח");
        this.pages.append(59, "נט");
        this.pages.append(60, "ס");
        this.pages.append(61, "סא");
        this.pages.append(62, "סב");
        this.pages.append(63, "סג");
        this.pages.append(64, "סד");
        this.pages.append(65, "סה");
        this.pages.append(66, "סו");
        this.pages.append(67, "סז");
        this.pages.append(68, "סח");
        this.pages.append(69, "סט");
        this.pages.append(70, "ע");
        this.pages.append(71, "עא");
        this.pages.append(72, "עב");
        this.pages.append(73, "עג");
        this.pages.append(74, "עד");
        this.pages.append(75, "עה");
        this.pages.append(76, "עו");
        this.pages.append(77, "עז");
        this.pages.append(78, "עח");
        this.pages.append(79, "עט");
        this.pages.append(80, "פ");
        this.pages.append(81, "פא");
        this.pages.append(82, "פב");
        this.pages.append(83, "פג");
        this.pages.append(84, "פד");
        this.pages.append(85, "פה");
        this.pages.append(86, "פו");
        this.pages.append(87, "פז");
        this.pages.append(88, "פח");
        this.pages.append(89, "פט");
        this.pages.append(90, "צ");
        this.pages.append(91, "צא");
        this.pages.append(92, "צב");
        this.pages.append(93, "צג");
        this.pages.append(94, "צד");
        this.pages.append(95, "צה");
        this.pages.append(96, "צו");
        this.pages.append(97, "צז");
        this.pages.append(98, "צח");
        this.pages.append(99, "צט");
        this.pages.append(100, "ק");
        this.pages.append(101, "קא");
        this.pages.append(102, "קב");
        this.pages.append(103, "קג");
        this.pages.append(104, "קד");
        this.pages.append(105, "קה");
        this.pages.append(106, "קו");
        this.pages.append(107, "קז");
        this.pages.append(108, "קח");
        this.pages.append(109, "קט");
        this.pages.append(110, "קי");
        this.pages.append(111, "קיא");
        this.pages.append(112, "קיב");
        this.pages.append(113, "קיג");
        this.pages.append(114, "קיד");
        this.pages.append(115, "קטו");
        this.pages.append(116, "קטז");
        this.pages.append(117, "קיז");
        this.pages.append(118, "קיח");
        this.pages.append(119, "קיט");
        this.pages.append(120, "קכ");
        this.pages.append(121, "קכא");
        this.pages.append(122, "קכב");
        this.pages.append(123, "קכג");
        this.pages.append(124, "קכד");
        this.pages.append(125, "קכה");
        this.pages.append(126, "קכו");
        this.pages.append(127, "קכז");
        this.pages.append(128, "קכח");
        this.pages.append(129, "קכט");
        this.pages.append(130, "קל");
        this.pages.append(131, "קלא");
        this.pages.append(132, "קלב");
        this.pages.append(133, "קלג");
        this.pages.append(134, "קלד");
        this.pages.append(135, "קלה");
        this.pages.append(136, "קלו");
        this.pages.append(137, "קלז");
        this.pages.append(138, "קלח");
        this.pages.append(139, "קלט");
        this.pages.append(140, "קמ");
        this.pages.append(141, "קמא");
        this.pages.append(142, "קמב");
        this.pages.append(143, "קמג");
        this.pages.append(144, "קמד");
        this.pages.append(145, "קמה");
        this.pages.append(146, "קמו");
        this.pages.append(147, "קמז");
        this.pages.append(148, "קמח");
        this.pages.append(149, "קמט");
        this.pages.append(150, "קנ");
        this.pages.append(151, "קנא");
        this.pages.append(152, "קנב");
        this.pages.append(153, "קנג");
        this.pages.append(154, "קנד");
        this.pages.append(155, "קנה");
        this.pages.append(156, "קנו");
        this.pages.append(157, "קנז");
        this.pages.append(158, "קנח");
        this.pages.append(159, "קנט");
        this.pages.append(160, "קס");
        this.pages.append(161, "קסא");
        this.pages.append(162, "קסב");
        this.pages.append(163, "קסג");
        this.pages.append(164, "קסד");
        this.pages.append(165, "קסה");
        this.pages.append(166, "קסו");
        this.pages.append(167, "קסז");
        this.pages.append(168, "קסח");
        this.pages.append(169, "קסט");
        this.pages.append(170, "קע");
        this.pages.append(171, "קעא");
        this.pages.append(172, "קעב");
        this.pages.append(173, "קעג");
        this.pages.append(174, "קעד");
        this.pages.append(175, "קעה");
        this.pages.append(176, "קעו");
    }
}