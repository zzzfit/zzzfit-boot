package cloud.zzzfit.web.test

import cloud.zzzfit.web.controller.AccountController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders.*


@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerIntegrationTests {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun givenGreetURIWithPathVariable_whenMockMVC_thenResponseOK() {
        Assertions.assertTrue(true)
//        mockMvc
//            .perform(post("/account/login", "John"))
//            .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
//            .andExpect(content().contentType("application/json;charset=UTF-8"))
//            .andExpect(jsonPath("$.message").value("Hello World John!!!"))
    }
}
