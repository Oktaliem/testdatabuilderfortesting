package com.oktaliem.unittest;

import com.oktaliem.builder.DateAndTimeBuilder;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.Calendar;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void getCurrentGregorianCalenderTest(){ System.out.println(dateAndTime.getGregorianCalendar()); }

    @Test
    public void getIso8601DateTest(){
        System.out.println(dateAndTime.getIso8601DateAndTime());
    }

    @Test
    public void getIso8601DateWithCalendarTest(){
        System.out.println(dateAndTime.getDateAndTimeIso8601String(2017, Calendar.FEBRUARY, 16, 20, 22, 28));
    }

}
