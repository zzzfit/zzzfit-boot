package com.ceam.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.admin.entity.CeamSysDict;
import com.ceam.admin.entity.CeamSysUser;
import com.ceam.admin.mapper.CeamSysDictMapper;
import com.ceam.admin.service.ICeamSysDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.admin.vo.CeaMSysUserVO;
import com.ceam.admin.vo.CeamSysDictVO;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.utils.PageVOUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-01-29
 */
@Service
public class CeamSysDictServiceImpl extends ServiceImpl<CeamSysDictMapper, CeamSysDict> implements ICeamSysDictService {

    @Override
    public IPage<CeamSysDictVO> pageCeamSysDictVO(PageableDTO pageableDTO) {
        LambdaQueryWrapper<CeamSysDict> queryWrapper = Wrappers.<CeamSysDict>lambdaQuery()
                .eq(CeamSysDict::getDeleted, GlobalConstants.FALSE);
        Page<CeamSysDict> page = new Page<>(pageableDTO.getPage(), pageableDTO.getSize());
        page.setCurrent((long)pageableDTO.getPage() + 1);
        Page<CeamSysDict> CeamSysDictPage = page(page, queryWrapper);
        IPage<CeamSysDictVO> ceamSysDictVOIPage = PageVOUtil.copyToPageVO(CeamSysDictPage, CeamSysDictVO.class);
        return ceamSysDictVOIPage;
    }
}
