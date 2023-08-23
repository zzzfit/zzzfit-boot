package com.ceam.sport.controller;


import com.ceam.sport.dto.AliPayParams;
import com.ceam.sport.service.ICeamCoursePlanService;
import com.ceam.sport.vo.CeamBuyCourseVO;
import com.ceam.sport.vo.CeamCoursePlanVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 排课 前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-02-18
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/coursePlan")
public class CeamCoursePlanController {

    private final ICeamCoursePlanService coursePlanService;

    @GetMapping("toPay")
    public ResponseEntity<Object> testBuy() {
        AliPayParams aliPayParams = new AliPayParams();
        aliPayParams.setApp_id("2021000116676718");
        aliPayParams.setMethod("alipay.trade.app.pay");
        aliPayParams.setCharset("utf-8");
        aliPayParams.setSign_type("RSA2");
        aliPayParams.setSign("FmUUi6hEQQ97kGSdYDVW3hu+y3TrKaab0IMMwQ+K6lBak1iClGjW7dSQYsNtFq+M6YP0CRKKH3kexlKg6z1GhZXFy5ZiiUaS6XvUlHtm+EoKGymGkaB4sRD8++XKVsg49q1YDfLcYPTCy+GcQwq1vpHVwqGo3A9QVRjBm6L38pLmvwVlTKB4QhrbvzzEF7gQ/WSx+bctkzWwLoyepr+Jtr+eVBmKcqU0mT+LKOEPE/7ck26Q+ey1GjZImBrXvFQbjdKlYYdwTWYWqhUeESGztO3vAkRckNlppjrXddeuneX1hFlWO7I28YQF4JQNyDChgPHxxrXtCOkcVg43+6pCWw==");
        aliPayParams.setTimestamp("2023-05-14 22:10:47");
        aliPayParams.setVersion("1.0");
        aliPayParams.setBiz_content("{\\\"out_trade_no\\\":\\\"168407400199239\\\",\\\"total_amount\\\":\\\"1.0\\\",\\\"subject\\\":\\\"网二手物品交易\\\",\\\"body\\\":\\\"\\\",\\\"timeout_express\\\":\\\"5m\\\",\\\"product_code\\\":\\\"FAST_INSTANT_TRADE_PAY\\\"}");
        return ResponseEntity.ok(aliPayParams);
    }

    @GetMapping
    public ResponseEntity<Object> getById(@RequestParam String id) {
        CeamBuyCourseVO ceamCoursePlanVO = coursePlanService
                .getCeamCoursePlanVO(Long.parseLong(id));
        return ResponseEntity.ok(ceamCoursePlanVO);
    }
}
