package com.oktaliem.unittest;

import com.oktaliem.builder.DateAndTimeBuilder;
import org.junit.Test;

public class DateAndTimeBuilderTest {
    DateAndTimeBuilder dateAndTime = new DateAndTimeBuilder();

    @Test
    public void createSimpleDate(){
        String format = "dd/M/yyyy";
        System.out.println(dateAndTime.simpleDate(format));
    }

    @Test
    public void getCurrentDateTest(){
        String format = "yyyy/MM/dd HH:mm:ss";
        System.out.println(dateAndTime.getCurrentDate(format));
    }

    @Test
    public void getYesterdayDateTest(){
        String format = "yyyy/MM/dd HH:mm:ss";
        System.out.println(dateAndTime.getYesterdayDate(format));
    }

    @Test
    public void getTomorrowDateTest(){
        String format = "dd-MM-yyyy";
        String format2 = "dd MM yyyy";
        System.out.println(dateAndTime.getTomorrowDate(format));
        System.out.println(dateAndTime.getTomorrowDate(format2));
    }

    @Test
    public void getTimeStampTest(){
        System.out.println(dateAndTime.getCurrentTimeStamp());
    }

    @Test
    public void getCurrentTimeToInstantTest(){
        System.out.println(dateAndTime.getCurrentTimeToInstant());
    }

    @Test
    public void getTimeByZoneTest(){
        System.out.println(dateAndTime.getZoneDateTime("Asia/Tokyo"));
    }

    @Test
    public void getCurrentGregorianCalenderTest(){
        System.out.println(dateAndTime.getGregorianCalendar());
    }


}
