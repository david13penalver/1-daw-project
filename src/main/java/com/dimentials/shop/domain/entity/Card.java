package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Card {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgPath;

    public Card(Integer id, String name, String description, BigDecimal price, String imgPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgPath = imgPath;
    }

    public Card() {
    }

    public Card(Integer id, String name, String description, String imgPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(name, card.name)
                && Objects.equals(description, card.description) && Objects.equals(price, card.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }
}
