package com.ceam.sport.utils;

import com.ceam.common.utils.DateUtils;
import com.ceam.sport.vo.NavDay;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CeaM
 * 2023/02/22 22:41
 **/
public class CourseWeekUtil {

    private static HashMap<Integer, String> map;
    private static HashMap<Integer, String> longMap;

    static {
        map = new HashMap<>();
        map.put(1, "明日");
        map.put(2, "周一");
        map.put(3, "周二");
        map.put(4, "周三");
        map.put(5, "周四");
        map.put(6, "周五");
        map.put(7, "周六");
        longMap = new HashMap<>();
        longMap.put(1, "星期日");
        longMap.put(2, "星期一");
        longMap.put(3, "星期二");
        longMap.put(4, "星期三");
        longMap.put(5, "星期四");
        longMap.put(6, "星期五");
        longMap.put(7, "星期六");
    }

    public static final String weekMap(Integer weekday) {
        return map.get(weekday);
    }

    public static final String longWeekMap(Integer weekday) {
        return longMap.get(weekday);
    }

    // 构建日历
    public static final List<NavDay> navDayList() {
        // 几号
        int day = DateUtils.day();
        // 周几
        int weekday = DateUtils.weekday();

        List<NavDay> linkedList = new LinkedList<>();
        NavDay firstNavDay = new NavDay();
        firstNavDay.setDate("今天");
        firstNavDay.setDay(day);
        firstNavDay.setWeekDay(weekday);
        linkedList.add(firstNavDay);
        NavDay secNavDay = new NavDay();
        secNavDay.setDate("明天");
        day = day + 1 > DateUtils.dayCount() ? 1 : day + 1;
        weekday = weekday + 1 > 7 ? 1 : weekday + 1;
        secNavDay.setDay(day);
        secNavDay.setWeekDay(weekday);
        linkedList.add(secNavDay);
        for (int i = 1; i < 7 - 1; i++) {
            weekday = weekday + 1;
            if (weekday > 7) {
                weekday = 1;
            }
            NavDay navDay = new NavDay();
            day = day + 1;
            int dayCount = DateUtils.dayCount();
            if (day > dayCount) {
                day = 1;
            }

            navDay.setDay(day);
            navDay.setDate(CourseWeekUtil.weekMap(weekday));
            navDay.setWeekDay(weekday);
            linkedList.add(navDay);
        }
        return linkedList;
    }
}
