package com.ceam.sport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.utils.PageVOUtil;
import com.ceam.sport.entity.CeamCoupon;
import com.ceam.sport.mapper.CeamCouponMapper;
import com.ceam.sport.service.ICeamCouponService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.sport.vo.CeamCouponVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券信息及规则表 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-21
 */
@Service
public class CeamCouponServiceImpl
        extends ServiceImpl<CeamCouponMapper, CeamCoupon> implements ICeamCouponService {

    @Override
    public IPage<CeamCouponVO> page(PageableDTO pageableDTO) {
        LambdaQueryWrapper<CeamCoupon> queryWrapper = Wrappers.<CeamCoupon>lambdaQuery()
                .eq(CeamCoupon::getDeleted, GlobalConstants.FALSE);
        Page<CeamCoupon> page = new Page<>();
        page.setCurrent((long)pageableDTO.getPage() + 1);
        Page<CeamCoupon> ceamCouponPage = baseMapper.selectPage(page, queryWrapper);
        IPage<CeamCouponVO> ceamCouponVOIPage = PageVOUtil
                .copyToPageVO(ceamCouponPage, CeamCouponVO.class);
        return ceamCouponVOIPage;
    }
}
