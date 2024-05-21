package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private Integer id;
    private User client;
    private List<OrderDetail> orderDetailList;
    private BigDecimal total = BigDecimal.ZERO;

    public Order(Integer id) {
        this.id = id;
    }

    public Order() {

    }

    public void addOrderDetail(OrderDetail orderDetail) {
        if (this.orderDetailList == null) {
            this.orderDetailList = new ArrayList<>();
        }
        this.orderDetailList.add(orderDetail);
        this.total = this.total.add(orderDetail.getTotal());
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

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Order(Integer id, User client, List<OrderDetail> orderDetailList, BigDecimal total) {
        this.id = id;
        this.client = client;
        this.orderDetailList = orderDetailList;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", orderDetailList=" + orderDetailList +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(client, order.client)
                && Objects.equals(orderDetailList, order.orderDetailList) && Objects.equals(total, order.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, orderDetailList, total);
    }
}
