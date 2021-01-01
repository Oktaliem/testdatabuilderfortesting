package com.oktaliem.unittest;

import com.jayway.jsonpath.JsonPath;
import com.oktaliem.builder.JsonPathBuilder;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;


import java.io.IOException;
import java.util.List;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JsonPathTest {


    @Test
    public void SampleTestOne() throws IOException {
        JsonPathBuilder path = new JsonPathBuilder("data.json");
        String getResponse = path.getJsonFile();
        System.out.println(getResponse);

        int id = JsonPath.read(getResponse, "$.[0].id");
        Assert.assertEquals(1, id);

        String title2 = JsonPath.read(getResponse, "$.[1].title");
        Assert.assertEquals("Quantum of Solace", title2);

        List<String> starring3 = JsonPath.read(getResponse, "$.[2].starring");
        Assert.assertEquals("[\"Daniel Craig\",\"Naomie Harris\"]", starring3.toString());

        List<Integer> ids = JsonPath.read(getResponse, "$.[*].id");
        System.out.println(ids);

        List<String> titles = JsonPath.read(getResponse, "$.[*].title");
        System.out.println(titles);

    }


    @Test
    public void SampleTestTwo() throws IOException {
        JsonPathBuilder path = new JsonPathBuilder("quiz.json");
        String getResponse = path.getJsonFile();
        System.out.println(getResponse);

        String sportQuestion = JsonPath.read(getResponse, "$.quiz.sport.q1.question");
        Assert.assertEquals("Which one is correct team name in NBA?", sportQuestion);

        List<String> questions = JsonPath.read(getResponse, "$..q1.question");
        System.out.println(questions);

        List<String> option2 = JsonPath.read(getResponse, "$..q1.options[1]");
        System.out.println(option2);

        List<String> option3 = JsonPath.read(getResponse, "$..sport.q1.options[1]");
        System.out.println(option3);

        List<String> option4 = JsonPath.read(getResponse, "$..sport.q1.options[1]");
        System.out.println(option4);

        List<String> answer = JsonPath.read(getResponse, "$..answer");
        System.out.println(answer.get(2));
        Assert.assertEquals("4", answer.get(2));

    }


    @Test
    public void SampleTestThree() throws IOException {
        JsonPathBuilder path = new JsonPathBuilder("identity.json");
        String getResponse = path.getJsonFile();
        System.out.println(getResponse);

        String street = JsonPath.read(getResponse, "$.address.street");
        Assert.assertEquals("Kulas Light", street);

        String latitude = JsonPath.read(getResponse, "$.address.geo.lat");
        Assert.assertEquals("-37.3159", latitude);

        String bs = JsonPath.read(getResponse, "$.company.bs");
        Assert.assertEquals("harness real-time e-markets", bs);

    }

}



