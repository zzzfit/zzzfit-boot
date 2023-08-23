package com.ceam.sport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.exception.ServiceException;
import com.ceam.common.utils.BeanCopyUtil;
import com.ceam.common.utils.DateUtils;
import com.ceam.common.utils.ObjectUtils;
import com.ceam.common.utils.SecurityUtils;
import com.ceam.sport.entity.CeamCoursePlan;
import com.ceam.sport.map.CoursePlanResultMap;
import com.ceam.sport.mapper.CeamCoursePlanMapper;
import com.ceam.sport.service.ICeamCommentsService;
import com.ceam.sport.service.ICeamCoursePlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.sport.utils.CourseWeekUtil;
import com.ceam.sport.vo.CeamBuyCourseVO;
import com.ceam.sport.vo.CeamCommentsVO;
import com.ceam.sport.vo.CeamCoursePlanVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 排课 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
@Service
@AllArgsConstructor
public class CeamCoursePlanServiceImpl
        extends ServiceImpl<CeamCoursePlanMapper, CeamCoursePlan> implements ICeamCoursePlanService {

    private final ICeamCommentsService commentsService;

    @Override
    public List<CeamCoursePlanVO> listCeamCoursePlanVO() {
        // 几号
        int day = DateUtils.day();
        // 周几
        int weekday = DateUtils.weekday();

        // 查询出课程信息
        List<CoursePlanResultMap> coursePlanResultMaps = baseMapper.listCeamCoursePlanVO();
        List<CeamCoursePlanVO> coursePlanVOS = BeanCopyUtil
                .copyListProperties(coursePlanResultMaps, CeamCoursePlanVO.class);

        Map<Integer, Object> map = new HashMap<>();

        Map<Integer, List<CeamCoursePlanVO>> courseMap = coursePlanVOS.stream()
                .collect(Collectors.groupingBy(CeamCoursePlanVO::getWeekday));

        return coursePlanVOS;
    }

    @Override
    public CeamBuyCourseVO getCeamCoursePlanVO(Long id) {
        Long userId = SecurityUtils.getUserId();
        if (ObjectUtils.isEmpty(userId)) {
            //throw new ServiceException("用户未登录");
        }
        CoursePlanResultMap coursePlanResultMap = baseMapper.getCeamCoursePlanVO(id);
        CeamBuyCourseVO buyCourseVO = BeanCopyUtil
                .copyProperties(coursePlanResultMap, CeamBuyCourseVO.class);
        buyCourseVO.setWeekName(CourseWeekUtil.longWeekMap(buyCourseVO.getWeekday()));
        // 如果今天，明天不遍历
        CourseWeekUtil.navDayList().forEach(item -> {
            if (item.getWeekDay() == buyCourseVO.getWeekday()) {
                int month = LocalDate.now().getMonth().getValue();
                String monthDay = month + "/" + item.getDay();
                buyCourseVO.setMonthDay(monthDay);
            }
        });

        List<CeamCommentsVO> ceamCommentsVOS = commentsService
                .listComments(GlobalConstants.ONE, buyCourseVO.getCoachId(), GlobalConstants.LONG_ONE);

        buyCourseVO.setComments(ceamCommentsVOS);

        return buyCourseVO;
    }
}
