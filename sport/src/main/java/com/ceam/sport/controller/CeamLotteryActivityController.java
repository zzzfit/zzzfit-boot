package com.ceam.sport.controller;


import com.ceam.sport.service.ICeamLotteryActivityService;
import com.ceam.sport.vo.LuckyResult;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 活动信息 前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-05-23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/lotteryActivity")
public class CeamLotteryActivityController {

    private final ICeamLotteryActivityService lotteryActivityService;

    @GetMapping
    public ResponseEntity<Object> lucky() {
        LuckyResult lucky = lotteryActivityService.lucky();
        return ResponseEntity.ok(lucky);
    }
}
