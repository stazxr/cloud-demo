package com.github.stazxr.study.cloud1.service.order.service;

import com.github.stazxr.study.cloud1.service.order.entity.Order;
import com.github.stazxr.study.cloud1.service.order.entity.User;
import com.github.stazxr.study.cloud1.service.order.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;

    private final RestTemplate restTemplate;

    public Order selectById(Long orderId) {
        Order order = orderMapper.selectById(orderId);
        String url = "http://localhost:8082/user/" + order.getUserId();
        User forEntity = restTemplate.getForObject(url, User.class);
        order.setUser(forEntity);
        return order;
    }
}
