package leetangle.study

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @GetMapping("/get")
    fun getMethod(): String {
        return "Hello!"
    }

    @PostMapping("/post")
    fun postMethod(): String {
        return "Hello!"
    }
}