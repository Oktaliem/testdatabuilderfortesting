package com.oktaliem;

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

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExcelBuilderTest {

    @Test
    public void getExcelRowsAndColumns() throws IOException, InvalidFormatException {
        String fileName = System.getProperty("user.dir") + "/src/main/resources/SampleData.xlsx";
        ExcelBuilder spreadsheet = new ExcelBuilder(new File(fileName));
        spreadsheet.switchToSheet("SalesOrders");
        Assert.assertEquals(spreadsheet.getCellData("Item", 3),"Pencil");
    }

}
