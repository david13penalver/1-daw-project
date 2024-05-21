package com.dimentials.shop.domain.service.impl;

import com.dimentials.shop.domain.service.OrderService;
import com.dimentials.shop.persistence.repository.OrderRepository;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
