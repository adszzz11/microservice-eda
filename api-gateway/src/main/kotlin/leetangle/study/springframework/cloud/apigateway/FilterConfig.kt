package leetangle.study.springframework.cloud.apigateway

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *packageName    : leetangle.study.springframework.cloud.apigateway
 * fileName       : FilterConfig
 * author         : sm
 * date           : 2024. 6. 17.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 6. 17.        sm       최초 생성
 */

@Configuration
class FilterConfig {
    @Bean
    fun gatewayRoutes(builder: RouteLocatorBuilder) {
        builder.routes {
            route {
                path("/first-service/**")
                filters {
                    addRequestHeader("first-request","first-request-header ")
                    addResponseHeader("first-response","first-response-header")
                }
                uri("http://localhost:8081")
            }
            route {
                path("/second-service/**")
                filters {
                    addRequestHeader("second-request","second-request-header ")
                    addResponseHeader("second-response","second-response-header")
                }
                uri("http://localhost:8081")
            }
            build()
        }

    }

}