package com.oktaliem.builder;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
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
            case FORMULA:
        }
        return data;
    }

}
