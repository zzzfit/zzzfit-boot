package com.ceam.sport.mapper;

import com.ceam.sport.entity.CeamCoursePlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceam.sport.map.CoursePlanResultMap;
import com.ceam.sport.vo.CeamCoursePlanVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 排课 Mapper 接口
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
public interface CeamCoursePlanMapper extends BaseMapper<CeamCoursePlan> {

    List<CoursePlanResultMap> listCeamCoursePlanVO();

    CoursePlanResultMap getCeamCoursePlanVO(@Param("id") Long id);
}
