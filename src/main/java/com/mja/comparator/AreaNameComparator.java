package com.mja.comparator;

import com.mja.SingleRow;

import java.util.Comparator;

public class AreaNameComparator implements Comparator<SingleRow> {

    @Override
    public int compare(SingleRow row1, SingleRow row2) {

        return row1.getAreaName().compareTo(row2.getAreaName());
    }
}
