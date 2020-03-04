package com.springboot.gatewayredis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.net.UnknownHostException;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayRedisApplication {

    private static final Logger log = LoggerFactory.getLogger(GatewayRedisApplication.class);


    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(GatewayRedisApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        //@formatter:off
        // String uri = "http://httpbin.org:80";
        // String uri = "http://localhost:9080";
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .route(r -> r.path("/test/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8090")
                        .order(0)
                        .id("test-route")
                )
                .build();
//        return builder.routes()
//                .route(r -> r.host("**.abc.org").and().path("/anything/png")
//                        .filters(f ->
//                                f.prefixPath("/httpbin")
//                                        .addResponseHeader("X-TestHeader", "foobar"))
//                        .uri(uri)
//                )
//                .route("read_body_pred", r -> r.host("*.readbody.org")
//                        .and().readBody(String.class,
//                                s -> s.trim().equalsIgnoreCase("hi"))
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .addResponseHeader("X-TestHeader", "read_body_pred")
//                        ).uri(uri)
//                )
//                .route("rewrite_request_obj", r -> r.host("*.rewriterequestobj.org")
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .addResponseHeader("X-TestHeader", "rewrite_request")
//                                .modifyRequestBody(String.class, Hello.class, MediaType.APPLICATION_JSON_VALUE,
//                                        (exchange, s) -> {
//                                            return Mono.just(new Hello(s.toUpperCase()));
//                                        })
//                        ).uri(uri)
//                )
//                .route("rewrite_request_upper", r -> r.host("*.rewriterequestupper.org")
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .addResponseHeader("X-TestHeader", "rewrite_request_upper")
//                                .modifyRequestBody(String.class, String.class,
//                                        (exchange, s) -> {
//                                            return Mono.just(s.toUpperCase() + s.toUpperCase());
//                                        })
//                        ).uri(uri)
//                )
//                .route("rewrite_response_upper", r -> r.host("*.rewriteresponseupper.org")
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .addResponseHeader("X-TestHeader", "rewrite_response_upper")
//                                .modifyResponseBody(String.class, String.class,
//                                        (exchange, s) -> {
//                                            return Mono.just(s.toUpperCase());
//                                        })
//                        ).uri(uri)
//                )
//                .route("rewrite_response_obj", r -> r.host("*.rewriteresponseobj.org")
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .addResponseHeader("X-TestHeader", "rewrite_response_obj")
//                                .modifyResponseBody(Map.class, String.class, MediaType.TEXT_PLAIN_VALUE,
//                                        (exchange, map) -> {
//                                            Object data = map.get("data");
//                                            return Mono.just(data.toString());
//                                        })
//                                .setResponseHeader("Content-Type", MediaType.TEXT_PLAIN_VALUE)
//                        ).uri(uri)
//                )
//                .route(r -> r.path("/image/webp")
//                        .filters(f ->
//                                f.prefixPath("/httpbin")
//                                        .addResponseHeader("X-AnotherHeader", "baz"))
//                        .uri(uri)
//                )
//                .route(r -> r.order(-1)
//                        .host("**.throttle.org").and().path("/get")
//                        .filters(f -> f.prefixPath("/httpbin")
//                                .filter(new ThrottleGatewayFilter()
//                                        .setCapacity(1)
//                                        .setRefillTokens(1)
//                                        .setRefillPeriod(10)
//                                        .setRefillUnit(TimeUnit.SECONDS)))
//                        .uri(uri)
//                )
//                .build();
        //@formatter:on
    }
}
