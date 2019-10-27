package com.mja;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class XlsTool {

    private HSSFWorkbook workbook = null;
    private HSSFSheet hssfSheet;
    private String xlsPath;
    private int sheetNumber;
    private List<SingleRow> rowList = new ArrayList<>();

    public XlsTool(String xlsPath, int sheetNumber) {
        this.xlsPath = xlsPath;
        this.sheetNumber = sheetNumber;
        readXls();
    }

    public List<SingleRow> getRowList() {
        return rowList;
    }

    //create workbook (HSSF) using existing XLS file
    private void readXls() {

        try {
            InputStream inputStream = new FileInputStream(xlsPath);
            workbook = new HSSFWorkbook(inputStream);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        hssfSheet = workbook.getSheetAt(sheetNumber);
    }

    //find cell with the text
    public HSSFCell findCell(String findingText) {
        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            for (int cellNum = 0; cellNum <= hssfSheet.getRow(rowNum).getLastCellNum(); cellNum++) {
                HSSFCell tempCell = hssfSheet.getRow(rowNum).getCell(cellNum);
                if (findingText.equals(tempCell.toString())) {
                    return tempCell;
                }
            }
        }
        return null;
    }

    // create List with rows
    public void makeDataModel(){
        for (int rowNum = 8; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            rowList.add(makeRow(rowNum));
        }
    }

    // create single row using data in workbook
    private SingleRow makeRow(int rowNumber) {
        Long id = (long)hssfSheet.getRow(rowNumber).getCell(0).getNumericCellValue();
        String state = hssfSheet.getRow(rowNumber).getCell(1).getStringCellValue();
        String areaName = hssfSheet.getRow(rowNumber).getCell(2).getStringCellValue();
        Long civilianLaborForce = (long)hssfSheet.getRow(rowNumber).getCell(6).getNumericCellValue();
        Long employed = (long)hssfSheet.getRow(rowNumber).getCell(7).getNumericCellValue();
        Long unemployed = (long)hssfSheet.getRow(rowNumber).getCell(8).getNumericCellValue();
        SingleRow row = new SingleRow(id, state, areaName, civilianLaborForce, employed, unemployed);
        return row;
    }

    // sort List using specific data
    public void sortRowList(Comparator<SingleRow> comparator) {
        Collections.sort(rowList, comparator);
    }

    // print List in a console
    public void printDataModel() {
        for (SingleRow singleRow : rowList) {
            System.out.println(singleRow.toString());
        }
    }

}
