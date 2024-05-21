package com.dimentials.shop.persistence.dao;

import com.dimentials.shop.domain.entity.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    List<OrderDetail> findByOrderId(Integer orderId);
}
