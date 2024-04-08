package com.github.stazxr.study.cloud1.service.order.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.stazxr.study.cloud1.feign.api.client.UserClient;
import com.github.stazxr.study.cloud1.feign.api.entity.User;
import com.github.stazxr.study.cloud1.service.order.entity.Order;
import com.github.stazxr.study.cloud1.service.order.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;

    private final RestTemplate restTemplate;

    private final UserClient userClient;

    public Order selectById(Long orderId) {
        Order order = orderMapper.selectById(orderId);
        // URL
        // String url = "http://localhost:8082/user/" + order.getUserId();

        // 注册中心
        // String url = "http://user-service/user/" + order.getUserId();

        // RestTemplate 调用
        // User user = restTemplate.getForObject(url, User.class);

        // Feign
        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        return order;
    }

    @SentinelResource("queryGoods")
    public void queryGoods() {
        System.out.println("查询商品");
    }
}
