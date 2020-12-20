package com.oktaliem.builder;

import com.oktaliem.model.TestData;

import java.lang.reflect.Method;

public class TestDataAnnotationBuilder {

    public String getMyName(Method name) {
        return name.getAnnotation(TestData.class).name();
    }

    public String getMyMobilePhoneName(Method name) {
        return name.getAnnotation(TestData.class).mobilePhoneType();
    }

    public String getTestInformation(Class<?> declaringClass) {
        return declaringClass.getAnnotation(TestData.class).info();
    }
}
