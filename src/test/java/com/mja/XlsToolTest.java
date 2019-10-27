package com.mja;

import com.mja.comparator.EmployedComparator;

public class XlsToolTest {

    public static void main(String[] args) {

        XlsTool xlsToolTest = new XlsTool("src\\main\\resources\\Unemployment.xls",0);
        xlsToolTest.makeDataModel();
        xlsToolTest.sortRowList(new EmployedComparator());
        xlsToolTest.printDataModel();

        ExportToXls exportToXls = new ExportToXls("src\\main\\resources\\Destination.xls",xlsToolTest.getRowList());
        exportToXls.createXls();

    }
}
