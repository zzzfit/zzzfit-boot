package com.ceam.sport.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ceam.common.exception.ServiceException;
import com.ceam.sport.entity.CeamLotteryActivity;
import com.ceam.sport.entity.CeamLotteryWheel;
import com.ceam.sport.mapper.CeamLotteryActivityMapper;
import com.ceam.sport.service.ICeamLotteryActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceam.sport.service.ICeamLotteryWheelService;
import com.ceam.sport.vo.LuckyResult;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 活动信息 服务实现类
 * </p>
 *
 * @author CeaM
 * @since 2023-05-23
 */
@Slf4j
@Service
@AllArgsConstructor
public class CeamLotteryActivityServiceImpl
        extends ServiceImpl<CeamLotteryActivityMapper, CeamLotteryActivity> implements ICeamLotteryActivityService {

    private final ICeamLotteryWheelService lotteryWheelService;

    @Override
    public LuckyResult lucky() {
        LambdaQueryWrapper<CeamLotteryActivity> queryWrapper = Wrappers.<CeamLotteryActivity>lambdaQuery()
                .orderByDesc(CeamLotteryActivity::getAddTime);
        CeamLotteryActivity ceamLotteryActivity = baseMapper.selectOne(queryWrapper);
        Map<String, Object> map = angles(ceamLotteryActivity);
        LuckyResult luckyResult = new LuckyResult();
        luckyResult.setAngles(BigDecimal.valueOf((double)map.get("angles")));
        luckyResult.setPrizeName((String)map.get("prizeName"));
        return luckyResult;
    }

    // 计算角度
    private Map<String, Object> angles(CeamLotteryActivity ceamLotteryActivity) {
        double prizeIndex = 0;
        // 如果高价物已经有人中过且达到上限，那么是否重新再次随机数，还是在循环中就做校验排除
        while (true) {
            double index = Math.random()* 10;
            if (index > 0 && index < ceamLotteryActivity.getSize()) {
                prizeIndex = index;
                break;
            }
        }

        int pi = (int)prizeIndex;
        log.info("pi=={}", pi);
        //int randomDeg = 360 - pi * 60 -120; // 6份
        int randomDeg = 360 - pi * 45 - 90 - 15; // 8份
        log.info("randomDeg=={}", randomDeg);

        // 将要旋转的度数  由于是顺时针的转动方向需要用360度来减
        int deg = 5 * 360 + randomDeg;

        double angles = (double)deg;

        LambdaQueryWrapper<CeamLotteryWheel> queryWrapper = Wrappers.<CeamLotteryWheel>lambdaQuery()
                .eq(CeamLotteryWheel::getActivityId, ceamLotteryActivity.getId())
                ;
        List<CeamLotteryWheel> lotteryWheels = lotteryWheelService
                .getBaseMapper().selectList(queryWrapper);
        if (CollectionUtil.isEmpty(lotteryWheels)) {
            throw new ServiceException("奖品配置不存在");
        }
        if (lotteryWheels.size() < pi) {
            throw new ServiceException("奖品配置有误");
        }
        CeamLotteryWheel ceamLotteryWheel = lotteryWheels.get(pi);
        Map<String, Object> map = new HashMap<>();
        map.put("angles", angles);
        map.put("prizeName", ceamLotteryWheel.getName());
        return map;
    }

}
