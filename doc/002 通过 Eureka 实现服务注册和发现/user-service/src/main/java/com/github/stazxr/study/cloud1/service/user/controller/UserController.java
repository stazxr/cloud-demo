package com.github.stazxr.study.cloud1.service.user.controller;

import com.github.stazxr.study.cloud1.service.user.entity.User;
import com.github.stazxr.study.cloud1.service.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public User queryById(@PathVariable Long userId) {
        return userService.selectById(userId);
    }
}
