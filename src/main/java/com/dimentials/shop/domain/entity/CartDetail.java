package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;

public class CartDetail {
    private Integer id;
    private Card card;
    private Integer quantity;
    private BigDecimal price;

    public BigDecimal getTotal() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    public CartDetail(Card card, Integer quantity) {
        this.card = card;
        this.quantity = quantity;
    }

    public CartDetail(Integer id, Card card, Integer quantity, BigDecimal price) {
        this.id = id;
        this.card = card;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
