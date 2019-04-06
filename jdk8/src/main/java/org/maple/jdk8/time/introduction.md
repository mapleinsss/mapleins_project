# java.time  java8 时间 API

# LocalDate类
## 构造时间
    // 获取当前年月日
    LocalDate localDate = LocalDate.now();
    // 直接构造哪一天
    LocalDate.of(1992, 3, 6)
    // 构造月份和日
    MonthDay.of(localDate1.getMonthValue(), localDate1.getDayOfMonth())
    
    
## 获取时间
    // 获取是当年第几天
    localDate.getDayOfYear()
    // 获取英文月份
    localDate.getMonth()
    // 获取英文星期几
    localDate.getDayOfWeek()
    // 获取年
    localDate.getYear()
    // 获取月
    localDate.getMonthValue()
    // 获取日
    localDate.getDayOfMonth()
    
## 比较时间
    // 调用者是否在参数日期之前
    localDate.isBefore(localDate1)
    // 调用者是否在参数日期之后
    localDate.isAfter(localDate1)
    // 调用者是否等于参数时间
    localDate.equals(localDate1)
    
    LocalDate localDate1 = LocalDate.now();
    LocalDate localDate2 = LocalDate.of(2020, 4, 10);
    Period period = Period.between(localDate1, localDate2); //两个时间的间隔
    System.out.println(period.getDays()); //间隔多少年
    System.out.println(period.getMonths()); //间隔多少个月
    System.out.println(period.getYears()); //间隔多少天
    
# LocalTime 类
## 构造时间
    // 获取当前 时分秒
    LocalTime localTime = LocalTime.now();
## 操作当前时间
    // 增加一个小时一分钟
    localTime.plusHours(1).plusMinutes(1)    
    // 灵活的增加，前面是单位值，后面是枚举选择
    localDate.plus(1, ChronoUnit.WEEKS)
    // 灵活的减少
    localDate.minus(1, ChronoUnit.MONTHS)
    
# LocalDateTime 类
    LocalDateTime.now() //获取当前年月日 时分秒
    
# Clock类
    // 获取一个时区的时间
    ZoneId zoneId = ZoneId.of("Asia/Shanghai");
    LocalDateTime localDateTime = LocalDateTime.now();
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,zoneId);
    // 获取当前的时区 时间戳
    Clock.systemDefaultZone()
    // 查看所有的时区
    ZoneId.getAvailableZoneIds()
    
# YearMonth 类
    //当前 日月
    YearMonth yearMonth = YearMonth.now();
    System.out.println(yearMonth); //当前月
    System.out.println(yearMonth.lengthOfMonth()); //这个月的天数
    System.out.println(yearMonth.isLeapYear()); //是否是闰年
        
# Instant 类
    // 获取 utc 时间
    Instant.now() 