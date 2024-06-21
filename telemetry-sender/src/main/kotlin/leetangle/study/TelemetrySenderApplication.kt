package leetangle.study


import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

val log = KotlinLogging.logger {  }

@SpringBootApplication
class TelemetrySenderApplication

fun main(args: Array<String>) {
    log.info { "HELLO TelemetrySender Application" }
    runApplication<TelemetrySenderApplication>(*args)
}
