package com.avishai.MyShas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * A class that represent the bridge between the file of a Masechet and the UI
 */
public class MainAdapter extends BaseExpandableListAdapter {
    private Activity ac;
    private List<String> listGroup;
    private HashMap<String, List<String>> listItems;
    private HashMap<String, Boolean> stateOfPages;
    private int numOfPages;
    private String[] link;
    private ProgressBar progressBar;
    private TextView progressTxt;
    private Boolean hasLastPage;

    /**
     * A constructor to init the object
     * @param ac - the Activity that called the method
     * @param listGroup - the container of the chapters in the Masechet
     * @param listItems - the container of the pages in the Masechet
     * @param store - the file to get the values and update
     * @param numOfPages - the number of the pages in the given Masechet
     * @param stateOfPages - the state of the pages before saving
     * @param firstLoad - to determine if this is the first load of the Activity
     * @param numMasechet - the number of the Masechet
     * @param progressBar the UI progressbar
     * @param progressTxt - the text of the percent of the learned pages
     * @param hasLastPage - to determine if the Masechet has last page
     */
    MainAdapter(Activity ac, List<String> listGroup, HashMap<String, List<String>> listItems,
                Keystore store, int numOfPages, HashMap<String, Boolean> stateOfPages, Boolean firstLoad,
                int numMasechet, ProgressBar progressBar, TextView progressTxt, Boolean hasLastPage) {

        this.ac = ac;
        this.listGroup = listGroup;
        this.listItems = listItems;
        this.stateOfPages = stateOfPages;
        this.numOfPages = numOfPages;
        this.link = new String[]{"https://www.hebrewbooks.org/shas.aspx?mesechta=" + numMasechet + "&daf=", "&format="};
        this.progressBar = progressBar;
        this.progressTxt = progressTxt;
        this.hasLastPage = hasLastPage;

        // to save the states when inserting the activity (boot only on first reload)
        if (firstLoad) {
            for (int i = 2; i <= this.numOfPages; ++i) {
                this.stateOfPages.put(String.valueOf(i), store.getBool(String.valueOf(i)));
            }
        }
    }

    @Override
    public int getGroupCount() {
        return this.listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listItems.get(this.listGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listItems.get(this.listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {
        String group = (String) getGroup(groupPosition);

        // for click on group
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) this.ac.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.list_group, null);
        }

        TextView textView = convertView.findViewById(R.id.list_parent);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(group);

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild,
                             View convertView, ViewGroup viewGroup) {

        String child = (String) getChild(groupPosition, childPosition);

        // for click on child
        if (convertView == null) {
            LayoutInflater li = (LayoutInflater) this.ac.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.list_items, null);
        }

        final CheckedTextView textView = convertView.findViewById(R.id.list_child);
        // split the page to the name and the number
        final String[] page = child.split("-");
        // add the name
        textView.setText(page[0]);
        // check against the number whether to check or uncheck the page
        if (stateOfPages.get(page[1])) {
            textView.setCheckMarkDrawable(R.drawable.checked);
            textView.setChecked(true);
        }
        else {
            textView.setCheckMarkDrawable(R.drawable.unchecked);
            textView.setChecked(false);
        }

        // to create a listener to handle click on the page
        textView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if (textView.isChecked()) {
                    textView.setCheckMarkDrawable(R.drawable.unchecked);
                    textView.setChecked(false);
                    stateOfPages.put(page[1], false);
                } else {
                    textView.setCheckMarkDrawable(R.drawable.checked);
                    textView.setChecked(true);
                    stateOfPages.put(page[1], true);
                }

                ProgramMethods.determineProgress(progressBar, stateOfPages, numOfPages, progressTxt);
            }
        });

        // the link for page a
        TextView txtBtn = convertView.findViewById(R.id.txtButton);
        txtBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.link_exlv, 0, 0, 0);
        txtBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                ProgramMethods.openLink(ac, link[0] + page[1] + link[1]);
            }
        });

        // the link to page b (if there is one)
        TextView txtBtnB = convertView.findViewById(R.id.txtButtonB);
        if (this.numOfPages == Integer.valueOf(page[1]) && !this.hasLastPage) {
            txtBtnB.setCompoundDrawablesWithIntrinsicBounds(R.drawable.unchecked, 0, 0, 0);
        }
        else {
            txtBtnB.setCompoundDrawablesWithIntrinsicBounds(R.drawable.link_exlv, 0, 0, 0);
            txtBtnB.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    ProgramMethods.openLink(ac, link[0] + page[1] + "b" + link[1]);
                }
            });
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    /**
     * Method to get the first page in the group
     * @param groupPosition - the given group
     * @return - the first page
     */
    int getNumOfFirstChild(int groupPosition) {
        return Integer.parseInt(this.listItems.get(this.listGroup.get(groupPosition)).get(0).split("-")[1]);
    }

    /**
     * Method to get the last page in the group
     * @param groupPosition - the given group
     * @return - the last page
     */
    int getNumOfLastChild(int groupPosition) {
       return Integer.parseInt(this.listItems.get(this.listGroup.get(groupPosition))
                                    .get(this.getChildrenCount(groupPosition)-1).split("-")[1]);
    }
}