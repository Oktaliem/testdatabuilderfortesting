package com.oktaliem.builder;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:environment.properties"})
public interface PropertiesBuilder extends Config {

    @Key("isqa")
    String getIsqa();

    @Key("db.port")
    int getPortNumber();

    @Key("idstb")
    String getIdstb();

    @Key("username")
    String getUserName();

    @Key("password")
    String getPassword();

}
