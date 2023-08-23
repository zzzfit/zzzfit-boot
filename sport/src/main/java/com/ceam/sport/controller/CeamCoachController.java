package com.ceam.sport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.service.ICeamCoachService;
import com.ceam.sport.vo.CeamCoachVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 教练表 前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/coach")
public class CeamCoachController {

    private final ICeamCoachService coachService;

    @GetMapping
    public ResponseEntity<Object> page(PageableDTO pageableDTO) {
        IPage<CeamCoachVO> page = coachService.page(pageableDTO);
        return ResponseEntity.ok(page);
    }
}
