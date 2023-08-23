package com.ceam.sport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.utils.PageVOUtil;
import com.ceam.sport.entity.CeamCustomer;
import com.ceam.sport.mapper.CeamCustomerMapper;
import com.ceam.sport.service.ICeamCustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.sport.vo.CeamCustomerVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-20
 */
@Service
public class CeamCustomerServiceImpl
        extends ServiceImpl<CeamCustomerMapper, CeamCustomer> implements ICeamCustomerService {

    @Override
    public IPage<CeamCustomerVO> page(PageableDTO pageableDTO) {
        LambdaQueryWrapper<CeamCustomer> queryWrapper = Wrappers.<CeamCustomer>lambdaQuery()
                .orderByDesc(CeamCustomer::getAddTime);
        Page<CeamCustomer> page = new Page<>();
        page.setCurrent((long)pageableDTO.getPage() + GlobalConstants.ONE);
        Page<CeamCustomer> ceamCommercialPage = this.baseMapper.selectPage(page, queryWrapper);
        IPage<CeamCustomerVO> pageVO = PageVOUtil
                .copyToPageVO(ceamCommercialPage, CeamCustomerVO.class);
        return pageVO;
    }
}
