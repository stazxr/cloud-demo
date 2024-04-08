package com.github.stazxr.study.cloud1.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
// @Order(1)
@Component
public class AuthenticationFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求信息
        ServerHttpRequest request = exchange.getRequest();

        // 获取请求路径
        String outUrl = request.getPath().pathWithinApplication().value();
        log.info("请求路径为：{}", outUrl);

        // 获取请求参数
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        log.info("请求头为：{}", request.getHeaders());
        log.info("请求参数为：{}", queryParams);
        String user = queryParams.getFirst("user");
        if ("admin".equals(user)) {
            return chain.filter(exchange);
        }

        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

    @Override
    public int getOrder() {
        return FilterOrder.FILTER_ORDERS.get(this.getClass());
    }
}
