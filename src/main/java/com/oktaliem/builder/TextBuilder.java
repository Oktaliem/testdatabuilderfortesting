package com.oktaliem.builder;


import org.junit.Assert;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TextBuilder {

    public void readingFromTextFileWithBufferReader(String fileName) {
        String path = System.getProperty("user.dir") + "/src/main/resources/" + fileName;
        if (fileName.contains(".txt")) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
                String line;
                System.out.println("Read text file using Buffer Reader:");
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("Not a text file");
        }
    }

    public String readingFromTextFileWithFilesReader(String fileName, int lineNumber) throws IOException {
        String filename = System.getProperty("user.dir") + "/src/main/resources/" + fileName;
        Path path = Paths.get(filename);
        List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println("Read text file using File Reader:");
        System.out.println(allLines.get(lineNumber));
        return allLines.get(lineNumber);
    }

    public void readingFromTextWithScanner(String fileName) throws IOException {
        String filename = System.getProperty("user.dir") + "/src/main/resources/" + fileName;
        Path path = Paths.get(filename);
        Scanner scanner = new Scanner(path);
        System.out.println("Read text file using Scanner:");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }

    public void createTextFile(String fileName) throws IOException {
        String filename = System.getProperty("user.dir") + "/target/" + fileName;
        boolean newFile = new File(filename).createNewFile();
        Assert.assertTrue(newFile);
        PrintWriter data = new PrintWriter(filename, "UTF-8");
        data.println("Test Writing a file");
        data.println("Ok!!!");
        data.printf("%s" + "%n" , "Go go go!!!!");
        data.close();
    }

}
