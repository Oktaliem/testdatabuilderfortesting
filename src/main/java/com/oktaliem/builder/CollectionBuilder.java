package com.oktaliem.builder;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.io.*;
import java.util.*;

public class CollectionBuilder {

    public Map<String, Object> convertJsonFileToHashMap(String fileName) throws IOException {
        String path = System.getProperty("user.dir") + "/src/main/resources/" + fileName;
        File testData = new File(path);
        InputStream stream = new FileInputStream(testData);
        JsonParser parser = Json.createParser(stream);
        Event event = parser.next();  // START_OBJECT
        Map<String, Object> map = getMap(parser);
        stream.close();
        System.out.println("Return : " + map);
        return map;
    }

    private static Map<String, Object> getMap(JsonParser parser) {
        HashMap<String, Object> map = new HashMap<>();
        Event event = parser.next();  // START_OBJECT
        String key = parser.getString();
        event = parser.next();       //  KEY_NAME
        while (!event.equals(Event.END_OBJECT)) {
            if (event.equals(Event.VALUE_STRING)) {
                String value = parser.getString();
                map.put(key, value);
            } else if (event.equals(Event.VALUE_NUMBER)) {
                Integer value = parser.getInt();
                map.put(key, value);
            } else if (event.equals(Event.START_ARRAY)) {
                ArrayList<Object> list = getList(parser);
                map.put(key, list);
            }
            event = parser.next();
            if (event.equals(Event.END_OBJECT)) {
                break;
            }
            key = parser.getString();
            event = parser.next();
        }
        System.out.println("get Map: " + map);
        return map;
    }

    private static ArrayList<Object> getList(JsonParser parser) {
        ArrayList<Object> object = new ArrayList<>();
        Event event = parser.next();  // START_ARRAY
        while (!event.equals(Event.END_ARRAY)) {
            if (event.equals(Event.VALUE_STRING)) {
                object.add(parser.getString());
                event = parser.next();
            } else if (event.equals(Event.START_OBJECT)) {
                Map<String, Object> map = getMap(parser);
                object.add(map);
                event = parser.next();
            } else if (event.equals(Event.START_ARRAY)) {
                ArrayList<Object> subList = getList(parser);
                object.add(subList);
                event = parser.next();
            }
        }
        System.out.println("Return List: " + object);
        return object;
    }

    public HashMap<String, Integer> convertDatToHaspMap(String fileName) throws FileNotFoundException {
        String path = System.getProperty("user.dir") + "/src/main/resources/" + fileName;
        File dataFile = new File(path);
        HashMap<String, Integer> testData = new HashMap<>();
        Scanner input = new Scanner(dataFile);
        while (input.hasNext()) {
            String car = input.next();
            int population = input.nextInt();
            testData.put(car, population);
        }
        return testData;
    }
}
