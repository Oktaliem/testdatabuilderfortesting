package com.oktaliem.unittest;

import com.oktaliem.builder.JsonTemplateBuilder;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JsonTemplateBuilderTest {
    JsonTemplateBuilder json = new JsonTemplateBuilder();

    @Test
    public void firstModelTest(){
        System.out.println(json.sample_1());
    }

    @Test
    public void secondModelTest(){
        System.out.println(json.sample_2());
    }

    @Test
    public void thirdModelTest(){
        System.out.println(json.sample_3());
    }

    @Test
    public void fourthModelTest(){
        System.out.println(json.sample_4());
    }
}
