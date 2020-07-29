package com.oktaliem.builder;

import org.json.CDL;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public JSONArray simpleJSONWithJSONArray() {
        JSONArray array = new JSONArray();
        array.put("vehicle");
        JSONObject obj = new JSONObject();
        obj.put("car", "honda");
        obj.put("colour", "black");
        obj.put("year", "2007");
        return array.put(obj);
    }

    public JSONArray simpleJSONArrayFromString(String json) {
        JSONArray array = new JSONArray(json);
        return array;
    }

    public JSONArray jsonArrayFromCollection() {
        List<String> list = new ArrayList<>();
        list.add("Indonesia");
        list.add("South Korea");
        list.add("Singapore");
        list.add("Japan");
        JSONArray array = new JSONArray(list);
        return array;
    }

    public JSONArray jsonArrayObjectCommaDelimited(String string) {
        JSONArray result = CDL.toJSONArray(string);
        return result;
    }

    public String JsonObjectToHttpHeader() {
        JSONObject jo = new JSONObject();
        jo.put("Method", "POST");
        jo.put("Request-URI", "http://www.example.com/");
        jo.put("HTTP-Version", "HTTP/1.1");
        return HTTP.toString(jo);
    }
}
