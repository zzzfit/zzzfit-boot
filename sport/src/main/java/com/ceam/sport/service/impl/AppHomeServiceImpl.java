package com.ceam.sport.service.impl;

import com.ceam.common.utils.DateUtils;
import com.ceam.sport.service.*;
import com.ceam.sport.utils.CourseWeekUtil;
import com.ceam.sport.vo.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author CeaM
 * 2023/02/19 11:56
 **/
@Slf4j
@Service
@AllArgsConstructor
public class AppHomeServiceImpl implements IAppHomeService {

    private final ICeamHomeNavService homeNavService;
    private final ICeamCoursePlanService coursePlanService;
    private final ICeamVipService vipService;
    private final ICeamCoachService coachService;

    @Override
    public Object getHome() {
        List<CeamHomeNavVO> ceamHomeNavVOS = homeNavService.listCeamHomeNavVO();
        Map<String, Object> map = new HashMap<>();
        map.put("navs", ceamHomeNavVOS);
        // 查询出所有课程

        List<CeamCoursePlanVO> coursePlanVOS = coursePlanService.listCeamCoursePlanVO();
        Map<Integer, List<CeamCoursePlanVO>> courseMap = coursePlanVOS.stream()
                .collect(Collectors.groupingBy(CeamCoursePlanVO::getWeekday));

        List<CeamVipVO> ceamVipVOS = vipService.listCeamVipVO();

        List<CeamCoachVO> ceamCoachVOS = coachService.listCeamCoachVO();

        map.put("coachList", ceamCoachVOS);

        map.put("vips", ceamVipVOS);

        map.put("courseMap", courseMap);
        map.put("navDayList", CourseWeekUtil.navDayList());

        return map;
    }

}
