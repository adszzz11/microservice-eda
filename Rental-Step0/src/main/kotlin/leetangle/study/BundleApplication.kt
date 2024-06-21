package leetangle.study.springframework.cloud.eurekaapplication


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication

class BundleApplication

fun main(args: Array<String>) {
    runApplication<BundleApplication>(*args)
}
