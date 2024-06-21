package leetangle.study.client.communicate.http

import leetangle.study.client.communicate.Communicative
import leetangle.study.client.communicate.http.dto.HttpRequestDto
import leetangle.study.client.communicate.http.dto.HttpResponseDto
import org.springframework.boot.ssl.SslBundle
import org.springframework.boot.web.client.ClientHttpRequestFactories
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.client.RestClient
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.net.URI
import java.time.Duration

class HttpCommunicator(val sslBundle: SslBundle? = null) : Communicative<HttpRequestDto, HttpResponseDto> {
    override fun requestBlock(request: HttpRequestDto): HttpResponseDto {
        return remote(request).block()!!

    }

    override fun requestNonBlock(request: HttpRequestDto): Mono<HttpResponseDto> {
        TODO("Not yet implemented")
    }

    private fun remote(request: HttpRequestDto): Mono<HttpResponseDto> {
        val settings = ClientHttpRequestFactorySettings.DEFAULTS
            .withReadTimeout(Duration.ofMillis(request.readTimeoutMillis.toLong()))
            .withConnectTimeout(Duration.ofMillis(request.conntimeoutMillis.toLong()))
        if (sslBundle != null)
            settings.withSslBundle(sslBundle)
        val restClient = RestClient.builder()
            .requestFactory(ClientHttpRequestFactories.get(settings))
            .build()
        var toUri: URI = if (request.queryParams.isNotEmpty()) {
                UriComponentsBuilder.fromHttpUrl(request.method.toString())
                    .queryParams(request.queryParams)
                    .build()
                    .toUri()
            } else request.uri
        
        return restClient.method(request.method)
            .uri(toUri)
            .headers {
                request.requestHeaders.forEach { (k, v) -> it.add(k, v) }
            }
            .contentType(request.mediaType)
            .accept(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML)
            .body(request.body)
            .exchange { clientRequest, clientResponse ->
                val responseDto = HttpResponseDto()
                val responseHeaders: MutableMap<String, String> = mutableMapOf()
                responseDto.httpStatus = HttpStatus.valueOf(clientResponse.statusCode.value())
                clientResponse.headers.forEach { k, l -> responseHeaders[k] = l[0] }
                responseDto.responseHeader = responseHeaders
                responseDto.responseBody = clientResponse.bodyTo(String::class.java)
                return@exchange Mono.just(responseDto)
            }
    }

}