package com.oktaliem.unittest;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.*;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CollectionBuilderTest {

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
        int[][] matrix = {{1, 3, 4, 6}, {3, 4, 5, 7}, {2, 4, 5, 7}, {5, 4, 5, 7}}; //test data

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        Assert.assertEquals(4,matrix[2][1]);
        Assert.assertEquals(5,matrix[2][2]);
    }

    @Test
    public void getMultidimensionalArrayMatrix() {
        int[] block = new int[5]; //test data
        block[0] = 15;
        block[1] = 21;
        block[2] = 70;
        block[3] = 45;
        block[4] = 40;

        Assert.assertEquals(45,block[3]);
        Assert.assertEquals(40,block[4]);
        Assert.assertEquals(70,block[2]);
        Assert.assertEquals(21,block[1]);

    }

    @Test
    public void getTestDataFromArrayList(){
        ArrayList<String> cars = new ArrayList<>(); //test data
        cars.add("BMW");
        cars.add("Honda");
        cars.add("Audi");

        System.out.println(cars.get(0));
        System.out.println(cars.get(1));
        System.out.println(cars.get(2));
    }

    @Test
    public void getTestDataFromLinkedList(){
        LinkedList<String> cars = new LinkedList<>(); //test data
        cars.add("BMW");
        cars.add("Honda");
        cars.add("Audi");

        System.out.println(cars.get(0));
        System.out.println(cars.get(1));
        System.out.println(cars.get(2));
    }

    @Test
    public void getTestDataFromMapList(){
        // Stores in pair, key -> value : Entry
        Map<Integer, String> map = new HashMap<>(); //test data
        map.put(1, "BMW");
        map.put(6, "Audi");
        map.put(4, "Honda");

        System.out.println(map.get(6));
    }


}
