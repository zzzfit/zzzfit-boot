package com.ceam.sport.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ceam.common.constants.GlobalConstants;
import com.ceam.common.exception.ServiceException;
import com.ceam.common.utils.ObjectUtils;
import com.ceam.common.utils.SecurityUtils;
import com.ceam.sport.entity.CeamComments;
import com.ceam.sport.mapper.CeamCommentsMapper;
import com.ceam.sport.service.ICeamCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.sport.vo.CeamCommentsVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-23
 */
@Service
public class CeamCommentsServiceImpl
        extends ServiceImpl<CeamCommentsMapper, CeamComments> implements ICeamCommentsService {

    @Override
    public List<CeamCommentsVO> listComments(Integer type, Long coachId, Long storeId) {
        List<CeamCommentsVO> ceamCommentsVOS = baseMapper.listComments(type, coachId, storeId);
        return ceamCommentsVOS;
    }
}
