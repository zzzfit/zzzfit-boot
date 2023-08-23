package com.ceam.sport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.service.ICeamVipService;
import com.ceam.sport.vo.CeamVipVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 会员卡 前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-02-19
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/vip")
public class CeamVipController {

    private final ICeamVipService vipService;

    @GetMapping
    public ResponseEntity<Object> page(PageableDTO pageableDTO) {
        IPage<CeamVipVO> page = vipService.page(pageableDTO);
        return ResponseEntity.ok(page);
    }
}
