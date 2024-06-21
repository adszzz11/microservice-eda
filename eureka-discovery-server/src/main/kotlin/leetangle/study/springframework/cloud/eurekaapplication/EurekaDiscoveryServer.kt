package leetangle.study.springframework.cloud.eurekaapplication


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class EurekaDiscoveryServer

fun main(args: Array<String>) {
    runApplication<EurekaDiscoveryServer>(*args)
}
