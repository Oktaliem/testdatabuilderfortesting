package com.oktaliem.unittest;

import com.oktaliem.builder.PropertiesBuilder;
import org.aeonbits.owner.ConfigFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.net.*;
import java.util.Map;
import java.util.Properties;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PropertiesBuilderTest {
    PropertiesBuilder env = ConfigFactory.create(PropertiesBuilder.class);

    @Test
    public void getPropertiesTest() {
        System.out.println(env.getIsqa());
        System.out.println(env.getIdstb());
        System.out.println(env.getUserName());
        System.out.println(env.getPassword());
        System.out.println(env.getPortNumber());
    }

    @Test
    public void getSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println("=======================================");
        System.out.println("User home Laptop ini : " + System.getProperty("user.home"));
        System.out.println("OS name Laptop ini: " + System.getProperty("os.name"));
        System.out.println("User directory Laptop ini: " + System.getProperty("user.dir"));
        System.out.println("Java version Laptop ini: " + System.getProperty("java.version"));
        System.out.println("Java vm vendor Laptop ini: " + System.getProperty("java.vm.vendor"));
    }


    @Test
    public void getEnvironmentVariables() {
        Map<String, String> env = System.getenv();
        env.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    public void getIpAddress() {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Local IP address : " + ip.getHostAddress());
            System.out.println("Host name : " + ip.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            System.out.println("Public IP address : " + socket.getLocalAddress().getHostAddress());
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }

    }
}
