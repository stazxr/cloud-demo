package com.github.stazxr.study.cloud1.service.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.stazxr.study.cloud1.feign.api.entity.User;
import lombok.Data;

@Data
@TableName("`order`")
public class Order {
    private Long id;
    private String name;
    private Long userId;
    private Integer num;
    @TableField(exist = false)
    private User user;
}
