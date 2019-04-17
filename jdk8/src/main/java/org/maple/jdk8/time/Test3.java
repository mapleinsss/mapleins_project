package org.maple.jdk8.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author Mapleins
 * @Date 2019-04-11 11:20
 * @Description
 */
public class Test3 {

    public static void main(String[] args) throws ParseException {

       long l = 1554953308143l;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(l);
        String format = simpleDateFormat.format(date);
        System.out.println(format);




    }
}
