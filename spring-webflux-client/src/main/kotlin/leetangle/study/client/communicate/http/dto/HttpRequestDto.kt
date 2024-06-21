package leetangle.study.client.communicate.http.dto

import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import java.net.URI
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets


data class HttpRequestDto(
    val urlEncodeCharSet: Charset = StandardCharsets.UTF_8,
    val uri : URI,
    val method: HttpMethod,
    val mediaType: MediaType,
    val conntimeoutMillis: Int,
    val readTimeoutMillis: Int
) {
    val requestHeaders: MutableMap<String, String> = LinkedHashMap()
    val queryParams: MultiValueMap<String, String> = LinkedMultiValueMap()
    var body: String = ""

}