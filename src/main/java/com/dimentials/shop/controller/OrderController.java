package com.dimentials.shop.controller;

import com.dimentials.shop.common.container.OrderIoC;
import com.dimentials.shop.domain.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController() {
        this.orderService = OrderIoC.getOrderService();
    }
}
