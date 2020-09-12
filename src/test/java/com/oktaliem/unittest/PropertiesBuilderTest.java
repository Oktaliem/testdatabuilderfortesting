package com.oktaliem.unittest;

import com.oktaliem.builder.PropertiesBuilder;
import org.aeonbits.owner.ConfigFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PropertiesBuilderTest {
    PropertiesBuilder env = ConfigFactory.create(PropertiesBuilder.class);

    @Test
    public void getPropertiesTest(){
        System.out.println(env.getIsqa());
        System.out.println(env.getIdstb());
        System.out.println(env.getUserName());
        System.out.println(env.getPassword());
        System.out.println(env.getPortNumber());
    }
}
