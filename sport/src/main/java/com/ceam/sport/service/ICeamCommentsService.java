package com.ceam.sport.service;

import com.ceam.sport.entity.CeamComments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.sport.vo.CeamCommentsVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-23
 */
public interface ICeamCommentsService extends IService<CeamComments> {

    List<CeamCommentsVO> listComments(Integer type, Long coachId, Long storeId);
}
