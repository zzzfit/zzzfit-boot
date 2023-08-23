package com.ceam.sport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.utils.PageVOUtil;
import com.ceam.sport.entity.CeamCourse;
import com.ceam.sport.mapper.CeamCourseMapper;
import com.ceam.sport.service.ICeamCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.sport.vo.CeamCourseVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-20
 */
@Service
public class CeamCourseServiceImpl
        extends ServiceImpl<CeamCourseMapper, CeamCourse> implements ICeamCourseService {

    @Override
    public IPage<CeamCourseVO> page(PageableDTO pageableDTO) {
        LambdaQueryWrapper<CeamCourse> queryWrapper = Wrappers.<CeamCourse>lambdaQuery()
                .eq(CeamCourse::getDeleted, GlobalConstants.FALSE);
        Page<CeamCourse> page = new Page<>();
        page.setCurrent((long)pageableDTO.getPage() + 1);
        Page<CeamCourse> ceamCoursePage = baseMapper.selectPage(page, queryWrapper);
        IPage<CeamCourseVO> ceamCourseVOIPage = PageVOUtil
                .copyToPageVO(ceamCoursePage, CeamCourseVO.class);
        return ceamCourseVOIPage;
    }
}
