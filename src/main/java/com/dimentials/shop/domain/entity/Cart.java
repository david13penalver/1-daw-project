package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Integer id;
    private Client client;
    private List<CartDetail> cartDetailList;
    private BigDecimal total;

    public Cart(Integer id) {
        this.id = id;
    }

    public void addCartDetail(CartDetail cartDetail) {
        if (cartDetailList == null) {
            cartDetailList = new ArrayList<>();
        }
        cartDetailList.add(cartDetail);
        total = total.add(cartDetail.getTotal());
    }

    public List<CartDetail> getCartDetailList() {
        if (cartDetailList == null) {
            cartDetailList = new ArrayList<>();
        }
        return cartDetailList;
    }
}