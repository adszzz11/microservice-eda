package leetangle.study.client.communicate.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.module.kotlin.convertValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.Test

class HttpCommunicatorTest {
    @Test
    fun test() {

//        val mainMap = mutableMapOf<String, Any>()
//        val subMap = mutableMapOf<String, Any>()
//        mainMap["Test"] = "test"
//        mainMap["thisis"] = "test2"
//        mainMap["TestData"] =
//            TestData(value1 = 1, value2 = "TestData", value3 = TestInnerData(value1 = 2, value2 = "TestInnerData"))
//        subMap["subMap1"] = "subMap1"
//        subMap["subMap2"] = "subMap2"
//        subMap["TestData"] =
//            TestData(value1 = 1, value2 = "TestData", value3 = TestInnerData(value1 = 2, value2 = "TestInnerData"))
//        mainMap["sub"] = subMap

        val om = jacksonObjectMapper().registerKotlinModule()
        val node = om.convertValue<ObjectNode>(
            TestData(
                value1 = 1,
                value2 = "TestData",
                value3 = TestInnerData(value1 = 2, value2 = "TestInnerData")
            )
        )

        println(om.writeValueAsString(node))

        println(om.writeValueAsString(TestData(
            value1 = 1,
            value2 = "TestData",
            value3 = TestInnerData(value1 = 2, value2 = "TestInnerData")
        )))
    }
}

data class TestData(val value1: Int, val value2: String, val value3: TestInnerData) {

}

data class TestInnerData(val value1: Int, val value2: String) {

}