package com.ceam.sport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.service.ICeamHomeNavService;
import com.ceam.sport.vo.CeamHomeNavVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-02-19
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/homeNav")
public class CeamHomeNavController {

    private final ICeamHomeNavService homeNavService;

    @GetMapping
    public ResponseEntity<Object> page(PageableDTO pageableDTO) {
        IPage<CeamHomeNavVO> page = homeNavService.page(pageableDTO);
        return ResponseEntity.ok(page);
    }
}
