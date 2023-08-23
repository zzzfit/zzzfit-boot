package com.ceam.sport.service;

import com.ceam.sport.entity.CeamCoursePlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.sport.vo.CeamBuyCourseVO;
import com.ceam.sport.vo.CeamCoursePlanVO;

import java.util.List;

/**
 * <p>
 * 排课 服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
public interface ICeamCoursePlanService extends IService<CeamCoursePlan> {

    List<CeamCoursePlanVO> listCeamCoursePlanVO();

    CeamBuyCourseVO getCeamCoursePlanVO(Long id);
}
