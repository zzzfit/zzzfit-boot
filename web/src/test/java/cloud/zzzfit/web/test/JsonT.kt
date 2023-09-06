//package cloud.zzzfit.web.test
//
//import org.assertj.core.api.Assertions.assertThat
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.json.JsonTest
//import org.springframework.boot.test.json.JacksonTester
//
//
//class VehicleDetails
//@JsonTest
//class MyJsonTests(@Autowired val json: JacksonTester<VehicleDetails>) {
//
//    @Test
//    fun serialize() {
//        val details = VehicleDetails("Honda", "Civic")
//        // Assert against a `.json` file in the same package as the test
//        assertThat(json.write(details)).isEqualToJson("expected.json")
//        // Or use JSON path based assertions
//        assertThat(json.write(details)).hasJsonPathStringValue("@.make")
//        assertThat(json.write(details)).extractingJsonPathStringValue("@.make").isEqualTo("Honda")
//    }
//
//    @Test
//    fun deserialize() {
//        val content = "{\"make\":\"Ford\",\"model\":\"Focus\"}"
//        assertThat(json.parse(content)).isEqualTo(VehicleDetails("Ford", "Focus"))
//        assertThat(json.parseObject(content).make).isEqualTo("Ford")
//    }
//
//}