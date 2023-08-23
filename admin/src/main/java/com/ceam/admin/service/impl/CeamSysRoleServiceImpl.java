package com.ceam.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.CeaMSysRoleDTO;
import com.ceam.admin.dto.MenuDTO;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.admin.dto.RoleDTO;
import com.ceam.admin.entity.CeamRoleMenu;
import com.ceam.admin.entity.CeamSysRole;
import com.ceam.admin.mapper.CeamSysRoleMapper;
import com.ceam.admin.service.ICeamRoleMenuService;
import com.ceam.admin.service.ICeamSysMenuService;
import com.ceam.admin.service.ICeamSysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.admin.vo.CeaMSysRoleVO;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.exception.ServiceException;
import com.ceam.common.utils.PageVOUtil;
import com.ceam.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-01-28
 */
@Slf4j
@Service
@AllArgsConstructor
public class CeamSysRoleServiceImpl extends ServiceImpl<CeamSysRoleMapper, CeamSysRole> implements ICeamSysRoleService {

    private ICeamSysMenuService ceamSysMenuService;
    private ICeamRoleMenuService ceamRoleMenuService;

    @Override
    public IPage<CeaMSysRoleVO> pageCeaMSysRoleVO(PageableDTO pageable) {
        LambdaQueryWrapper<CeamSysRole> queryWrapper = Wrappers.<CeamSysRole>lambdaQuery()
                .eq(CeamSysRole::getDeleted, GlobalConstants.FALSE);
        Page<CeamSysRole> page = new Page<>(pageable.getPage(), pageable.getSize());
        // 手动设置当前页，不然分页失效
        page.setCurrent((long)pageable.getPage() + GlobalConstants.ONE);
        Page<CeamSysRole> ceamSysRolePage = page(page, queryWrapper);
        IPage<CeaMSysRoleVO> ceaMSysRoleVOIPage = PageVOUtil.copyToPageVO(ceamSysRolePage, CeaMSysRoleVO.class);

        for (CeaMSysRoleVO role : ceaMSysRoleVOIPage.getRecords()) {

            List<MenuDTO> menuDTOS = ceamSysMenuService.findByRoleId(role.getId(), GlobalConstants.ZERO);
            role.setMenus(menuDTOS);
        }

        return ceaMSysRoleVOIPage;
    }

    @Override
    public Collection<SimpleGrantedAuthority> grantedAuthorities(Long userId) {
        List<RoleDTO> roleItemDTOS = this.baseMapper.listByUserId(userId);
        if (CollectionUtils.isEmpty(roleItemDTOS)) {
            throw new ServiceException("没有分配角色");
        }

        List<MenuDTO> menuDTOS = ceamSysMenuService.findByRoles(roleItemDTOS.get(0).getId(), GlobalConstants.ZERO);

        // 角色
        Set<String> permissions = roleItemDTOS.stream()
                .filter(role -> StringUtils.isNotBlank(role.getName()))
                .map(RoleDTO::getName).collect(Collectors.toSet());
        permissions.addAll(
                menuDTOS.stream()
                        .filter(menu -> StringUtils.isNotBlank(menu.getPermission()))
                        .map(MenuDTO::getPermission).collect(Collectors.toSet())
        );

        return permissions.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoleDTO> listByUserId(Long userId) {
        return this.baseMapper.listByUserId(userId);
    }

    @Override
    public void updateMenu(CeaMSysRoleDTO roleDTO, CeamSysRole role) {
        if (roleDTO.getMenus().size() > 0) {
            List<CeamRoleMenu> rolesMenusList = roleDTO.getMenus().stream().map(i -> {
                CeamRoleMenu rolesMenus = new CeamRoleMenu();
                rolesMenus.setRoleId(roleDTO.getId());
                rolesMenus.setMenuId(i.getId());
                return rolesMenus;
            }).collect(Collectors.toList());
            ceamRoleMenuService.remove(new LambdaQueryWrapper<CeamRoleMenu>()
                    .eq(CeamRoleMenu::getRoleId, roleDTO.getId()));
            ceamRoleMenuService.saveBatch(rolesMenusList);
        }
    }
}
