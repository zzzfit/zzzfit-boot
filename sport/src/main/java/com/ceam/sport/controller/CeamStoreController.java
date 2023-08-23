package com.ceam.sport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.service.ICeamStoreService;
import com.ceam.sport.vo.CeamStoreVO;
import com.ceam.sport.vo.StoreDetailVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 门店表 前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/store")
public class CeamStoreController {

    private final ICeamStoreService storeService;

    @GetMapping("detail")
    public ResponseEntity<Object> storeDetail(@RequestParam String storeId) {
        StoreDetailVO storeDetail = storeService.getStoreDetail(Long.parseLong(storeId));
        return ResponseEntity.ok(storeDetail);
    }

    @GetMapping("appList")
    public ResponseEntity<Object> appList() {
        List<CeamStoreVO> ceamStoreVOS = storeService.listCeamStoreVO();
        return ResponseEntity.ok(ceamStoreVOS);
    }

    @GetMapping
    public ResponseEntity<Object> page(PageableDTO pageableDTO) {
        IPage<CeamStoreVO> page = storeService.page(pageableDTO);
        return ResponseEntity.ok(page);
    }
}
