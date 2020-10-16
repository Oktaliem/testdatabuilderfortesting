package com.oktaliem.builder;

import com.github.jsontemplate.JsonTemplate;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

import java.util.Locale;

import static io.qala.datagen.RandomShortApi.positiveInteger;
import static io.qala.datagen.RandomShortApi.sampleMultiple;

public class JsonTemplateBuilder {

    public String sample_1() {
        //note: tidak boleh ada spasi pada value
        String template = "{" +
                "  name : John," +
                "  age : 23," +
                "  role : [ developer, tester ]," +
                "  address : {" +
                "    city : Utrecht," +
                "    street : Musicallaan," +
                "    number : 413" +
                "  }" +
                "}";
        return new JsonTemplate(template).prettyString();
    }

    public String sample_2() {
        String template = "{" +
                "  name : @s," +
                "  age : @i(max=100)," +
                "  role : @s[](min=1, max=3)," +
                "  address : {" +
                "    city : @s," +
                "    street : @s," +
                "    number : @i" +
                "  }" +
                "}";
        return new JsonTemplate(template).prettyString();
    }

    public String sample_3() {
        Fairy testData = Fairy.create(Locale.getDefault());
        Person person = testData.person();
        String template = "{\n" +
                "  name : " + person.getFirstName() + ",\n" +
                "  age : " + person.getAge() + ",\n" +
                "  accountBalance: " + person.getPassportNumber() + ",\n" +
                "  married : " + person.getSex() + ",\n" +
                "  role : " + person.getUsername() +
                "}";
        return new JsonTemplate(template).prettyString();
    }

    public String sample_4() {
        Fairy testData = Fairy.create(Locale.getDefault());
        Person person = testData.person();
        String template = "{" +
                "  name : " + person.getFirstName() + ",\n" +
                "  age : " + +person.getAge() + ",\n" +
                "  role : " + sampleMultiple(2, "A", "B", "C") + ",\n" +
                "  address : {" +
                "    city : " + person.getAddress() + ",\n" +
                "    street : Musicallaan," +
                "    number : " + positiveInteger()+
                "  }" +
                "}";
        return new JsonTemplate(template).prettyString();
    }
}
