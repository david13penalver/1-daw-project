package com.dimentials.shop.persistence.dao.impl.jdbc;

import com.dimentials.shop.common.exception.ResourceNotFoundException;
import com.dimentials.shop.domain.entity.Order;
import com.dimentials.shop.persistence.dao.OrderDao;

import java.util.List;

public class OrderDaoJdbc implements OrderDao {
    List<Order> orderList = List.of(new Order(1), new Order(2));
    Order order = new Order(1);

    @Override
    public List<Order> findOrderByUserId(Integer userId) {
        return orderList;
    }

    @Override
    public Order findById(int id) {
        for (Order order : orderList) {
            if (order.getId() == id) {
                return order;
            }
        }
        if (order == null) {
            throw new ResourceNotFoundException("Order with id " + id + " not found.");
        }
        return order;
    }
}
