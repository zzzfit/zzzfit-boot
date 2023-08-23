package com.ceam.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.admin.entity.CeamSysJob;
import com.ceam.admin.mapper.CeamSysJobMapper;
import com.ceam.admin.service.ICeamSysJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.admin.vo.CeamSysJobVO;
import com.ceam.common.constants.GlobalConstants;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-01-29
 */
@Service
public class CeamSysJobServiceImpl extends ServiceImpl<CeamSysJobMapper, CeamSysJob> implements ICeamSysJobService {

    @Override
    public IPage<CeamSysJobVO> pageCeamSysJobVO(PageableDTO pageableDTO) {
        Page<CeamSysJobVO> page = new Page<>();
        page.setCurrent((pageableDTO.getPage()) + GlobalConstants.ONE);
        page.setSize(pageableDTO.getSize());
        IPage<CeamSysJobVO> ceamSysJobVOIPage = baseMapper.pageCeamSysJobVO(page);
        return ceamSysJobVOIPage;
    }
}
