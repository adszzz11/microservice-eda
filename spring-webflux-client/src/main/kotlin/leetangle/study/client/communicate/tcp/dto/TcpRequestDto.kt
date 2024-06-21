package leetangle.study.client.communicate.tcp.dto

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

class TcpRequestDto(
    val urlEncodeCharset: Charset = StandardCharsets.UTF_8,
    val ip : String,
    val port: Int,
    val connTimeoutMillis: Int = 10000,
    val readTimeoutMillis: Int = 10000,
    val body: String
) {


}