package com.ceam.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author CeaM
 * 2023/02/19 13:10
 **/
@Slf4j
public class DateUtils {

    public static void main(String[] args) {
        Date today = new Date();
        Calendar c= Calendar.getInstance();
        c.setTime(today);
        int weekday=c.get(Calendar.DAY_OF_WEEK);
        log.info("now day：{}", weekday);
        day();
        dayCount();
    }

    /**
     * 周几，周日 1，周一 2，
     * @return int
     */
    public static int weekday() {
        Date today = new Date();
        Calendar c= Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        return weekday;
    }

    public static int day() {
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        log.info("day：{}", dayOfMonth);
        return dayOfMonth;
    }

    /**
     * 获取当前月有多少天
     *
     * @return dayCount
     */
    public static int dayCount() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        log.info("actualMaximum：{}", actualMaximum);
        return actualMaximum;
    }
}
