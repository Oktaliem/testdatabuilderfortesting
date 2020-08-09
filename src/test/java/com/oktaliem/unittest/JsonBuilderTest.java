package com.oktaliem.unittest;

import com.oktaliem.builder.JsonBuilder;
import com.oktaliem.model.CreditCard;
import com.oktaliem.model.CreditCardDeserialize;
import com.oktaliem.model.Measurement;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static org.apache.commons.lang3.StringUtils.trim;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JsonBuilderTest {
    JsonBuilder json = new JsonBuilder();
    private CreditCard testData;
    private CreditCardDeserialize deserialize;

    @Test
    public void simpleJson() {
        String result = "{\"number\":\"23\",\"colour\":\"red\",\"name\":\"maria\"}";
        System.out.println(json.simpleJson());
        Assert.assertEquals(result,json.simpleJson().toString());
    }

    @Test
    public void simpleJsonWithMap() {
        String result = "{\"name\":\"jon doe\",\"city\":\"chicago\",\"age\":\"22\"}";
        System.out.println(json.simpleJsonWithMap());
        Assert.assertEquals(result,json.simpleJsonWithMap().toString());
    }

    @Test
    public void createJsonObjectWithString() {
        String result = "{\"number\":\"23\",\"colour\":\"red\",\"name\":\"maria\"}";
        System.out.println(json.simpleJsonFromString(result));
        Assert.assertEquals(result,json.simpleJsonFromString(result).toString());
    }

    @Test
    public void createSimpleJSONArray() {
        String result = "[\"vehicle\",{\"colour\":\"black\",\"car\":\"honda\",\"year\":\"2007\"}]";
        System.out.print(json.simpleJSONWithJSONArray());
        Assert.assertEquals(result,json.simpleJSONWithJSONArray().toString());
    }

    @Test
    public void createJsonArrayFromString() {
        String result = "[\"vehicle\",{\"colour\":\"black\",\"car\":\"honda\",\"year\":\"2007\"}]";
        System.out.print(json.simpleJSONArrayFromString(result));
        Assert.assertEquals(result,json.simpleJSONArrayFromString(result).toString());
    }

    @Test
    public void createJsonArrayFromCollection() {
        String result = "[\"Indonesia\",\"South Korea\",\"Singapore\",\"Japan\"]";
        System.out.println(json.jsonArrayFromCollection());
        Assert.assertEquals(result,json.simpleJSONArrayFromString(result).toString());
    }

    @Test
    public void createJsonArrayAndJsonObjectUsingCommaDelimited() {
        String string = "name, city, age \n" +
                "john, chicago, 22 \n" +
                "gary, florida, 35 \n" +
                "sal, vegas, 18";
        String result = "[{\"name\":\"john\",\"city\":\"chicago\",\"age\":\"22\"},{\"name\":\"gary\",\"city\":\"florida\",\"age\":\"35\"},{\"name\":\"sal\",\"city\":\"vegas\",\"age\":\"18\"}]";
        System.out.println(json.jsonArrayObjectCommaDelimited(string));
        Assert.assertEquals(result,json.jsonArrayObjectCommaDelimited(string).toString());
    }

    @Test
    public void convertJsonObjectToHttpHeader() {
        String result = "POST \"http://www.example.com/\" HTTP/1.1";
        System.out.println(json.jsonObjectToHttpHeader());
        Assert.assertEquals(result, trim(json.jsonObjectToHttpHeader()));
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
        Assert.assertEquals(result, json.jsonObjectAndJSONArray(measurement).toString() );
    }

    @Test()
    public void extractJsonToGetter() throws IOException {
        deserialize = CreditCardDeserialize.get(System.getProperty("user.dir") + "/src/main/resources/example_2.json");
        System.out.println(deserialize);
        System.out.println(deserialize.getFirstname());
        Assert.assertEquals("Jon", deserialize.getFirstname());
        System.out.println(deserialize.getLastName());
        Assert.assertEquals("Doe", deserialize.getLastName());
        System.out.println(deserialize.getEmail());
        Assert.assertEquals("jd@gmail.com", deserialize.getEmail());
        System.out.println(deserialize.getDate());
        Assert.assertEquals("01/01/1968", deserialize.getDate());
        System.out.println(deserialize.getAddress());
        Assert.assertEquals("anywhere you like", deserialize.getAddress());

        CreditCardDeserialize.CC cc = deserialize.getCc();
        System.out.println(cc.getNumber());
        Assert.assertEquals("4444-4444-4444-4444", cc.getNumber());
        System.out.println(cc.getBank());
        Assert.assertEquals("DBS", cc.getBank());

        CreditCardDeserialize.Product product = deserialize.getProduct();
        System.out.println(product.getType());
        Assert.assertEquals("platinum", product.getType());
    }

    @Test
    public void createJsonOnTheFly() throws IOException {
        CreditCard.CC cc = new CreditCard.CC("4444-4444-4444-5555", "BCA");
        CreditCard.Product product = new CreditCard.Product("Gold");
        CreditCard data = new CreditCard("Okta", "Joe", "abc@gmail.com", "01/01/1967", "Singapore", cc, product);
        String testData = CreditCard.set(data);
        System.out.println(testData);
        String result = "{\n" +
                "  \"lastName\" : \"Joe\",\n" +
                "  \"firstname\" : \"Okta\",\n" +
                "  \"lastname\" : \"Joe\",\n" +
                "  \"email\" : \"abc@gmail.com\",\n" +
                "  \"date\" : \"01/01/1967\",\n" +
                "  \"address\" : \"Singapore\",\n" +
                "  \"cc\" : {\n" +
                "    \"number\" : \"4444-4444-4444-5555\",\n" +
                "    \"bank\" : \"BCA\"\n" +
                "  },\n" +
                "  \"product\" : {\n" +
                "    \"type\" : \"Gold\"\n" +
                "  }\n" +
                "}";
        Assert.assertEquals(result,testData);
    }

}
