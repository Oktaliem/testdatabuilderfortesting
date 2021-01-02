package com.oktaliem.unittest;

import com.oktaliem.builder.ExcelBuilder;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.IOException;

import static com.oktaliem.constants.ConstantForPath.MAIN_RESOURCES_PATH;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExcelBuilderTest {
    String fileName = MAIN_RESOURCES_PATH + "SampleData.xlsx";

    @Test
    public void getExcelColumnAndRowFromExcelFile() throws IOException, InvalidFormatException {
        ExcelBuilder spreadsheet = new ExcelBuilder(new File(fileName));
        spreadsheet.switchToSheet("SalesOrders");
        Assert.assertEquals(spreadsheet.getCellData("Item", 3), "Pencil");
    }

    @Test
    public void writeDataToExcelFile() {
        String fileName = MAIN_RESOURCES_PATH + "WriteExcel.xlsx";
        Object[][] cars = {
                {"Car", "Type", "Total"},
                {"BMW", "Sedan", 2},
                {"KIA", "Sedan", 4},
                {"Honda", "Sedan", 8},
                {"Toyota", "Sedan", 1},
                {"Ferari", "Sedan", "No data"}
        };
        ExcelBuilder excel = new ExcelBuilder();
        excel.createExcelFile(fileName, cars);
    }

    @Test
    public void getValueBySetUpRowAncColumn() throws Exception {
        ExcelBuilder excel = new ExcelBuilder();
        excel.setExcelFile(fileName, "SalesOrders");
        Assert.assertEquals("Kivell", excel.getCellData(2, 2));
        System.out.println(excel.getCellData(2, 2));
    }

}
