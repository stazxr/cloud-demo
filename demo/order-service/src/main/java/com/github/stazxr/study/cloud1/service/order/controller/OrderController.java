package com.github.stazxr.study.cloud1.service.order.controller;

import com.github.stazxr.study.cloud1.service.order.entity.Order;
import com.github.stazxr.study.cloud1.service.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/testAddRequestHeader")
    public String queryById(@RequestHeader(value = "NewHeader", required = false) String newHeader) {
        System.out.println("newHeader: " + newHeader);
        return newHeader;
    }

    @GetMapping("/query")
    public String queryOrder() {
        orderService.queryGoods();
        System.out.println("查询订单");
        return "查询订单成功";
    }

    @GetMapping("/save")
    public String saveOrder() {
        orderService.queryGoods();
        System.out.println("查询订单");
        return "查询订单成功";
    }
}
