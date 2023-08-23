package com.ceam.sport.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ceam.sport.dto.CeamLotteryWheelDTO;
import com.ceam.sport.service.ICeamLotteryWheelService;
import com.ceam.sport.vo.CeamLotteryWheelVO;
import com.ceam.sport.vo.UniLotteryWheel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CeaM
 * @since 2023-05-22
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/wheel")
public class CeamLotteryWheelController {

    private final ICeamLotteryWheelService lotteryWheelService;

    @GetMapping
    public ResponseEntity<Object> page(CeamLotteryWheelDTO data) {
        IPage<CeamLotteryWheelVO> page = lotteryWheelService.page(data);
        return ResponseEntity.ok(page);
    }

    @GetMapping("uni")
    public ResponseEntity<Object> listBy() {
        List<UniLotteryWheel> page = lotteryWheelService.listBy();
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody CeamLotteryWheelDTO data) {
        boolean add = lotteryWheelService.add(data);
        return ResponseEntity.ok(add);
    }

    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody CeamLotteryWheelDTO data) {
        boolean edit = lotteryWheelService.edit(data);
        return ResponseEntity.ok(edit);
    }

    @DeleteMapping
    public ResponseEntity<Object> remove(@RequestBody Set<Long> ids) {
        boolean b = lotteryWheelService.remove(ids);
        return ResponseEntity.ok(b);
    }
}
