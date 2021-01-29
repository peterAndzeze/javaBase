package com.customer.date;

import java.time.*;
import java.time.temporal.TemporalField;

/**
 * jdk1.8中以后引入Joda-Time
 */
public class DateTime {

    public void getCurrentUTC(){
        Clock clock=Clock.systemUTC();
        System.out.println("当前时间："+clock.instant());
        System.out.println("时间戳："+clock.millis());
    }


    public void getLocalDateNow(){
        LocalDate date = LocalDate.now();
        Clock clock=Clock.systemUTC();
        LocalDate localDate1=LocalDate.now(clock);

        System.out.println("localdate---->"+date);
        System.out.println("localdate1---->"+localDate1);
        System.out.println("在一年中的第"+date.getDayOfYear());
        System.out.println("在一个星期中的:"+date.getDayOfWeek());
        System.out.println("在一个月中的："+date.getDayOfMonth());

        System.out.println("年："+date.getYear()+"month:"+date.getMonth()+"->"+date.getMonthValue());
        System.out.println("平年："+date.isLeapYear());
        System.out.println("年的长度："+date.lengthOfYear()+"月的天数："+date.lengthOfMonth());
        System.out.println("当前日期的前一天："+date.minusDays(1L));
        System.out.println("当前月的前俩月："+date.minusMonths(2L));
        System.out.println("当前年的前三年："+date.minusYears(3L));
        System.out.println("当前日期的4个星期前："+date.minusWeeks(4L));
        System.out.println("当前日期后两天："+date.plusDays(2));
        System.out.println("设置时间"+date.atTime(3,2));//必须大于0
        //十分秒的使用：LocalTime
    }


    public  void localDateTime(){
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
        //自     定义时间
        LocalDateTime from=LocalDateTime.of(2014,Month.MAY,2,12,0);
        LocalDateTime to=LocalDateTime.of(2014,Month.MAY,2,12,20);

        Duration duration=Duration.between(from,to);
        System.out.println("相差天数："+duration.toDays());
        System.out.println("相差小时："+duration.toHours());
        System.out.println("相差分钟："+duration.toMinutes());

    }

}
