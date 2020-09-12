package com.oktaliem.unittest;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static io.qala.datagen.RandomElements.from;
import static io.qala.datagen.RandomShortApi.*;
import static io.qala.datagen.RandomString.Type.NUMERIC;
import static io.qala.datagen.RandomValue.between;
import static io.qala.datagen.RandomValue.length;
import static io.qala.datagen.Repeater.repeat;
import static io.qala.datagen.StringModifier.Impls.*;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataGenBuilderTest {

    @Test
    public void dataGeneratorString(){
        System.out.println(english(10));
        System.out.println(alphanumeric(0, 25));
        System.out.println(numeric(1, 10));
        System.out.println(unicode(5));
        System.out.println(length(5).string("A_ B"));
        System.out.println(length(10).with(specialSymbol()).english());
        System.out.println(length(5).with(spaces()).numeric());
        System.out.println(length(3).with(spaceLeft()).english());
        System.out.println(length(4).with(spacesRight(2)).english());
        System.out.println(length(10).with(prefix("BLAH")).numeric());
        System.out.println(between(1, 10).alphanumerics(4));
        System.out.println(repeat(length(4), NUMERIC).string("-").times(4)); // for credit card
    }


    @Test
    public void dataGeneratorNumbers(){
        System.out.println(between(0, 100).integer());
        System.out.println(between(-100, 100).integer());
        System.out.println(positiveInteger());
        System.out.println(Long());
        System.out.println(negativeDouble());
    }

    @Test
    public void dataGeneratorArrays(){
        System.out.println(sample("A", "B", "C","JK","LM"));
        System.out.println(sampleMultiple(2, "A", "B", "C"));
        System.out.println(from("A", "B").sampleWithReplacement(3));
        System.out.println(from("A", "B", "C").shuffled());
    }


    @Test
    public void dataGeneratorDates() throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(between(f.parse("2015-01-01"), f.parse("2016-01-01")).date());
    }
}
