package com.dimentials.shop.domain.service.impl;

import com.dimentials.shop.domain.entity.Order;
import com.dimentials.shop.domain.service.OrderService;
import com.dimentials.shop.persistence.repository.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findByUserId(Integer userId) {
        return orderRepository.findByUserId(userId);
    }
}
