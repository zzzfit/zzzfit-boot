package cloud.zzzfit.web.test.cloud.zzzfit.web.test

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mock.web.MockServletContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import org.springframework.web.context.WebApplicationContext
import org.springframework.test.web.servlet.result.MockMvcResultHandlers

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [ ])
@WebAppConfiguration
class WebIntegrationTest {
    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    @Throws(Exception::class)
    fun setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun givenWac_whenServletContext_thenItProvidesGreetController() {
        val servletContext = webApplicationContext.servletContext
        Assertions.assertNotNull(servletContext)
        Assertions.assertTrue(servletContext is MockServletContext)
//        Assertions.assertNotNull(webApplicationContext.getBean("greetController"))
    }

//    @Test
//    fun givenGreetURIWithPathVariable_whenMockMVC_thenResponseOK() {
//        mockMvc
//            .perform(get("/greetWithPathVariable/{name}", "John"))
//            .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
//            .andExpect(content().contentType("application/json;charset=UTF-8"))
//            .andExpect(jsonPath("$.message").value("Hello World John!!!"))
//    }
}


