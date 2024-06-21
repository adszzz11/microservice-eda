//package leetangle.study.client.communicate.tcp
//
//import io.netty.handler.timeout.ReadTimeoutException
//import leetangle.study.client.communicate.Communicative
//import leetangle.study.client.communicate.tcp.dto.TcpRequestDto
//import leetangle.study.client.communicate.tcp.dto.TcpResponseDto
//import leetangle.study.logger
//import reactor.core.publisher.Mono
//import reactor.netty.Connection
//import reactor.netty.tcp.TcpClient
//import java.net.ConnectException
//import java.time.Duration
//
//class TcpCommunicator : Communicative<TcpRequestDto, TcpResponseDto> {
//    override fun requestBlock(request: TcpRequestDto): TcpResponseDto {
//        val responseDto = TcpResponseDto()
//        val client = remote(request)
//        val connection = client.connectNow(Duration.ofMillis(request.connTimeoutMillis.toLong()))
//        val result = inboundTraffic(connection)
//        outboundTraffic(connection, request)
//        responseDto.responseBody = result
//        return responseDto
//
//    }
//
//    override fun requestNonBlock(request: TcpRequestDto): Mono<TcpResponseDto> {
//        val responseDto = TcpResponseDto()
//        val client: TcpClient = remote(request)
//        client
//            .handle { inbound, outbound ->
//                outbound.sendString(Mono.just("test"))
//                    .then(
//                        inbound.receive()
//                            .asString()
//                            .doOnNext(System.out::println)
//                            .then()
//                    )
//
//            }
//            .connect()
//
//
//    }
//
//    private fun outboundTraffic(connection: Connection, request: TcpRequestDto) {
//        connection.outbound()
//            .sendString(Mono.just(request.body))
//            .then()
//            .subscribe()
//    }
//
//    private fun inboundTraffic(connection: Connection): String {
//        var result: String = ""
//        connection
//            .inbound()
//            .receive()
//            .asString()
//            .subscribe(
//                { response ->
//                    // 서버로부터 받은 응답을 로그에 출력
//                    result = response
//                    logger.info { "Received response from server: $response" }
////                    println("Received response from server: $response")
//                },
//                /* errorConsumer = */
//                { error ->
//                    when (error) {
//                        is ConnectException -> logger.error("Connection Refused: The server is not accepting requests.")
//                        is ReadTimeoutException -> logger.error("Read Timeout: The server did not respond in time.")
//                        else -> {
//                            logger.error { "An unexpected error occurred: $error" }
//                            throw RuntimeException(error)
//                        }
//
//                    }
//                },
//                /* completeConsumer = */
//                {
//                    logger.info { "Completed transmission." }
////                    println("Completed transmission.")
//                }
//            )
//        return result
//    }
//
//
//    private fun remote(request: TcpRequestDto): TcpClient {
//        return TcpClient.create()
//            .host(request.ip)
//            .port(request.port)
//            .doOnResolve { connection -> }
//            .doOnResolveError { connection, error -> }
//            .doOnConnect { connection -> println("Connect Start to ${connection.remoteAddress()}") }
//            .doOnConnected { connection -> println("Connected to ${connection.address()}") }
////            .doOnChannelInit { connectionObserver, channel, socketAddress ->  }
//            .doOnDisconnected { connection -> println("Disconnected from ${connection.address()}") }
//
//
//    }
//}