package com.dimentials.shop.persistence.repository.impl;

import com.dimentials.shop.persistence.dao.OrderDao;
import com.dimentials.shop.persistence.repository.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository {
    private final OrderDao orderDao;

    public OrderRepositoryImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
