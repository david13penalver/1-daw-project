package com.dimentials.shop.persistence.dao;

import com.dimentials.shop.domain.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findOrderByUserId(Integer userId);

    Order findById(int id);
}
