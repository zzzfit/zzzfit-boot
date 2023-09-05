package cloud.zzzfit.web.controller

import cloud.zzzfit.web.ApiResponse
import cloud.zzzfit.web.service.AccountService
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@RequestMapping("/account")
class AccountController {

//    @Autowired
//    private lateinit var accountService: AccountService

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody username: String ,@RequestBody password: String): ApiResponse<*> {
        val res =  ApiResponse<String>()
        res.code = 0
        res.result = "ok"
        res.success = true
        return res
//        return ResponseEntity.ok(HttpStatus.OK);
    }
}