package com.ceam.sport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.utils.BeanCopyUtil;
import com.ceam.common.utils.ObjectUtils;
import com.ceam.common.utils.PageVOUtil;
import com.ceam.sport.entity.CeamVip;
import com.ceam.sport.mapper.CeamVipMapper;
import com.ceam.sport.service.ICeamVipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.sport.vo.CeamVipVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * <p>
 * 会员卡 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-19
 */
@Service
public class CeamVipServiceImpl
        extends ServiceImpl<CeamVipMapper, CeamVip> implements ICeamVipService {

    @Override
    public List<CeamVipVO> listCeamVipVO() {
        LambdaQueryWrapper<CeamVip> wrapper = Wrappers.<CeamVip>lambdaQuery()
                .eq(CeamVip::getDeleted, GlobalConstants.FALSE);
        List<CeamVip> ceamVips = baseMapper.selectList(wrapper);
        List<CeamVipVO> ceamVipVOS = BeanCopyUtil.copyListProperties(ceamVips, CeamVipVO.class);

        ceamVipVOS.forEach(item -> {
            if (ObjectUtils.isNotEmpty(item.getDiscount())) {
                BigDecimal amount = item.getAmount();
                BigDecimal discount = item.getDiscount();
                BigDecimal discountAmount = amount.multiply(discount);
                item.setDiscountAmount(discountAmount.setScale(0, RoundingMode.HALF_UP));
            }
        });
        return ceamVipVOS;
    }

    @Override
    public IPage<CeamVipVO> page(PageableDTO pageableDTO) {

        LambdaQueryWrapper<CeamVip> queryWrapper = Wrappers.<CeamVip>lambdaQuery()
                .eq(CeamVip::getDeleted, GlobalConstants.FALSE);
        Page<CeamVip> page = new Page<>();
        page.setCurrent((long)pageableDTO.getPage() + 1);
        Page<CeamVip> ceamVipPage = baseMapper.selectPage(page, queryWrapper);
        return PageVOUtil.copyToPageVO(ceamVipPage, CeamVipVO.class);
    }
}
