package leetangle.study

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestLogController {

    @GetMapping("/api/v1/hi")
    fun hi() : String{
        log.info { "get param input, /api/v1/hi" }
        return "hi"
    }
}