package com.oktaliem.unittest;

import com.github.javafaker.Faker;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.Locale;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JavaFakerTest {
    Faker testData = new Faker(new Locale("en_SG"));

    @Test
    public void createRandomAddress(){
        System.out.println(testData.address().fullAddress());
        System.out.println(testData.address().secondaryAddress());
        System.out.println(testData.address().streetAddress());
        System.out.println(testData.address().buildingNumber());
        System.out.println(testData.address().city());
        System.out.println(testData.address().cityName());
        System.out.println(testData.address().cityPrefix());
        System.out.println(testData.address().citySuffix());
        System.out.println(testData.address().country());
        System.out.println(testData.address().countryCode());
        System.out.println(testData.address().zipCode());
        System.out.println(testData.address().streetAddressNumber());
        System.out.println(testData.address().streetName());
        System.out.println(testData.address().streetPrefix());
        System.out.println(testData.address().streetName());
    }

    @Test
    public void createRandomCompany(){
        System.out.println(testData.company().bs());
        System.out.println(testData.company().logo());
        System.out.println(testData.company().url());
        System.out.println(testData.company().buzzword());
        System.out.println(testData.company().catchPhrase());
        System.out.println(testData.company().industry());
        System.out.println(testData.company().name());
        System.out.println(testData.company().profession());
    }

    @Test
    public void createRandomIdNumber(){
        System.out.println(testData.idNumber().validSvSeSsn());
        System.out.println(testData.idNumber().valid());
        System.out.println(testData.idNumber().invalid());
        System.out.println(testData.idNumber().invalidSvSeSsn());
        System.out.println(testData.idNumber().ssnValid());
    }

    @Test
    public void createRandomCrypto(){
        System.out.println(testData.crypto().md5());
        System.out.println(testData.crypto().sha1());
        System.out.println(testData.crypto().sha256());
        System.out.println(testData.crypto().sha512());
    }


    @Test
    public void createRandomCurrency(){
        System.out.println(testData.currency().code());
        System.out.println(testData.currency().name());
    }


    @Test
    public void createRandomNumber(){
        System.out.println(testData.number().digits(10));
        System.out.println(testData.number().digit());
        System.out.println(testData.number().randomDigitNotZero());
        System.out.println(testData.number().randomDigit());
        System.out.println(testData.number().numberBetween(1,9));
        System.out.println(testData.number().numberBetween(1,1000));
        System.out.println(testData.number().randomNumber());
        System.out.println(testData.number().randomDouble(2,1,9));
        System.out.println(testData.number().randomDouble(1,11,20));
    }

    @Test
    public void createRandomPhoneNumber(){
        System.out.println(testData.phoneNumber().cellPhone());
        System.out.println(testData.phoneNumber().extension());
        System.out.println(testData.phoneNumber().phoneNumber());
        System.out.println(testData.phoneNumber().subscriberNumber());
        System.out.println(testData.phoneNumber().subscriberNumber());
    }

    @Test
    public void createRandomThing(){
        System.out.println(testData.random().hex());
        System.out.println(testData.random().hex(20));
        System.out.println(testData.random().nextBoolean());
        System.out.println(testData.random().nextDouble());
        System.out.println(testData.random().nextInt(2));
        System.out.println(testData.random().nextInt(1,300));
        System.out.println(testData.random().nextLong());
        System.out.println(testData.random().nextLong(1800));
    }

    @Test
    public void createRandomName(){
        System.out.println(testData.name().bloodGroup());
        System.out.println(testData.name().firstName());
        System.out.println(testData.name().fullName());
        System.out.println(testData.name().lastName());
        System.out.println(testData.name().name());
        System.out.println(testData.name().nameWithMiddle());
        System.out.println(testData.name().prefix());
        System.out.println(testData.name().suffix());
        System.out.println(testData.name().title());
        System.out.println(testData.name().username());
    }

    @Test
    public void createRandomFile(){
        System.out.println(testData.file().extension());
        System.out.println(testData.file().fileName());
        System.out.println(testData.file().mimeType());
    }

}
