package leetangle.study.springframework.cloud.eurekaclient.eurekaclient.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

/**
 *packageName    : leetangle.study.springframework.cloud.eurekaclient.eurekaclient
 * fileName       : ClientController
 * author         : sm
 * date           : 4/28/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/28/24        sm       최초 생성
 */

@RestController
class ClientController {
    @GetMapping("/first-service/")
    fun firstService(): String {
        println("FIRST_SERVICE CALLED")
        return "OK1"
    }
    @GetMapping("/first-service/Test")
    fun firstServiceTest(): String {
        println("FIRST_SERVICE_TEST CALLED")
        return "OK1_Test"
    }
    @GetMapping("/first-service/welcome")
    fun welcome(): String {
        println("FIRST_SERVICE_WELCOME CALLED")
        return "OK1_Welcome"
    }

    @GetMapping("/second-service/")
    fun secondService(): String {
        println("SECOND_SERVICE CALLED")
        return "OK2"
    }
    @GetMapping("/second-service/Test")
    fun secondServiceTest(): String {
        println("SECOND_SERVICE_TEST CALLED")
        return "OK2_TEST"
    }
    @GetMapping("/second-service/Welcome")
    fun secondServiceWelcome(): String {
        println("SECOND_SERVICE_WELCOME CALLED")
        return "OK2_WELCOME"
    }

    @GetMapping("/first-service/message")
    fun firstServiceMessage(@RequestHeader("first-request") header: String): String {
        println(header)
        return "Hello world in First Service."
    }
    @GetMapping("/second-service/message")
    fun secondServiceMessage(@RequestHeader("second-request") header: String): String {
        println(header)
        return "Hello world in Second Service."

    }
}
