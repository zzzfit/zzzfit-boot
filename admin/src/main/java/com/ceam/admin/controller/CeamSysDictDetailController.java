package com.ceam.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.CeamSysDictDetailDTO;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.admin.service.ICeamSysDictDetailService;
import com.ceam.admin.vo.CeamSysDictDetailVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据字典详情 前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-01-29
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/dictDetail")
public class CeamSysDictDetailController {

    private final ICeamSysDictDetailService ceamSysDictDetailService;

    @GetMapping
    public ResponseEntity<Object> page(CeamSysDictDetailDTO data, PageableDTO pageableDTO) {
        IPage<CeamSysDictDetailVO> ceamSysDictDetailVOIPage = ceamSysDictDetailService
                .pageCeamSysDictDetailVO(data, pageableDTO);
        return ResponseEntity.ok(ceamSysDictDetailVOIPage);
    }
}
