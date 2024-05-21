package com.dimentials.shop.persistence.repository.impl;

import com.dimentials.shop.domain.entity.Order;
import com.dimentials.shop.persistence.dao.OrderDao;
import com.dimentials.shop.persistence.repository.OrderRepository;

import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private final OrderDao orderDao;

    public OrderRepositoryImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> findByUserId(Integer userId) {
        return orderDao.findOrderByUserId(userId);
    }
}
