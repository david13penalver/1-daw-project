package com.dimentials.shop.persistence.dao.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class CardEntity {

    private Integer id;
    private String name;
    private String description;
    private String imgPath;
    private BigDecimal price;

    public CardEntity(Integer id, String name, String description, BigDecimal price, String imgPath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgPath = imgPath;
    }

    public CardEntity(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CardEntity() {

    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardEntity that = (CardEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(imgPath, that.imgPath) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, imgPath);
    }

    @Override
    public String toString() {
        return "CardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", price=" + price +
                '}';
    }
}
