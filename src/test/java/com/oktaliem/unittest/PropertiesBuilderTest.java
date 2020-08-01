package com.oktaliem.unittest;

import com.oktaliem.builder.PropertiesBuilder;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;

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
