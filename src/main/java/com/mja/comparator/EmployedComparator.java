package com.mja.comparator;

import com.mja.SingleRow;

import java.util.Comparator;

public class EmployedComparator implements Comparator<SingleRow> {

    @Override
    public int compare(SingleRow row1, SingleRow row2) {

        return row1.getEmployed().compareTo(row2.getEmployed());
    }
}
