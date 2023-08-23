package com.ceam.sport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.service.ICeamCouponService;
import com.ceam.sport.vo.CeamCouponVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 优惠券信息及规则表 前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-02-21
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/coupon")
public class CeamCouponController {

    private final ICeamCouponService couponService;

    @GetMapping
    public ResponseEntity<Object> page(PageableDTO pageableDTO) {
        IPage<CeamCouponVO> page = couponService.page(pageableDTO);
        return ResponseEntity.ok(page);
    }
}
