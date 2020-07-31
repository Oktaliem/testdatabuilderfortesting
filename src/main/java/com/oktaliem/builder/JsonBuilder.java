package com.oktaliem.builder;

import com.oktaliem.model.Measurement;
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

    public String jsonObjectToHttpHeader() {
        JSONObject jo = new JSONObject();
        jo.put("Method", "POST");
        jo.put("Request-URI", "http://www.example.com/");
        jo.put("HTTP-Version", "HTTP/1.1");
        return HTTP.toString(jo);
    }

    public JSONObject jsonObjectAndJSONArray(Measurement measurement) {
        JSONObject jo = new JSONObject();
        jo.put("id",measurement.getId());
        jo.put("version", measurement.getVersion());
        JSONArray branchCurr = new JSONArray();
        branchCurr.put("1.02");
        branchCurr.put("2.02");
        branchCurr.put("7.93");
        JSONObject pw = new JSONObject();
        pw.put("value", measurement.getValue());
        pw.put("quality", measurement.getQuality());
        JSONObject power = new JSONObject();
        power.put("Power", pw);
        power.put("temp", measurement.getTemp());
        power.put("branchCurr", branchCurr);
        JSONObject measurePoint = new JSONObject();
        measurePoint.put("measurepoints", power);
        measurePoint.put("time", measurement.getTime());
        jo.put("params", measurePoint);
        jo.put("method", measurement.getMtd());
        return jo;
    }
}
