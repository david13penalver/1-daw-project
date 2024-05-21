package com.dimentials.shop.persistence.dao.impl.jdbc;

import com.dimentials.shop.domain.entity.Order;
import com.dimentials.shop.persistence.dao.OrderDao;

import java.util.List;

public class OrderDaoJdbc implements OrderDao {

    @Override
    public List<Order> findOrderByUserId(Integer userId) {
        return null;
    }
}
