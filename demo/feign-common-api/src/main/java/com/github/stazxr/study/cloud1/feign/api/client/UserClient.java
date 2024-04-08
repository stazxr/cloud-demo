package com.github.stazxr.study.cloud1.feign.api.client;

import com.github.stazxr.study.cloud1.feign.api.client.factory.UserClientFallbackFactory;
import com.github.stazxr.study.cloud1.feign.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service", fallbackFactory = UserClientFallbackFactory.class)
// @FeignClient(value = "user-service", configuration = FeignClientConfiguration.class)
public interface UserClient {
    @GetMapping("/user/{userId}")
    User findById(@PathVariable Long userId);
}
