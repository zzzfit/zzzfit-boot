package com.ceam.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.CeaMSysUserDTO;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.admin.entity.CeamSysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.admin.vo.CeaMSysUserVO;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-01-28
 */
public interface ICeamSysUserService extends IService<CeamSysUser> {

    /**
     * 分页查询
     *
     * @param pageableDTO 分页入参
     * @return 分页数据
     */
    IPage<CeaMSysUserVO> pageCeaMSysUserVO(PageableDTO pageableDTO);

    /**
     * 根据账号加载用户信息
     *
     * @param userName 用户账号
     * @return CeaMSysUserDTO
     */
    CeaMSysUserDTO loadUserInfo(String userName);

    /**
     * 添加用户
     *
     * @param data 前端入参
     */
    void add(CeaMSysUserDTO data);

    /**
     * 修改用户
     *
     * @param data 前端入参
     */
    void edit(CeaMSysUserDTO data);

    /**
     * 根据用户ID删除用户
     *
     * @param id userId
     */
    void remove(Long id);
}
