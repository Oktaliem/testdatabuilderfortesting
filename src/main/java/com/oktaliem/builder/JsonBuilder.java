package com.oktaliem.builder;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonBuilder {

    public JSONObject simpleJson() {
        JSONObject json = new JSONObject();
        json.put("name", "maria");
        json.put("colour", "red");
        json.put("number", "23");
        return json;
    }

    public JSONObject simpleJsonWithMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "jon doe");
        map.put("age", "22");
        map.put("city", "chicago");
        JSONObject json = new JSONObject(map);
        return json;
    }

    public JSONObject simpleJsonFromString(String input) {
        JSONObject json = new JSONObject(input);
        return json;
    }
}
