package com.github.stazxr.study.cloud1.service.user.controller;

import com.github.stazxr.study.cloud1.service.user.entity.User;
import com.github.stazxr.study.cloud1.service.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Value("${spring.datasource.url}")
    private String url;

    @GetMapping("/{userId}")
    public User queryById(@PathVariable Long userId) {
        System.out.println("url: " + url);
        return userService.selectById(userId);
    }

    @GetMapping("/testAddRequestHeader")
    public String queryById(@RequestHeader(value = "NewHeader", required = false) String newHeader) {
        System.out.println("newHeader: " + newHeader);
        return newHeader;
    }
}
