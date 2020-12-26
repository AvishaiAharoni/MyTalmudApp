package com.avishai.MyShas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.Map;
import java.util.Set;

/**
 * A class that represent a file object
 */
public class Keystore {
    private SharedPreferences SP;
    private String fileName;

    /**
     * A constructor to init the values
     * @param context - the context of the Activity that called the constructor
     * @param fileName - the name of the file
     * @param numOfPages - the number of the pages in the Masechet
     */
    Keystore(Context context, String fileName, int numOfPages) {
        this.fileName = fileName;
        this.SP = context.getApplicationContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);

        // to insert the pages at the first time
        if (!this.SP.contains("2")) {
            for (int i = 2; i <= numOfPages; ++i) {
                this.putBool(String.valueOf(i), false);
            }
        }
    }

    /**
     * Method to get the value for a given key
     * @param key - the key to get for it the value
     * @return - the boolean value
     */
    Boolean getBool(String key) {
        return this.SP.getBoolean(key, false);
    }

    /**
     * Method to put in the file given value for a given key
     * @param key - the key to put for it the value
     * @param bool - the boolean value to insert
     */
    final void putBool(String key, Boolean bool) {
        Editor editor = this.SP.edit();

        editor.putBoolean(key, bool);
        editor.apply();
    }

    /**
     * Method to clear the file (make all the pages as false)
     */
    void clear(){
        Editor editor = this.SP.edit();

        editor.clear();
        editor.apply();
    }

    /**
     * Method to remove the file
     */
    void remove(){
        Editor editor = this.SP.edit();

        editor.remove(this.fileName);
        editor.apply();
    }

    /**
     * Method to get the numbers of given group of values (true / false)
     * @param learned - to determine whether to check learned / not learned pages
     * @return the sum of the requested pages
     */
    int getNumOfGivenPages(Boolean learned) {
        int res = 0;

        Set<String> entry = this.SP.getAll().keySet();
        for (String curr : entry) {
            if (this.SP.getBoolean(curr, learned) == learned) {
               ++res;
            }
        }

        return res;
    }
}