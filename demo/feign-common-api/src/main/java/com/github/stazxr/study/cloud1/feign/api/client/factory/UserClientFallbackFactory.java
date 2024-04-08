package com.github.stazxr.study.cloud1.feign.api.client.factory;

import com.github.stazxr.study.cloud1.feign.api.client.UserClient;
import com.github.stazxr.study.cloud1.feign.api.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable cause) {
        return new UserClient() {
            @Override
            public User findById(Long userId) {
                log.error("查询用户信息失败", cause);
                return null;
            }
        };
    }
}
