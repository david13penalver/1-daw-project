package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CartDetail that = (CartDetail) o;
        return Objects.equals(id, that.id) && Objects.equals(card, that.card) && Objects.equals(quantity, that.quantity)
                && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card, quantity, price);
    }
}
