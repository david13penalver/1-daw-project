package com.dimentials.shop.controller;

import com.dimentials.shop.common.container.OrderIoC;
import com.dimentials.shop.domain.entity.Order;
import com.dimentials.shop.domain.entity.User;
import com.dimentials.shop.domain.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController() {
        this.orderService = OrderIoC.getOrderService();
    }

    @GetMapping
    public String findAllByUser(Model model) {
        User user = new com.dimentials.shop.domain.entity.User(1, "David", "Peñalver", "Navarro", "david13penalver@gmail.com", false, "Spain", "Aldaya", "Plaza Corts Valencianes", "8", "1", "1");
        List<Order> orderList = orderService.findByUserId(user.getUserId());
        model.addAttribute("orderList", orderList);
        return "orders/list";
    }
}
