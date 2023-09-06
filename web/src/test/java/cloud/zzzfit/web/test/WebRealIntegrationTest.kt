//package cloud.zzzfit.web.test
//
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.BeforeEach
//import org.springframework.boot.test.context.SpringBootTest
//import io.restassured.RestAssured.given
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
//import io.restassured.RestAssured
//@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
//class WebRealIntegrationTest {
//    @BeforeEach
//    fun setUp() {
//        RestAssured.port = RestAssured.DEFAULT_PORT
//    }
//
//    @Test
//    fun givenGreetURI_whenSendingReq_thenVerifyResponse() {
//        given().get("/greet")
//            .then()
//            .statusCode(200)
//    }
//}