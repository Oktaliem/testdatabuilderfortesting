package com.oktaliem.builder;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndTimeBuilder {
    SimpleDateFormat date;

    public String simpleDate(String format) {
        date = new SimpleDateFormat(format);
        return date.format(new Date());
    }

    public String getCurrentDate(String format) {
        date = new SimpleDateFormat(format);
        Date dt = new Date();
        return date.format(dt);
    }

    public String getYesterdayDate(String format) {
        date = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date dt = cal.getTime();
        return date.format(dt);
    }

    public String getTomorrowDate(String format) {
        date = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +1);
        Date dt = cal.getTime();
        return date.format(dt);
    }

    public String getCurrentTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime());
    }

    public String getCurrentTimeToInstant(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Instant instant = timestamp.toInstant();
        return String.valueOf(instant);
    }

    public String getZoneDateTime(String timeZone){
        Instant instant = Instant.now();
        ZonedDateTime jpTime = instant.atZone(ZoneId.of(timeZone));
        return String.valueOf(jpTime);
    }

    public String getGregorianCalendar(){
        date = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat year = new SimpleDateFormat("yyyy");
        int y = Integer.parseInt(year.format(new Date()));
        SimpleDateFormat month = new SimpleDateFormat("MM");
        int m = Integer.parseInt(month.format(new Date()));
        SimpleDateFormat day = new SimpleDateFormat("dd");
        int d = Integer.parseInt(day.format(new Date()));
        Calendar calendar = new GregorianCalendar(y,m,d);
        calendar.add(Calendar.MONTH,-1);
        return date.format(calendar.getTime());
    }
}
