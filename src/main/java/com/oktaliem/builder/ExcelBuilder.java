package com.oktaliem.builder;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ExcelBuilder {

    private File spreadsheet;
    private Sheet currentSheet;
    private Map<String, Integer> columns;
    private XSSFSheet ExcelWSheet;
    private static XSSFCell cell;
    private static XSSFRow row;

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

    public void setExcelFile(String Path, String SheetName) throws Exception {
            FileInputStream ExcelFile = new FileInputStream(Path);
            XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
    }

    public String getCellData(int RowNum, int ColNum) throws Exception {
            cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String cellData = cell.getStringCellValue();
            return cellData;
    }
}
