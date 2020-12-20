package com.oktaliem.builder;

import com.oktaliem.model.TestData;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestDataAnnotationBuilder {

    public String getMyName(Method method) {
        System.out.println("Get Name: " + method.getName());
        System.out.println("Get Return Type: " + method.getReturnType());
        System.out.println("Get Annotation Return Type: " + method.getAnnotatedReturnType());
        System.out.println("Get Default Value: " + method.getDefaultValue());
        System.out.println("Get Declaration Class: " + method.getDeclaringClass());
        System.out.println("Get Parameter Types: " + method.getParameterTypes().length);
        System.out.println("Get Exception Types: " + method.getExceptionTypes().length);
        System.out.println("Get Parameters: " + Arrays.stream(method.getParameters()).count());
        System.out.println("Get Annotations: " + method.getAnnotations().length);
        System.out.println("Get Class: " + method.getClass());
        return method.getAnnotation(TestData.class).name();
    }

    public String getMyMobilePhoneName(Method method) {
        return method.getAnnotation(TestData.class).mobilePhoneType();
    }

    public String getTestInformation(Class<?> declaringClass) {
        return declaringClass.getAnnotation(TestData.class).info();
    }

}
