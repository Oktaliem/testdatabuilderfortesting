package com.oktaliem;

import com.oktaliem.builder.JsonBuilder;
import com.oktaliem.model.Measurement;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import static org.apache.commons.lang3.StringUtils.trim;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JsonBuilderTest {
    JsonBuilder json = new JsonBuilder();

    @Test
    public void simpleJson() {
        String result = "{\"number\":\"23\",\"colour\":\"red\",\"name\":\"maria\"}";
        System.out.println(json.simpleJson());
        Assert.assertEquals(json.simpleJson().toString(), result);
    }

    @Test
    public void simpleJsonWithMap() {
        String result = "{\"name\":\"jon doe\",\"city\":\"chicago\",\"age\":\"22\"}";
        System.out.println(json.simpleJsonWithMap());
        Assert.assertEquals(json.simpleJsonWithMap().toString(), result);
    }

    @Test
    public void createJsonObjectWithString() {
        String result = "{\"number\":\"23\",\"colour\":\"red\",\"name\":\"maria\"}";
        System.out.println(json.simpleJsonFromString(result));
        Assert.assertEquals(json.simpleJsonFromString(result).toString(), result);
    }

    @Test
    public void createSimpleJSONArray() {
        String result = "[\"vehicle\",{\"colour\":\"black\",\"car\":\"honda\",\"year\":\"2007\"}]";
        System.out.print(json.simpleJSONWithJSONArray());
        Assert.assertEquals(json.simpleJSONWithJSONArray().toString(), result);
    }

    @Test
    public void createJsonArrayFromString() {
        String result = "[\"vehicle\",{\"colour\":\"black\",\"car\":\"honda\",\"year\":\"2007\"}]";
        System.out.print(json.simpleJSONArrayFromString(result));
        Assert.assertEquals(json.simpleJSONArrayFromString(result).toString(), result);
    }

    @Test
    public void createJsonArrayFromCollection() {
        String result = "[\"Indonesia\",\"South Korea\",\"Singapore\",\"Japan\"]";
        System.out.println(json.jsonArrayFromCollection());
        Assert.assertEquals(json.simpleJSONArrayFromString(result).toString(), result);
    }

    @Test
    public void createJsonArrayAndJsonObjectUsingCommaDelimited() {
        String string = "name, city, age \n" +
                "john, chicago, 22 \n" +
                "gary, florida, 35 \n" +
                "sal, vegas, 18";
        String result = "[{\"name\":\"john\",\"city\":\"chicago\",\"age\":\"22\"},{\"name\":\"gary\",\"city\":\"florida\",\"age\":\"35\"},{\"name\":\"sal\",\"city\":\"vegas\",\"age\":\"18\"}]";
        System.out.println(json.jsonArrayObjectCommaDelimited(string));
        Assert.assertEquals(json.jsonArrayObjectCommaDelimited(string).toString(), result);
    }

    @Test
    public void convertJsonObjectToHttpHeader() {
        String result = "POST \"http://www.example.com/\" HTTP/1.1";
        System.out.println(json.jsonObjectToHttpHeader());
        Assert.assertEquals(trim(json.jsonObjectToHttpHeader()), result);
    }

    @Test
    public void createJsonObjectAndJsonArray() {
        Measurement measurement = new Measurement();
        measurement.setId("123");
        measurement.setVersion("1.0");
        measurement.setValue(1.0);
        measurement.setQuality(9);
        measurement.setTemp(1.02);
        measurement.setTime(12345);
        measurement.setMtd("thing.measurepoint.post");

        String result = "{\"method\":\"thing.measurepoint.post\",\"id\":\"123\",\"params\":{\"measurepoints\":{\"temp\":1.02,\"branchCurr\":[\"1.02\",\"2.02\",\"7.93\"],\"Power\":{\"value\":1,\"quality\":9}},\"time\":12345},\"version\":\"1.0\"}";
        System.out.println(json.jsonObjectAndJSONArray(measurement));
        Assert.assertEquals(json.jsonObjectAndJSONArray(measurement).toString(), result);
    }

}
