package com.ceam.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.CeaMSysRoleDTO;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.admin.dto.RoleDTO;
import com.ceam.admin.entity.CeamSysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.admin.vo.CeaMSysRoleVO;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-01-28
 */
public interface ICeamSysRoleService extends IService<CeamSysRole> {

    IPage<CeaMSysRoleVO> pageCeaMSysRoleVO(PageableDTO pageable);

    /**
     * 获取用户权限信息
     * @param userId 用户信息
     * @return 权限信息
     */
    Collection<SimpleGrantedAuthority> grantedAuthorities(Long userId);

    /**
     *
     * @param userId 用户ID
     * @return RoleItemVOs
     */
    List<RoleDTO> listByUserId(Long userId);

    void updateMenu(CeaMSysRoleDTO roleDTO, CeamSysRole role);
}
