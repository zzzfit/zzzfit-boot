package com.ceam.sport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.service.ICeamCourseService;
import com.ceam.sport.vo.CeamCourseVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 课程表 前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-02-20
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/course")
public class CeamCourseController {

    private final ICeamCourseService courseService;

    @GetMapping
    public ResponseEntity<Object> page(PageableDTO pageableDTO) {
        IPage<CeamCourseVO> page = courseService.page(pageableDTO);
        return ResponseEntity.ok(page);
    }
}
