package com.github.stazxr.study.cloud1.feign.api.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String address;
}
