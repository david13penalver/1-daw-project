package com.dimentials.shop.domain.service;

import com.dimentials.shop.domain.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findByUserId(Integer userId);

    Order findById(int id);
}
