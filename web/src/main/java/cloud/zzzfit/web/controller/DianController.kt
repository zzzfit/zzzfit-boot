package cloud.zzzfit.web.controller

import cloud.zzzfit.web.service.DianService
import cloud.zzzfit.web.service.OrderService
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@Slf4j
@RestController
@RequestMapping("/dian")
class DianController {

    @Autowired
    lateinit var orderService: DianService
}