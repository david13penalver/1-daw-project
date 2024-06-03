package com.dimentials.shop.domain.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Card {

    private Integer id;
    private String name;
    private String description;
    private String description_es;
    private String description_en;
    private BigDecimal price;
    private String imgPath;

    public Card(Integer id, String name, String description, BigDecimal price, String imgPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgPath = imgPath;
    }

    public Card(Integer id, String name, String description_es, String getDescription_en, BigDecimal price, String imgPath) {
        this.id = id;
        this.name = name;
        this.description_es = description_es;
        this.description_en = getDescription_en;
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

    public String getDescription_es() {
        return description_es;
    }

    public void setDescription_es(String description_es) {
        this.description_es = description_es;
    }

    public String getDescription_en() {
        return description_en;
    }

    public void setDescription_en(String getDescription_en) {
        this.description_en = getDescription_en;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(name, card.name) && Objects.equals(description, card.description) && Objects.equals(price, card.price) && Objects.equals(imgPath, card.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, imgPath);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
