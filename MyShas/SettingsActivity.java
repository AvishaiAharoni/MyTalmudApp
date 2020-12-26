package com.avishai.MyShas;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * An Activity to manage the settings of the application
 */
public class SettingsActivity extends AppCompatActivity {
    private SharedPreferences set;
    private Switch switchNotif;
    private TextView txtShowNotif;
    private TextView dayWeekTxt;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView txtDayOfTheWeek;
    private Spinner listWeek;
    private TextView txtHour;
    private EditText editTextTimer;
    private TextView labelMessage;
    private TextView txtMessage;
    private String messageText;
    private EditText customMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        // The custom Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView name = toolbar.findViewById(R.id.headText);
        name.setText(R.string.settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.set = getApplicationContext().getSharedPreferences("setFile", Context.MODE_PRIVATE);

        // all the UI
        this.txtShowNotif = findViewById(R.id.txtShowNotif);
        this.switchNotif = findViewById(R.id.switchNotif);
        this.dayWeekTxt = findViewById(R.id.txtDayOrWeek);
        this.radioGroup = findViewById(R.id.radioGroup);
        this.txtDayOfTheWeek = findViewById(R.id.txtDayOfTheWeek);
        this.txtHour = findViewById(R.id.txtHour);
        this.labelMessage = findViewById(R.id.labelMessage);
        this.txtMessage = findViewById(R.id.txtMessage);
        this.listWeek = findViewById(R.id.listWeek);
        this.editTextTimer = findViewById(R.id.editTextTime);

        /* the first switch */
        this.switchNotif.setChecked(this.set.getBoolean("showNotif", true));

        /* the day list */
        this.listWeek.setSelection(this.set.getInt("dayOfWeek", 5));

        /* the type of the notification (weekly - 0, daily - 1, once - 2) */
        int id = this.set.getInt("typeNotification", 2);
        this.radioGroup.check(this.radioGroup.getChildAt(id).getId());
        this.radioButton = findViewById(this.radioGroup.getCheckedRadioButtonId());

        checkEnableForAll();

        this.switchNotif.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkEnableForAll();
            }
        });

        this.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = group.findViewById(checkedId);

                checkEnableForDayWeek();
            }
        });

        manageTimePicker();

        manageCustomMessage();
    }

    /**
     * Help method to manage the TimePicker dialog
     */
    private void manageTimePicker() {
        this.editTextTimer.setInputType(InputType.TYPE_NULL);
        this.editTextTimer.setFocusable(false);
        this.editTextTimer.setText(this.set.getString("time", "21:30"));

        this.editTextTimer.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    listenerForEditTimer();
                }
            }
        });

        this.editTextTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerForEditTimer();
            }
        });
    }

    /**
     * Help method to manage the message to show in the notification
     */
    private void manageCustomMessage() {
        /* the message to show */
        this.messageText = this.set.getString("message", "לא לשכוח ללמוד דף יומי");
        this.txtMessage.setText(this.messageText);

        this.customMessage = new EditText(this);

        this.txtMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lisenerForMessage();
            }
        });

        this.labelMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lisenerForMessage();
            }
        });
    }

    /**
     * Method to inflate the settings menu
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_settings, menu);

        return true;
    }

    /**
     * Method to to determine what happened at click on item in the menu
     * @param item - the item that been clicked
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.asPdf:
                setFormat("pdf");
                break;
            case R.id.asText:
                setFormat("text");
                break;
            case R.id.home:
                home();
                break;
            case R.id.save:
                save();
                break;
            case R.id.about :
                ProgramMethods.about(this);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Method to set the format of the link to show
     * @param format - the requested format
     */
    private void setFormat(String format) {
        this.set = getApplicationContext().getSharedPreferences("setFile", Context.MODE_PRIVATE);

        Editor editor = set.edit();
        editor.putString("format", format);
        editor.apply();

        Toast.makeText(this, "עדכון התצוגה נשמר בהצלחה", Toast.LENGTH_LONG).show();
    }

    /**
     * Method to manage the dialog message
     */
    private void lisenerForMessage() {
        AlertDialog.Builder alert = new AlertDialog.Builder(SettingsActivity.this);

        /* for the second time that the txtMessage is been clicked */
        if (customMessage.getParent()!=null) {
            ((ViewGroup) customMessage.getParent()).removeView(customMessage);
        }

        /* to set the past message to the dialod alert */
        if (!txtMessage.getText().toString().equals("לא הוגדרה התראה")) {
            customMessage.setText(txtMessage.getText());
            customMessage.setSelection(customMessage.getText().length());
        }
        alert.setTitle("טקסט להתראה")
                .setView(customMessage)
                .setPositiveButton("אישור", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        messageText = customMessage.getText().toString().trim();
                        if (customMessage.getText().toString().equals("")) {
                            messageText = "לא הוגדרה התראה";
                        }
                        txtMessage.setText(messageText);
                    }
                }).setNegativeButton("ביטול", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                txtMessage.setText(messageText);
                dialog.cancel();
            }
        }).show();
    }

    /**
     * Method to manage the listener of the Time dialog
     */
    private void listenerForEditTimer() {
        String[] timeToShow = {"21", "30"};

        /* to determine the time to show in the Time dialog */
        if (!this.editTextTimer.getText().toString().equals("")) {
            timeToShow = this.editTextTimer.getText().toString().split(":");
        }
        int hour = Integer.parseInt(timeToShow[0]);
        int minutes = Integer.parseInt(timeToShow[1]);

        // time picker dialog
        TimePickerDialog picker = new TimePickerDialog(SettingsActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                        String time;
                        time = sMinute > 9 ? sHour + ":" + sMinute : sHour + ":0" + sMinute;
                        editTextTimer.setText(time);
                    }
                }, hour, minutes, true);
        picker.show();
    }

    /**
     * Help method to determine whether all the UI that related to the week should be enabled / disabled
     */
    private void checkEnableForDayWeek() {
        switch ((String) this.radioButton.getTag()) {
            case "0":                         // week
            case "2":                         // once
                enableDisableWeek(true);
                break;
            case "1":                         // day
                enableDisableWeek(false);
                break;
        }
    }

    /**
     * Help method to determine whether all the UI should be enabled / disabled
     */
    private void checkEnableForAll() {
        if (this.switchNotif.isChecked()) {
            enableDisableAll(true);
            checkEnableForDayWeek();
        }
        else {
            enableDisableAll(false);
        }
    }

    /**
     * Method to enabled/ disable al the UI
     * @param shouldEnabled - to determine whether all the UI should be enabled / disabled
     */
    private void enableDisableAll(boolean shouldEnabled) {
        this.txtShowNotif.setEnabled(shouldEnabled);
        for (int i = 0; i < this.radioGroup.getChildCount(); ++i) {
            radioGroup.getChildAt(i).setEnabled(shouldEnabled);
        }
        this.dayWeekTxt.setEnabled(shouldEnabled);
        this.txtHour.setEnabled(shouldEnabled);
        this.labelMessage.setEnabled(shouldEnabled);
        this.txtMessage.setEnabled(shouldEnabled);
        this.editTextTimer.setEnabled(shouldEnabled);

        enableDisableWeek(shouldEnabled);
    }

    /**
     * Help method to enable / disable all the UI that related to the week
     * @param shouldEnabled - to determine whether all the UI should be enabled / disabled
     */
    private void enableDisableWeek(boolean shouldEnabled) {
        this.txtDayOfTheWeek.setEnabled(shouldEnabled);
        this.listWeek.setEnabled(shouldEnabled);
    }

    /**
     * to manage the "home" button
     * @param view - the button that clicked
     */
    public void Home(View view) {
        home();
    }

    /**
     * to manage the "home" button
     */
    private void home() {
        disableButtonns();

        ProgramMethods.manageHome(this, "שינוי התזכורות לא נשמר");
    }

    /**
     * Method to disable the "home" and "save" buttons after the user clicked on one of them
     */
    private void disableButtonns() {
        ImageButton home = findViewById(R.id.homeWithoutSave);
        home.setEnabled(false);
        ImageButton save = findViewById((R.id.saveChanges));
        save.setEnabled(false);
    }

    /**
     * to manage the "save" button
     * @param view - the button that clicked
     */
    public void Save(View view) {
        save();
    }

    /**
     * to manage the "save" button
     */
    private void save() {
        disableButtonns();

        int typeNotification = Integer.parseInt((String) this.radioButton.getTag());
        boolean runOnce;

        /* insert all the settings for next use */
        Editor editor = this.set.edit();

        editor.putBoolean("showNotif", this.switchNotif.isChecked());
        editor.putString("message", this.txtMessage.getText().toString());
        editor.putInt("dayOfWeek", this.listWeek.getSelectedItemPosition());
        editor.putInt("typeNotification", typeNotification);
        editor.putString("time", this.editTextTimer.getText().toString());

        if (typeNotification == 2) {                    // once
            editor.putBoolean("runOnce", true);
            runOnce = true;
        }
        else {
            editor.putBoolean("runOnce", false);
            runOnce = false;
        }

        editor.apply();

        /* to cancel any previous notification */
        ProgramMethods.cancelNotification(getApplicationContext(), 120);
        ProgramMethods.cancelNotification(getApplicationContext(), 121);

        /* to create the notification */
        if (this.switchNotif.isChecked()) {
            ProgramMethods.createNotificationAtTime(getApplicationContext(), this.editTextTimer.getText().toString().split(":"),
                    (String) this.radioButton.getTag(), this.listWeek.getSelectedItemPosition(), runOnce);
        }

        ProgramMethods.manageHome(this, "השינויים נשמרו בהצלחה!");
    }
}