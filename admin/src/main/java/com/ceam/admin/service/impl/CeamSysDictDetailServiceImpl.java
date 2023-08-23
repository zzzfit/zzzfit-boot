package com.ceam.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.CeamSysDictDetailDTO;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.admin.entity.CeamSysDictDetail;
import com.ceam.admin.mapper.CeamSysDictDetailMapper;
import com.ceam.admin.service.ICeamSysDictDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.admin.vo.CeamSysDictDetailVO;
import com.ceam.common.constants.GlobalConstants;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典详情 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-01-29
 */
@Service
public class CeamSysDictDetailServiceImpl extends ServiceImpl<CeamSysDictDetailMapper, CeamSysDictDetail> implements ICeamSysDictDetailService {

    @Override
    public IPage<CeamSysDictDetailVO> pageCeamSysDictDetailVO(CeamSysDictDetailDTO data,
                                                              PageableDTO pageableDTO) {

        Page<CeamSysDictDetailVO> page = new Page<>();
        page.setCurrent(pageableDTO.getPage() + GlobalConstants.ONE);
        return baseMapper.pageCeamSysDictDetailVO(data.getDictName(), page);
    }
}
