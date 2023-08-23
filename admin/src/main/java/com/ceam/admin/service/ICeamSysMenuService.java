package com.ceam.admin.service;

import com.ceam.admin.dto.MenuDTO;
import com.ceam.admin.dto.RoleDTO;
import com.ceam.admin.entity.CeamSysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.admin.vo.MenuVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-01-28
 */
public interface ICeamSysMenuService extends IService<CeamSysMenu> {

    List<MenuDTO> findByRoles(Long id, Integer type);

    List<MenuDTO> findByRoleId(Long roleId, Integer type);

    List<CeamSysMenu> listAllMenu();

    /**
     * 根据pid查询
     * @param pid /
     * @return /
     */
    List<CeamSysMenu> findByPid(long pid);

    Object getMenuTree(List<CeamSysMenu> menus);

    /**
     * 构建菜单树
     * @param menuDTOs 原始数据
     * @return /
     */
    Map<String, Object> buildTree(List<MenuDTO> menuDTOs);

    /**
     * 构建菜单树
     * @param menuDTOs /
     * @return /
     */
    List<MenuVO> buildMenus(List<MenuDTO> menuDTOs);

    void add(MenuDTO menuDTO);

    void edit(MenuDTO menuDTO);
}
