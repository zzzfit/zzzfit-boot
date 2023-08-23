package com.ceam.admin.controller;


import com.ceam.admin.dto.CeaMSysUserDTO;
import com.ceam.admin.dto.MenuDTO;
import com.ceam.admin.entity.CeamSysMenu;
import com.ceam.admin.service.ICeamSysMenuService;
import com.ceam.admin.service.ICeamSysRoleService;
import com.ceam.admin.service.ICeamSysUserService;
import com.ceam.admin.vo.MenuVO;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.utils.BeanCopyUtil;
import com.ceam.common.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-01-28
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/menus")
public class CeamSysMenuController {

    private final ICeamSysMenuService menuService;
    private final ICeamSysUserService userInfoService;
    private final ICeamSysRoleService roleInfoService;

    @GetMapping(value = "/build")
    public ResponseEntity<Object> buildMenus() {
        log.info("build0000[0000000]");
        CeaMSysUserDTO ceaMSysUserDTO = userInfoService.loadUserInfo(SecurityUtils.getUsername());
        List<MenuDTO> menuDtoList = menuService
                .findByRoles(roleInfoService.listByUserId(ceaMSysUserDTO.getId()).get(0).getId(), GlobalConstants.ONE);
        log.info("menuDtoList===【{}】", menuDtoList);
        List<MenuDTO> menuDTOs = (List<MenuDTO>) menuService.buildTree(menuDtoList).get("records");
        log.info("menuDTOs===【{}】", menuDTOs);
        List<MenuVO> menuVOS = menuService.buildMenus(menuDTOs);
        log.info("菜单数据000===【{}】", menuVOS);
        return ResponseEntity.ok(menuVOS);
    }

    @GetMapping
    public ResponseEntity<Object> listMenus() {

        List<CeamSysMenu> menuDtoList = menuService.listAllMenu();
        List<MenuDTO> menuDTOS = BeanCopyUtil.copyListProperties(menuDtoList, MenuDTO.class);
        Map<String, Object> map = menuService.buildTree(menuDTOS);
        return ResponseEntity.ok(map);
    }

    @GetMapping("tree")
    public ResponseEntity tree() {
        Object menuTree = menuService.getMenuTree(menuService.findByPid(0L));
        return ResponseEntity.ok(menuTree);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody MenuDTO menuDTO) {
        menuService.add(menuDTO);
        return ResponseEntity.ok("");
    }

    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody MenuDTO menuDTO) {
        menuService.edit(menuDTO);
        return ResponseEntity.ok("");
    }
}
