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

        String sportQuestion = JsonPath.read(getResponse,"$.quiz.sport.q1.question");
        System.out.println(sportQuestion);

        List<String>  questions = JsonPath.read(getResponse,"$..q1.question");
        System.out.println(questions);

        List<String> option2 = JsonPath.read(getResponse,"$..q1.options[1]");
        System.out.println(option2);

        List<String> option3 = JsonPath.read(getResponse,"$..sport.q1.options[1]");
        System.out.println(option3);

    }


}



