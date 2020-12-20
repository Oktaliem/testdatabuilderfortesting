package com.oktaliem.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface TestData {
    String name() default "okta";

    String mobilePhoneType() default "Samsung";

    String info() default "Test made by Okta";
}
