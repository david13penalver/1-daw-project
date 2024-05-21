package com.dimentials.shop.common.container;

import com.dimentials.shop.persistence.dao.OrderDetailDao;
import com.dimentials.shop.persistence.dao.impl.jdbc.OrderDetailDaoJdbc;

public class OrderDetailIoC {
    private static OrderDetailDao orderDetailDao;

    public static OrderDetailDao getOrderDetailDao() {
        if(orderDetailDao == null) {
            orderDetailDao = new OrderDetailDaoJdbc();
        }
        return orderDetailDao;
    }

    public static void setOrderDetailDao(OrderDetailDao orderDetailDao) {
        OrderDetailIoC.orderDetailDao = orderDetailDao;
    }
}
