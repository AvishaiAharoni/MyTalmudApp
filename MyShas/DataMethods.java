package com.avishai.MyShas;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Help class with methods of the data
 */
class DataMethods {
    /**
     * To sum how much pages learned (or not) from a given masechet.
     * The calculate is from the copy of the state (before saving it)
     * @param stateOfPages  - copy of the state (before saving)
     * @param learned - determine if the calculation if for pages that learned or not
     * @return the sum of the pages
     */
    static int sumPagesLearn(HashMap<String, Boolean> stateOfPages, Boolean learned) {
        int res = 0;

        for (Boolean entry : stateOfPages.values()) {
            if (entry == learned) {
                ++res;
            }
        }

        return res;
    }

    /**
     * To check / uncheck all pages in range of srartPage and endPage (include) to be the same (learned or not)
     * @param startPage - the first page to check
     * @param endPage - the last page to check
     * @param stateOfPages  - copy of the state (before saving)
     * @return true if all the pages was checked and false for uncheck
     */
    static boolean checkAllPages(int startPage, int endPage, HashMap<String, Boolean> stateOfPages) {
        for (int currPage = startPage; currPage<= endPage; ++currPage) {
            Boolean val = stateOfPages.get(String.valueOf(currPage));
            if (!val) {                                                          // there is a page that didn't be learned
                DataMethods.checkPages(startPage, endPage, stateOfPages, true);

                return true;
            }
        }

        DataMethods.checkPages(startPage, endPage, stateOfPages, false);        // all pages learned

        return false;
    }

    /**
     * Help method to check / uncheck all pages in range of srartPage and endPage (include) to be the same (learned or not)
     * @param startPage - the first page to check
     * @param endPage - the last page to check
     * @param stateOfPages  - copy of the state (before saving)
     * @param shouldCheck  - to determine between check / unceck the pages
     */
    private static void checkPages(int startPage, int endPage, HashMap<String, Boolean> stateOfPages, Boolean shouldCheck) {
        for (int currPage = startPage; currPage <= endPage; ++currPage) {
            stateOfPages.put(String.valueOf(currPage), shouldCheck);
        }
    }

