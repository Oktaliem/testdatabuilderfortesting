package com.oktaliem;

import com.oktaliem.builder.JsonBuilder;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JsonBuilderTest {
    JsonBuilder json = new JsonBuilder();

    @Test
    public void simpleJson(){
        String result = "{\"number\":\"23\",\"colour\":\"red\",\"name\":\"maria\"}";
        System.out.println(json.simpleJson());
        Assert.assertEquals(json.simpleJson().toString(),result);
    }

    @Test
    public void simpleJsonWithMap(){
        String result = "{\"name\":\"jon doe\",\"city\":\"chicago\",\"age\":\"22\"}";
        System.out.println(json.simpleJsonWithMap());
        Assert.assertEquals(json.simpleJsonWithMap().toString(),result);
    }

    @Test
    public void createJsonObjectWithString(){
        String result = "{\"number\":\"23\",\"colour\":\"red\",\"name\":\"maria\"}";
        System.out.println(json.simpleJsonFromString(result));
        Assert.assertEquals(json.simpleJsonFromString(result).toString(),result);
    }

}
