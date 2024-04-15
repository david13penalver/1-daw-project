package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;

public class Card {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;

    public Card(Integer id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Card() {
    }

    public Card(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
