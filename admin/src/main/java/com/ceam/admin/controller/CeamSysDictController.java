package com.ceam.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.admin.service.ICeamSysDictService;
import com.ceam.admin.vo.CeamSysDictVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-01-29
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/dict")
public class CeamSysDictController {

    private final ICeamSysDictService ceamSysDictService;

    @GetMapping
    public ResponseEntity<IPage<CeamSysDictVO>> t(PageableDTO pageableDTO) {
        IPage<CeamSysDictVO> ceamSysDictVOIPage = ceamSysDictService.pageCeamSysDictVO(pageableDTO);
        return ResponseEntity.ok(ceamSysDictVOIPage);
    }
}
