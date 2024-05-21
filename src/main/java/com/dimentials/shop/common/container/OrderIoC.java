package com.dimentials.shop.common.container;

import com.dimentials.shop.domain.service.OrderService;
import com.dimentials.shop.domain.service.impl.OrderServiceImpl;
import com.dimentials.shop.persistence.dao.OrderDao;
import com.dimentials.shop.persistence.dao.impl.jdbc.OrderDaoJdbc;
import com.dimentials.shop.persistence.repository.OrderRepository;
import com.dimentials.shop.persistence.repository.impl.OrderRepositoryImpl;

public class OrderIoC {
    private static OrderService orderService;
    private static OrderRepository orderRepository;

    private static OrderDao orderDao;

    public static OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl(getOrderRespository());
        }
        return orderService;
    }

    public static OrderRepository getOrderRespository() {
        if (orderRepository == null) {
            orderRepository = new OrderRepositoryImpl(getOrderDao());
        }
        return orderRepository;
    }

    public static OrderDao getOrderDao() {
        if (orderDao == null) {
            //orderDao = new OrderDaoMemory();
            orderDao = new OrderDaoJdbc();
        }
        return orderDao;
    }

    public static void setOrderService(OrderService orderService) {
        OrderIoC.orderService = orderService;
    }

    public static void setOrderRespository(OrderRepository orderRepository) {
        OrderIoC.orderRepository = orderRepository;
    }

    public static void setOrderDao(OrderDao orderDao) {
        OrderIoC.orderDao = orderDao;
    }

    public static void reset() {
        orderService = null;
        orderRepository = null;
        orderDao = null;
    }
}
