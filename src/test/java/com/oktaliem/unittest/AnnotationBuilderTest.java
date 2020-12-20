package com.oktaliem.unittest;


import com.oktaliem.builder.TestDataAnnotationBuilder;
import com.oktaliem.model.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@TestData()
public class AnnotationBuilderTest {
    TestDataAnnotationBuilder testData = new TestDataAnnotationBuilder();

    @Test
    @TestData()
    public void getTestDataViaAnnotationByDefault(Method method) {
        String name = testData.getMyName(method);
        String mobile = testData.getMyMobilePhoneName(method);
        System.out.println(name);
        Assert.assertEquals(name,"okta");
        System.out.println(mobile);
        Assert.assertEquals(mobile,"Samsung");
    }

    @Test
    @TestData(mobilePhoneType = "iPhone")
    public void getTestDataWithOverrideAnnotation(Method method) {
        String name = testData.getMyName(method);
        String mobile = testData.getMyMobilePhoneName(method);
        System.out.println(name);
        Assert.assertEquals(name,"okta");
        System.out.println(mobile);
        Assert.assertEquals(mobile,"iPhone");
    }

    @Test
    @TestData(mobilePhoneType = "iPhone",name = "Clint")
    public void getTestDataWithOverrideAllAnnotation(Method method) {
        String name = testData.getMyName(method);
        String mobile = testData.getMyMobilePhoneName(method);
        System.out.println(name);
        Assert.assertEquals(name,"Clint");
        System.out.println(mobile);
        Assert.assertEquals(mobile,"iPhone");
    }

    @Test
    public void getTestDataFromClassAnnotation(Method method){
        String information = testData.getTestInformation(method.getDeclaringClass());
        System.out.println(information);
        Assert.assertEquals(information,"Test made by Okta");
    }
}
