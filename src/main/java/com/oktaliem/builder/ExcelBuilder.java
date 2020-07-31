package com.oktaliem.builder;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelBuilder {

    private File spreadsheet;
    private Sheet currentSheet;
    private Map<String, Integer> columns;

    public ExcelBuilder(File file) {
        spreadsheet = file;
        columns = new HashMap();
    }
    public ExcelBuilder(){}

    public void switchToSheet(String name) throws IOException, InvalidFormatException {
        Workbook workbooks = new XSSFWorkbook(spreadsheet);
        try {
            currentSheet = workbooks.getSheet(name);
            for (Cell cell : currentSheet.getRow(0)) {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellData(String column, int row) {
        Row dataRow = currentSheet.getRow(row);
        return getCellDataAsString(dataRow.getCell(columns.get(column)));
    }

    private String getCellDataAsString(Cell cell) {
        String data = null;
        switch (cell.getCellType()) {
            case STRING:
                data = cell.getStringCellValue();
                break;
            case NUMERIC:
                data = String.valueOf((int) cell.getNumericCellValue());
                break;
        }
        return data;
    }

    public void createExcelFile(String fileName, Object[][] cars) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Cars in Java");
        int rowNum = 0;
        System.out.println("Creating excel");
        for (Object[] datatype : cars) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}
