package com.mja.comparator;

import com.mja.SingleRow;

import java.util.Comparator;

public class IdComparator implements Comparator<SingleRow> {

    @Override
    public int compare(SingleRow row1, SingleRow row2) {

        return row1.getId().compareTo(row2.getId());
    }
}
