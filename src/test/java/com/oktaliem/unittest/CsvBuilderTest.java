package com.oktaliem.unittest;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.io.FileReader;
import java.io.IOException;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CsvBuilderTest {
    String fileName = System.getProperty("user.dir") + "/src/main/resources/electronictransaction.csv";

    @Test
    public void readCsvData() throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader(fileName));
        String[] cell = reader.readNext();
        String seriesRefColumn = cell[0];
        String periodColumn = cell[1];
        String dataValueColumn = cell[2];

        System.out.println(seriesRefColumn);
        System.out.println(periodColumn);
        System.out.println(dataValueColumn);

        System.out.println("======================================");

        String[] csvCell;
        while ((csvCell = reader.readNext()) != null) {
            System.out.println("**********************************");
            System.out.println(csvCell[0]);
            System.out.println(csvCell[1]);
            System.out.println(csvCell[2]);
            System.out.println("**********************************");
        }
    }
}
