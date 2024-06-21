package leetangle.study

import io.netty.handler.timeout.ReadTimeoutException
import mu.KotlinLogging
import org.reactivestreams.Publisher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.netty.Connection
import reactor.netty.NettyInbound
import reactor.netty.NettyOutbound
import reactor.netty.tcp.TcpClient
import java.net.ConnectException
import java.util.function.BiFunction

val logger = KotlinLogging.logger { }

@RestController
@RequestMapping("/")
class MainController {

    @GetMapping("/")
    fun method1(): String {
        return "OK"
    }

    @GetMapping("/error")
    fun method3(): String {
        return "OK"
    }

    @GetMapping("/send")
    fun method2(): String {
        println("SEND INIT")
        val host = "localhost"
        val port = 8081 // TcpServer와 동일한 포트 번호 사용

        TcpClient.create()
            .host(host)
            .port(port)
            .handle { inbound, outbound ->
                outbound.sendString(Mono.just("Hello, server!")).then()
            }
            .handle { inbound, outbound ->  inbound.receive().then()}
            .connect()
//            .flatMap(response -> response.inbound().receive().asString())
//            .flatMapMany { it.inbound().receive().asString() }  // 연결 후, 수신 데이터 처리
            .subscribe(
                /* consumer = */
                { response ->
                    // 서버로부터 받은 응답을 로그에 출력
                    logger.info { "Received response from server: $response" }
                },
                /* errorConsumer = */
                { error ->

                    when (error) {
                        is ConnectException -> logger.error("Connection Refused: The server is not accepting requests.")
                        is ReadTimeoutException -> logger.error("Read Timeout: The server did not respond in time.")
                        else -> logger.error { "An unexpected error occurred: $error" }
                    }
                },
                /* completeConsumer = */
                { logger.info { "Completed transmission." } }
            )




        return "OK"


//
//        // TCP 클라이언트 생성 및 요청 보내기
//        TcpClient.create()
//            .host(host)
//            .port(port)
//            .doOnResolveError { connection, throwable -> println("CONNECTION : $connection, THROWABLE : $throwable") }
//            .handle { inbound, outbound ->
//                outbound
//                    .sendString(
//                        Mono.just("Hello, server!").doOnError { println(it)}
//                    )
//                    .then(
//                        inbound
//                        .receive()
//                        .asString()
//                            .doOnError { println(it)}
//                        .doOnNext { println(it) }
//                        .doOnError {
//                            println("ERROR CAUGHT ! $it")
//                        }
//                        .then())
//
//            }
//            .connectNow()
//
//            .onDispose()
//            .doOnError { println(it) }
//            .block()
//        return "OK"
    }
}