package com.ceam.sport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.utils.BeanCopyUtil;
import com.ceam.common.utils.PageVOUtil;
import com.ceam.sport.entity.CeamCoach;
import com.ceam.sport.mapper.CeamCoachMapper;
import com.ceam.sport.service.ICeamCoachService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.sport.vo.CeamCoachVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 教练表 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
@Service
public class CeamCoachServiceImpl
        extends ServiceImpl<CeamCoachMapper, CeamCoach> implements ICeamCoachService {

    @Override
    public List<CeamCoachVO> listCeamCoachVO() {
        LambdaQueryWrapper<CeamCoach> queryWrapper = Wrappers.<CeamCoach>lambdaQuery()
                .eq(CeamCoach::getDeleted, GlobalConstants.FALSE);
        List<CeamCoach> ceamCoaches = baseMapper.selectList(queryWrapper);
        List<CeamCoachVO> ceamCoachVOS = BeanCopyUtil.copyListProperties(ceamCoaches, CeamCoachVO.class);

        return ceamCoachVOS;
    }

    @Override
    public IPage<CeamCoachVO> page(PageableDTO pageableDTO) {
        LambdaQueryWrapper<CeamCoach> queryWrapper = Wrappers.<CeamCoach>lambdaQuery()
                .eq(CeamCoach::getDeleted, GlobalConstants.FALSE);
        Page<CeamCoach> page = new Page<>();
        page.setCurrent((long)pageableDTO.getPage() + 1);

        Page<CeamCoach> ceamCustomerLevelPage = this.baseMapper.selectPage(page, queryWrapper);
        IPage<CeamCoachVO> pageVO = PageVOUtil
                .copyToPageVO(ceamCustomerLevelPage, CeamCoachVO.class);
        return pageVO;
    }
}
