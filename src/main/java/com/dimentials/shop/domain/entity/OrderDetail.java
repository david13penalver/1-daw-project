package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;

public class OrderDetail {

    private Integer id;
    private Card card;
    private Integer quantity;
    private BigDecimal price;

    public BigDecimal getTotal() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public OrderDetail(Integer id, Integer quantity, BigDecimal price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
    
}
