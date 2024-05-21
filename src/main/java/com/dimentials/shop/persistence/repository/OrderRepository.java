package com.dimentials.shop.persistence.repository;

import com.dimentials.shop.domain.entity.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> findByUserId(Integer userId);

    Order findById(int id);
}
