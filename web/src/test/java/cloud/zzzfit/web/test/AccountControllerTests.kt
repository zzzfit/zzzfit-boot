//package cloud.zzzfit.web.test
//
//import cloud.zzzfit.web.controller.AccountController
//import cloud.zzzfit.web.service.AccountService
//import com.fasterxml.jackson.databind.ObjectMapper
//import org.junit.jupiter.api.Assertions
//import org.junit.jupiter.api.Test
//import org.mockito.BDDMockito.given
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.boot.test.mock.mockito.MockBean
//import org.springframework.http.MediaType
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
//
//@WebMvcTest(controllers=[AccountController::class])
//class AccountControllerTests(@Autowired val mvc: MockMvc) {
//
//    @Autowired
//    private lateinit var objectMapper: ObjectMapper
//
//    @MockBean
//    private lateinit var accountService: AccountService
//
//    @Test
//    fun givenGreetURIWithPathVariable_whenMockMVC_thenResponseOK() {
//        given(accountService.login("admin", "password")).willReturn(null)
////        Assertions.assertTrue(true)
//        mvc
//            .perform(
//                MockMvcRequestBuilders.post("/account/login")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content("{\"username\":\"admin\",\"password\":\"password\"}")
//            )
//            .andDo(MockMvcResultHandlers.print())
//            .andExpectAll(
//                status().isOk(),
//                content().contentType(MediaType.APPLICATION_JSON),
//                jsonPath("$.success").value(true),
//            )
//    }
//}
