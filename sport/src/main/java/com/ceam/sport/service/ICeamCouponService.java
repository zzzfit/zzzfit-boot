package com.ceam.sport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.entity.CeamCoupon;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.sport.vo.CeamCouponVO;

/**
 * <p>
 * 优惠券信息及规则表 服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-21
 */
public interface ICeamCouponService extends IService<CeamCoupon> {

    IPage<CeamCouponVO> page(PageableDTO pageableDTO);
}
