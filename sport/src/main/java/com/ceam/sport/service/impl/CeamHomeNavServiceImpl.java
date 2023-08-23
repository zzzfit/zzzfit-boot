package com.ceam.sport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.utils.BeanCopyUtil;
import com.ceam.common.utils.PageVOUtil;
import com.ceam.sport.entity.CeamHomeNav;
import com.ceam.sport.mapper.CeamHomeNavMapper;
import com.ceam.sport.service.ICeamHomeNavService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.sport.vo.CeamHomeNavVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-19
 */
@Service
public class CeamHomeNavServiceImpl
        extends ServiceImpl<CeamHomeNavMapper, CeamHomeNav> implements ICeamHomeNavService {


    @Override
    public List<CeamHomeNavVO> listCeamHomeNavVO() {
        LambdaQueryWrapper<CeamHomeNav> wrapper = Wrappers.<CeamHomeNav>lambdaQuery()
                .eq(CeamHomeNav::getDeleted, GlobalConstants.FALSE)
                .eq(CeamHomeNav::getIsShow, GlobalConstants.TRUE);
        List<CeamHomeNav> ceamHomeNavs = baseMapper.selectList(wrapper);
        List<CeamHomeNavVO> ceamHomeNavVOS = BeanCopyUtil
                .copyListProperties(ceamHomeNavs, CeamHomeNavVO.class);
        return ceamHomeNavVOS;
    }

    @Override
    public IPage<CeamHomeNavVO> page(PageableDTO pageableDTO) {
        LambdaQueryWrapper<CeamHomeNav> queryWrapper = Wrappers.<CeamHomeNav>lambdaQuery()
                .eq(CeamHomeNav::getDeleted, GlobalConstants.FALSE);
        Page<CeamHomeNav> page = new Page<>();
        page.setCurrent((long)pageableDTO.getPage() + 1);
        Page<CeamHomeNav> ceamHomeNavPage = baseMapper.selectPage(page, queryWrapper);
        IPage<CeamHomeNavVO> ceamHomeNavVOIPage = PageVOUtil
                .copyToPageVO(ceamHomeNavPage, CeamHomeNavVO.class);
        return ceamHomeNavVOIPage;
    }
}
