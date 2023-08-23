package com.ceam.admin.controller;


import com.ceam.admin.dto.CeamSysDeptDTO;
import com.ceam.admin.service.ICeamSysDeptService;
import com.ceam.common.utils.BeanCopyUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 部门 前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-01-29
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/dept")
public class CeamSysDeptController {

    private final ICeamSysDeptService ceamSysDeptService;

    @GetMapping
    public ResponseEntity<Object> getDeptTree() {
        List<CeamSysDeptDTO> deptDTOs = BeanCopyUtil
                .copyListProperties(ceamSysDeptService.queryAll(), CeamSysDeptDTO.class);
        return ResponseEntity.ok(ceamSysDeptService.buildTree(deptDTOs));
    }
}