    /**
     * To insert the pages of Brachot in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataBrachot(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.brachotChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.brachotChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.brachotChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.brachotChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.brachotChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.brachotChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.brachotChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.brachotChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.brachotChap9);
        Collections.addAll(list9, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Shabat in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataShabat(Activity ac, List<String> listGroup, MainAdapter adapter,
                                   HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));
        listGroup.add(ac.getString(R.string.Chap11));
        listGroup.add(ac.getString(R.string.Chap12));
        listGroup.add(ac.getString(R.string.Chap13));
        listGroup.add(ac.getString(R.string.Chap14));
        listGroup.add(ac.getString(R.string.Chap15));
        listGroup.add(ac.getString(R.string.Chap16));
        listGroup.add(ac.getString(R.string.Chap17));
        listGroup.add(ac.getString(R.string.Chap18));
        listGroup.add(ac.getString(R.string.Chap19));
        listGroup.add(ac.getString(R.string.Chap20));
        listGroup.add(ac.getString(R.string.Chap21));
        listGroup.add(ac.getString(R.string.Chap22));
        listGroup.add(ac.getString(R.string.Chap23));
        listGroup.add(ac.getString(R.string.Chap24));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap10);
        Collections.addAll(list10, array);

        List<String> list11 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap11);
        Collections.addAll(list11, array);

        List<String> list12 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap12);
        Collections.addAll(list12, array);

        List<String> list13 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap13);
        Collections.addAll(list13, array);

        List<String> list14 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap14);
        Collections.addAll(list14, array);

        List<String> list15 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap15);
        Collections.addAll(list15, array);

        List<String> list16 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap16);
        Collections.addAll(list16, array);

        List<String> list17 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap17);
        Collections.addAll(list17, array);

        List<String> list18 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap18);
        Collections.addAll(list18, array);

        List<String> list19 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap19);
        Collections.addAll(list19, array);

        List<String> list20 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap20);
        Collections.addAll(list20, array);

        List<String> list21 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap21);
        Collections.addAll(list21, array);

        List<String> list22 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap22);
        Collections.addAll(list22, array);

        List<String> list23 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap23);
        Collections.addAll(list23, array);

        List<String> list24 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shabatChap24);
        Collections.addAll(list24, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);
        listItems.put(listGroup.get(10), list11);
        listItems.put(listGroup.get(11), list12);
        listItems.put(listGroup.get(12), list13);
        listItems.put(listGroup.get(13), list14);
        listItems.put(listGroup.get(14), list15);
        listItems.put(listGroup.get(15), list16);
        listItems.put(listGroup.get(16), list17);
        listItems.put(listGroup.get(17), list18);
        listItems.put(listGroup.get(18), list19);
        listItems.put(listGroup.get(19), list20);
        listItems.put(listGroup.get(20), list21);
        listItems.put(listGroup.get(21), list22);
        listItems.put(listGroup.get(22), list23);
        listItems.put(listGroup.get(23), list24);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Eruvin in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataEruvin(Activity ac, List<String> listGroup, MainAdapter adapter,
                                   HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.eruvinChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.eruvinChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.eruvinChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.eruvinChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.eruvinChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.eruvinChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.eruvinChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.eruvinChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.eruvinChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.eruvinChap10);
        Collections.addAll(list10, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Psachim in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataPsachim(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.psachimChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.psachimChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.psachimChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.psachimChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.psachimChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.psachimChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.psachimChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.psachimChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.psachimChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.psachimChap10);
        Collections.addAll(list10, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Shkalim in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataShkalim(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shkalimChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shkalimChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shkalimChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shkalimChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shkalimChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shkalimChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shkalimChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shkalimChap8);
        Collections.addAll(list8, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Yoma in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataYoma(Activity ac, List<String> listGroup, MainAdapter adapter,
                                 HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yomaChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yomaChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yomaChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yomaChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yomaChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yomaChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yomaChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yomaChap8);
        Collections.addAll(list8, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Rosh Hashana in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataRoshHashana(Activity ac, List<String> listGroup, MainAdapter adapter,
                                        HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.roshHashanaChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.roshHashanaChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.roshHashanaChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.roshHashanaChap4);
        Collections.addAll(list4, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Suka in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataSuka(Activity ac, List<String> listGroup, MainAdapter adapter,
                                 HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sukaChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sukaChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sukaChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sukaChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sukaChap5);
        Collections.addAll(list5, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Beitza in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataBeitza(Activity ac, List<String> listGroup, MainAdapter adapter,
                                   HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.beitzaChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.beitzaChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.beitzaChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.beitzaChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.beitzaChap5);
        Collections.addAll(list5, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Taanit in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataTaanit(Activity ac, List<String> listGroup, MainAdapter adapter,
                                   HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.taanitChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.taanitChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.taanitChap3);
        Collections.addAll(list3, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Megila in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataMegila(Activity ac, List<String> listGroup, MainAdapter adapter,
                                   HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.megilaChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.megilaChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.megilaChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.megilaChap4);
        Collections.addAll(list4, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Mped Katan in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataMoedKatan(Activity ac, List<String> listGroup, MainAdapter adapter,
                                      HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.moedKatanChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.moedKatanChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.moedKatanChap3);
        Collections.addAll(list3, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Hagiga in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataHagiga(Activity ac, List<String> listGroup, MainAdapter adapter,
                                   HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.hagigaChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.hagigaChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.hagigaChap3);
        Collections.addAll(list3, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Yevamot in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataYevamot(Activity ac, List<String> listGroup, MainAdapter adapter,
                                   HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));
        listGroup.add(ac.getString(R.string.Chap11));
        listGroup.add(ac.getString(R.string.Chap12));
        listGroup.add(ac.getString(R.string.Chap13));
        listGroup.add(ac.getString(R.string.Chap14));
        listGroup.add(ac.getString(R.string.Chap15));
        listGroup.add(ac.getString(R.string.Chap16));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap10);
        Collections.addAll(list10, array);

        List<String> list11 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap11);
        Collections.addAll(list11, array);

        List<String> list12 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap12);
        Collections.addAll(list12, array);

        List<String> list13 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap13);
        Collections.addAll(list13, array);

        List<String> list14 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap14);
        Collections.addAll(list14, array);

        List<String> list15 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap15);
        Collections.addAll(list15, array);

        List<String> list16 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.yevamotChap16);
        Collections.addAll(list16, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);
        listItems.put(listGroup.get(10), list11);
        listItems.put(listGroup.get(11), list12);
        listItems.put(listGroup.get(12), list13);
        listItems.put(listGroup.get(13), list14);
        listItems.put(listGroup.get(14), list15);
        listItems.put(listGroup.get(15), list16);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Ktubot in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataKtubot(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));
        listGroup.add(ac.getString(R.string.Chap11));
        listGroup.add(ac.getString(R.string.Chap12));
        listGroup.add(ac.getString(R.string.Chap13));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap10);
        Collections.addAll(list10, array);

        List<String> list11 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap11);
        Collections.addAll(list11, array);

        List<String> list12 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap12);
        Collections.addAll(list12, array);

        List<String> list13 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.ktubotChap13);
        Collections.addAll(list13, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);
        listItems.put(listGroup.get(10), list11);
        listItems.put(listGroup.get(11), list12);
        listItems.put(listGroup.get(12), list13);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Nedarim in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataNedarim(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));
        listGroup.add(ac.getString(R.string.Chap11));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nedarimChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nedarimChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nedarimChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nedarimChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nedarimChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nedarimChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nedarimChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nedarimChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nedarimChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nedarimChap10);
        Collections.addAll(list10, array);

        List<String> list11 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nedarimChap11);
        Collections.addAll(list11, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);
        listItems.put(listGroup.get(10), list11);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Nazir in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataNazir(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nazirChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nazirChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nazirChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nazirChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nazirChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nazirChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nazirChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nazirChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nazirChap9);
        Collections.addAll(list9, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Sota in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataSota(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sotaChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sotaChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sotaChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sotaChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sotaChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sotaChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sotaChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sotaChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sotaChap9);
        Collections.addAll(list9, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Gitin in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataGitin(Activity ac, List<String> listGroup, MainAdapter adapter,
                                  HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.gitinChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.gitinChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.gitinChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.gitinChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.gitinChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.gitinChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.gitinChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.gitinChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.gitinChap9);
        Collections.addAll(list9, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Kidushin in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataKidushin(Activity ac, List<String> listGroup, MainAdapter adapter,
                                   HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.kidushinChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.kidushinChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.kidushinChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.kidushinChap4);
        Collections.addAll(list4, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Baba Kama in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataBabaKama(Activity ac, List<String> listGroup, MainAdapter adapter,
                                 HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaKamaChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaKamaChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaKamaChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaKamaChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaKamaChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaKamaChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaKamaChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaKamaChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaKamaChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaKamaChap10);
        Collections.addAll(list10, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Baba Metzia in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataBabaMetzia(Activity ac, List<String> listGroup, MainAdapter adapter,
                                 HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaMetziaChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaMetziaChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaMetziaChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaMetziaChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaMetziaChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaMetziaChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaMetziaChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaMetziaChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaMetziaChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaMetziaChap10);
        Collections.addAll(list10, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Baba Batra in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataBabaBatra(Activity ac, List<String> listGroup, MainAdapter adapter,
                                 HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaBatraChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaBatraChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaBatraChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaBatraChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaBatraChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaBatraChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaBatraChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaBatraChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaBatraChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.babaBatraChap10);
        Collections.addAll(list10, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Sanhedrin in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataSanhedrin(Activity ac, List<String> listGroup, MainAdapter adapter,
                                 HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));
        listGroup.add(ac.getString(R.string.Chap11));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sanhedrinChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sanhedrinChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sanhedrinChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sanhedrinChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sanhedrinChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sanhedrinChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sanhedrinChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sanhedrinChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sanhedrinChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sanhedrinChap10);
        Collections.addAll(list10, array);

        List<String> list11 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.sanhedrinChap11);
        Collections.addAll(list11, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);
        listItems.put(listGroup.get(10), list11);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Makot in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataMakot(Activity ac, List<String> listGroup, MainAdapter adapter,
                                   HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.makotChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.makotChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.makotChap3);
        Collections.addAll(list3, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Shvuot in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataShvuot(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shvuotChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shvuotChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shvuotChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shvuotChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shvuotChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shvuotChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shvuotChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.shvuotChap8);
        Collections.addAll(list8, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Avoda Zara in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataAvodaZara(Activity ac, List<String> listGroup, MainAdapter adapter,
                                   HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.avodaZaraChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.avodaZaraChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.avodaZaraChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.avodaZaraChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.avodaZaraChap5);
        Collections.addAll(list5, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Horayot in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataHorayot(Activity ac, List<String> listGroup, MainAdapter adapter,
                                   HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.horayotChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.horayotChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.horayotChap3);
        Collections.addAll(list3, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Zvachim in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataZvachim(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));
        listGroup.add(ac.getString(R.string.Chap11));
        listGroup.add(ac.getString(R.string.Chap12));
        listGroup.add(ac.getString(R.string.Chap13));
        listGroup.add(ac.getString(R.string.Chap14));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap10);
        Collections.addAll(list10, array);

        List<String> list11 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap11);
        Collections.addAll(list11, array);

        List<String> list12 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap12);
        Collections.addAll(list12, array);

        List<String> list13 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap13);
        Collections.addAll(list13, array);

        List<String> list14 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.zvachimChap14);
        Collections.addAll(list14, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);
        listItems.put(listGroup.get(10), list11);
        listItems.put(listGroup.get(11), list12);
        listItems.put(listGroup.get(12), list13);
        listItems.put(listGroup.get(13), list14);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Menachot in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataMenachot(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));
        listGroup.add(ac.getString(R.string.Chap11));
        listGroup.add(ac.getString(R.string.Chap12));
        listGroup.add(ac.getString(R.string.Chap13));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap10);
        Collections.addAll(list10, array);

        List<String> list11 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap11);
        Collections.addAll(list11, array);

        List<String> list12 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap12);
        Collections.addAll(list12, array);

        List<String> list13 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.menachotChap13);
        Collections.addAll(list13, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);
        listItems.put(listGroup.get(10), list11);
        listItems.put(listGroup.get(11), list12);
        listItems.put(listGroup.get(12), list13);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Chulin in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataChulin(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));
        listGroup.add(ac.getString(R.string.Chap11));
        listGroup.add(ac.getString(R.string.Chap12));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap10);
        Collections.addAll(list10, array);

        List<String> list11 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap11);
        Collections.addAll(list11, array);

        List<String> list12 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.chulinChap12);
        Collections.addAll(list12, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);
        listItems.put(listGroup.get(10), list11);
        listItems.put(listGroup.get(11), list12);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Bechorot in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataBechorot(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.bechorotChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.bechorotChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.bechorotChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.bechorotChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.bechorotChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.bechorotChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.bechorotChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.bechorotChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.bechorotChap9);
        Collections.addAll(list9, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Arachin in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataArachin(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.arachinChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.arachinChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.arachinChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.arachinChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.arachinChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.arachinChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.arachinChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.arachinChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.arachinChap9);
        Collections.addAll(list9, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Tmura in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataTmura(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.tmuraChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.tmuraChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.tmuraChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.tmuraChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.tmuraChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.tmuraChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.tmuraChap7);
        Collections.addAll(list7, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Kritut in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataKritut(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.kritutChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.kritutChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.kritutChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.kritutChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.kritutChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.kritutChap6);
        Collections.addAll(list6, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Meila (and Kinim, Tamid, Midot) in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataMeila(Activity ac, List<String> listGroup, MainAdapter adapter,
                                    HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.kinimHead));
        listGroup.add(ac.getString(R.string.tamidHead));
        listGroup.add(ac.getString(R.string.midotHead));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.meilaChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.meilaChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.meilaChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.meilaChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.meilaChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.meilaChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.kinim);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.tamid);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.midot);
        Collections.addAll(list9, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);

        adapter.notifyDataSetChanged();
    }

    /**
     * To insert the pages of Nida in order of the chapters
     * @param ac - the activity
     * @param listGroup - the container of the chapters
     * @param adapter - the bridge between the app and the expandable list items
     * @param listItems - the container of the pages (in the chapters
     */
    static void initListDataNida(Activity ac, List<String> listGroup, MainAdapter adapter,
                                 HashMap<String, List<String>> listItems) {
        listGroup.add(ac.getString(R.string.Chap1));
        listGroup.add(ac.getString(R.string.Chap2));
        listGroup.add(ac.getString(R.string.Chap3));
        listGroup.add(ac.getString(R.string.Chap4));
        listGroup.add(ac.getString(R.string.Chap5));
        listGroup.add(ac.getString(R.string.Chap6));
        listGroup.add(ac.getString(R.string.Chap7));
        listGroup.add(ac.getString(R.string.Chap8));
        listGroup.add(ac.getString(R.string.Chap9));
        listGroup.add(ac.getString(R.string.Chap10));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nidaChap1);
        Collections.addAll(list1, array);

