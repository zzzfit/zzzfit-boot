package com.ceam.sport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.utils.BeanCopyUtil;
import com.ceam.common.utils.PageVOUtil;
import com.ceam.common.utils.SecurityUtils;
import com.ceam.sport.dto.CeamLotteryWheelDTO;
import com.ceam.sport.entity.CeamLotteryWheel;
import com.ceam.sport.mapper.CeamLotteryWheelMapper;
import com.ceam.sport.service.ICeamLotteryWheelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.sport.vo.CeamLotteryWheelVO;
import com.ceam.sport.vo.UniLotteryWheel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-05-22
 */
@Service
public class CeamLotteryWheelServiceImpl
        extends ServiceImpl<CeamLotteryWheelMapper, CeamLotteryWheel> implements ICeamLotteryWheelService {

    @Override
    public IPage<CeamLotteryWheelVO> page(CeamLotteryWheelDTO data) {
        LambdaQueryWrapper<CeamLotteryWheel> queryWrapper = Wrappers.<CeamLotteryWheel>lambdaQuery()
                .eq(CeamLotteryWheel::getDeleted, GlobalConstants.FALSE);
        Page<CeamLotteryWheel> page = new Page<>();
        page.setCurrent((long)data.getPage() + 1);
        Page<CeamLotteryWheel> ceamLotteryWheelPage = baseMapper.selectPage(page, queryWrapper);
        IPage<CeamLotteryWheelVO> ceamLotteryWheelVOIPage = PageVOUtil
                .copyToPageVO(ceamLotteryWheelPage, CeamLotteryWheelVO.class);
        return ceamLotteryWheelVOIPage;
    }

    @Override
    public List<UniLotteryWheel> listBy() {
        LambdaQueryWrapper<CeamLotteryWheel> queryWrapper = Wrappers.<CeamLotteryWheel>lambdaQuery()
                .eq(CeamLotteryWheel::getDeleted, GlobalConstants.FALSE);
        queryWrapper.eq(CeamLotteryWheel::getActivityId, 1L);
        List<CeamLotteryWheel> ceamLotteryWheels = baseMapper.selectList(queryWrapper);
        List<UniLotteryWheel> list = new LinkedList<>();
        ceamLotteryWheels.forEach(item -> {
            UniLotteryWheel uniLotteryWheel = new UniLotteryWheel();
            uniLotteryWheel.setId(item.getId() + "" );
            uniLotteryWheel.setName(item.getName() == null ? "" : item.getName());
            uniLotteryWheel.setContent(item.getContent() == null ? "" : item.getContent());
            uniLotteryWheel.setSrc(item.getPicUrl() == null ? "" : item.getPicUrl());
            uniLotteryWheel.setBackgroundColor(item.getBgColor() == null ? "" : item.getBgColor());
            uniLotteryWheel.setColor(item.getColor() == null ? "" : item.getColor());
            list.add(uniLotteryWheel);
        });
        return list;
    }

    @Override
    public boolean add(CeamLotteryWheelDTO data) {
        CeamLotteryWheel ceamLotteryWheel = BeanCopyUtil.copyProperties(data, CeamLotteryWheel.class);
        ceamLotteryWheel.setAddBy(SecurityUtils.getUserId());
        ceamLotteryWheel.setAddTime(LocalDateTime.now());
        boolean b = updateById(ceamLotteryWheel);
        return b;
    }

    @Override
    public boolean edit(CeamLotteryWheelDTO data) {
        CeamLotteryWheel ceamLotteryWheel = BeanCopyUtil.copyProperties(data, CeamLotteryWheel.class);
        ceamLotteryWheel.setUpdBy(SecurityUtils.getUserId());
        ceamLotteryWheel.setUpdTime(LocalDateTime.now());
        boolean b = updateById(ceamLotteryWheel);
        return b;
    }

    @Override
    public boolean remove(Set<Long> ids) {
        // 活动进行中不做移除
        boolean b = removeBatchByIds(ids);
        return b;
    }
}
