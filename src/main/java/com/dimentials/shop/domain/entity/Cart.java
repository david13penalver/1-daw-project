package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart {
    private Integer id;
    private User client;
    private List<CartDetail> cartDetailList;
    private BigDecimal total;

    public Cart(Integer id) {
        this.id = id;
    }

    public Cart() {

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

    public Cart(Integer id, User client, List<CartDetail> cartDetailList, BigDecimal total) {
        this.id = id;
        this.client = client;
        this.cartDetailList = cartDetailList;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setCartDetailList(List<CartDetail> cartDetailList) {
        this.cartDetailList = cartDetailList;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) && Objects.equals(client, cart.client)
                && Objects.equals(cartDetailList, cart.cartDetailList) && Objects.equals(total, cart.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, cartDetailList, total);
    }
}