package com.ceam.sport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.admin.dto.PageableDTO;
import com.ceam.sport.entity.CeamVip;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.sport.vo.CeamVipVO;

import java.util.List;

/**
 * <p>
 * 会员卡 服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-02-19
 */
public interface ICeamVipService extends IService<CeamVip> {

    List<CeamVipVO> listCeamVipVO();

    IPage<CeamVipVO> page(PageableDTO pageableDTO);
}
