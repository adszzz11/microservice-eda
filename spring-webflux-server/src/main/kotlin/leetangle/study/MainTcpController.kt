//package leetangle.study
//
//import jakarta.annotation.PostConstruct
//import org.springframework.stereotype.Component
//import reactor.core.publisher.Mono
//import reactor.netty.tcp.TcpServer
//
//@Component
//class MainTcpController {
//    @PostConstruct
//    fun startTcpServer() {
//        TcpServer.create()
//            .port(8081)
//            .handle { inbound, outbound ->
//                inbound.receive()
//                    .asString()
//                    .doOnNext { println(it) }
//                    .concatMap {
//                        outbound.sendString(Mono.just("OK"))
//                    }
//                    .onErrorResume { e -> outbound.sendString(Mono.just("Error : ${e.message}"))  }
//            }
//            .bindNow()
//            .onDispose()
//            .block()
//    }
//}