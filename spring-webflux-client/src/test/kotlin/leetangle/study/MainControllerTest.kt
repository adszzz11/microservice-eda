package leetangle.study

import io.netty.handler.timeout.ReadTimeoutException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono
import reactor.netty.tcp.TcpClient
import java.net.ConnectException
import java.nio.charset.StandardCharsets
import java.sql.Connection
import java.util.*


class MainControllerTest {
    @Test
    fun test1() {
        println("Test 시작")
        val connect = TcpClient.create()
            .host("localhost")
            .port(8081)
            .handle { inbound, outbound ->
                outbound
                    .sendString(Mono.just("ㅆT!EST"))
                    .then(inbound.receive().asString().doOnNext { println(it) }.then())
            }
            .connect()
            .blockOptional()
            .orElseThrow()
            .disposeNow()

//        connect.subscribe { connection ->
//            connection.outbound()
//                .sendString(Mono.just("ㅆTEST"))
//                .then()
//                .subscribe()
//
//            connection.inbound()
//                .receive()
//                .asString()
//                .subscribe(System.out::println)
//
//
//        }
//            .dispose()


    }
}