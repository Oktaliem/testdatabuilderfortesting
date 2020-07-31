package com.oktaliem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Measurement {
    //If you are using intelliJ then install Lombok Plugin
    private String id;
    private String version;
    private double value;
    private double quality;
    private double temp;
    private List<String> ranchCurr;
    private int time;
    private String mtd;

}
