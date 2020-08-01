package com.oktaliem.unittest;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.DateProducer;
import io.codearte.jfairy.producer.RandomGenerator;
import io.codearte.jfairy.producer.payment.CreditCard;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.company.Company;
import io.codearte.jfairy.producer.net.NetworkProducer;

import io.codearte.jfairy.producer.text.TextProducer;
import io.codearte.jfairy.producer.util.AlphaNumberSystem;
import io.codearte.jfairy.producer.util.LanguageCode;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

public class JFairyTest {
    Fairy testData = Fairy.create(Locale.getDefault());

    @Test
    public void getPersonTest(){
        Person person = testData.person();
        System.out.println(person.getAddress());
        System.out.println(person.getEmail());
        System.out.println(person.getCompanyEmail());
        System.out.println(person.getCompany().getEmail());
        System.out.println(person.getCompany().getUrl());
        System.out.println(person.getCompany().getDomain());
        System.out.println(person.getCompany().getName());
        System.out.println(person.getCompany().getVatIdentificationNumber());
        System.out.println(person.getAge());
        System.out.println(person.getDateOfBirth());
        System.out.println(person.getFirstName());
        System.out.println(person.getFullName());
        System.out.println(person.getLastName());
        System.out.println(person.getMiddleName());
        System.out.println(person.getNationalIdentificationNumber());
        System.out.println(person.getNationalIdentityCardNumber());
        System.out.println(person.getPassportNumber());
        System.out.println(person.getPassword());
        System.out.println(person.getSex());
        System.out.println(person.getTelephoneNumber());
        System.out.println(person.getUsername());
    }

    @Test
    public void getCompanyTest(){
        Company co = testData.company();
        System.out.println(co.getVatIdentificationNumber());
        System.out.println(co.getName());
        System.out.println(co.getDomain());
        System.out.println(co.getUrl());
        System.out.println(co.getEmail());
    }

    @Test
    public void getNetWork(){
        NetworkProducer net = testData.networkProducer();
        System.out.println(net.url(false));
        System.out.println(net.ipAddress());
    }

    @Test
    public void getCreditCardTest(){
        CreditCard cc = testData.creditCard();
        System.out.println(cc.getExpiryDate());
        System.out.println(cc.getExpiryDateAsString());
        System.out.println(cc.getVendor());
    }

    @Test
    public void getBaseProducerTest(){
        BaseProducer base = testData.baseProducer();
        System.out.println(base.randomElement(3));
        System.out.println(base.bothify("harimau"));
        System.out.println(base.letterify("kUcing"));
        System.out.println(base.randomBetween(1,90));
        System.out.println(base.randomBetween(-1000,-100));
        System.out.println(base.randomBetween(1.6,100.5));
        System.out.println(base.randomInt(20));
        System.out.println(base.trueOrFalse());
    }

    @Test
    public void getTextProducerTest(){
        TextProducer textProducer = testData.textProducer();
        System.out.println(textProducer.limitedTo(1000).word());
        System.out.println(textProducer.latinSentence());
        System.out.println(textProducer.latinWord());
        System.out.println(textProducer.loremIpsum());
        System.out.println(textProducer.paragraph());
        System.out.println(textProducer.randomString(50));
        System.out.println(textProducer.sentence());
        System.out.println(textProducer.text());
        System.out.println(textProducer.word());
        System.out.println(textProducer.word(20));
        System.out.println(textProducer.sentence(900));
        System.out.println(textProducer.paragraph(70));
        System.out.println(textProducer.latinSentence(30));

    }

    @Test
    public void getDateTest(){
        DateProducer date = testData.dateProducer();
        System.out.println(date.randomDateBetweenYears(1990,2050));
        System.out.println(date.randomDateBetweenYearAndNow(2000));
        System.out.println(date.randomDateInTheFuture());
        System.out.println(date.randomDateInTheFuture(20));
        System.out.println(date.randomDateInThePast(1990));
    }

}