        List<String> list2 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nidaChap2);
        Collections.addAll(list2, array);

        List<String> list3 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nidaChap3);
        Collections.addAll(list3, array);

        List<String> list4 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nidaChap4);
        Collections.addAll(list4, array);

        List<String> list5 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nidaChap5);
        Collections.addAll(list5, array);

        List<String> list6 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nidaChap6);
        Collections.addAll(list6, array);

        List<String> list7 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nidaChap7);
        Collections.addAll(list7, array);

        List<String> list8 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nidaChap8);
        Collections.addAll(list8, array);

        List<String> list9 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nidaChap9);
        Collections.addAll(list9, array);

        List<String> list10 = new ArrayList<>();
        array = ac.getResources().getStringArray(R.array.nidaChap10);
        Collections.addAll(list10, array);

        listItems.put(listGroup.get(0), list1);
        listItems.put(listGroup.get(1), list2);
        listItems.put(listGroup.get(2), list3);
        listItems.put(listGroup.get(3), list4);
        listItems.put(listGroup.get(4), list5);
        listItems.put(listGroup.get(5), list6);
        listItems.put(listGroup.get(6), list7);
        listItems.put(listGroup.get(7), list8);
        listItems.put(listGroup.get(8), list9);
        listItems.put(listGroup.get(9), list10);

        adapter.notifyDataSetChanged();
    }
}