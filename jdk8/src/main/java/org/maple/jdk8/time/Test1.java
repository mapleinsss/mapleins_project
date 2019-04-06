package org.maple.jdk8.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;

/**
 * @Author Mapleins
 * @Date 2019-04-06 2:28
 * @Description java8 时间
 */
public class Test1 {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);  //2019-04-06
        //getDayOfYear() 获取的是一年当中的第几天
        System.out.println(localDate.getDayOfYear()); //96
        //getMonth() 获取的是月份的英文
        System.out.println(localDate.getMonth()); //APRIL
        //getDayOfWeek() 获取的是星期的英文
        System.out.println(localDate.getDayOfWeek()); //SATURDAY
        System.out.println(localDate.getYear() + " " + localDate.getMonthValue() + " " + localDate.getDayOfMonth());//2019 4 6

        System.out.println("------------------");

        //直接构造哪一天
        LocalDate localDate1 = LocalDate.of(1992, 3, 6);
        System.out.println(localDate1);
        //比较日期
        System.out.println(localDate.isBefore(localDate1));
        System.out.println(localDate.isAfter(localDate1));
        System.out.println(localDate.equals(localDate1));

        System.out.println("--------------------");

        //对比两个日期的 月和日 是否相同
        MonthDay mon1 = MonthDay.of(localDate1.getMonthValue(), localDate1.getDayOfMonth());
        MonthDay mon2 = MonthDay.from(LocalDate.of(2019, 3, 6));
        if(mon1.equals(mon2)){
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }

        System.out.println("-----------------------");

        //当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        //增加时间
        LocalTime time = localTime.plusHours(1).plusMinutes(1);
        System.out.println(time);


        //前面是增加的数量，后面是枚举值 可以选择年月日时分秒
        LocalDate plus1Week = localDate.plus(1, ChronoUnit.WEEKS);
        System.out.println(plus1Week);

        System.out.println("-----------------------");

        //减
        LocalDate minus1Month = localDate.minus(1, ChronoUnit.MONTHS);
        System.out.println(minus1Month);

        System.out.println("------------------------");
    }
}
