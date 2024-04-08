package com.github.stazxr.study.cloud1.service.order.controller;

import com.github.stazxr.study.cloud1.service.order.entity.Order;
import com.github.stazxr.study.cloud1.service.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public Order queryById(@PathVariable Long orderId) {
        return orderService.selectById(orderId);
    }
}
