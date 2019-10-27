package com.mja.comparator;

import com.mja.SingleRow;

import java.util.Comparator;

public class CivilianLaborForceComparator implements Comparator<SingleRow> {

    @Override
    public int compare(SingleRow row1, SingleRow row2) {

        return row1.getCivilianLaborForce().compareTo(row2.getCivilianLaborForce());
    }
}
