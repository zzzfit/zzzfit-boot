//package cloud.zzzfit.web.test
//
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.http.MediaType
//import org.springframework.mock.web.MockMultipartFile
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
//import org.springframework.test.web.servlet.setup.MockMvcBuilders
//import org.springframework.web.context.WebApplicationContext
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class FileControllerTests {
//    @Autowired
//    private lateinit var webApplicationContext: WebApplicationContext
//    @Test
//    @Throws(Exception::class)
//    fun whenFileUploaded_thenVerifyStatus() {
//        val file = MockMultipartFile(
//            "file",
//            "hello.txt",
//            MediaType.TEXT_PLAIN_VALUE,
//            "Hello, World!".toByteArray()
//        )
//        val mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
//        mockMvc.perform(multipart("/upload").file(file))
//            .andExpect(status().isOk())
//    }
//}