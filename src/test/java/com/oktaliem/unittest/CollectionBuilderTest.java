package com.oktaliem.unittest;

import com.oktaliem.builder.CollectionBuilder;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CollectionBuilderTest {
    CollectionBuilder collection = new CollectionBuilder();

    @Test
    public void getSingleArrayInt() {
        int[] single = {33, 3, 4, 5}; //test data

        for (int j : single) {
            System.out.println(j);
        }
        System.out.println(single[1]);
    }

    @Test
    public void getSingleArrayString() {
        String[] cars = {"BMW", "VW",}; //test data

        for (String car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void getMultidimensionalArray() {
        int[][] matrix = {          //row = i
                {1, 3, 4, 6},       //row 0
                {7, 8, 9, 10},      //row 1
                {11, 12, 13, 14},   //row 2
                {15, 16, 17, 18}    //row 3
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        Assert.assertEquals(1, matrix[0][0]); //row 0, column 0
        Assert.assertEquals(12, matrix[2][1]);
        Assert.assertEquals(17, matrix[3][2]);
    }

    @Test
    public void getMultidimensionalArrayMatrix() {
        int[] block = new int[5]; //test data
        block[0] = 15;
        block[1] = 21;
        block[2] = 70;
        block[3] = 45;
        block[4] = 40;

        System.out.println(Arrays.stream(block).max().getAsInt());
        System.out.println(Arrays.stream(block).min().getAsInt());
        System.out.println(Arrays.stream(block).average().getAsDouble());
        Assert.assertEquals(45, block[3]);
        Assert.assertEquals(40, block[4]);
        Assert.assertEquals(70, block[2]);
        Assert.assertEquals(21, block[1]);

    }

    @Test
    public void getTestDataFromArrayList() {
        List<String> cars = new ArrayList<>(); //test data
        cars.add("BMW");
        cars.add("Honda");
        cars.add("Audi");

        System.out.println(cars);
        System.out.println(cars.get(0));
        System.out.println(cars.get(1));
        System.out.println(cars.get(2));
    }

    @Test
    public void getTestDataFromLinkedList() {
        List<String> cars = new LinkedList<>(); //test data
        cars.add("BMW");
        cars.add("Honda");
        cars.add("Audi");

        System.out.println(cars);
        System.out.println(cars.get(0));
        System.out.println(cars.get(1));
        System.out.println(cars.get(2));
    }

    @Test
    public void getTestDataFromMapList() {
        // Stores in pair, key -> value : Entry
        Map<Integer, String> map = new HashMap<>(); //test data
        map.put(1, "BMW");
        map.put(6, "Audi");
        map.put(4, "Honda");

        System.out.println(map);
        System.out.println(map.get(6));
    }

    @Test
    public void convertFromJsonFileToHashMap() throws IOException {
        Map<String, Object> result = collection.convertJsonFileToHashMap("example_2.json");
        System.out.println(result);
        Assert.assertEquals(result.get("firstname"), "Jon");
        Map<String, Object> result2 = collection.convertJsonFileToHashMap("Books.json");
        System.out.println(result2);
    }

    @Test
    public void convertFromDatToHashMap() throws FileNotFoundException {
        HashMap<String, Integer> testData = collection.convertDatToHaspMap("Cars.dat");
        System.out.println(testData);
        Assert.assertEquals(87990000,testData.get("Ferrari").intValue());
    }


}
