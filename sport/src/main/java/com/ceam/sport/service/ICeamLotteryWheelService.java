package com.ceam.sport.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.sport.dto.CeamLotteryWheelDTO;
import com.ceam.sport.entity.CeamLotteryWheel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.sport.vo.CeamLotteryWheelVO;
import com.ceam.sport.vo.UniLotteryWheel;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-05-22
 */
public interface ICeamLotteryWheelService extends IService<CeamLotteryWheel> {

    IPage<CeamLotteryWheelVO> page(CeamLotteryWheelDTO data);

    List<UniLotteryWheel> listBy();

    boolean add(CeamLotteryWheelDTO data);

    boolean edit(CeamLotteryWheelDTO data);

    boolean remove(Set<Long> ids);
}
