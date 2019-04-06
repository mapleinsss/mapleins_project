package org.maple.jdk8.time;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author Mapleins
 * @Date 2019-04-06 2:34
 * @Description
 */
public class Test2 {

    public static void main(String[] args) {

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock); //SystemClock[Asia/Shanghai]
        System.out.println(clock.millis());  //1554524824005
        long l = System.currentTimeMillis();
        System.out.println(l); //1554524824005


        System.out.println("--------------");

        //查看所有的时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        TreeSet<String> treeSet = new TreeSet<String>(){
            {
                addAll(set);
            }
        };
//        treeSet.forEach(System.out::println);

        //构造带有时区的
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,zoneId);
        System.out.println(localDateTime); //2019-04-06T12:38:00.903
        System.out.println(zonedDateTime); //2019-04-06T12:38:00.903+08:00[Asia/Shanghai]

        System.out.println("---------------");

        //获取年月
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfMonth()); //这个月的天数
        System.out.println(yearMonth.isLeapYear()); //是否是闰年

        System.out.println("---------------");

        YearMonth yearMonth1 = YearMonth.of(2016, 2);
        System.out.println(yearMonth1);
        System.out.println(yearMonth1.lengthOfMonth());
        System.out.println(yearMonth1.isLeapYear());

        System.out.println("---------------");

        //查看日期间隔
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2020, 4, 10);
        Period period = Period.between(localDate1, localDate2);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());
        /**
            4
            0
            1
          间隔是1年0个月4天
         */

        System.out.println("---------------");

        // utc 时间
        System.out.println(Instant.now());

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

    }
}
