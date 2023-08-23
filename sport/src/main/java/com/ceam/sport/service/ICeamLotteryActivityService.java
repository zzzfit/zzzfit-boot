package com.ceam.sport.service;

import com.ceam.sport.entity.CeamLotteryActivity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceam.sport.vo.LuckyResult;

/**
 * <p>
 * 活动信息 服务类
 * </p>
 *
 * @author CeaM
 * @since 2023-05-23
 */
public interface ICeamLotteryActivityService extends IService<CeamLotteryActivity> {

    LuckyResult lucky();
}
