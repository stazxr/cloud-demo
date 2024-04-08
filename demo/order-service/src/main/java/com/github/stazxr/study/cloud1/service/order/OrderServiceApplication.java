package com.github.stazxr.study.cloud1.service.order;

import com.github.stazxr.study.cloud1.feign.api.client.UserClient;
import com.github.stazxr.study.cloud1.feign.api.config.FeignClientConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// @EnableFeignClients(basePackages = "com.github.stazxr.study.cloud1.feign.api.client", defaultConfiguration = FeignClientConfiguration.class)
@EnableFeignClients(clients = UserClient.class, defaultConfiguration = FeignClientConfiguration.class)
@MapperScan(value = {"com.github.stazxr.study.cloud1.service.order.mapper"})
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
