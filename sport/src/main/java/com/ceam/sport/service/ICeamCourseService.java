package com.ceam.sport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.entity.CeamCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.sport.vo.CeamCourseVO;

/**
 * <p>
 * 课程表 服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-20
 */
public interface ICeamCourseService extends IService<CeamCourse> {

    IPage<CeamCourseVO> page(PageableDTO pageableDTO);
}
