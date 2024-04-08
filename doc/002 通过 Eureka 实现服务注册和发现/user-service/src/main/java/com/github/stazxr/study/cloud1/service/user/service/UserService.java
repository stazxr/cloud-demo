package com.github.stazxr.study.cloud1.service.user.service;

import com.github.stazxr.study.cloud1.service.user.entity.User;
import com.github.stazxr.study.cloud1.service.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public User selectById(Long userId) {
        return userMapper.selectById(userId);
    }
}
