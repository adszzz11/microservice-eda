package leetangle.study.client.communicate.tcp.dto

import reactor.core.publisher.Mono

class TcpResponseDto(
    var publisher : Mono<*>? = null,
    var responseBody: String? = null
) {
}