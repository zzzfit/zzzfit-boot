package com.ceam.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.CeaMSysUserDTO;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.admin.service.ICeamSysUserService;
import com.ceam.admin.vo.CeaMSysUserVO;
import com.ceam.common.exception.ServiceException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author CeaM
 * 2023/01/27 10:31
 **/
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class CeamSysUserController {

    private final ICeamSysUserService ceamSysUserService;

    @GetMapping
    public ResponseEntity page(PageableDTO pageableDTO) {
        IPage<CeaMSysUserVO> ceaMSysUserVOIPage = ceamSysUserService.pageCeaMSysUserVO(pageableDTO);
        return ResponseEntity.ok(ceaMSysUserVOIPage);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody CeaMSysUserDTO data) {
        ceamSysUserService.add(data);
        return ResponseEntity.ok("成功");
    }

    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody CeaMSysUserDTO data) {
        ceamSysUserService.edit(data);
        return ResponseEntity.ok("成功");
    }

    @DeleteMapping
    public ResponseEntity<Object> add(@RequestParam String id) {
        ceamSysUserService.remove(Long.parseLong(id));
        return ResponseEntity.ok("成功");
    }
}
