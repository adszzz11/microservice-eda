package leetangle.study.client.communicate.http.dto

import org.reactivestreams.Publisher
import org.springframework.http.HttpStatus
import reactor.core.publisher.Mono

data class HttpResponseDto(
    var responseHeader: Map<String, String>? = null,
    var httpStatus: HttpStatus? = null,
    var publisher: Mono<*>? = null,
    var responseBody: String? = null
) {
}