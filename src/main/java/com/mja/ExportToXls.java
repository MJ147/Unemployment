package com.mja;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportToXls {
    private Workbook workbook = new HSSFWorkbook();
    private Sheet sheet = workbook.createSheet("Sheet");
    private String destinationPath;
    private List<SingleRow> rowList;


    public ExportToXls(String destinationPath, List<SingleRow> rowList) {
        this.destinationPath = destinationPath;
        this.rowList = rowList;
    }

    // create XLS file by converting: List -> HSSFWorkbook -> XLS
    public void createXls(){
        createRows();
        createCells();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(destinationPath);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // create empty rows in a sheet
    private void createRows() {
        for (int i = 0; i < rowList.size(); i++) {
            workbook.getSheet("Sheet").createRow(i);
        }
    }

    // fill rows with cells with data from rows in List
    private void createCells() {
        for (int i = 0; i < rowList.size() ; i++) {
            workbook.getSheet("Sheet").getRow(i).createCell(0).setCellValue(rowList.get(i).getId());
            workbook.getSheet("Sheet").getRow(i).createCell(1).setCellValue(rowList.get(i).getState());
            workbook.getSheet("Sheet").getRow(i).createCell(2).setCellValue(rowList.get(i).getAreaName());
            workbook.getSheet("Sheet").getRow(i).createCell(3).setCellValue(rowList.get(i).getCivilianLaborForce());
            workbook.getSheet("Sheet").getRow(i).createCell(4).setCellValue(rowList.get(i).getEmployed());
            workbook.getSheet("Sheet").getRow(i).createCell(5).setCellValue(rowList.get(i).getUnemployed());
        }
    }

}

