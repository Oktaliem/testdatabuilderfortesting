package com.oktaliem.unittest;

import com.oktaliem.builder.TextBuilder;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.testng.Assert;

import java.io.IOException;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TextBuilderTest {
    TextBuilder text = new TextBuilder();
    public static final String fileName = "scratch.txt";

    @Test
    public void printAllTextWithBufferReader() {
        text.readingFromTextFileWithBufferReader(fileName);
    }

    @Test
    public void printTextFileContentByLineWithFileReader() throws IOException {
        Assert.assertEquals(text.readingFromTextFileWithFilesReader(fileName, 3), "4 Plane");
    }

    @Test
    public void printAllTextWithScanner() throws IOException {
        text.readingFromTextWithScanner(fileName);
    }

    @Test
    public void createTextFile() throws IOException {
        text.createTextFile(fileName);
    }

}
