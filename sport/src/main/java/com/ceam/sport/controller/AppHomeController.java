package com.ceam.sport.controller;

import com.ceam.sport.service.IAppHomeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CeaM
 * 2023/02/18 22:25
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/api/home")
public class AppHomeController {

    private IAppHomeService appHomeService;

    @GetMapping
    public ResponseEntity<Object> home() {
        Object map = appHomeService.getHome();
        return ResponseEntity.ok(map);
    }
}
