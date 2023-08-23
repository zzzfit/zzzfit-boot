package com.ceam.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.admin.service.ICeamSysJobService;
import com.ceam.admin.vo.CeamSysJobVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 岗位 前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-01-29
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/job")
public class CeamSysJobController {

    private final ICeamSysJobService ceamSysJobService;

    @GetMapping
    public ResponseEntity<IPage<CeamSysJobVO>> page(PageableDTO pageableDTO) {
        IPage<CeamSysJobVO> ceamSysJobVOIPage = ceamSysJobService.pageCeamSysJobVO(pageableDTO);
        return ResponseEntity.ok(ceamSysJobVOIPage);
    }
}
