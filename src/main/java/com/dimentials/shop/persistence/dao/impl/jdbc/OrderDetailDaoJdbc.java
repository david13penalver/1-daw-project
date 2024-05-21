package com.dimentials.shop.persistence.dao.impl.jdbc;

import com.dimentials.shop.domain.entity.OrderDetail;
import com.dimentials.shop.persistence.dao.OrderDetailDao;

import java.util.List;

public class OrderDetailDaoJdbc implements OrderDetailDao {
    @Override
    public List<OrderDetail> findByOrderId(Integer orderId) {
        return null;
    }
}
