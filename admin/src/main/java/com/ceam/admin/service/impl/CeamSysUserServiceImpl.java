package com.ceam.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.CeaMSysUserDTO;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.admin.entity.CeamSysRole;
import com.ceam.admin.entity.CeamSysUser;
import com.ceam.admin.mapper.CeamSysUserMapper;
import com.ceam.admin.service.ICeamSysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.admin.vo.CeaMSysRoleVO;
import com.ceam.admin.vo.CeaMSysUserVO;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.exception.ServiceException;
import com.ceam.common.utils.BeanCopyUtil;
import com.ceam.common.utils.ObjectUtils;
import com.ceam.common.utils.PageVOUtil;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-01-28
 */
@Service
public class CeamSysUserServiceImpl
        extends ServiceImpl<CeamSysUserMapper, CeamSysUser> implements ICeamSysUserService {

    @Override
    public IPage<CeaMSysUserVO> pageCeaMSysUserVO(PageableDTO pageableDTO) {
        LambdaQueryWrapper<CeamSysUser> queryWrapper = Wrappers.<CeamSysUser>lambdaQuery()
                .eq(CeamSysUser::getDeleted, GlobalConstants.FALSE);
        Page<CeamSysUser> page = new Page<>(pageableDTO.getPage(), pageableDTO.getSize());
        page.setCurrent((long)pageableDTO.getPage()  + GlobalConstants.ONE);
        Page<CeamSysUser> ceamSysUserPage = page(page, queryWrapper);
        IPage<CeaMSysUserVO> ceaMSysUserVOIPage = PageVOUtil.copyToPageVO(ceamSysUserPage, CeaMSysUserVO.class);
        return ceaMSysUserVOIPage;
    }

    @Override
    public CeaMSysUserDTO loadUserInfo(String userName) {
        LambdaQueryWrapper<CeamSysUser> queryWrapper = Wrappers.<CeamSysUser>lambdaQuery()
                .eq(CeamSysUser::getUsername, userName);
        CeamSysUser ceamSysUser = baseMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(ceamSysUser)) {
            throw new ServiceException("账号不存在");
        }
        if (ceamSysUser.getStatus() == GlobalConstants.ONE) {
            throw new ServiceException("账号已禁用");
        }
        CeaMSysUserDTO ceaMSysUserDTO = BeanCopyUtil.copyProperties(ceamSysUser, CeaMSysUserDTO.class);
        return ceaMSysUserDTO;
    }

    @Override
    public void add(CeaMSysUserDTO data) {
        CeamSysUser ceamSysUser = BeanCopyUtil.copyProperties(data, CeamSysUser.class);
        save(ceamSysUser);
    }

    @Override
    public void edit(CeaMSysUserDTO data) {
        CeamSysUser ceamSysUser = BeanCopyUtil.copyProperties(data, CeamSysUser.class);
        updateById(ceamSysUser);
    }

    @Override
    public void remove(Long id) {
        removeById(id);
    }
}
