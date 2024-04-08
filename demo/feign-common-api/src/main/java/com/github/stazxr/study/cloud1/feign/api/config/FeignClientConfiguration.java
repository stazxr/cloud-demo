package com.github.stazxr.study.cloud1.feign.api.config;

import com.github.stazxr.study.cloud1.feign.api.client.factory.UserClientFallbackFactory;
import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignClientConfiguration {
    @Bean
    public Logger.Level feignLogLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public UserClientFallbackFactory userClientFallbackFactory() {
        return new UserClientFallbackFactory();
    }
}
