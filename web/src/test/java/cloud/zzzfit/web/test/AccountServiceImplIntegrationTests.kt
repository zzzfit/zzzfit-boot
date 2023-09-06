//package cloud.zzzfit.web.test
//
//import cloud.zzzfit.data.repository.UserRepository
//import cloud.zzzfit.web.service.AccountService
//import cloud.zzzfit.web.service.impl.AccountServiceImpl
//import org.junit.jupiter.api.Assertions
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.extension.ExtendWith
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.boot.test.context.TestConfiguration
//import org.springframework.boot.test.mock.mockito.MockBean
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Import
//import org.springframework.test.context.ContextConfiguration
//import org.springframework.test.context.junit.jupiter.SpringExtension
//
//
//
//
//@ExtendWith(SpringExtension::class)
////@Import(ImplTestContextConfiguration::class)
////@ExtendWith(SpringExtension::class)
////@SpringBootTest
//@ContextConfiguration
//class AccountServiceImplIntegrationTests {
//
//    @TestConfiguration
//    internal class ImplTestContextConfiguration {
//        @Bean
//        fun accountService(): AccountService {
//            return  AccountServiceImpl()
//        }
//    }
//
//    @Autowired
//    lateinit var service: AccountService
//
//    @MockBean
//    private lateinit var userRepository: UserRepository
//
//    @Test
//    fun test111() {
//        Assertions.assertTrue(true)
//    }
//}