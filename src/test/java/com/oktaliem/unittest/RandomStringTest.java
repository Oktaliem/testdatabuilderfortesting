package com.oktaliem.unittest;

import com.oktaliem.builder.RandomStringBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RandomStringTest {


    @Test
    public void generateUUIDWithDash(){
        RandomStringBuilder uuid = new RandomStringBuilder();
        String a = uuid.generateRandomUUID();
        Assert.assertTrue(a.contains("-"));
        System.out.println(a);
    }

    @Test
    public void generateUUIDWithoutDash(){
        RandomStringBuilder uuid = new RandomStringBuilder();
        String b = uuid.generateRandomUUUIDWithoutDash();
        Assert.assertFalse(b.contains("-"));
        System.out.print(b);
    }

    @Test
    public void randomAlphaNumeric(){
        RandomStringBuilder text = new RandomStringBuilder();
        String c = text.generateRandomAlphanumeric(6);
        Assert.assertEquals(c.length(),6);
        System.out.println(c);
        String d = text.generateRandomAlphanumeric(12);
        Assert.assertEquals(d.length(),12);
        System.out.println(d);
    }

    @Test
    public void generateRandomPassword(){
        RandomStringBuilder random = new RandomStringBuilder();
        String e = "okta@" + random.generateStrengthPassword(8);
        Assert.assertEquals(e.length(),13);
        System.out.println(e);
    }


}
